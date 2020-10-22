package com.example.myapplication;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondPage extends AppCompatActivity implements Serializable {
    public Timer timer = new Timer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
                 SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String time = sdf.format(new Date(System.currentTimeMillis()));
                TextView tvTime = (TextView) findViewById(R.id.tvTime);
                tvTime.setText(time);

    }

}