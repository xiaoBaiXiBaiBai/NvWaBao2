package com.cxjd.nvwabao.ActivityNews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.adapter.DragAdapter;
import com.cxjd.nvwabao.bean.TitleLable;
import com.cxjd.nvwabao.helper.ItemDragHelperCallback;

import org.litepal.crud.DataSupport;

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
    private DragAdapter adapter;
    List<TitleLable> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        mRecy = (RecyclerView) findViewById(R.id.recy);
        init();
    }

    private void init() {
        items= DataSupport.findAll(TitleLable.class);
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

        adapter = new DragAdapter(this, items);
        //adapter.setGiveback(giveback);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int viewType = adapter.getItemViewType(position);
                return viewType == DragAdapter.TYPE_TITLE ? 5 : 1;
            }
        });
        mRecy.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        init();
        adapter.notifyDataSetChanged();
    }
}