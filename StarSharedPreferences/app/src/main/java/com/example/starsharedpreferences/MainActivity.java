package com.example.starsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "prefs";
    private ImageView img;
    private Button btnOnOff;
    private boolean online;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        online = settings.getBoolean("online", false);

        if(online) {
            img.setImageResource(android.R.drawable.star_big_on);
        } else {
            img.setImageResource(android.R.drawable.star_big_off);
        }

        img = (ImageView) findViewById(R.id.img_star);
        btnOnOff = (Button) findViewById(R.id.btn_on_off);
        btnOnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOff();
            }
        });
    }

    public void onOff() {
        online = !online;

        if(online) {
            img.setImageResource(android.R.drawable.star_big_on);
        } else {
            img.setImageResource(android.R.drawable.star_big_off);
        }

        setOnline(online);
    }

    protected void setOnline(boolean online) {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("online", online);
        editor.commit();
    }
}