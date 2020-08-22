package com.example.speech_to_textapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView mtxtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mtxtResult = findViewById(R.id.txtResult);
        Bundle extras =getIntent().getExtras();
        if (extras !=null) {
            String data = extras.getString("Voice_Data");
            if (data !=null){
                mtxtResult.setText(data);
            }
            else {
                Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
            }
            }
        }
    }
