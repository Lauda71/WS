package com.example.newmod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class second extends AppCompatActivity implements View.OnClickListener {


    Button btnman;
    Button btnwoman;
    Button btnKA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnman = (Button) findViewById(R.id.btnman);
        btnman.setOnClickListener(this);

        btnwoman = (Button) findViewById(R.id.btnwoman);
        btnwoman.setOnClickListener(this);

        btnKA = (Button) findViewById(R.id.btnKA);
        btnKA.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnman:
                Intent intent = new Intent(this, man.class);
                startActivity(intent);
                break;

            case R.id.btnwoman:
                Intent iintent = new Intent(this, woman.class);
                startActivity(iintent);
                break;
            case R.id.btnKA:
                Toast.makeText(this, "Функция пока не доступна...", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}      