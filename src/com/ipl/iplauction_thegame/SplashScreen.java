package com.ipl.iplauction_thegame;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
 
public class SplashScreen extends Activity {
	MediaPlayer mp;
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 2000;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mp = MediaPlayer.create(getBaseContext(), R.raw.ipl_horn); 
        mp.start(); //Starts your sound
        new Handler().postDelayed(new Runnable() {
 
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
 
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
 
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
 public void onDestroy()
 {
	 if (mp != null) {
		   if (mp.isPlaying ()) mp.stop ();
		   mp.release ();
		   mp = null;
		}
	 super.onDestroy();
 }
}