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

public class CategoryAdapter extends ArrayAdapter{
    String res[];
    boolean display = false;
    Handler handleSpeakerDisplay = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            display = true;
        }
    };

    CategoryAdapter(Context context, String[] resource){
        super(context, R.layout.custom_category, resource);

        res = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.custom_category, parent, false);

        loadCategoryData(position);

        //while(display){
            TextView textView = (TextView) customView.findViewById(R.id.categoryTextVewId);
            ImageView imageView = (ImageView) customView.findViewById(R.id.categoryImageViewId);
            TextView textViewHidden = (TextView) customView.findViewById(R.id.hiddenViewId);
            /*
            assign image value from sdcard to imageView
            */

            imageView.setImageResource(R.drawable.splashimage1);//only for prototype
            textView.setText(
                    "" + getContext().getResources().getString(R.string.categoryName) + res[position] + "\n"//res for prototype only
                            + getContext().getResources().getString(R.string.categorySummary)
            );
            textViewHidden.setText(res[position]);

            display = false;
       // }

        return customView;
    }

    private void loadCategoryData(int positon){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
            /*
            code to load the data of the specific category
            select * from table where categoryname = res[position]
            */
            /*
            load speaker data in xml file and download the speaker image from provided url
            */
                handleSpeakerDisplay.sendEmptyMessage(0);
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

}
