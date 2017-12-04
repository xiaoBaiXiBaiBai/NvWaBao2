package com.cxjd.nvwabao.fragment.findFunctions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.adapter.ListViewAdapter;
import com.cxjd.nvwabao.fragment.findFunctions.twentyfourHours.Find24HoursRight01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 李超 on 2017/11/29.
 */

public class Left24HoursFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.left_fragment_find_24hours,container,false);
        return view;
    }


}
