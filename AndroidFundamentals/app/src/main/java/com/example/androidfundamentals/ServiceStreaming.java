package com.example.androidfundamentals;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import java.io.IOException;

/**
 * Created by Osvaldo Villagrana on 3/20/16.
 */
public class ServiceStreaming extends Service implements MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener {
    public static final String ACTION_PLAY = "com.example.androidfundamentals.action.PLAY";
    public static final String ACTION_PAUSE = "com.example.androidfundamentals.action.PAUSE";
    public static final String ACTION_STOP = "com.example.androidfundamentals.action.STOP";
    public static final int STOPPED_STATE = 2;
    public static final int PREPARING_STATE = 3;
    public static final int PLAYING_STATE = 1;
    public static final int PAUSED_STATE = 1;
    final int NOTIFICATION_ID = 1;

    int state = STOPPED_STATE;

    MediaPlayer mediaPlayer = null;
    WifiManager.WifiLock wifiLock;
    NotificationManager mNotificationManager;
    NotificationCompat.Builder mNotificationBuilder = null;


    @Override
    public void onCreate() {
        wifiLock = ((WifiManager) getSystemService(Context.WIFI_SERVICE))
                .createWifiLock(WifiManager.WIFI_MODE_FULL, "mylock");
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent.getAction();

        if (action.equals(ACTION_PLAY)) processPlayRequest();
        else if (action.equals(ACTION_PAUSE)) processPauseRequest();
        else if (action.equals(ACTION_STOP)) processStopRequest();
        return START_NOT_STICKY;
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        state = PLAYING_STATE;
        setUpAsForeground("Playing");
        startMediaPlayer();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
        mediaPlayer.reset();
        return false;
    }

    @Override
    public void onDestroy() {
        stopForeground(true);

        if (mediaPlayer != null) {
            mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer = null;
        }

        if (wifiLock.isHeld()) {
            wifiLock.release();
        }
    }

    private void createMediaPlayer() {
        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
            mediaPlayer.setOnPreparedListener(this);
        } else {
            mediaPlayer.reset();
        }
    }

    private void processPlayRequest() {
        if (state == STOPPED_STATE) {
            play();
        } else if (state == PAUSED_STATE) {
            state = PLAYING_STATE;
            setUpAsForeground("Radio Station");
            startMediaPlayer();
        }
    }

    private void startMediaPlayer() {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    private void releaseResources(boolean releaseMediaPlayer, boolean stopForeground) {
        if (stopForeground) {
            stopForeground(true);
        }

        if (releaseMediaPlayer && mediaPlayer != null) {
            mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer = null;
        }

        if (wifiLock.isHeld()) {
            wifiLock.release();
        }
    }

    void setUpAsForeground(String text) {
        PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0,
                new Intent(getApplicationContext(), MainActivity.class),
                PendingIntent.FLAG_UPDATE_CURRENT);
        // Build the notification object.
        mNotificationBuilder = new NotificationCompat.Builder(getApplicationContext())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setTicker(text)
                .setWhen(System.currentTimeMillis())
                .setContentTitle("RandomMusicPlayer")
                .setContentText(text)
                .setContentIntent(pi)
                .setOngoing(true)
                .addAction(generateAction(android.R.drawable.ic_media_play, "Play", "com.example.androidfundamentals.action.PLAY"))
                .addAction(generateAction(android.R.drawable.ic_media_pause, "Pause", "com.example.androidfundamentals.action.PAUSE"))
                .addAction(generateAction(android.R.drawable.ic_delete, "Stop", "com.example.androidfundamentals.action.STOP"));
        startForeground(NOTIFICATION_ID, mNotificationBuilder.build());
    }

    private void processPauseRequest() {
        if (state == PLAYING_STATE) {
            state = PAUSED_STATE;
            mediaPlayer.pause();
            releaseResources(false, false);
            setUpAsForeground("Pause");
        }
    }

    private void processStopRequest() {
        if (state == PLAYING_STATE || state == PAUSED_STATE) {
            state = STOPPED_STATE;
            releaseResources(true, true);
            stopSelf();
        }
    }

    private void play() {
        state = STOPPED_STATE;
        releaseResources(false, true);

        createMediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        Uri.Builder uri = new Uri.Builder();
        uri.scheme("http")
                .authority("streaming.radionomy.com")
                .appendPath("70s-Disco-Nights")
                .appendQueryParameter("lang", "en-US%2cen%3bq%3d0.8%2ces%3bq%3d0.6");
        try {
            mediaPlayer.setDataSource(getApplicationContext(), uri.build());
        } catch (IOException e) {
            e.printStackTrace();
        }

        state = PREPARING_STATE;
        setUpAsForeground("loading...");
        mediaPlayer.prepareAsync();
        wifiLock.acquire();
    }

    private NotificationCompat.Action generateAction(int icon, String title, String intentAction ) {
        Intent intent = new Intent(getApplicationContext(), ServiceStreaming.class );
        intent.setAction(intentAction);
        PendingIntent pendingIntent = PendingIntent.getService(getApplicationContext(), 1, intent, 0);
        return new NotificationCompat.Action.Builder(icon, title, pendingIntent).build();
    }
}
