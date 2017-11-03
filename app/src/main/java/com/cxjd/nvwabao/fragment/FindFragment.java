package com.cxjd.nvwabao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cxjd.nvwabao.R;

/**
 * Created by 李超 on 2017/10/29.
 */

public class FindFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find,container,false);
        TextView textView = view.findViewById(R.id.fragment_title);
        textView.setText(R.string.find);
        return view;
    }
}
