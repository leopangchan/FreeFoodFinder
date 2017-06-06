package com.example.yiupang.freefoodfinder;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

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
    List<Event> events;

    public EventArrayAdapter(Context context, int layoutResourceId, List<Event> events)
    {
        super(context, layoutResourceId, events);
        this.context = context;
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
        ViewHolder holder;
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View newConvertView = convertView;

        if(newConvertView == null)
        {
            newConvertView = inflater.inflate(R.layout.events_list_item, parent, false);
            holder = new ViewHolder();

            holder.name = (TextView) newConvertView.findViewById(R.id.name);
            holder.type = (TextView) newConvertView.findViewById(R.id.type);
            holder.desc = (TextView) newConvertView.findViewById(R.id.desc);

            Event rowPos = events.get(position);

            holder.name.setText(rowPos.getName());
            holder.type.setText(rowPos.getFoodType());
            holder.desc.setText(rowPos.getDescription());

            newConvertView.setTag(holder);
        }
        return newConvertView;
    }
}
