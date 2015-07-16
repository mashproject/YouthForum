package com.benutzer.unescoyouthforum15;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ImageView;

import android.os.Handler;
import java.util.logging.LogRecord;


public class MainActivity extends ActionBarActivity {
        Handler handleSplashImageDisplay = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                displaySplashImage();
            }
        };

        Handler handleActivityStart = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                nextActicityLaunch();
            }
        };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Download Splash Image from Server
        loadBackgroundImage();
        //Display downloaded image on screen
        displaySplashImage();
        //pause screen for some time and load next activity's content from serever
        pauseSplashLoadContent();
        //launch next activity
        //check Handler
    }

    private void loadBackgroundImage(){
        //downloading splash image on phone
        Runnable runnableLoadSplash = new Runnable() {
            @Override
            public void run() {
                //required code to load splash Image
                handleSplashImageDisplay.sendEmptyMessage(0);
            }
        };
        Thread threadLoadSplash = new Thread(runnableLoadSplash);
        threadLoadSplash.start();
    };

    public void displaySplashImage(){
        //load image from sd card in real app

        ImageView imageView1 = (ImageView) findViewById(R.id.splashImage1Id);
        ImageView imageView2 = (ImageView) findViewById(R.id.splashImage2Id);
        imageView1.setImageResource(R.drawable.splashimage1);
        imageView2.setImageResource(R.drawable.splashimage2);
    };

    private void pauseSplashLoadContent(){
        Runnable runnablePause = new Runnable() {
            @Override
            public void run() {
                //required code
                long FutureTime = System.currentTimeMillis() + 2000;
                while(System.currentTimeMillis() < FutureTime){
                    synchronized (this){
                        try{
                            wait(FutureTime - System.currentTimeMillis());
                            /*
                            pausing the splash screen
                             */
                        }
                        catch(Exception ex){

                        }
                    }
                }
                handleActivityStart.sendEmptyMessage(0);
            }
        };
        Thread threadPause = new Thread(runnablePause);
        threadPause.start();
    };

    public void nextActicityLaunch(){
        Intent intent = new Intent(this, BrowseEvents.class);
        startActivity(intent);
    };
}
