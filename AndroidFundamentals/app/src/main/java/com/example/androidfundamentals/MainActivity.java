package com.example.androidfundamentals;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button play = (Button) findViewById(R.id.play);
        final Button pause = (Button) findViewById(R.id.pause);
        final Button stop = (Button) findViewById(R.id.stop);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ServiceStreaming.class);
                intent.setAction("com.example.androidfundamentals.action.PLAY");
                startService(intent);
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ServiceStreaming.class);
                intent.setAction("com.example.androidfundamentals.action.PAUSE");
                startService(intent);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ServiceStreaming.class);
                intent.setAction("com.example.androidfundamentals.action.STOP");
                startService(intent);
            }
        });
    }



//    private void play() {
//        //http://streaming.radionomy.com/70s-Disco-Nights?lang=en-US%2cen%3bq%3d0.8%2ces%3bq%3d0.6
//
//        Uri.Builder uri = new Uri.Builder();
//        uri.scheme("http")
//                .authority("streaming.radionomy.com")
//                .appendPath("70s-Disco-Nights")
//                .appendQueryParameter("lang", "en-US%2cen%3bq%3d0.8%2ces%3bq%3d0.6");
//        MediaPlayer mediaPlayer = new MediaPlayer();
//
//        try {
//            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//            mediaPlayer.setDataSource(getApplicationContext(), uri.build());
//            mediaPlayer.setOnPreparedListener(this);
//            mediaPlayer.prepareAsync(); // prepare async to not block main thread
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        mediaPlayer.start();
//    }
}
