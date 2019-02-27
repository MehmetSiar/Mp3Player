package com.example.mp3player1;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;


public class MusicPlay extends AppCompatActivity {
    Intent pathIntent;
  //  SeekBar seekBar;
  //  Handler mHandler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_play);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       //  seekBar = findViewById(R.id.seekBar);
        Button btnPlay = findViewById(R.id.button2);
        Button btnStop = findViewById(R.id.button3);
       // mHandler=new Handler();



        final FloatingActionButton[] fab = {findViewById(R.id.fab)};
        fab[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pathIntentStart = new Intent(MusicPlay.this,MusicService.class);
                Bundle extras = getIntent().getExtras();
                String value = extras.getString("path2");
                pathIntentStart.putExtra("path3",value);
                startService(pathIntentStart);
    }

            });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pathIntent = new Intent(MusicPlay.this, MusicService.class);
                Bundle extras = getIntent().getExtras();
                String value = extras.getString("path2");
                pathIntent.putExtra("path3", value);

                stopService(pathIntent);
            }
            });
//          MusicPlay.this.runOnUiThread(new Runnable() {
//              @Override
//              public void run() {
//                  if (musicService.mediaPlayer != null){
//                      int mCurrentPosition = musicService.mediaPlayer.getCurrentPosition() / 1000;
//                      seekBar.setProgress(mCurrentPosition);
//                  }
//                  mHandler.postDelayed(this, 1000);
//              }
//          });
//     seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//             @Override
//             public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                 seekBar.setMax(musicService.mediaPlayer.getDuration() / 1000);
//
//                 musicService.mediaPlayer.seekTo(progress*1000);
//             }
//
//             @Override
//             public void onStartTrackingTouch(SeekBar seekBar) {
//
//             }
//
//             @Override
//             public void onStopTrackingTouch(SeekBar seekBar) {
//
//             }
//     });
          }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        pathIntent = new Intent(MusicPlay.this, MusicService.class);
        Bundle extras = getIntent().getExtras();
        String value = extras.getString("path2");
        pathIntent.putExtra("path3", value);

        stopService(pathIntent);


        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        stopService(pathIntent);
        super.onDestroy();

    }
}




