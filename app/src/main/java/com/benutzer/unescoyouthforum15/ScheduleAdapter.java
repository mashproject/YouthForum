package com.benutzer.unescoyouthforum15;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * Created by amitesh on 14/8/15.
 */
public class ScheduleAdapter extends ArrayAdapter {
    String[] res;

    Handler handleScheduleDisplay = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //
        }
    };

    ScheduleAdapter(Context context, String[] resource){
        super(context, R.layout.custom_schedule, resource);
        res = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());

        View customView = layoutInflater.inflate(R.layout.custom_schedule, parent, false);
        ImageView imageView = (ImageView) customView.findViewById(R.id.scheduleAdapterImageViewId);
        TextView textView = (TextView) customView.findViewById(R.id.scheduleAdapterTextViewId);

        imageView.setImageResource(R.drawable.scheduleicon);
        textView.setText("Schedule : Time Date Venue " + res[position]);

        return customView;
    }
}
