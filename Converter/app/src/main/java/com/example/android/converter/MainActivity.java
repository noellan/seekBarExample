package com.example.android.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText inputView;
    private TextView outputView;
    private RadioButton ftocButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputView = findViewById(R.id.inputView);
        outputView = findViewById(R.id.outputView);
        ftocButton = findViewById(R.id.ftocButton);
    }

    public void buttonPressed(View v){
        String input = inputView.getText().toString();
        double t = Double.parseDouble(input);
        double result;
        if (ftocButton.isChecked()){
            result = 1.8*t+32;
        } else {
            result = 1.8*t-32;
        }
        outputView.setText(result+"");
    }
}
