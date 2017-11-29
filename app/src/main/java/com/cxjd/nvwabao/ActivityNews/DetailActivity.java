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
         //   String str="<html lang=\"en\"><head><meta charset=\"UTF-8\"><title>这个季节，天气温度慢慢降低，男人得注意保养前列腺！ </title><style type=\"text/css\">.reads {margin: 0 auto;width: 500px;}h2{text-align:center;}</style></head><body><h2>这个季节，天气温度慢慢降低，男人得注意保养前列腺！ </h2><div class=\"reads\">\n<p>天气一天天变凉，不少前列腺疾病患者又发起了愁。因为男人的睾丸害怕高温，但前列腺恰恰相反，最怕冷，一受凉就会“感冒”。天气转凉，人体交感神经兴奋性增强，使前列腺腺体收缩，腺管和血管扩张，造成慢性充血，尿道内压不断增加，严重时可引起逆流。</p><center><p align=\"center\"><img alt=\"\" src=\"http://img.cnys.com/upload/picture/2017/11-01/MeYWIc.jpg\"/></p></center><p>尿道情况的变化还会加重前列腺液的淤积，诱发前列腺疾病或加重原有病情。慢性前列腺炎一复发，尿频、尿急、尿痛，会阴、睾丸疼痛等症状也会陆续出现。</p><p>秋冬要防住慢性前列腺炎，首先要保证给前列腺提供一个温暖的环境，降低腺体和精道的腔内压力，松弛平滑肌，减少出口的阻力，使前列腺引流通畅。保暖还可以减少肌肉组织收缩，缓解前列腺充血、水肿状态。</p><h3><strong>五类男性要注意前列腺健康</strong></h3><p>作为男性重要的性腺器官——前列腺，它给许多男性带来了“雄风”，却也让不少人受到困扰。前列腺炎症与职业和人群密切相关，以下五类人是前列腺疾病的高发人群，生活中更需要呵护前列腺健康。</p><center><p align=\"center\"><img alt=\"\" src=\"http://img.cnys.com/upload/picture/2017/11-01/9L8YVk.jpg\"/></p></center><p><strong>销售人员</strong></p><p>销售人员需要更多的应酬，可能经常大量饮酒、吃辛辣刺激食物，生活不规律。这些都会引起前列腺充血，增加细菌入侵的风险，进而诱发前列腺炎症。</p><p><strong>久坐办公室的白领</strong></p><p>白领们长期久坐，整个生殖系统血液微循环受阻、新陈代谢减慢，进而导致新陈代谢产生的各种有害物质排泄不畅，前列腺充血，引发炎症。</p>\n</div><div class=\"reads\">\n<p><strong>频繁自慰的单身</strong></p><p>由于没有性伴侣，一些人通过自慰解决生理需求。未婚男性正常的自慰频率是每周2—5次，超过5次就太频繁，易造成前列腺过度充血，静脉回流障碍，免疫抵抗能力下降，而且随着细菌在局部停留时间的延长，产生炎症的机会将相应增加。</p><p><strong>长途汽车司机</strong></p><p>由于不能及时排尿，使得尿液长期停留在尿路中，细菌不能被及时冲走，从而增加了细菌感染的机会。</p><center><p align=\"center\"><strong></strong></p><p align=\"center\"><img alt=\"\" src=\"http://img.cnys.com/upload/picture/2017/11-01/MNe0Eh.jpg\"/></p></center><p><strong>刚结婚的新郎</strong></p><p>新婚男士出现前列腺炎症主要可能由于：操办婚礼等过度劳累，身体虚弱、婚宴时过量饮酒、蜜月过程中卫生条件较差等。至于性生活过度则和手淫过频一样，导致前列腺反复充血进而诱发前列腺炎，许多新婚男士也因此患上“蜜月型”前列腺炎。</p><p>秋冬气温骤降，关爱腺健康也要及时跟上，如果你是上面的五类男性，一定要更加注意保护前列腺，远离男炎之隐。</p>\n</div></body></html>";
        }

        private void initWebview() {
            webView.setWebViewClient(new MyWebViewClient());
            webView.addJavascriptInterface(new JavaScriptInterface(this), "imagelistner");//这个是给图片设置点击监听的，如果
            webView.getSettings().setTextSize(WebSettings.TextSize.NORMAL);
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
