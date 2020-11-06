package com.example.training_0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    final String ATTRIBUTE_NAME_NAME = "name";
    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_CH = "checked";
    final String ATTRIBUTE_NAME_IMG = "img";

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        String[] name = {"someName1", "someName2", "someName3", "someName4", "someName5"};
        String[] text = {"someText1", "someText2", "someText3", "someText4", "someText5"};
        boolean[] ch = {true, false, true, false, true};
        int img = R.drawable.ic_launcher_foreground;

        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(text.length);
        Map<String, Object> m;
        for (int i = 0; i < text.length; i++){
            m = new HashMap<String, Object>();
            m.put(ATTRIBUTE_NAME_NAME, name[i]);
            m.put(ATTRIBUTE_NAME_TEXT, text[i]);
            m.put(ATTRIBUTE_NAME_CH, ch[i]);
            m.put(ATTRIBUTE_NAME_IMG, img);
            data.add(m);
        }

        String[] from = {ATTRIBUTE_NAME_NAME, ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_CH, ATTRIBUTE_NAME_IMG};
        int[] to = {R.id.tvName, R.id.tvdes, R.id.cb, R.id.ivImg};

        SimpleAdapter sAdapter = new SimpleAdapter(this, data, R.layout.item, from, to);

        lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(sAdapter);
    }
}