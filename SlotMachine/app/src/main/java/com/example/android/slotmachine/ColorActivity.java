package com.example.android.slotmachine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by android on 3/20/18.
 */

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBackPressed() {
        Intent data = new Intent();
        data.putExtra("COLOR", color);
        setResult(RESULT_OK, data);
        finish();
    }
}
