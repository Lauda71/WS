package com.example.lessons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener*/ {

    TextView tv;
    CheckBox chb;
    //Button btnOk;
    //Button btnCancel;

    private static final String TAG = "myLogs";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.les14);

        // lesson 14
        tv = (TextView) findViewById(R.id.textView);
        chb = (CheckBox) findViewById(R.id.chbExtMenu);

        /* Lesson 12
        // найдем View-элементы
        Log.d(TAG, "найдем View-элементы");
        tvOut = (TextView) findViewById(R.id.tvOut);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);


        // присваиваем обработчик кнопкам
        Log.d(TAG, "присваиваем обработчик кнопкам");
        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

         */


        /*
        lesson 11

        LinearLayout llBottom = (LinearLayout) findViewById(R.id.llBottom);
        TextView tvBottom = (TextView) findViewById(R.id.tvBottom);
        Button btnBottom = (Button) findViewById(R.id.btnBottom);

        llBottom.setBackgroundResource(R.color.llBottomColor);
        tvBottom.setText(R.string.tvBottomText);
        btnBottom.setText(R.string.btnBottomText);
        */
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /*
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }*/

    // обновление меню
    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
        menu.setGroupVisible(R.id.group1, chb.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }


    // обработка нажатий
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder();

        // Выведем в TextView информацию о нажатом пункте меню
        sb.append("Item Menu");
        sb.append("\r\n groupId: " + String.valueOf(item.getGroupId()));
        sb.append("\r\n itemId: " + String.valueOf(item.getItemId()));
        sb.append("\r\n order: " + String.valueOf(item.getOrder()));
        sb.append("\r\n title: " + item.getTitle());
        tv.setText(sb.toString());

        return super.onOptionsItemSelected(item);
    }



    /*
    @Override
    public void onClick(View v) {
        // по id определяем кнопку, вызвавшую этот обработчик
        Log.d(TAG, "по id определяем кнопку, вызвавшую этот обработчик");

        switch (v.getId()) {
            case R.id.btnOk:
                // кнопка ОК
                Log.d(TAG, "кнопка ОК");
                tvOut.setText("Нажата кнопка ОКokOKokOK");
                Toast.makeText(this, "Нажата кнопка ОК", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnCancel:
                // кнопка Cancel
                Log.d(TAG, "кнопка Cancel");
                tvOut.setText("Нажата кнопка Canceeel");
                Toast.makeText(this, "Нажата кнопка Cancel", Toast.LENGTH_LONG).show();
                break;
        }
    }

     */
}