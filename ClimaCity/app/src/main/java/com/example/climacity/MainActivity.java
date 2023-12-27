package com.example.climacity;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final int REQUEST_CODE = 123;
    final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather";
    final String APP_ID = "ea4f923ca0bb8eccf3937c74f453d407";
    final long MIN_TIME = 200;
    final float MIN_DISTANCE = 1;

    String LOCATION_PROVIDER = LocationManager.GPS_PROVIDER;
    final String LOGCAT_TAG = "Clima";

    TextView mTextViewCity;
    ImageView mImageViewSky;
    TextView mTextViewTemperature;

    LocationManager mLocationManager;
    LocationListener mLocationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mTextViewCity = (TextView) findViewById(R.id.textViewCity);
        mImageViewSky = (ImageView) findViewById(R.id.imageViewSky);
        mTextViewTemperature = (TextView) findViewById(R.id.textViewTemperature);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}