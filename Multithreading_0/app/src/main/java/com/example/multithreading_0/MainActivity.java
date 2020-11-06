package com.example.multithreading_0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    static SomeThing smth;
    String json = "";
    JSONArray array = null;

    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_CODE = "code";
    final String ATTRIBUTE_NAME_IMG = "img";
    final String ATTRIBUTE_NAME_SELL = "sell";
    final String ATTRIBUTE_NAME_BUY = "buy";

    String[] pic;
    int[] image;

    ArrayList<Map<String, Object>> data;

    public static StringBuilder strbuild = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        smth = new SomeThing();

        Thread myThready = new Thread(smth);
        myThready.start();

        //System.out.print("Главный поток завершен...");


        /*
        jObject = new JSONObject(jString);
       JSONObject geoObject = jObject.getJSONObject("geodata");

       String geoId = geoObject.getString("id");
           System.out.println(geoId);

       String name = geoObject.getString("name");
       System.out.println(name);

       String gender=geoObject.getString("gender");
       System.out.println(gender);

       String lat=geoObject.getString("latitude");
       System.out.println(lat);

       String longit =geoObject.getString("longitude");
       System.out.println(longit);

       --------------------------
       */

        int count = -1;
        do{
            try {
                count++;
                Thread.sleep(1000);
                Log.e("waiting...", "" + count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (smth.isAlive());

        try{
            smth.join();	//Подождать пока вторйо поток завершится

            json = strbuild.toString();
            array = new JSONArray (json);

            image = new int[array.length()];

            //int img = R.mipmap.flag_foreground;
            pic = new String[array.length()];
            for(int i = 0; i < array.length(); i++){
                pic[i] = array.getJSONObject(i).getString("charcode").toLowerCase().substring(0,2);
                //Log.e("dickPic", ": " + pic[i]);
                //Thread.sleep(500);
                //Toast.makeText(this, pic[i], )
                //image[i] = this.getResources().getIdentifier(pic[i],"mipmap", this.getPackageName());
                Log.e("imgPic", ": " + String.valueOf(image[i]));

                image[i] = this.getResources().getIdentifier(array.getJSONObject(i).getString("charcode").toLowerCase().substring(0, 2),"mipmap",this.getPackageName());
            }

            data = new ArrayList<Map<String, Object>>();
            Map<String, Object> m;
            for (int i = 0; i < array.length(); i++)
            {
                m = new HashMap<>();
                m.put(ATTRIBUTE_NAME_TEXT, array.getJSONObject(i).getString("name"));
                m.put(ATTRIBUTE_NAME_CODE, array.getJSONObject(i).getString("charcode"));
                m.put(ATTRIBUTE_NAME_IMG, image[i]);
                m.put(ATTRIBUTE_NAME_SELL, array.getJSONObject(i).getString("sell"));
                m.put(ATTRIBUTE_NAME_BUY, array.getJSONObject(i).getString("buy"));
                data.add(m);
            }

            String[] from = {ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_CODE, ATTRIBUTE_NAME_IMG, ATTRIBUTE_NAME_SELL, ATTRIBUTE_NAME_BUY};
            int[] to = {R.id.name, R.id.code, R.id.img, R.id.sell, R.id.buy};

            SimpleAdapter sAdapter = new SimpleAdapter(this, data, R.layout.item, from, to);

            ListView lv = (ListView) findViewById(R.id.lvSimple);
            lv.setAdapter(sAdapter);


            Log.e("Пример", array.getJSONObject(1).getString("charcode"));
        }catch(Exception e){
            Log.e("ALIVE", e.toString());
        }

        Log.e("end", "Конец главного потока");
    }
}

class SomeThing
extends Thread
implements Runnable
{
    public void run(){
        //System.out.print("Второй поток...");
        Log.e("tag", "Второй поток...");

        // http://mobile-api.fxnode.ru:18888/valute   !!! API

        String query = "http://mobile-api.fxnode.ru:18888/valute";

        HttpURLConnection connection = null;
        try{

            connection = (HttpURLConnection) new URL(query).openConnection();

            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            // ...

            connection.connect();

            Log.e("tag", "Подключение было!");

            //StringBuilder sb = new StringBuilder();

            if(HttpURLConnection.HTTP_OK == connection.getResponseCode()){
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String line;
                while((line = in.readLine()) != null){
                    MainActivity.strbuild.append(line);
                    MainActivity.strbuild.append("\n");
                }

                Log.e("myTag", MainActivity.strbuild.toString());

            } else{
                Log.e("myTag", "fail: " + connection.getResponseCode() + " " + connection.getResponseMessage() );
            }

        } catch (Throwable cause){
            //cause.printStackTrace();
            Log.e("tag", cause.toString());
        } finally {
            if(connection != null){
                connection.disconnect();
            }
        }

        Log.e("tag", "Второстепенный поток завершен...");
    }
}