package com.example.MyApplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //setContentView(R.style.SplashTheme);
        //setTheme(R.style.SplashTheme);

        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, mainMenu.class);
        startActivity(intent);
        //finish();
    }
}

