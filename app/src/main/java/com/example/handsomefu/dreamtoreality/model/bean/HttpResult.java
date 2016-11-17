package com.example.handsomefu.dreamtoreality.model.bean;

/**
 * Created by HandsomeFu on 2016/11/16.
 {
 "error": false,
 "results": [
 {
 "_id": "5829b5b2421aa911e32d87e3",
 "createdAt": "2016-11-14T21:01:38.860Z",
 "desc": "\u52a8\u753b\u63d2\u503c\u5668\u7684\u7f16\u8f91\u5668",
 "images": [
 "http://img.gank.io/fa3bb06d-1bfb-41a7-8bfe-78adeb55c049"
 ],
 "publishedAt": "2016-11-16T11:37:18.947Z",
 "source": "chrome",
 "type": "Android",
 "url": "https://github.com/MartinRGB/RapidInterpolator",
 "used": true,
 "who": "Jason"
 },
 {
 "_id": "582bb5f6421aa93a61577f2d",
 "createdAt": "2016-11-16T09:27:18.173Z",
 "desc": "Android MP3\u5f55\u5236\uff0c\u6ce2\u5f62\u663e\u793a\uff0c\u97f3\u9891\u6743\u9650\u517c\u5bb9\u4e0e\u64ad\u653e",
 "images": [
 "http://img.gank.io/b740d072-3c32-4c8f-aa7a-b0dd45968e19"
 ],
 "publishedAt": "2016-11-16T11:37:18.947Z",
 "source": "web",
 "type": "Android",
 "url": "http://www.jianshu.com/p/2448e2903b07",
 "used": true,
 "who": "Shuyu Guo"
 }
 ]
 }
 */

//将返回的数据做统一处理   如果成功，返回results
public class HttpResult<T> {
    private boolean error;
    private T results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean ifError) {
        this.error = error;
    }

    public T getResult() {
        return results;
    }

    public void setResult(T results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "error=" + error +
                ", results=" + results +
                '}';
    }
}
