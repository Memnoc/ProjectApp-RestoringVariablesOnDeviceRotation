package com.smartdroidesign.restoringvariablesrotatation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView mTextViewCount;
    private int mCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewCount = findViewById(R.id.text_view_count);

        Button buttonDecrement = findViewById(R.id.button_decrement);
        Button buttonIncrement = findViewById(R.id.button_increment);

        buttonDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrement();
            }
        });

        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increment();
            }
        });

        // method 2 restoring
//        if(savedInstanceState != null) {
//            mCount = savedInstanceState.getInt("count");
//            mTextViewCount.setText(String.valueOf(mCount));
//        }

    }

    private void decrement() {
        mCount--;
        mTextViewCount.setText(String.valueOf(mCount));
    }

    private void increment() {
        mCount++;
        mTextViewCount.setText(String.valueOf(mCount));
    }

    /**
     * Saving the members' state
     * @param outState passing the values to get saved to the bundle
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", mCount);
    }

    /**
     * Method 1 - no check for null values needed
     * @param savedInstanceState parameter that retrieves the value passed to onSaveInstanceState()
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCount = savedInstanceState.getInt("count");
        mTextViewCount.setText(String.valueOf(mCount));
    }
}
