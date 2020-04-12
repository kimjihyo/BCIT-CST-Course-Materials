package com.jihyokim.lab06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        String productType = getIntent().getStringExtra(ProductTypeActivity.PRODUCT_TYPE);
        String productName = getIntent().getStringExtra(ProductTypeActivity.PRODUCT_NAME);
        Food selectedFood;
        selectedFood = searchFood(productType, productName);

        if (selectedFood != null) {
            String fileName = selectedFood.getName().toLowerCase();

            int resourceId = getResources().getIdentifier(
                    fileName, "drawable", getPackageName() );

            ((ImageView) findViewById(R.id.product_image)).setImageResource(resourceId);
            ((TextView) findViewById(R.id.product_name)).setText(selectedFood.getName());
            ((TextView) findViewById(R.id.product_category)).setText(selectedFood.getCategory());
            ((TextView) findViewById(R.id.product_country_of_origin)).setText(selectedFood.getCountryOfOrigin());
            ((TextView) findViewById(R.id.product_pound)).setText(String.valueOf(selectedFood.getUnit()));
            ((TextView) findViewById(R.id.product_price)).setText(String.valueOf(selectedFood.getPrice()));
        }


    }

    private Food searchFood(String type, String name) {
        Log.i("MAIN_ACTIVITY", type);
        Log.i("MAIN_ACTIVITY", name);
        if (type.equals("Fruits")) {
            for (Food food : Food.fruits) {
                if (food.getName().equals(name)) {
                    return food;
                }
            }
        } else if (type.equals("Vegetables")) {
            for (Food food : Food.vegetables) {
                if (food.getName().equals(name)) {
                    return food;
                }
            }
        } else {
            for (Food food : Food.bakery) {
                if (food.getName().equals(name)) {
                    return food;
                }
            }
        }
        return null;
    }
}
