package com.moutamid.livestreamingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import net.webilisim.webplayer.WEBPlayer;
import net.webilisim.webplayer.WEBPlayerStd;

public class VedioActivity extends AppCompatActivity {

    WEBPlayerStd webPlayerStd;
    RelativeLayout layout_options;

    TextView link , name;

    ImageView dec_brightness , inc_brightness;
    ImageView dec_sound , inc_sound;
    ImageView favroties , cast;
    ImageView radio_iv , stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vedio);

        link = findViewById(R.id.link);
        name = findViewById(R.id.name);

        dec_brightness = findViewById(R.id.dec_brightness);
        inc_brightness = findViewById(R.id.inc_brightness);
        dec_sound = findViewById(R.id.dec_sound);
        inc_sound = findViewById(R.id.inc_sound);
        favroties = findViewById(R.id.favroties);
        cast = findViewById(R.id.cast);
        radio_iv = findViewById(R.id.radio_iv);
        stop = findViewById(R.id.stop);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            link.setText(bundle.getString("link"));
            name.setText(bundle.getString("name"));
        }

        String link_text = link.getText().toString().trim();
        String name_text = name.getText().toString().trim();

        webPlayerStd = findViewById(R.id.webplayer);
        layout_options = findViewById(R.id.layout_buttons);

        webPlayerStd.setUp(link_text , name_text);

        dec_brightness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(VedioActivity.this, "Decrease Brightness", Toast.LENGTH_SHORT).show();
            }
        });

        inc_brightness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(VedioActivity.this, "Increase Brightness", Toast.LENGTH_SHORT).show();
            }
        });

        dec_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(VedioActivity.this, "Decrease Sound", Toast.LENGTH_SHORT).show();
            }
        });

        inc_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(VedioActivity.this, "Increase Sound", Toast.LENGTH_SHORT).show();
            }
        });

        favroties.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(VedioActivity.this, "Favroities", Toast.LENGTH_SHORT).show();
            }
        });

        cast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(VedioActivity.this, "Cast", Toast.LENGTH_SHORT).show();
            }
        });

        radio_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(VedioActivity.this, "Radio", Toast.LENGTH_SHORT).show();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(VedioActivity.this, "Stop", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (WEBPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        WEBPlayer.releaseAllVideos();
    }
}