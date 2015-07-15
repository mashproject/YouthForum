package com.benutzer.unescoyouthforum15;

/**
 * Created by amitesh on 14/7/15.
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

public class SpeakerAdapter extends ArrayAdapter{
    int id;
    String[] res;
    boolean display = false;
    Handler handleSpeakerDisplay = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            display = true;
        }
    };

    SpeakerAdapter(Context context, String[] resource, int idResource) {
        super(context, R.layout.custom_speaker,resource);
        id = idResource;
        res = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.custom_speaker, parent, false);

        loadSpeakerData(position);

        while(display){
            TextView textView = (TextView) customView.findViewById(R.id.speakerTextVewId);
            ImageView imageView = (ImageView) customView.findViewById(R.id.speakerImageViewId);

        /*
        assign image value from sdcard to imageView
         */

            imageView.setImageResource(R.drawable.speakerbuttonicon);//only for prototype
            textView.setText(
                    "" + getContext().getResources().getString(R.string.speakerName) + res[position] + "\n"//res for prototype only
                            + getContext().getResources().getString(R.string.speakerEvent) + "\n"
                            + getContext().getResources().getString(R.string.speakerPosition) + "\n"
                            + getContext().getResources().getString(R.string.speakerTwitterHandle)
            );
            display = false;
        }

        return customView;
    }

    private void loadSpeakerData(int positon){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
            /*
            code to load the data of the specific speaker
            select * from speakertable where eventid = id and speakername = res[position]
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
