package com.example.android.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView timer;
    private Handler handler;
    private Update update;
    private long startTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = findViewById(R.id.timer);
        handler = new Handler();
        update = new Update();
        startTime = System.currentTimeMillis();
        handler.postDelayed(update, 1000);


    }

    private void buttonPressed(View v){
        handler.removeCallbacks(update);
    }

    private class Update implements Runnable {

        @Override
        public void run(){
            long current = System.currentTimeMillis();
            long elapsed = (current - startTime)/1000;
            timer.setText(""+elapsed);
            handler.postDelayed(update, 10000);
        }

    }
}
