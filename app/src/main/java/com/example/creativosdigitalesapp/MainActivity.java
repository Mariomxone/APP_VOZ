package com.example.creativosdigitalesapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_CODE_SPEECH_INPUT=100;
    private TextView mEntradadevoz;
    private TextView mEntradadevoz1;
    private TextView mEntradadevoz2;
    private TextView mEntradadevoz3;
    private TextView mEntradadevoz4;
    private ImageButton mBotonhablar,mBotonhablar1,mBotonhablar2,mBotonhablar3,mBotonhablar4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEntradadevoz = findViewById(R.id.txtnombre);
        mEntradadevoz1 = findViewById(R.id.txtapellidos);
        mEntradadevoz2 = findViewById(R.id.txtcorreo);
        mEntradadevoz3 = findViewById(R.id.txtnum);
        mEntradadevoz4 = findViewById(R.id.txtedad);

       mBotonhablar = findViewById(R.id.btnnombre);
        mBotonhablar1 = findViewById(R.id.btnapellidos);
        mBotonhablar2 = findViewById(R.id.btncorreo);
        mBotonhablar3 = findViewById(R.id.btncel);
        mBotonhablar4 = findViewById(R.id.btnedad);

        mBotonhablar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarEntradaVoz();
            }

        });

        mBotonhablar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Voz();
            }

        });

        mBotonhablar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarEntradaVoz();
            }

        });

        mBotonhablar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarEntradaVoz();
            }

        });

        mBotonhablar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarEntradaVoz();
            }

        });
    }
    private void iniciarEntradaVoz(){

        Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Hola dime tú nombre");
        try {
            startActivityForResult(intent,REQ_CODE_SPEECH_INPUT);
        }catch (ActivityNotFoundException e){

        }
    }

    private void Voz(){

        Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Hola dime tús apellidos");
        try {
            startActivityForResult(intent,REQ_CODE_SPEECH_INPUT);
        }catch (ActivityNotFoundException e){

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case REQ_CODE_SPEECH_INPUT:{
                if (resultCode==RESULT_OK && null!=data){
                    ArrayList<String> result= data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    mEntradadevoz.setText(result.get(0));
                    mEntradadevoz1.setText(result.get(0));
                    mEntradadevoz2.setText(result.get(0));
                    mEntradadevoz3.setText(result.get(0));
                    mEntradadevoz4.setText(result.get(0));
                }
                break;
            }
        }
    }
}