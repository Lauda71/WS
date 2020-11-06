package com.example.simpleadapter_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_CHECKED = "checked";
    final String ATTRIBUTE_NAME_IMAGE = "image";

    ListView lvSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        String[] texts = {"sometext1", "sometext 2", "sometext 3", "sometext 4", "sometext 5"};
        boolean[] checked = {true, false, false, true, false};
        int img = R.mipmap.man_layer;

        // упаковываем данные в понятную для адаптера структуру
        ArrayList<Map <String, Object>> data = new ArrayList<Map<String, Object>>(texts.length);
        Map<String, Object> m;
        for (int i = 0 ; i < texts.length; i++){
            m = new HashMap<String, Object>();
            m.put(ATTRIBUTE_NAME_TEXT, texts[i]);
            m.put(ATTRIBUTE_NAME_CHECKED, checked[i]);
            m.put(ATTRIBUTE_NAME_IMAGE, img);
            data.add(m);
        }

        // массив имен атрибутов, из которых будут читаться данные
        String[] from = {ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_CHECKED, ATTRIBUTE_NAME_IMAGE, ATTRIBUTE_NAME_TEXT};

        // массив id View-компонентов, в которые будут вставляться данные
        int[] to = {R.id.tvText, R.id.cbChecked, R.id.ivImg, R.id.cbChecked};

        // создание адаптера
        SimpleAdapter sAdapter = new SimpleAdapter(this, data, R.layout.item, from, to);

        // опредеяем список и присваеваем ему адаптер
        lvSimple = (ListView) findViewById(R.id.lvSimple);
        lvSimple.setAdapter(sAdapter);
    }
}