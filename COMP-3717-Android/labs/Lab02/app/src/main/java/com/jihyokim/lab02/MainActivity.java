package com.jihyokim.lab02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button changeColorButton;
    private Button speakButton;
    private Button apiVersionButton;
    private Button serialNumberButton;
    private int[] colors = {Color.RED, Color.BLACK, Color.BLUE, Color.YELLOW, Color.WHITE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeColorButton = findViewById(R.id.change_color_button);
        speakButton = findViewById(R.id.speak_button);
        apiVersionButton = findViewById(R.id.api_version_button);
        serialNumberButton = findViewById(R.id.serial_number_button);

        changeColorButton.setOnClickListener(this);
        speakButton.setOnClickListener(this);
        apiVersionButton.setOnClickListener(this);
        serialNumberButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.change_color_button:
                Log.i("MainActivity", "change color button");
                changeBackgroundColor();
                break;
            case R.id.speak_button:
                Log.i("MainActivity", "speak button");
                openSpeakActivity();
                break;
            case R.id.api_version_button:
                Log.i("MainActivity", "api version button");
                Toast.makeText(getApplicationContext(), getAPIVersionInString(), Toast.LENGTH_LONG).show();
                break;
            case R.id.serial_number_button:
                Log.i("MainActivity", "serial number button");
                sendSerialNumberToAnotherApp();
                break;
            default:
                Log.i("MainActivity", "default");
        }
    }

    private void changeBackgroundColor() {
        LinearLayoutCompat layout = findViewById(R.id.my_linear_layout);
        Random r = new Random();
        int n = r.nextInt(this.colors.length);
        layout.setBackgroundColor(colors[n]);
    }

    private void openSpeakActivity() {
        Intent intent = new Intent(getApplicationContext(), SpeakActivity.class);
        startActivity(intent);
    }

    private String getAPIVersionInString() {
        String manufacturer = android.os.Build.MANUFACTURER;
        String model = android.os.Build.MODEL;
        int version = android.os.Build.VERSION.SDK_INT;
        String versionRelease = android.os.Build.VERSION.RELEASE;

        String messageText = "manufacturer " + manufacturer
                + " \n model " + model
                + " \n version " + version
                + " \n versionRelease " + versionRelease;
        return messageText;
    }

    private void sendSerialNumberToAnotherApp() {
        String deviceID = Settings.System.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, deviceID);
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent, null));
    }
}
