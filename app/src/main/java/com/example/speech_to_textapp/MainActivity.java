package com.example.speech_to_textapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_SPEECH_INPUT = 1000;
     ImageButton mvoiceBtn;
     String resultTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mvoiceBtn = findViewById(R.id.voiceBtn);

        //button on-click action
        mvoiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak();

            }


        });
    }

private void speak(){
        //defining intents
    Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
    intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Speak something");

    //starting the intent
    try {
        startActivityForResult(intent,REQUEST_CODE_SPEECH_INPUT);
    }
    catch (Exception e){
        //if error found displays shows the error message
        Toast.makeText(this,""+e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    }

    //receiving the voice input


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case REQUEST_CODE_SPEECH_INPUT:{
                if (resultCode == RESULT_OK && null!=data){
                    //getting the text array from voice intent
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    //setting the text view
                    resultTxt = result.get(0);
                    String s = result.get(0);
                    Intent sendData = new Intent(this,MainActivity2.class);
                    sendData.putExtra("Voice_Data",s);
                    startActivity(sendData);

                }
                break;
            }
        }
    }

}