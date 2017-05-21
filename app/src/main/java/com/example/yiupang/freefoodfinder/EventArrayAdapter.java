package com.example.yiupang.freefoodfinder;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


/**
 * Created by yiupang on 5/20/2017.
 *
 */
public class EventArrayAdapter extends ArrayAdapter<Event>
{
    private class ViewHolder{
        TextView name;
        TextView type;
        TextView desc;
    }

    private Context context;
    private int layoutResourceId;
    List<Event> events;

    public EventArrayAdapter(Context context, int layoutResourceId, List<Event> events)
    {
        super(context, layoutResourceId, events);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.events = events;
    }

    @Override
    public long getItemId(int position){return  events.indexOf(position);}

    @Override
    public int getCount(){
        return events.size();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder = null;
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();

        if(convertView == null) {
            convertView = inflater.inflate(R.layout.events_list_item, parent, false);
            holder = new ViewHolder();

            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.type = (TextView) convertView.findViewById(R.id.type);
            holder.desc = (TextView) convertView.findViewById(R.id.desc);

            Event row_pos = events.get(position);

            holder.name.setText(row_pos.getName());
            holder.type.setText(row_pos.getFoodType());
            holder.desc.setText(row_pos.getDescription());

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }
}
