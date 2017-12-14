package com.cxjd.nvwabao.ActivityNews;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.adapter.CommentFun;
import com.cxjd.nvwabao.adapter.CustomTagHandler;
import com.cxjd.nvwabao.adapter.HttpTitleUtil;
import com.cxjd.nvwabao.adapter.MomentAdapter;
import com.cxjd.nvwabao.bean.Comment;
import com.cxjd.nvwabao.bean.Moment;
import com.cxjd.nvwabao.bean.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class NewsDetailActivity extends Activity {
    String str;
    String string;
    public static User sUser = new User(1, "走向远方"); // 当前登录用户
    private ProgressDialog progressDialog;
    private ListView mListView;
    private MomentAdapter mAdapter;
    WebView webView;
    ImageView shares,lovasave,commenmy;
    final ArrayList<Moment> moments = new ArrayList<Moment>();
    EditText commen;
    private String commentUrl = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        View view= LayoutInflater.from(this).inflate(R.layout.webview_layout,null);
        webView=view.findViewById(R.id.webview);
        initMycommen();
        WindowManager windowManager= (WindowManager)getSystemService(Context.WINDOW_SERVICE);
        int width = windowManager.getDefaultDisplay().getWidth();
        chooseScale(width);
        Intent intent=getIntent();
        String url=intent.getStringExtra("content");
        String pageId=intent.getStringExtra("pageId");
        commentUrl="http://192.168.31.227/user/getComments/"+901;
        initWebview();
        sendRequest(url);
        requestComment(commentUrl);
        mListView = (ListView) findViewById(R.id.list_moment);
        init();


    }
   // [{"id":4,"content":"我日你妈个皮耶","create_time":"4小时前","author_id":1,"author_name":null,"father_comment_id":-1,"reply_obj_id":901,"comments":[{"id":5,"content":"我日你妈个皮耶","create_time":"4小时前","author_id":1,"author_name":null,"father_comment_id":4,"reply_obj_id":-1,"comments":null,"replyPerson":null},{"id":6,"content":"我日你妈个皮耶","create_time":"4小时前","author_id":1,"author_name":null,"father_comment_id":4,"reply_obj_id":5,"comments":null,"replyPerson":null}],"replyPerson":null}]

    private void requestComment(String commentUrl) {

        HttpTitleUtil.sendOkHttpRequest(commentUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String comments=response.body().string();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.i("TAG",comments);
                        }
                    });
            }
        });
    }


    private void initMycommen() {
        shares=findViewById(R.id.shares);
        lovasave=findViewById(R.id.lovesave);
        commenmy=findViewById(R.id.commenMy);
        commen=findViewById(R.id.conmm);
        commenmy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String content=commen.getText().toString();
               if(TextUtils.isEmpty(content)){
                   Toast.makeText(NewsDetailActivity.this, "评论不能为空", Toast.LENGTH_SHORT).show();
                }else {
                   ArrayList<Comment> comments = new ArrayList<Comment>();
                   moments.add(new Moment(content + "", comments));
                   commen.setText("");
                   mAdapter.notifyDataSetChanged();
                   InputMethodManager im = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                   im.hideSoftInputFromWindow(commenmy.getWindowToken(), 0);

               }
            }
        });
    }

    private void init() {
        // 模拟数据
        ArrayList<Comment> comments = new ArrayList<Comment>();

        for (int i = 0; i < 4; i++) {
            comments.add(new Comment(new User(i + 2, "用户" + i), "评论" + i, null));
            comments.add(new Comment(new User(i + 100, "用户" + (i + 100)), "评论" + i, new User(i + 200, "用户" + (i + 200))));
            moments.add(new Moment("动态 " + i, comments));
        }
        mAdapter = new MomentAdapter(this, moments, new CustomTagHandler(this, new CustomTagHandler.OnCommentClickListener() {
            @Override
            public void onCommentatorClick(View view, User commentator) {
                //点击评论者
                Toast.makeText(getApplicationContext(), commentator.mName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onReceiverClick(View view, User receiver) {
                //点击被回复者
                Toast.makeText(getApplicationContext(), receiver.mName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onContentClick(View view, User commentator, User receiver) {
                //点击评论内容
                if (commentator != null && commentator.mId == sUser.mId) { // 不能回复自己的评论
                    return;
                }
                inputComment(view, commentator);
            }
        }));
        mListView.setAdapter(mAdapter);
        mListView.addHeaderView(webView);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"click"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void inputComment(final View v) {
        inputComment(v, null);
    }

    public void inputComment(final View v, final User receiver) {
        CommentFun.inputComment(this, mListView, v, receiver, new CommentFun.InputCommentListener() {
            @Override
            public void onCommitComment(String content) {
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    /**
     * webview
     */
    private void sendRequest(String url) {
      //  showProgressDialog();
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
                    //    closeProgressDialog();
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

    private void chooseScale(int width) {
        if(width > 650)
        {
            this.webView.setInitialScale(320);
        }else if(width > 520)
        {
            this.webView.setInitialScale(180);
        }else if(width > 450)
        {
            this.webView.setInitialScale(160);
        }else if(width > 300)
        {
            this.webView.setInitialScale(140);
        }else
        {
            this.webView.setInitialScale(100);
        }
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
        webSettings.setDisplayZoomControls(false);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBlockNetworkImage(false);
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
    void commenMy(View view){
        Toast.makeText(this, "哈哈哈", Toast.LENGTH_SHORT).show();
    }
    private void showProgressDialog(){
        if (progressDialog==null){
            progressDialog=new ProgressDialog(this);
            progressDialog.setMessage("正在加载...");
            progressDialog.setCanceledOnTouchOutside(false);
        }
        progressDialog.show();
    }
    private void closeProgressDialog(){
        if (progressDialog!=null){
            progressDialog.dismiss();
        }
    }
}
