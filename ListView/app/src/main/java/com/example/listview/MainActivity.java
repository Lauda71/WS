package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] names = {"Иван", "Мухаммад", "Ратибор", "Братишка", "Святослав", "Машенька", "Дашенька", "Данила", "Серега", "Илюха", "Петруня", "Димооон", "Света"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // находим список
        ListView lvmain = (ListView) findViewById(R.id.lvMain);

        // создание адаптера
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.my_list_item, names);

        ArrayAdapter<String> dptr = new ArrayAdapter<String>(this, R.layout.super_items, names);

        // присваиваем адаптер списку
        lvmain.setAdapter(dptr);
    }
}