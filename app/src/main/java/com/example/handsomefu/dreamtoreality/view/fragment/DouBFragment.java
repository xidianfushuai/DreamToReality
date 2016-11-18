package com.example.handsomefu.dreamtoreality.view.fragment;

import android.app.ProgressDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.handsomefu.dreamtoreality.R;
import com.example.handsomefu.dreamtoreality.basemvp.BaseFragment;
import com.example.handsomefu.dreamtoreality.model.bean.Book;
import com.example.handsomefu.dreamtoreality.model.utils.CommonUtils;
import com.example.handsomefu.dreamtoreality.presenter.DouBPresenter;
import com.example.handsomefu.dreamtoreality.presenter.adapter.BookAdapter;
import com.example.handsomefu.dreamtoreality.view.viewi.DouBView;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by HandsomeFu on 2016/11/14.
 */
public class DouBFragment extends BaseFragment<DouBView, DouBPresenter> implements DouBView{
    @Bind(R.id.et_book_name)
    EditText etBookName;
    @Bind(R.id.bt_search)
    Button btSearch;
    @Bind(R.id.rv_dou_b)
    RecyclerView rvDouB;
    private ProgressDialog progressDialog;
    @Override
    protected DouBPresenter initPresenter() {
        return new DouBPresenter();
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initView() {
        progressDialog = new ProgressDialog(mContext);
        progressDialog.setCancelable(false);
        rvDouB.setLayoutManager(new LinearLayoutManager(mContext));
    }

    @Override
    public int getLayoutId() {
        return R.layout.fg_doub;
    }
    @OnClick({R.id.bt_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_search:
                if (TextUtils.isEmpty(getSearchKey())) {
                    CommonUtils.toast("请输入书名");
                    return;
                }
                presenter.searchBook(getSearchKey(), null, 0, 10);
                break;
        }
    }
    private String getSearchKey(){
        return etBookName.getText().toString().trim();
    }

    @Override
    public void onSearchBookSuccessed(List<Book> bookList) {
        rvDouB.setAdapter(new BookAdapter(mContext, bookList));
    }

    @Override
    public void onSearchBookFailed(String message) {

    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }
}
