package com.example.somebody.hci_project;

import android.content.res.AssetFileDescriptor;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MoodPage extends AppCompatActivity {

    private MediaPlayer mp;
    public String currentSound = "";
    public boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_page);

        final View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.GRAY);


        Button playB = (Button) this.findViewById(R.id.playButton);

        playB.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                stopPlaying();
                int tempi;

                switch(currentSound){
                    case "Victorious":
                        tempi = R.raw.victorious;
                        break;
                    case "Magnificent":
                        tempi = R.raw.magnificent;
                        break;
                    case "Sad":
                        tempi = R.raw.sad;
                        break;
                    case "Brooding":
                        tempi = R.raw.brooding;
                        break;
                    case "Melancholy":
                        tempi = R.raw.melancholy;
                        break;
                    default:
                        tempi = R.raw.happy;
                        break;
                }

                mp = MediaPlayer.create(MoodPage.this, tempi);
                if(!isPlaying){
                    mp.setVolume(100f, 100f);
                    mp.start();
                    mp.setLooping(true);
                }
                isPlaying = true;
            }
        });

        Button stopB = (Button) this.findViewById(R.id.stopButton);

        stopB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stopPlaying();
                mp = MediaPlayer.create(MoodPage.this, R.raw.arrow);
                mp.stop();
                isPlaying = false;
            }
        });

        Button happyB = (Button) this.findViewById(R.id.happyButton);

        happyB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentSound = "Happy";
                view.setBackgroundColor(Color.YELLOW);
            }
        });

        Button vicB = (Button) this.findViewById(R.id.vicButton);

        vicB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentSound = "Victorious";
                view.setBackgroundColor(Color.GREEN);
            }
        });

        Button magB = (Button) this.findViewById(R.id.magButton);

        magB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentSound = "Magnificent";
                view.setBackgroundColor(Color.RED);
            }
        });

        Button sadB = (Button) this.findViewById(R.id.sadButton);

        sadB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentSound = "Sad";
                view.setBackgroundColor(Color.BLUE);
            }
        });

        Button broodB = (Button) this.findViewById(R.id.broodButton);

        broodB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentSound = "Brooding";
                view.setBackgroundColor(Color.GRAY);
            }
        });

        Button melB = (Button) this.findViewById(R.id.melButton);

        melB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentSound = "Melancholy";
                view.setBackgroundColor(Color.parseColor("#800080"));
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
