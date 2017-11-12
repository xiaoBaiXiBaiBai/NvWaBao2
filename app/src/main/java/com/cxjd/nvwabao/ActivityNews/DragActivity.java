package com.cxjd.nvwabao.ActivityNews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
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
    List<FocusTitle> items,tempList;
    private DragAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        mRecy = (RecyclerView) findViewById(R.id.recy);
        titlelist=new ArrayList<>();
        tempList=new ArrayList<>();
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
    private void initTitle() {
         items = new ArrayList<>();
         tempList= TitleListManagr.readTitleList(this,TitleListManagr.str_show);
         if (tempList!=null){
             for (int i = 0; i <tempList.size(); i++) {
              items.add(i,tempList.get(i));
             }
         }else{
             tempList= TitleListManagr.readTitleList(this,TitleListManagr.str_all);
             for (int i = 0; i <tempList.size(); i++) {
                 items.add(i,tempList.get(i));
             }
         }
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        initTitle();
        adapter.notifyDataSetChanged();
    }
}