package com.jihyokim.async_lecturedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class MainActivity extends AppCompatActivity {
    private String TAG = MainActivity.class.getSimpleName();
    private ListView lv;
    // URL to get contacts JSON
    private static String SERVICE_URL = "http://data.vncvr.ca/api/people/";
    private ArrayList<Toon> toonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.toonList);
        if (lv == null) {
            Log.i(TAG, "lv is null in onCreate");
        }

        GetContacts getContacts = new GetContacts();
        getContacts.execute();
    }

    /**
     * Async task class to get json by making HTTP call
     */
    private class GetContacts extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            String jsonStr = null;

            // Making a request to url and getting response
            jsonStr = sh.makeServiceCall(SERVICE_URL);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                Log.d(TAG, "Json: " + jsonStr);
                // this step is needed to wrap the JSON array inside
                // a JSON object that looks like this { "toons": . . . . }
                jsonStr = "{\"toons\":" + jsonStr + "}";
                Gson gson = new Gson();
                BaseToon baseToon = gson.fromJson(jsonStr, BaseToon.class);
                toonList = baseToon.getToons();
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            ToonsAdapter adapter = new ToonsAdapter(MainActivity.this, toonList);
            if (lv == null) {
                Log.i(TAG, "its null");
            }
            // Attach the adapter to a ListView
            lv.setAdapter(adapter);
        }
    }
}
