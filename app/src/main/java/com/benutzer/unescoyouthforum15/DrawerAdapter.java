package com.benutzer.unescoyouthforum15;

/**
 * Created by amitesh on 20/7/15.
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

public class DrawerAdapter extends ArrayAdapter{
    DrawerAdapter(Context context, String[] resource) {
        super(context, R.layout.custom_speaker,resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.custom_drawer, parent, false);

        ImageView imageView = (ImageView) customView.findViewById(R.id.drawerImageViewId);
        TextView textView = (TextView) customView.findViewById(R.id.drawerTextVewId);
        imageView.setImageResource(R.drawable.iconplaceholder);
        textView.setText(getContext().getResources().getStringArray(R.array.drawerOption)[position]);

        return customView;
    }
}
