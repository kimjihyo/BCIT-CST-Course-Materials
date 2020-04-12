package ca.bcit.jihyokim.lab13;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private DBHelper mDB;
    private ListView mHolidayListView;
    private Spinner mSpinner;
    private Button mButton;
    private TextView mName;
    private TextView mDate;
    private boolean isFixedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDB = new DBHelper(this);

        ArrayList<String> spinnerSelections = new ArrayList<>();
        spinnerSelections.add("1");
        spinnerSelections.add("0");

        mSpinner = findViewById(R.id.fixed_date_spinner);
        mSpinner.setAdapter(new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, spinnerSelections));

        mHolidayListView = findViewById(R.id.holiday_list_view);
        final ArrayList<Holiday> holidays = mDB.getHolidays();
        final HolidayAdapter adapter = new HolidayAdapter(this, holidays);
        mHolidayListView.setAdapter(adapter);

        mButton = findViewById(R.id.add_button);
        mName = findViewById(R.id.holiday_name_edit_text);
        mDate = findViewById(R.id.holiday_next_date_edit_text);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + mName.getText().toString());
                Log.d(TAG, "onClick: " + mDate.getText().toString());
                Log.d(TAG, "onClick: " + mSpinner.getSelectedItem().toString());
                Holiday h = new Holiday(mName.getText().toString(),
                        mDate.getText().toString(),
                        Integer.valueOf(mSpinner.getSelectedItem().toString()));
                mDB.insertHoliday(h);
                holidays.add(h);
            }
        });
    }
}
