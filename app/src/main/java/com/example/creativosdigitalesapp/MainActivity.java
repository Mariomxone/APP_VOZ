package com.example.creativosdigitalesapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    //private static final int REQ_CODE_SPEECH_INPUT=100; sirve para diferenciar los metodos
    private static final int REQ_CODE_SPEECH_INPUT = 100;
    private static final int REQ_CODE_SPEECH_INPUT2 = 200;
    private static final int REQ_CODE_SPEECH_INPUT3 = 300;
    private static final int REQ_CODE_SPEECH_INPUT4 = 400;
    private static final int REQ_CODE_SPEECH_INPUT5 = 500;
    private TextView mEntradadevoz;
    private TextView mEntradadevoz1;
    private TextView mEntradadevoz2;
    private TextView mEntradadevoz3;
    private TextView mEntradadevoz4;
    private ImageButton mBotonhablar, mBotonhablar1, mBotonhablar2, mBotonhablar3, mBotonhablar4;



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
                Voz2();
            }

        });
        mBotonhablar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Voz3();
            }

        });
        mBotonhablar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Voz4();
            }

        });


    }

    private void iniciarEntradaVoz() {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hola dime tú nombre");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException e) {

        }
    }

    private void Voz() {

        Intent voz = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        voz.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        voz.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        voz.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hola dime tús apellidos");
        try {
            startActivityForResult(voz, REQ_CODE_SPEECH_INPUT2);
        } catch (ActivityNotFoundException e) {

        }
    }

    private void Voz2() {

        Intent voz = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        voz.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        voz.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        voz.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hola dime tú instagram");
        try {
            startActivityForResult(voz, REQ_CODE_SPEECH_INPUT3);
        } catch (ActivityNotFoundException e) {

        }
    }

    private void Voz3() {

        Intent voz = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        voz.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        voz.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        voz.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hola dime tú celular");
        try {
            startActivityForResult(voz, REQ_CODE_SPEECH_INPUT4);
        } catch (ActivityNotFoundException e) {

        }
    }

    private void Voz4() {

        Intent voz = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        voz.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        voz.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        voz.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hola dime tú edad");
        try {
            startActivityForResult(voz, REQ_CODE_SPEECH_INPUT5);
        } catch (ActivityNotFoundException e) {

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    mEntradadevoz.setText(result.get(0));
                }
                break;
                // REQ_CODE_SPEECH_INPUT sirve para diferenciar entre las 4 interfaces de voz //
            }
            case REQ_CODE_SPEECH_INPUT2: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    mEntradadevoz1.setText(result.get(0));
                }
                break;
            }
            case REQ_CODE_SPEECH_INPUT3: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    mEntradadevoz2.setText(result.get(0));
                }
                break;
            }
            case REQ_CODE_SPEECH_INPUT4: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    mEntradadevoz3.setText(result.get(0));
                }
                break;
            }
            case REQ_CODE_SPEECH_INPUT5: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    mEntradadevoz4.setText(result.get(0));
                }
                break;
            }
        }
    }
    public void ir(View view){
        Intent intent = new Intent(MainActivity. this, Voz.class);
        startActivity(intent);
    }
}