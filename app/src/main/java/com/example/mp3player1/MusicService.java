package com.example.mp3player1;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;

import java.io.IOException;

public class MusicService extends Service {
    MediaPlayer mediaPlayer = new MediaPlayer();
    String path3;

    public MusicService() {
    mediaPlayer.stop();
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        getSongPath(intent);
        Bundle extras = intent.getExtras();
         path3 = extras.getString("path3");
        mediaPlayer.reset();
        try {
            mediaPlayer.setDataSource(path3);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.start();
        return START_STICKY;

    }

    @Override
    public void onDestroy() {

      mediaPlayer.stop();
      mediaPlayer.reset();
        super.onDestroy();
    }


//    public String getSongPath(Intent intent){
//        Bundle extras = intent.getExtras();
//        path3 = extras.getString("path3");
//        return path3;
//    }


}

