package com.cxjd.nvwabao.ActivityNews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.adapter.DragAdapter;
import com.cxjd.nvwabao.bean.FocusTitle;
import com.cxjd.nvwabao.helper.ItemDragHelperCallback;
import com.cxjd.nvwabao.utils.TitleListManagr;

import java.util.ArrayList;
import java.util.List;

/**
 * 拖拽
 * Created by YoKeyword on 16/1/4.
 */
/**
 * 拖拽
 * Created by YoKeyword on 16/1/4.
 */
public class DragActivity extends AppCompatActivity{
    private RecyclerView mRecy;
    List<String> titlelist;
    List<FocusTitle> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        mRecy = (RecyclerView) findViewById(R.id.recy);
        titlelist=new ArrayList<>();
        init();
    }

    private void init() {
        initTitle();
        GridLayoutManager manager = new GridLayoutManager(this, 5);
        mRecy.setLayoutManager(manager);

        ItemDragHelperCallback callback = new ItemDragHelperCallback(){
            @Override
            public boolean isLongPressDragEnabled() {
                // 长按拖拽打开
                return true;
            }
        };
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(mRecy);

        final DragAdapter adapter = new DragAdapter(this, items);
        //adapter.setGiveback(giveback);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int viewType = adapter.getItemViewType(position);
                return viewType == DragAdapter.TYPE_TITLE ? 5 : 1;
            }
        });
       /* adapter.ItemClick(this, new DragAdapter.OnItemClickCallback() {
            @Override
            public void onClick(View view, Object info) {
                Intent intent=new Intent(DragActivity.this,TitleStateActivity.class);
                startActivity(intent);
              Log.i("TAG",view.getContext().toString());
            }
        });*/
        mRecy.setAdapter(adapter);
    }
    public List<FocusTitle> getTitleList(){
        initTitle();
        return items;
    }

    private void initTitle() {
        items = new ArrayList<>();
        List<FocusTitle> list= TitleListManagr.readTitleList(this);
        Log.i("TAG",list.toString()+"hjnk");
        for (int i = 0; i <list.size(); i++) {
            items.add(list.get(i));
            Log.i("TAG1",items.get(i).getTitleName());
        }
    }

}