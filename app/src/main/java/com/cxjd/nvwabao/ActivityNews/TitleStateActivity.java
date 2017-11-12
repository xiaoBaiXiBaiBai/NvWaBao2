package com.cxjd.nvwabao.ActivityNews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.adapter.SpecialRecyclerAdapter;
import com.cxjd.nvwabao.bean.FocusTitle;
import com.cxjd.nvwabao.utils.TitleListManagr;

import java.util.ArrayList;
import java.util.List;

public class TitleStateActivity extends AppCompatActivity {
    private List<FocusTitle> originList,temList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_state);
        originList=new ArrayList<>();
        originList= TitleListManagr.readTitleList(TitleStateActivity.this,TitleListManagr.str_all);

        RecyclerView recycler= (RecyclerView) findViewById(R.id.seasion_recycler_recycler);

        GridLayoutManager manager=new GridLayoutManager(this,2);

        recycler.setLayoutManager(manager);

        final SpecialRecyclerAdapter adapter=new SpecialRecyclerAdapter(originList,this);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int viewtype=adapter.getItemViewType(position);
                return viewtype== SpecialRecyclerAdapter.IS_TITLE.TITLE_IS.ordinal()? 2:1;
            }
        });
        recycler.setAdapter(adapter);
    }

}
