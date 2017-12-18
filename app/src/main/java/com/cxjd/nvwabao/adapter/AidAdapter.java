package com.cxjd.nvwabao.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cxjd.nvwabao.FirstAid.Aid01;
import com.cxjd.nvwabao.FirstAid.Aid02;
import com.cxjd.nvwabao.FirstAid.Aid03;
import com.cxjd.nvwabao.FirstAid.Aid04;
import com.cxjd.nvwabao.FirstAid.Aid05;
import com.cxjd.nvwabao.FirstAid.Aid06;
import com.cxjd.nvwabao.FirstAid.Aid07;
import com.cxjd.nvwabao.FirstAid.Aid08;
import com.cxjd.nvwabao.FirstAid.Aid09;
import com.cxjd.nvwabao.FirstAid.Aid10;
import com.cxjd.nvwabao.FirstAid.Aid11;
import com.cxjd.nvwabao.FirstAid.Aid12;
import com.cxjd.nvwabao.FirstAid.Aid13;
import com.cxjd.nvwabao.FirstAid.Aid14;
import com.cxjd.nvwabao.FirstAid.Aid15;
import com.cxjd.nvwabao.FirstAid.Aid16;
import com.cxjd.nvwabao.FirstAid.Aid17;
import com.cxjd.nvwabao.FirstAid.Aid18;
import com.cxjd.nvwabao.FirstAid.Aid19;
import com.cxjd.nvwabao.FirstAid.Aid20;
import com.cxjd.nvwabao.FirstAid.Aid21;
import com.cxjd.nvwabao.FirstAid.Aid22;
import com.cxjd.nvwabao.FirstAid.Aid23;
import com.cxjd.nvwabao.FirstAid.Aid24;
import com.cxjd.nvwabao.FirstAid.Aid25;
import com.cxjd.nvwabao.FirstAid.Aid26;
import com.cxjd.nvwabao.FirstAid.Aid27;
import com.cxjd.nvwabao.FirstAid.Aid28;
import com.cxjd.nvwabao.FirstAid.Aid29;
import com.cxjd.nvwabao.FirstAid.Aid30;
import com.cxjd.nvwabao.FirstAid.Aid31;
import com.cxjd.nvwabao.FirstAid.Aid32;
import com.cxjd.nvwabao.FirstAid.Aid33;
import com.cxjd.nvwabao.FirstAid.Aid34;
import com.cxjd.nvwabao.FirstAid.Aid35;
import com.cxjd.nvwabao.FirstAid.Aid36;
import com.cxjd.nvwabao.FirstAid.Aid37;
import com.cxjd.nvwabao.FirstAid.Aid38;
import com.cxjd.nvwabao.FirstAid.Aid39;
import com.cxjd.nvwabao.FirstAid.Aid40;
import com.cxjd.nvwabao.FirstAid.Aid41;
import com.cxjd.nvwabao.FirstAid.Aid42;
import com.cxjd.nvwabao.FirstAid.Aid43;
import com.cxjd.nvwabao.FirstAid.Aid44;
import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.bean.ListView;

import java.util.List;

/**
 * Created by 李超 on 2017/12/4.
 */

public class AidAdapter extends RecyclerView.Adapter<AidAdapter.ViewHolder> {

