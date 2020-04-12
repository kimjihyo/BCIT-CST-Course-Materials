package ca.bcit.tipcalculator;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class TableActivity extends AppCompatActivity implements View.OnClickListener, TextView.OnEditorActionListener{
    private Button mPercentDownButton;
    private Button mPercentUpButton;
    private TextView mTipTextView;
    private TextView mTotalTextView;
    private TextView mTipPercentTextView;
    private EditText mBillAmountEditText;
    private float mTipPercent = 0.15f;
    private float mTotalAmount = 0f;
    private float mTipAmount = 0f;
    private String mBillAmountString = "";

    private SharedPreferences mSavedValues;

    @Override
    protected void onCreate(Bundle savedInstanceSpace) {
        super.onCreate(savedInstanceSpace);
        setContentView(R.layout.activity_table);

        mPercentDownButton = findViewById(R.id.btnPercentDown);
        mPercentUpButton = findViewById(R.id.btnPercentUp);
        mTipTextView = findViewById(R.id.textviewTip);
        mTotalTextView = findViewById(R.id.textviewTotal);
        mBillAmountEditText = findViewById(R.id.billAmountEditText);
        mTipPercentTextView = findViewById(R.id.tipPercent);

        mPercentDownButton.setOnClickListener(this);
        mPercentUpButton.setOnClickListener(this);
        mBillAmountEditText.setOnEditorActionListener(this);

        mSavedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPercentDown:
                mTipPercent -= 0.01f;
                calculateAndDisplay();
                break;
            case R.id.btnPercentUp:
                mTipPercent += 0.01f;
                calculateAndDisplay();
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mBillAmountString = mSavedValues.getString("billAmountString", "");
        mTipPercent = mSavedValues.getFloat("tipPercent", 0.0f);
        mBillAmountEditText.setText(mBillAmountString);
        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        mTipPercentTextView.setText(numberFormat.format(mTipPercent));
        calculateAndDisplay();

    }

    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = mSavedValues.edit();
        editor.putString("billAmountString", mBillAmountString);
        editor.putFloat("tipPercent", mTipPercent);
        editor.apply();
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE ||
                actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
            calculateAndDisplay();
        }
        return false;
    }

    private void calculateAndDisplay() {
        mBillAmountString = mBillAmountEditText.getText().toString();
        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        mTipPercentTextView.setText(numberFormat.format(mTipPercent));

        float billAmount;
        try {
            billAmount = Float.parseFloat(mBillAmountString);
        } catch (Exception exception) {
            billAmount = 0f;
        }

        mTipAmount = billAmount * mTipPercent;
        mTotalAmount = billAmount + mTipAmount;

        NumberFormat currencyNumberFormat = NumberFormat.getCurrencyInstance();
        mTipTextView.setText(currencyNumberFormat.format(mTipAmount));
        mTotalTextView.setText(currencyNumberFormat.format(mTotalAmount));
    }
}