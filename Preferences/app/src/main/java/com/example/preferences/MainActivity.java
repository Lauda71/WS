package com.example.preferences;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

    EditText etText;
    Button btnSave, btnLoad;

    SharedPreferences sPref;

    final String SAVED_TEXT = "saved_text";


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        etText = (EditText) findViewById(R.id.etText);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);

        btnLoad = (Button) findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(this);

        loadText();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:
                saveText();
                break;
            case R.id.btnLoad:
                loadText();
                break;
            default:
                break;
        }
    }

    // сохранение данных
    void saveText() {

        //  с помощью метода getPreferences получаем объект sPref класса SharedPreferences, который позволяет работать с данными (читать и писать)
        sPref = getPreferences(MODE_PRIVATE);
        // константа MODE_PRIVATE используется для настройки доступа и означает, что после сохранения, данные будут видны только этому приложению.

        //  чтобы редактировать данные, необходим объект Editor – получаем его из sPref
        Editor ed = sPref.edit();

        // В метод putString указываем наименование переменной – это константа SAVED_TEXT, и значение – содержимое поля etText
        ed.putString(SAVED_TEXT, etText.getText().toString());

        // чтобы данные сохранились, необходимо выполнить commit
        ed.commit();

        // для наглядности выводим сообщение, что данные сохранены
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }

    // загрузка данных
    void loadText() {

        // с помощью метода getPreferences получаем объект sPref класса SharedPreferences
        sPref = getPreferences(MODE_PRIVATE);
        // MODE_PRIVATE снова указывается, хотя и используется только при записи данных

        String savedText = sPref.getString(SAVED_TEXT, "");
        // читаем с помощью метода getString – в параметрах указываем константу - это имя, и значение по умолчанию (пустая строка)

        // далее пишем значение в поле ввода etText и выводим сообщение, что данные считаны
        etText.setText(savedText);

        // для наглядности выводим сообщение, что данные загружены
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText();
    }
}