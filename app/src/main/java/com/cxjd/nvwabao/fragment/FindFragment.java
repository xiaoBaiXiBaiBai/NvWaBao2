package com.cxjd.nvwabao.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.bean.FindFunction;
import com.cxjd.nvwabao.bean.FindFunctionAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by 李超 on 2017/10/29.
 *
 * 发现碎片
 *
 */

public class FindFragment extends Fragment {

    private List<FindFunction> functionList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find,container,false);
        TextView textView = view.findViewById(R.id.fragment_title);
        textView.setText(R.string.find);
        if(functionList.isEmpty()==true){
            initFindFunction();
        }
        RecyclerView recyclerView = view.findViewById(R.id.find_recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this.getActivity(),3);
        recyclerView.setLayoutManager(layoutManager);
        FindFunctionAdapter adapter = new FindFunctionAdapter(functionList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    /**
     *   初始化发现列表功能
     */
    private void initFindFunction() {
        FindFunction twentyFour  = new FindFunction(R.drawable.icon_find_24);
        functionList.add(twentyFour);
        FindFunction fourAndFive = new FindFunction(R.drawable.icon_find_fiveandfour);
        functionList.add(fourAndFive);
        FindFunction shengAndKe  = new FindFunction(R.drawable.icon_find_shnegandke);
        functionList.add(shengAndKe);
        FindFunction yingYangSu  = new FindFunction(R.drawable.icon_find_yingyangsu);
        functionList.add(yingYangSu);
        FindFunction jiJiu       = new FindFunction(R.drawable.icon_find_jijiu);
        functionList.add(jiJiu);
        FindFunction weight      = new FindFunction(R.drawable.icon_find_weight);
        functionList.add(weight);
        FindFunction tableware   = new FindFunction(R.drawable.icon_find_tableware);
        functionList.add(tableware);
        FindFunction seven       = new FindFunction(R.drawable.icon_find_qi);
        functionList.add(seven);
        FindFunction baibing     = new FindFunction(R.drawable.icon_find_sick);
        functionList.add(baibing);

    }
}






