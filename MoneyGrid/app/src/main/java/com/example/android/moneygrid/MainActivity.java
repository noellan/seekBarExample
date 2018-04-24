package com.example.android.moneygrid;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private GridLayout grid;
    private SeekBar bar;
    private Handler handler;
    private Update update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler();
        grid = findViewById(R.id.grid);
        bar = findViewById(R.id.bar);
        update = new Update();
        handler.postDelayed(update, 1000);
        bar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    resetGrid();
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

        for(int i=0; i<9; i++){
            ImageView imageView = (ImageView) getLayoutInflater().inflate(R.layout.image_layout, grid, false);
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.football));
            grid.addView(imageView);
        }
    }

    public void resetGrid(){
        grid.removeAllViews();
        int dimension = bar.getProgress()*3+3;
        grid.setColumnCount(dimension);
        grid.setRowCount(dimension);
        int size = dimension*dimension;
        for(int i=0; i<size; i++){
            ImageView imageView =(ImageView) getLayoutInflater().inflate(R.layout.image_layout, grid, false);
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.football));
            grid.addView(imageView);
        }
    }


    private class Update implements Runnable {

        @Override
        public void run(){
            Random rand = new Random();
            ImageView imageView = (ImageView) grid.getChildAt(rand.nextInt());
            imageView.setImageDrawable(null);
            handler.postDelayed(update, 1000);
        }

    }
}
