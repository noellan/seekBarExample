package com.example.android.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar bar;
    private TextView seekLabel;
    private EditText tipOutput;
    private CheckBox check;
    private TextView billInput;
    private EditText pplInput;
    private EditText output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekLabel = findViewById(R.id.seekLabel);
        pplInput = findViewById(R.id.pplInput);
        tipOutput = findViewById(R.id.tipOutput);
        tipOutput.setOnEditorActionListener(
                new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        String data = tipOutput.getText().toString();
                        int progress = Integer.parseInt(data);
                        bar.setProgress(progress);
                        return false;
                    }
                }
        );

        billInput = findViewById(R.id.billInput);
        check = findViewById(R.id.check);
        output = findViewById(R.id.output);
        bar = findViewById(R.id.seekBar);
        bar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        seekLabel.setText(i+"");
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

    public void buttonPressed(View v){
        String bill = billInput.getText().toString();
        String ppl = pplInput.getText().toString();
        double b = Double.parseDouble(bill);
        double p = Double.parseDouble(ppl);
        int t = bar.getProgress();
        double ti;

        ti= b*(t/100.0);

        double result;
        if(check.isChecked()){
            result = ti+b/p;
        } else {
            result = ti +b;
        }
        tipOutput.setText(String.format("%.2f",ti));
        output.setText(String.format("%.2f", result));
    }


}
