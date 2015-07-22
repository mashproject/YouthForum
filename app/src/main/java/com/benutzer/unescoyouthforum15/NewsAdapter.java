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

public class NewsAdapter extends ArrayAdapter{
    String[] res;

    NewsAdapter(Context context, String[] resource){
        super(context, R.layout.custom_news,resource);
        res = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());

        View customView = layoutInflater.inflate(R.layout.custom_news, parent, false);

        ImageView imageView = (ImageView) customView.findViewById(R.id.newsFeedImageViewId);
        TextView textView = (TextView) customView.findViewById(R.id.newsFeedTextViewId);

        imageView.setImageResource(R.drawable.iconplaceholder);
        textView.setText("News " + res[position]);

        return customView;
    }
}
