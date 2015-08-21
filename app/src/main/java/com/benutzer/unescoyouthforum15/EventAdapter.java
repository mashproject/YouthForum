package com.benutzer.unescoyouthforum15;

/**
 * Created by amitesh on 16/7/15.
 */

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class EventAdapter extends ArrayAdapter{
    String res[];
    boolean display = false;
    Handler handleEventAdpaterDisplay = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            display = true;
        }
    };

    EventAdapter(Context context, String[] resource){
        super(context, R.layout.custom_event, resource);

        res = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.custom_event, parent, false);

        loadEventAdapterData(position);

       //while(!display){}
            TextView textView = (TextView) customView.findViewById(R.id.eventAdapterTextVewId);
            TextView textViewHidden = (TextView) customView.findViewById(R.id.hiddenViewEventId);
            ImageView imageView = (ImageView) customView.findViewById(R.id.eventAdapterImageViewId);

            /*
            load image icon from sd card
             */

            textView.setText(
                    "" + getContext().getResources().getString(R.string.eventAdapterName)  + " " + res[position]+ "" + "\n"
                    + getContext().getResources().getString(R.string.eventAdapterDesc) + "\n"
            );
            textViewHidden.setText(res[position]); //only for prototype
            imageView.setImageResource(R.drawable.splashimage2); //only for prototype

            display = false;
       // }

        return customView;
    }

    private void loadEventAdapterData(int position){
        Runnable runnable =  new Runnable() {
            @Override
            public void run() {
                /*
                load the data and image icon for event using event id i.e. res[position]
                 */

                handleEventAdpaterDisplay.sendEmptyMessage(0);
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
