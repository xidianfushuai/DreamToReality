package com.example.handsomefu.dreamtoreality.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.handsomefu.dreamtoreality.R;
import com.example.handsomefu.dreamtoreality.model.utils.Glides;

/**
 * Created by HandsomeFu on 2016/11/17.
 */

public class WebviewActivity extends AppCompatActivity {
    private WebView webView;
    private ImageView ivWelfare;
    private String url;
    private boolean isWelfare;
    private ProgressBar pbLoading;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_webview);
        pbLoading = (ProgressBar) findViewById(R.id.progress_bar);
        webView = (WebView) findViewById(R.id.wv_view);
        url = getIntent().getStringExtra("url");
        isWelfare = getIntent().getBooleanExtra("isWelfare", false);
        if (isWelfare) {
            initWelfare();

        }else {
            initWebview();
        }
    }

    private void initWebview() {
        pbLoading.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        //WebView加载web资源
        webView.loadUrl(url);
        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                // TODO Auto-generated method stub
                if (newProgress == 100) {
                    pbLoading.setVisibility(View.GONE);

                } else {
                    pbLoading.setProgress(newProgress);
                }

            }
        });
        //启用支持javascript
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
//        优先使用缓存
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
    }

    private void initWelfare() {
        ivWelfare = (ImageView) findViewById(R.id.iv_welfare);
        ivWelfare.setVisibility(View.VISIBLE);
        Glides.getInstance().load(this, url, ivWelfare);
    }

    //改写物理按键——返回的逻辑
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webView.canGoBack()) {
                webView.goBack();//返回上一页面
                return true;
            } else {
                finish();
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
