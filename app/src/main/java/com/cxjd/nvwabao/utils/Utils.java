package com.cxjd.nvwabao.utils;
import android.content.res.Resources;
/**
 * Created by 白 on 2018/3/30.
 */

public class Utils {
    /**
     * 密度
     */
    public static final float DENSITY = Resources.getSystem().getDisplayMetrics().density;

    public static int dp2px(int dp) {
        return Math.round(dp * DENSITY);
    }
}