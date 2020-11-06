package com.example.manyforms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mainMenu extends AppCompatActivity {

    Button btnman;
    Button btnwoman;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //setTheme(R.style.SplashTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        btnman = (Button) findViewById(R.id.btnman);
        Intent intentman = new Intent(this, man.class);

        btnwoman = (Button) findViewById(R.id.btnwoman);
        Intent intentwoman = new Intent(this, woman.class);

        View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
                switch (v.getId()){
                    case (R.id.btnman):
                        startActivity(intentman);
                        break;
                    case (R.id.btnwoman):
                        startActivity(intentwoman   );
                        break;
                }
           }
        };

        btnman.setOnClickListener(oclBtn);
        btnwoman.setOnClickListener(oclBtn);
    }



}