    private List<ListView> mListView;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View aidItemView;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            aidItemView = itemView;
            textView = itemView.findViewById(R.id.aid_TextView);
        }
    }

    public AidAdapter(List<ListView> mListView) {
        this.mListView = mListView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.aid_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.aidItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();

                switch (position){
                    case 0 :
                        Intent intent = new Intent(view.getContext(), Aid01.class);
                        view.getContext().startActivity(intent);
                        break;
                    case 1 :
                        Intent intent1 = new Intent(view.getContext(), Aid02.class);
                        view.getContext().startActivity(intent1);
                        break;
                    case 2 :
                        Intent intent2 = new Intent(view.getContext(), Aid03.class);
                        view.getContext().startActivity(intent2);
                        break;
                    case 3 :
                        Intent intent3 = new Intent(view.getContext(), Aid04.class);
                        view.getContext().startActivity(intent3);
                        break;
                    case 4 :
                        Intent intent4 = new Intent(view.getContext(), Aid05.class);
                        view.getContext().startActivity(intent4);
                        break;
                    case 5 :
                        Intent intent5 = new Intent(view.getContext(), Aid06.class);
                        view.getContext().startActivity(intent5);
                        break;
                    case 6 :
                        Intent intent6 = new Intent(view.getContext(), Aid07.class);
                        view.getContext().startActivity(intent6);
                        break;
                    case 7 :
                        Intent intent7 = new Intent(view.getContext(), Aid08.class);
                        view.getContext().startActivity(intent7);
                        break;
                    case 8 :
                        Intent intent8 = new Intent(view.getContext(), Aid09.class);
                        view.getContext().startActivity(intent8);
                        break;
                    case 9 :
                        Intent intent9 = new Intent(view.getContext(), Aid10.class);
                        view.getContext().startActivity(intent9);
                        break;
                    case 10 :
                        Intent intent10 = new Intent(view.getContext(), Aid11.class);
                        view.getContext().startActivity(intent10);
                        break;
                    case 11 :
                        Intent intent11 = new Intent(view.getContext(), Aid12.class);
                        view.getContext().startActivity(intent11);
                        break;
                    case 12 :
                        Intent intent12 = new Intent(view.getContext(), Aid13.class);
                        view.getContext().startActivity(intent12);
                        break;
                    case 13 :
                        Intent intent13 = new Intent(view.getContext(), Aid14.class);
                        view.getContext().startActivity(intent13);
                        break;
                    case 14 :
                        Intent intent14 = new Intent(view.getContext(), Aid15.class);
                        view.getContext().startActivity(intent14);
                        break;
                    case 15 :
                        Intent intent15 = new Intent(view.getContext(), Aid16.class);
                        view.getContext().startActivity(intent15);
                        break;
                    case 16 :
                        Intent intent16 = new Intent(view.getContext(), Aid17.class);
                        view.getContext().startActivity(intent16);
                        break;
                    case 17 :
                        Intent intent17 = new Intent(view.getContext(), Aid18.class);
                        view.getContext().startActivity(intent17);
                        break;
                    case 18 :
                        Intent intent18 = new Intent(view.getContext(), Aid19.class);
                        view.getContext().startActivity(intent18);
                        break;
                    case 19 :
                        Intent intent19 = new Intent(view.getContext(), Aid20.class);
                        view.getContext().startActivity(intent19);
                        break;
                    case 20 :
                        Intent intent20 = new Intent(view.getContext(), Aid21.class);
                        view.getContext().startActivity(intent20);
                        break;
                    case 21 :
                        Intent intent21 = new Intent(view.getContext(), Aid22.class);
                        view.getContext().startActivity(intent21);
                        break;
                    case 22 :
                        Intent intent22 = new Intent(view.getContext(), Aid23.class);
                        view.getContext().startActivity(intent22);
                        break;
                    case 23 :
                        Intent intent23 = new Intent(view.getContext(), Aid24.class);
                        view.getContext().startActivity(intent23);
                        break;
                    case 24 :
                        Intent intent24 = new Intent(view.getContext(), Aid25.class);
                        view.getContext().startActivity(intent24);
                        break;
                    case 25 :
                        Intent intent25 = new Intent(view.getContext(), Aid26.class);
                        view.getContext().startActivity(intent25);
                        break;
                    case 26 :
                        Intent intent26 = new Intent(view.getContext(), Aid27.class);
                        view.getContext().startActivity(intent26);
                        break;
                    case 27 :
                        Intent intent27 = new Intent(view.getContext(), Aid28.class);
                        view.getContext().startActivity(intent27);
                        break;
                    case 28 :
                        Intent intent28 = new Intent(view.getContext(), Aid29.class);
                        view.getContext().startActivity(intent28);
                        break;
                    case 29 :
                        Intent intent29 = new Intent(view.getContext(), Aid30.class);
                        view.getContext().startActivity(intent29);
                        break;
                    case 30 :
                        Intent intent30 = new Intent(view.getContext(), Aid31.class);
                        view.getContext().startActivity(intent30);
                        break;
                    case 31 :
                        Intent intent31 = new Intent(view.getContext(), Aid32.class);
                        view.getContext().startActivity(intent31);
                        break;
                    case 32 :
                        Intent intent32 = new Intent(view.getContext(), Aid33.class);
                        view.getContext().startActivity(intent32);
                        break;
                    case 33 :
                        Intent intent33 = new Intent(view.getContext(), Aid34.class);
                        view.getContext().startActivity(intent33);
                        break;
                    case 34 :
                        Intent intent34 = new Intent(view.getContext(), Aid35.class);
                        view.getContext().startActivity(intent34);
                        break;
                    case 35 :
                        Intent intent35 = new Intent(view.getContext(), Aid36.class);
                        view.getContext().startActivity(intent35);
                        break;
                    case 36 :
                        Intent intent36 = new Intent(view.getContext(), Aid37.class);
                        view.getContext().startActivity(intent36);
                        break;
                    case 37 :
                        Intent intent37 = new Intent(view.getContext(), Aid38.class);
                        view.getContext().startActivity(intent37);
                        break;
                    case 38 :
                        Intent intent38 = new Intent(view.getContext(), Aid39.class);
                        view.getContext().startActivity(intent38);
                        break;
                    case 39 :
                        Intent intent39 = new Intent(view.getContext(), Aid40.class);
                        view.getContext().startActivity(intent39);
                        break;
                    case 40 :
                        Intent intent40 = new Intent(view.getContext(), Aid41.class);
                        view.getContext().startActivity(intent40);
                        break;
                    case 41 :
                        Intent intent41 = new Intent(view.getContext(), Aid42.class);
                        view.getContext().startActivity(intent41);
                        break;
                    case 42 :
                        Intent intent42 = new Intent(view.getContext(), Aid43.class);
                        view.getContext().startActivity(intent42);
                        break;
                    case 43 :
                        Intent intent43 = new Intent(view.getContext(), Aid44.class);
                        view.getContext().startActivity(intent43);
                        break;



                }

            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
         ListView listView = mListView.get(position);
         holder.textView.setText(listView.getName());
    }

    @Override
    public int getItemCount() {
        return mListView.size();
    }


}
