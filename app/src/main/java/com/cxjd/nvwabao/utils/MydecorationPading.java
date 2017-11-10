package com.cxjd.nvwabao.utils;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cxjd.nvwabao.R;


/**
 * Created by abu on 2017/10/8.
 */

public class MydecorationPading extends RecyclerView.ItemDecoration {
    private int divider;
    public MydecorationPading(Context context) {
           divider=context.getResources().getDimensionPixelSize(R.dimen.divider);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom=divider;
        outRect.right=divider;
    }
}
