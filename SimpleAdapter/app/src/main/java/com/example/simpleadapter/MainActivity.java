package com.example.simpleadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    final String ATRIBUTE_NAME_TEXT = "text";
    final String ATRIBUTE_NAME_CHECKED = "checked";
    final String ATRIBUTE_NAME_IMAGE = "image";
    final String ATRIBUTE_NAME_NAZVANIE = "note";

    ListView lvSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        // массивы даных
        String[] texts = {"sometext 1", "sometext 2", "sometext 3", "sometext 4", "sometext 5"};
        String[] notes = {"Название чек-бокса 1", "Название чек-бокса 2", "Название чек-бокса 3", "Название чек-бокса 4", "Название чек-бокса 5" };
        boolean[] checked = {true, false, false, true, false};
        int img = R.drawable.ic_launcher_foreground;

        // упаковываем данные в понятную для адапетара структуру
        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(texts.length);
        Map<String, Object> m;
        for (int i = 0; i < texts.length; i++){
            m = new HashMap<String, Object>();
            m.put(ATRIBUTE_NAME_TEXT, texts[i]);
            m.put(ATRIBUTE_NAME_CHECKED, checked[i]);
            m.put(ATRIBUTE_NAME_IMAGE, img);
            m.put(ATRIBUTE_NAME_NAZVANIE, notes[i]);
            data.add(m);
        }

        // массив имен атрибутов, из которых будут читаться данные
        String[] from = {ATRIBUTE_NAME_TEXT, ATRIBUTE_NAME_CHECKED, ATRIBUTE_NAME_IMAGE, ATRIBUTE_NAME_NAZVANIE};

        // массив ID View-компонентов, в которые будут вставлять даные
        int[] to = {R.id.tvText, R.id.cbChecked, R.id.ivImg, R.id.cbChecked};

        // создание адаптера
        SimpleAdapter sAdapetr = new SimpleAdapter(this, data, R.layout.item, from, to);
        // определяем, список и присваиваем ему адаптер
        lvSimple = (ListView) findViewById(R.id.lvSimple);
        lvSimple.setAdapter(sAdapetr);
    }
}