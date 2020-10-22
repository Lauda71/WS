package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstAtive extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_ative);

        Button time, date;
        time = (Button) findViewById(R.id.btnTime);
        date = (Button) findViewById(R.id.btnDate);

        time.setOnClickListener(this);
        date.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        Intent intent;
        switch (v.getId())
        {
            case R.id.btnDate:
                intent = new Intent("com.example.intent.action.showdate");
                startActivity(intent);
                break;
            case  R.id.btnTime:
                intent = new Intent("com.example.intent.action.showtime");
                startActivity(intent);
                break;
        }
    }
}