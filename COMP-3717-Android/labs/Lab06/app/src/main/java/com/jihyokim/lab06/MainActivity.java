package com.jihyokim.lab06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static String PRODUCT_TYPE = "com.jihyokim.lab06.product_type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] categories = {"Fruits", "Vegetables", "Bakery"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_view_category, categories);
        ListView listView = findViewById(R.id.category_list_view);
        listView.setAdapter(adapter);
        final Intent intent = new Intent(this, ProductTypeActivity.class);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("MAIN_ACTIVITY", ((TextView)view).getText().toString());
                intent.putExtra(PRODUCT_TYPE, ((TextView)view).getText().toString());
                startActivity(intent);
            }
        });
    }
}
