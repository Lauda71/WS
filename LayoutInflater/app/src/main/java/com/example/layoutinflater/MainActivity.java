package com.example.layoutinflater;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

   String[] name = {"Иван", "Марья", "Петр", "Антон", "Даша", "Борис", "Костя", "Игоорь", "Игоорь", "Игоорь", "Игоорь", "Игоорь", "Игоорь", "Игоорь", "Игоорь", "Игоорь"};
   String[] position = {"Программист", "Бухгалтер", "Программист", "Кадровик", "Уничтожитель", "Аннигилятор", "Палач Рока", "Директор", "Директор", "Директор", "Директор", "Директор", "Директор", "Директор", "Директор", "Директор"};
   int salary[] = {13000, 10000, 13000, 10000, 50000, 70000, 1000000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000};

   int[] colors = new int[2];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        colors[0] = Color.parseColor("#559966CC");
        colors[1] = Color.parseColor("#55336699");

        LinearLayout linLayout = (LinearLayout) findViewById(R.id.linLayout);

        LayoutInflater ltInflater = getLayoutInflater();

        for (int i = 0; i < name.length; i++)
        {
            Log.e("myLogs", "i = " + i);

            View item = ltInflater.inflate(R.layout.item, linLayout, false);

            TextView tvName = (TextView) item.findViewById(R.id.tvName);
            tvName.setText(name[i]);

            TextView tvPosition = (TextView) item.findViewById(R.id.tvPosition);
            tvPosition.setText("Должность: " + position[i]);

            TextView tvSalary = (TextView) item.findViewById(R.id.tvSalary);
            tvSalary.setText("Оклад: " + String.valueOf(salary[i]));

            item.getLayoutParams().width = LayoutParams.MATCH_PARENT;
            item.setBackgroundColor(colors[i % 2]);
            linLayout.addView(item);
        }
    }
}