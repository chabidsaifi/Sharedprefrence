package com.abid.sharedprephrence;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;
    Button btn1;
    Button btn2;
    Button btn3;

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edittext1);
        editText2 = findViewById(R.id.textInputLayout);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);

        pref = getSharedPreferences("My Data", Context.MODE_PRIVATE);// my data.xml store formater file
        editor = pref.edit();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();
                String phone = editText2.getText().toString();
                editor.putString("Name_key",name);
                editor.putString("Phone_key",phone);
                editor.commit();
                Toast.makeText(MainActivity.this, "Data saved", Toast.LENGTH_SHORT).show();
                editText.setText("");
                editText2.setText("");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = pref.getString("Name_key",null);
                String phone = pref.getString("Phone_key",null);
                Toast.makeText(MainActivity.this, "Name: "+name+"\n Phone:"+phone,Toast.LENGTH_SHORT).show();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.remove("Name_key");//
                editor.clear();
                editor.commit();
               // Toast.makeText(MainActivity.this, "Data is Remove", Toast.LENGTH_SHORT).show();

            }
        });

    }
}