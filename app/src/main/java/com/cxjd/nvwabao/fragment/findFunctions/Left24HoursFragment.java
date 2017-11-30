package com.cxjd.nvwabao.fragment.findFunctions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cxjd.nvwabao.R;

/**
 * Created by 李超 on 2017/11/29.
 */

public class Left24HoursFragment extends Fragment {

    private String[] data = {"23.00 ~ 01.00","01.00 ~ 03.00","03.00 ~ 05.00","05.00 ~ 07.00","07.00 ~ 09.00","09.00 ~ 11.00",
                              "11.00 ~ 13.00", "13.00 ~ 15.00","15.00 ~ 17.00","17.00 ~ 19.00","19.00 ~ 21.00","21.00 ~ 23.00"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.left_fragment_find_24hours,container,false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_list_item_1,data);
        ListView listView = view.findViewById(R.id.list_view_24);
        listView.setAdapter(adapter);
        return view;
    }
}
