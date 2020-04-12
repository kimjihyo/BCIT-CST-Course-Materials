package com.jihyokim.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.w3c.dom.Text;

import java.util.Locale;

public class SpeakActivity extends AppCompatActivity implements View.OnClickListener {
    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speak);

        findViewById(R.id.speak_activity_speak_button).setOnClickListener(this);
        findViewById(R.id.speak_activity_back_button).setOnClickListener(this);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    Log.i("SpeakActivity", "init");
                    textToSpeech.setLanguage(Locale.CANADA);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.speak_activity_speak_button:
                speak(((EditText) findViewById(R.id.text_to_speak)).getText().toString());
                break;
            case R.id.speak_activity_back_button:
                finish();
                break;
            default:
                Log.i("SpeakActivity", "default");
        }
    }

    private void speak(String text) {
        if (text != null && !text.isEmpty()) {
            Log.i("SpeakActivity", text);
            textToSpeech.speak(text, TextToSpeech.QUEUE_ADD, null);
        }
    }

}
