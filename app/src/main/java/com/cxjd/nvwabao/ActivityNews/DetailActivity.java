package com.cxjd.nvwabao.ActivityNews;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.adapter.HttpTitleUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class DetailActivity extends AppCompatActivity {
        WebView webView;
        String str;
        String string;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_detail);
            webView = findViewById(R.id.webview);
            webView.setInitialScale(200);
            Intent intent=getIntent();
            String url="http://"+intent.getStringExtra("content");
            initWebview();
            HttpTitleUtil.sendHttpRequest(url, new HttpTitleUtil.HttpCallbackListener() {
                @Override
                public void onFinish(String response) {
                       str=response.toString();
                    try {
                        JSONObject jsonObject=new JSONObject(str);
                        string= (String) jsonObject.get("content");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                webView.loadDataWithBaseURL(null,string,"text/html", "utf-8",null);
                            }
                        });
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onError(Exception e) {

                }
            });
        }

        private void initWebview() {
            webView.setWebViewClient(new MyWebViewClient());
            webView.addJavascriptInterface(new JavaScriptInterface(this), "imagelistner");//这个是给图片设置点击监听的，如果
            webView.getSettings().setTextSize(WebSettings.TextSize.LARGER);
            WebSettings webSettings = webView.getSettings();//获取webview设置属性
            webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);//把html中的内容放大webview等宽的一列中
            webSettings.setJavaScriptEnabled(true);//支持js
            webSettings.setBuiltInZoomControls(true); // 显示放大缩小
            webSettings.setSupportZoom(true); // 可以缩放
            webSettings.setJavaScriptEnabled(true);//支持js
        }
        private class MyWebViewClient extends WebViewClient {

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                imgReset();//重置webview中img标签的图片大小
                // html加载完成之后，添加监听图片的点击js函数
                addImageClickListner();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        }

        public static class JavaScriptInterface {

            private Context context;

            public JavaScriptInterface(Context context) {
                this.context = context;
            }

            //点击图片回调方法
            //必须添加注解,否则无法响应
            @JavascriptInterface
            public void openImage(String img) {

            }
        }

        /**
         * 对图片进行重置大小，宽度就是手机屏幕宽度，高度根据宽度比便自动缩放
         **/
        private void imgReset() {
            webView.loadUrl("javascript:(function(){" +
                    "var objs = document.getElementsByTagName('img'); " +
                    "for(var i=0;i<objs.length;i++)  " +
                    "{"
                    + "var img = objs[i];   " +
                    "    img.style.maxWidth = '90%'; img.style.height = 'auto';  " +
                    "}" +
                    "})()");
        }

        private void addImageClickListner() {
            // 这段js函数的功能就是，遍历所有的img节点，并添加onclick函数，函数的功能是在图片点击的时候调用本地java接口并传递url过去
            webView.loadUrl("javascript:(function(){" +
                    "var objs = document.getElementsByTagName(\"img\"); " +
                    "for(var i=0;i<objs.length;i++)  " +
                    "{"
                    + "    objs[i].onclick=function()  " +
                    "    {  "
                    + "        window.imagelistner.openImage(this.src);  " +
                    "    }  " +
                    "}" +
                    "})()");
        }

}
