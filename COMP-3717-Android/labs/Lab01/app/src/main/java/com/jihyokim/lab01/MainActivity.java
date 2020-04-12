package com.jihyokim.lab01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void reverseString(View view) {
        EditText input = findViewById(R.id.input_text);
        TextView output = findViewById(R.id.result_text);

        if (input.getText().toString().isEmpty()) {
            output.setText(R.string.error_message);
            output.setTextColor(Color.RED);
        } else {
            StringBuilder sb = new StringBuilder(input.getText().toString());
            output.setText(sb.reverse());
        }
    }
}
