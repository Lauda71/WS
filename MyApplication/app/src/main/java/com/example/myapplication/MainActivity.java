package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc);

        // первый ряд
        // сложение
        Button btn_pls = (Button) findViewById(R.id.btn_pls);
        btn_pls.setOnClickListener(this::onClick);

        // вычитание
        Button btn_mns = (Button) findViewById(R.id.btn_mns);
        btn_pls.setOnClickListener(this::onClick);

        // умножение
        Button btn_mul = (Button) findViewById(R.id.btn_pls);
        btn_pls.setOnClickListener(this::onClick);

        // деление
        Button btn_div = (Button) findViewById(R.id.btn_pls);
        btn_pls.setOnClickListener(this::onClick);

        // вычислить
        Button btn_go = (Button) findViewById(R.id.btn_pls);
        btn_pls.setOnClickListener(this::onClick);


        // второй ряд
        Button btn_1 = (Button) findViewById(R.id.btn_1);
        btn_pls.setOnClickListener(this::onClick);

        Button btn_2 = (Button) findViewById(R.id.btn_2);
        btn_pls.setOnClickListener(this::onClick);

        Button btn_3 = (Button) findViewById(R.id.btn_3);
        btn_pls.setOnClickListener(this::onClick);

        Button btn_4 = (Button) findViewById(R.id.btn_4);
        btn_pls.setOnClickListener(this::onClick);

        Button btn_5 = (Button) findViewById(R.id.btn_5);
        btn_pls.setOnClickListener(this::onClick);
        // третий ряд
        Button btn_6 = (Button) findViewById(R.id.btn_6);
        btn_pls.setOnClickListener(this::onClick);

        Button btn_7 = (Button) findViewById(R.id.btn_7);
        btn_pls.setOnClickListener(this::onClick);

        Button btn_8 = (Button) findViewById(R.id.btn_8);
        btn_pls.setOnClickListener(this::onClick);

        Button btn_9 = (Button) findViewById(R.id.btn_9);
        btn_pls.setOnClickListener(this::onClick);

        Button btn_0 = (Button) findViewById(R.id.btn_0);
        btn_pls.setOnClickListener(this::onClick);


        // четвертый ряд
        Button btn_sin = (Button) findViewById(R.id.btn_sin);
        btn_pls.setOnClickListener(this::onClick);

        Button btn_cos = (Button) findViewById(R.id.btn_cos);
        btn_pls.setOnClickListener(this::onClick);

        Button btn_dot = (Button) findViewById(R.id.btn_dot);
        btn_pls.setOnClickListener(this::onClick);

        Button btn_x = (Button) findViewById(R.id.btn_clear_all);
        btn_pls.setOnClickListener(this::onClick);

        Button btn_last = (Button) findViewById(R.id.btn_clear_last);
        btn_pls.setOnClickListener(this::onClick);


        // пятый ряд
        Button btn_pow = (Button) findViewById(R.id.btn_pow);
        btn_pls.setOnClickListener(this::onClick);

        Button btn_root = (Button) findViewById(R.id.btn_root);
        btn_pls.setOnClickListener(this::onClick);



    }




    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub

        menu.add("Выход");
        menu.add("Подробнее о приложении");
        menu.add("Просто пункт, не обращайте внимания");
        menu.add("Удалить приложение");

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }


    String str = "";
    public void onClick(View but)
    {
        TextView exp = (TextView) findViewById(R.id.expression);

        switch (but.getId()){
            case R.id.btn_0:
                str = str + "0";
                exp.setText(str);
                break;

            case R.id.btn_1:
                str = str + "1";
                exp.setText(str);
                break;

            case R.id.btn_2:
                str = str + "2";
                exp.setText(str);
                break;

            case R.id.btn_3:
                str = str + "3";
                exp.setText(str);
                break;

            case R.id.btn_4:
                str = str + "4";
                exp.setText(str);
                break;

            case R.id.btn_5:
                str = str + "5";
                exp.setText(str);
                break;

            case R.id.btn_6:
                str = str + "6";
                exp.setText(str);
                break;

            case R.id.btn_7:
                str = str + "7";
                exp.setText(str);
                break;

            case R.id.btn_8:
                str = str + "8";
                exp.setText(str);
                break;

            case R.id.btn_9:
                str = str + "9";
                exp.setText(str);
                break;

            case R.id.btn_clear_all:
                str = "";
                exp.setText(str);
                break;

            case R.id.btn_clear_last:
                str = str.replace(str.substring(str.length()-1), "");
                exp.setText(str);
                break;

            case R.id.btn_cos:
                str = String.valueOf(Math.cos(Double.valueOf(str)));
                exp.setText(str);
                break;

            case R.id.btn_sin:
                str = String.valueOf(Math.sin(Double.valueOf(str)));
                exp.setText(str);
                break;

            case R.id.btn_div:
                str = str + "/";
                exp.setText(str);
                break;

            case R.id.btn_mul:
                str = str + "*";
                exp.setText(str);
                break;

            case R.id.btn_pls:
                str = str + "+";
                exp.setText(str);
                break;

            case R.id.btn_mns:
                str = str + "-";
                exp.setText(str);
                break;

            case R.id.btn_dot:
                str = str + ".";
                exp.setText(str);
                break;

            case R.id.btn_pow:
                str = str + "^2";
                exp.setText(str);
                break;

            case R.id.btn_root:
                str = str + "√";
                exp.setText(str);
                break;

            case R.id.btn_go:
                String strr = str;
                strr = strr.replace("*", "+");
                strr = strr.replace("/", "+");
                strr = strr.replace("-", "+");

                String[] sstr = strr.split("\\+");


                for (int i = 0; i < str.length(); i++)
                {
                    //if( str.indexOf(i) != '1')
                    if(Character.isDigit(str.charAt(i))==false)
                    {

                    }

                }
                break;
        }

    }
}