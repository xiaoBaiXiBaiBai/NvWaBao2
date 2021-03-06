package com.cxjd.nvwabao.ActivityNews;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

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
import android.widget.TextView;


import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.adapter.CommentFun;
import com.cxjd.nvwabao.adapter.CustomTagHandler;
import com.cxjd.nvwabao.adapter.HttpTitleUtil;
import com.cxjd.nvwabao.adapter.MomentAdapter;
import com.cxjd.nvwabao.bean.Comment;
import com.cxjd.nvwabao.bean.Moment;
import com.cxjd.nvwabao.bean.User;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.litepal.crud.DataSupport;
import android.widget.Toast;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class NewsDetailActivity extends Activity {
    String str;
    String string;
    private ProgressDialog progressDialog;
    private ListView mListView;
    private MomentAdapter mAdapter;
    WebView webView;
    ImageView hit,lovasave,commenmy;
    List<Moment> momentList;
    EditText commen;
    TextView lovecount;
    private String commentUrl = null;
    int pageId,count;
    View view;
    boolean IS_hit,IS_COLLECT;
    User user;
    List<User> userList;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        view= LayoutInflater.from(this).inflate(R.layout.webview_layout,null);
        webView=view.findViewById(R.id.webvie);
        user=DataSupport.findFirst(User.class);
        userList=new ArrayList<>();
        userList=DataSupport.findAll(User.class);

        initMycommen();
        WindowManager windowManager= (WindowManager)getSystemService(Context.WINDOW_SERVICE);
        int width = windowManager.getDefaultDisplay().getWidth();
        chooseScale(width);
        Intent intent=getIntent();
        String url=intent.getStringExtra("content")+"/"+34;
        pageId=intent.getIntExtra("pageId",-1);
        commentUrl="http://47.94.145.225/user/getComments/"+pageId+"/"+0;
        initWebview();
        sendRequest(url);
        mListView = (ListView) findViewById(R.id.list_moment);
    }

    private boolean justIsLogin() {
        if (userList.isEmpty()||userList.size()<=0){
            return false;
        }else {
            return true;
        }
    }

    private void requestComment(String commentUrl) {

        HttpTitleUtil.sendOkHttpRequest(commentUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                   runOnUiThread(new Runnable() {
                       @Override
                       public void run() {
                           Toast.makeText(NewsDetailActivity.this, "加载失败", Toast.LENGTH_SHORT).show();
                       }
                   });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                    final String requestResult=response.body().string();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            momentList=handleComment(requestResult);
                            init(momentList);
                        }
                    });
            }
        });
    }

    private List<Moment> handleComment(String commentsall){
        List<Moment> momentList=new ArrayList<>();
        try {
            JSONArray jsonArray=new JSONArray(commentsall);
            for (int i=0;i<jsonArray.length();i++){
                String comcontent=jsonArray.getJSONObject(i).toString();
                Moment moment=new Gson().fromJson(comcontent,Moment.class);
                momentList.add(moment);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return momentList;
    }
    private void initMycommen() {
        hit=findViewById(R.id.hitbtn);
        lovasave=findViewById(R.id.lovesave);
        commenmy=findViewById(R.id.commenMy);
        commen=findViewById(R.id.conmm);
        lovecount=findViewById(R.id.love_count);
        commenmy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (justIsLogin()==false){
                    Toast.makeText(NewsDetailActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
                }else {
                    String content = commen.getText().toString();
                    if (TextUtils.isEmpty(content)) {
                        Toast.makeText(NewsDetailActivity.this, "评论不能为空", Toast.LENGTH_SHORT).show();
                    } else {
                        User user = DataSupport.findFirst(User.class);
                        final ArrayList<Comment> comments = new ArrayList<Comment>();
                        Moment moment = new Moment();
                        moment.setmContent(content);
                        moment.setAuthor(user);
                        moment.setCreate_time("刚刚");
                        moment.setmComment(comments);
                        momentList.add(moment);
                        commen.setText("");
                        InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        im.hideSoftInputFromWindow(commenmy.getWindowToken(), 0);
                        mAdapter.notifyDataSetChanged();
                        mListView.post(new Runnable() {
                            @Override
                            public void run() {
                                mListView.smoothScrollToPosition(mListView.getBottom());
                            }
                        });
                        String posUrl = "http://47.94.145.225/user/addComments/" + content + "/" + user.getmId() + "/" + pageId + "/" + "-1";
                        HttpTitleUtil.sendOkHttpRequest(posUrl, new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {

                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                            }
                        });
                    }
                }
            }
        });

        hit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (justIsLogin()==false){
                    Toast.makeText(NewsDetailActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
                }else {
                    if (IS_hit == true) {
                        Toast.makeText(NewsDetailActivity.this, "你已点过赞", Toast.LENGTH_SHORT).show();
                    } else {
                        User user = DataSupport.findFirst(User.class);
                        String url = "http://47.94.145.225/user/addPraise/" + pageId + "/" + user.getmId();
                        HttpTitleUtil.sendOkHttpRequest(url, new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(NewsDetailActivity.this, "点赞失败", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        hit.setImageResource(R.mipmap.zanf);
                                        count++;
                                        lovecount.setText("" + count);
                                        Toast.makeText(NewsDetailActivity.this, "点赞成功", Toast.LENGTH_SHORT).show();
                                        IS_hit = true;
                                    }
                                });
                            }
                        });
                    }
                }
                }
        });
        lovasave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (justIsLogin()==false){
                    Toast.makeText(NewsDetailActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
                }else {
                    if (IS_COLLECT == false) {
                        String url = "http://47.94.145.225/user/getCollection/" + pageId + "/" + user.getmId() + "/add";
                        HttpTitleUtil.sendOkHttpRequest(url, new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {

                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        lovasave.setImageResource(R.mipmap.issave);
                                        Toast.makeText(NewsDetailActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                                        IS_COLLECT = true;
                                    }
                                });
                            }
                        });
                    } else {
                        String url = "http://47.94.145.225/user/getCollection/" + pageId + "/" + user.getmId() + "/del";
                        HttpTitleUtil.sendOkHttpRequest(url, new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {

                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        lovasave.setImageResource(R.mipmap.nsave);
                                        Toast.makeText(NewsDetailActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                                        IS_COLLECT = false;
                                    }
                                });
                            }
                        });

                    }
                }
            }
        });
    }

    private void init(List<Moment> moments) {
        mAdapter = new MomentAdapter(this,pageId, moments, new CustomTagHandler(this, new CustomTagHandler.OnCommentClickListener() {
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
                if (commentator != null && commentator.mId ==user.getmId() ) { // 不能回复自己的评论
                    return;
                }
                inputComment(view, commentator);
            }
        }));
        mListView.setAdapter(mAdapter);
        mListView.addHeaderView(view);
    }

    public void inputComment(final View v) {
        inputComment(v, null);
    }

    public void inputComment(final View v, final User receiver) {
        CommentFun.inputComment(this, mListView, v, receiver, new CommentFun.InputCommentListener() {
            @Override
            public void onCommitComment(String content,int position) {
                mAdapter.notifyDataSetChanged();
                User user= DataSupport.findFirst(User.class);
                String smallCommenUrl = null;
                if (receiver==null){
                    smallCommenUrl="http://47.94.145.225/user/addComments/"+content+"/"+user.getmId()+"/"+"-1"+"/"+position;
                }else {
                    smallCommenUrl="http://47.94.145.225/user/addComments/"+content+"/"+user.getmId()+"/"
                            +receiver.getmId()+"/"+position;
                }
                HttpTitleUtil.sendOkHttpRequest(smallCommenUrl, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                    }
                });
            }
        });
        InputMethodManager m=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        m.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * webview
     */
    private void sendRequest(String url) {
        showProgressDialog();
        HttpTitleUtil.sendHttpRequest(url, new HttpTitleUtil.HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                str=response.toString();
                try {
                    JSONObject jsonObject=new JSONObject(str);
                    string= (String) jsonObject.get("content");
                    count= (int) jsonObject.get("praise_num");
                    IS_hit= (boolean) jsonObject.get("is_user_praise");
                    IS_COLLECT= (boolean) jsonObject.get("is_user_collect");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                        webView.loadDataWithBaseURL(null,string,"text/html", "utf-8",null);
                            lovecount.setText(count+"");
                            if (IS_COLLECT==true){
                                lovasave.setImageResource(R.mipmap.issave);
                            }else {
                                lovasave.setImageResource(R.mipmap.nsave);
                            }
                            if (IS_hit==true){
                                hit.setImageResource(R.mipmap.zanf);
                            }else {
                                hit.setImageResource(R.mipmap.zan);
                            }
                            try {
                                Thread.sleep(2000);
                                requestComment(commentUrl);
                                closeProgressDialog();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
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
            this.webView.setInitialScale(315);
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
        webView.getSettings().setTextSize(WebSettings.TextSize.SMALLER);
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
