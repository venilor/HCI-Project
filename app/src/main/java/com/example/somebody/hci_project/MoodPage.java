package com.example.somebody.hci_project;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;

public class MoodPage extends AppCompatActivity {

    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_page);

        final View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.GRAY);


        Button one = (Button) this.findViewById(R.id.BIGMOOD);


        final AssetFileDescriptor file = this.getResources().openRawResourceFd(R.raw.arrow);

        one.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                stopPlaying();
                mp = MediaPlayer.create(MoodPage.this, R.raw.arrow);
                mp.start();
                mp.setLooping(true);
            }
        });

        Button two = (Button) this.findViewById(R.id.SMOLMOOD);

        two.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stopPlaying();
                mp = MediaPlayer.create(MoodPage.this, R.raw.arrow);
                mp.stop();
            }
        });

    }

    private void stopPlaying(){
        if(mp != null){
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}
