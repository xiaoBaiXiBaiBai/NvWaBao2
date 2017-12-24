package com.cxjd.nvwabao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.bean.People;

import java.util.List;

/**
 * Created by Administrator on 2017/12/1.
 */

public class Select2Adapter extends BaseAdapter {
    private Context context;
    private List<String> persons;
    private ViewHolder holder;
    private int defItem;//声明默认选中的项

    public Select2Adapter(Context context, List<String> persons) {
        super();
        this.context = context;
        this.persons = persons;
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Object getItem(int position) {
        return persons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    /**
     适配器中添加这个方法
     */
    public void setDefSelect(int position) {
        this.defItem = position;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       // People people = (People) getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_parent_item, null);
            holder = new ViewHolder();
            holder.item1 = (TextView) convertView.findViewById(R.id.item1);
          ///  holder.fruitImage = convertView.findViewById(R.id.fruit_image);
          //  holder.item2 = (TextView) convertView.findViewById(R.id.item2);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (defItem == position) {
            convertView.setBackgroundResource(R.color.white);
        } else {
            convertView.setBackgroundResource(R.color.huise);
        }
        //绑定数据
       // Person person = persons.get(position);
      //  holder.fruitImage.setImageResource(people.getImageId());
        holder.item1.setText(persons.get(position));
       // holder.item2.setText(person.getSex());
        return convertView;
    }

    class ViewHolder {
       // ImageView fruitImage;
        TextView item1;
    }

}

