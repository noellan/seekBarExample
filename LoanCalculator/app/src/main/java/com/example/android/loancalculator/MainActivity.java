package com.example.android.loancalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView seekLabel;
    private EditText carInput;
    private EditText downInput;
    private EditText APRInput;
    private EditText paymentoutput;
    private RadioButton loanbtn;
    private RadioButton leasebtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        seekLabel = findViewById(R.id.seekLabel);
        carInput = findViewById(R.id.carcostinput);
        downInput = findViewById(R.id.DPinput);
        APRInput = findViewById(R.id.APRinput);
        loanbtn = findViewById(R.id.loanbtn);
        leasebtn = findViewById(R.id.leasebtn);
        paymentoutput = findViewById(R.id.paymentOutput);

        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        seekLabel.setText(i+"");
                        buttonPressed(seekBar);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

        carInput.setOnEditorActionListener(
                new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        buttonPressed(textView);
                        return false;
                    }
                }
        );

        downInput.setOnEditorActionListener(
                new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        buttonPressed(textView);
                        return false;
                    }
                }
        );

        APRInput.setOnEditorActionListener(
                new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        buttonPressed(textView);
                        return false;
                    }
                }
        );

        loanbtn.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        buttonPressed(compoundButton);
                    }
                }
        );

        leasebtn.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        buttonPressed(compoundButton);
                    }
                }
        );

        if(savedInstanceState != null){
            paymentoutput.setText(savedInstanceState.getString("TOTAL"));
        }

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("TOTAL", paymentoutput.getText().toString());
    }

    public void buttonPressed(View v) {
        try {

            String car = carInput.getText().toString();
            String down = downInput.getText().toString();
            String APR = APRInput.getText().toString();

            double c = Double.parseDouble(car);
            double d = Double.parseDouble(down);
            double a = Double.parseDouble(APR) / 100;

            int time = seekBar.getProgress();

            double r = 0;

            if (loanbtn.isChecked()) {
                r = (a / 12) * (c - d) / (1 - Math.pow((1 + (a / 12)), -time));
            } else if (leasebtn.isChecked()) {
                r = (a / 12) * ((c / 3) - d) / (1 - Math.pow((1 + a / 12), -36));
            }

            paymentoutput.setText(String.format("%.2f", r));

        } catch (NumberFormatException n){

        }
    }

}
