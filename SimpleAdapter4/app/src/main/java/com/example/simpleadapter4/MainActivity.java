package com.example.simpleadapter4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final int CM_DELETE_ID = 1;

    // имена атрибутов
    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_IMAGE = "image";

    ListView lvSimple;
    SimpleAdapter sAdapter;
    ArrayList<Map<String, Object>> data;
    Map<String, Object> m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //упаковочка
        data = new ArrayList<Map<String, Object>>();
        for (int i = 1; i < 5; i++){
            m = new HashMap<String, Object>();
            m.put(ATTRIBUTE_NAME_TEXT, " some   text " + i);
            m.put(ATTRIBUTE_NAME_IMAGE, R.mipmap.senior_foreground);
            data.add(m);
        }

        String[] from = {ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_IMAGE};
        int[] to = {R.id.tvText, R.id.ivImg};

        sAdapter = new SimpleAdapter(this, data, R.layout.item, from, to);

        lvSimple = (ListView) findViewById(R.id.lvSimple);
        lvSimple.setAdapter(sAdapter);
        registerForContextMenu(lvSimple); // это что-то новенькое !!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
    }

    public void onButtonClick(View v){
        // создание нового Map'a
        m = new HashMap<String, Object>();
        m.put(ATTRIBUTE_NAME_TEXT, " some   text " + (data.size() + 1));
        m.put(ATTRIBUTE_NAME_IMAGE, R.mipmap.senior_foreground);

        // добавление его в коллекцию
        data.add(m);

        // уведомляем, что данные изменились
        sAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, CM_DELETE_ID, 0, "Удалить запись");
    }

    @Override
    public boolean onContextItemSelected (MenuItem item){
        if( item.getItemId() == CM_DELETE_ID){
            // получение инфы о пункте списка
            AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

            // удаляем Map из коллекции, используя позицию пункта в списке
            data.remove(acmi.position);

            // уведомляем, что данные изменились
            sAdapter.notifyDataSetChanged();
            return true;
        }
        return super.onContextItemSelected(item);
    }


}