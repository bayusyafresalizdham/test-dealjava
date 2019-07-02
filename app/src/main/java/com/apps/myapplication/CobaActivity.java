package com.apps.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.github.nkzawa.socketio.client.IO;
import okhttp3.OkHttpClient;

public class CobaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        IO.Options opts = new IO.Options();


    }
}
