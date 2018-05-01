package com.example.android.slotmachine;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {



    private GridLayout slots;
    private SeekBar seekBar;
    private TextView pointview;
    private Handler handler;
    private Update update;
    private RelativeLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pointview = findViewById(R.id.points);
        handler = new Handler();
        slots = findViewById(R.id.slots);
        seekBar = findViewById(R.id.seekBar);
        update = new Update();
        handler.postDelayed(update, 1000);
        layout = findViewById(R.id.layout);
        layout.setBackgroundColor(0xFFFFF00);

        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

    }

    private class Update implements Runnable {

        @Override
        public void run() {
            Random rand = new Random();
            ImageView imageview = (ImageView) slots.getChildAt(rand.nextInt(3));
            imageview.setImageDrawable(getResources().getDrawable(R.drawable.cherry));
            imageview.setImageDrawable(getResources().getDrawable(R.drawable.grape));
            imageview.setImageDrawable(getResources().getDrawable(R.drawable.pear));
            imageview.setImageDrawable(getResources().getDrawable(R.drawable.strawberry));
            handler.postDelayed(update, 100);
        }
    }

    public void buttonPressed(View v) {
        rotate=Integer.parseInt(getString(R.string.3));
        v.startAnimation(rotate);
        Intent i = new Intent(this, ColorActivity.class);
        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        int color = data.getIntExtra("COLOR", 0xFFFF0000);
        layout.setBackgroundColor(color);
    }
}