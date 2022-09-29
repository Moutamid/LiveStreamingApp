package com.moutamid.livestreamingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MusicActivity extends AppCompatActivity {

    ImageView pause , play;
    ImageView forward, backward;
    MediaPlayer mediaPlayer;

    CardView card_seek;

    SeekBar seekBar;
    TextView playerPosition , playerDuration;

    Handler handler = new Handler();
    Runnable runnable;
    String audioUrl;

    @Override
    protected void onStart() {
        super.onStart();
        audioUrl = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3";
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(audioUrl);
            mediaPlayer.prepare();
            playAudio();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        pause = findViewById(R.id.pause);
        play = findViewById(R.id.play);
        backward = findViewById(R.id.backward);
        forward = findViewById(R.id.forward);
        card_seek = findViewById(R.id.card_seek);

        seekBar = findViewById(R.id.seek_bar);
        playerPosition = findViewById(R.id.player_positiom);
        playerDuration = findViewById(R.id.player_duration);

        runnable = new Runnable() {
            @Override
            public void run() {
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                handler.postDelayed(this::run , 500);
            }
        };


        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer != null) {
                    int currentPosition = mediaPlayer.getCurrentPosition();
                    int seekForwardTime = 30 * 1000;
                    if (currentPosition + seekForwardTime <= mediaPlayer.getDuration()) {
                        mediaPlayer.seekTo(currentPosition + seekForwardTime);
                    } else {
                        mediaPlayer.seekTo(mediaPlayer.getDuration());
                    }
                }
            }
        });

        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer != null) {
                    int currentPosition = mediaPlayer.getCurrentPosition();
                    int seekBackwardTime = 30 * 1000;
                    if (currentPosition - seekBackwardTime >= 0) {
                        mediaPlayer.seekTo(currentPosition - seekBackwardTime);
                    } else {
                        mediaPlayer.seekTo(0);
                    }
                }
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager conMgr = (ConnectivityManager) getSystemService (Context.CONNECTIVITY_SERVICE);
                // ARE WE CONNECTED TO THE NET
                if (conMgr.getActiveNetworkInfo() != null
                        && conMgr.getActiveNetworkInfo().isAvailable()
                        && conMgr.getActiveNetworkInfo().isConnected()) {
                    playAudio();
                } else {

                    Toast.makeText(MusicActivity.this, "Internet is not available...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    pause.setVisibility(View.GONE);
                    play.setVisibility(View.VISIBLE);
                    mediaPlayer.pause();
                    handler.removeCallbacks(runnable);
                } else {

                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b){
                    mediaPlayer.seekTo(i);
                }
                playerPosition.setText(convertFormat(mediaPlayer.getCurrentPosition()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    protected void onPause() {
        mediaPlayer.stop();
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        mediaPlayer.stop();
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        mediaPlayer.stop();
        super.onDestroy();
    }

    @SuppressLint("DefaultLocale")
    private String convertFormat(int duration) {
        return String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(duration),
                TimeUnit.MILLISECONDS.toSeconds(duration) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
    }

    private void playAudio() {
        pause.setVisibility(View.VISIBLE);
        play.setVisibility(View.GONE);
        mediaPlayer.start();
        mediaPlayer.seekTo(mediaPlayer.getCurrentPosition());
        seekBar.setMax(mediaPlayer.getDuration());
        handler.postDelayed(runnable , 0);
        playerDuration.setText(convertFormat(mediaPlayer.getDuration()));
    }
}