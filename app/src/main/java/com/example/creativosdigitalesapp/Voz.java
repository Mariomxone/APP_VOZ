package com.example.creativosdigitalesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Voz extends AppCompatActivity {

    //creación de los botones de hablar
    private Button speakbtnn;
    private EditText edittext;
    TTSManager ttsmanager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voz);

        ttsmanager = new TTSManager();
        ttsmanager.init(this );

        edittext=findViewById(R.id.txtout);
        speakbtnn = findViewById(R.id.btnspeak);

        speakbtnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=edittext.getText().toString();
                Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
                ttsmanager.initQueue(text);

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ttsmanager.shutDown();
    }
    }
