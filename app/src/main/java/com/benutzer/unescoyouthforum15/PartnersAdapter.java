package com.benutzer.unescoyouthforum15;

/**
 * Created by amitesh on 22/7/15.
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

public class PartnersAdapter extends ArrayAdapter{
    String[] res;

    PartnersAdapter(Context context, String[] resource){
        super(context, R.layout.custom_partners, resource);
        res = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.custom_partners, parent, false);

        ImageView imageView = (ImageView) customView.findViewById(R.id.partnersImageViewId);
        TextView textView = (TextView) customView.findViewById(R.id.partnersTextViewId);

        /*
        load content
         */
        imageView.setImageResource(R.drawable.speakerbuttonicon);
        textView.setText(getContext().getResources().getString(R.string.partnerName) + " " + res[position]
                        + "\n" + getContext().getResources().getString(R.string.partnerContact));

        return customView;
    }
}
