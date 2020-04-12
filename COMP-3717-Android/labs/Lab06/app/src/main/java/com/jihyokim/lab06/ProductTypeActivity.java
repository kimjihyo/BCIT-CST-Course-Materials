package com.jihyokim.lab06;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductTypeActivity extends ListActivity {
    static final String PRODUCT_NAME = "com.jihyokim.lab06.product_name";
    static final String PRODUCT_TYPE = "com.jihyokim.lab06.product_type";
    private String productType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productType = getIntent().getStringExtra(MainActivity.PRODUCT_TYPE);
        ArrayList<String> foodsInString = new ArrayList<>();
        if (productType.equals( "Fruits")) {
            for (Food food : Food.fruits) {
                foodsInString.add(food.getName());
            }
        } else if (productType.equals("Vegetables")){
            for (Food food : Food.vegetables) {
                foodsInString.add(food.getName());
            }
        } else {
            for (Food food : Food.bakery) {
                foodsInString.add(food.getName());
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_view_category, foodsInString);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView list, View view, int position, long id) {
        final Intent intent = new Intent(this, ProductDetailActivity.class);
        String productName = ((TextView)view).getText().toString();
        intent.putExtra(PRODUCT_NAME, productName);
        intent.putExtra(PRODUCT_TYPE, productType);
        startActivity(intent);
    }

}
