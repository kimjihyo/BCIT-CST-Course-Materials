package ca.bcit.globalmathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startGame(View view) {
        Intent i = new Intent(MainActivity.this, GameActivity.class);
        startActivity(i);
    }

    public void startKotlinGame(View view) {
        Intent i = new Intent(MainActivity.this, KotlinGameActivity.class);
        startActivity(i);

    }
}
