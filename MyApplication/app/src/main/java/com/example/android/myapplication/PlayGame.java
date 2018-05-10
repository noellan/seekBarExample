package com.example.android.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by android on 5/9/18.
 */

public class PlayGame extends AppCompatActivity{

    private List<Game> qlist;
    private int points = 0;
    private int qid = 0;
    private Question ques;
    private TextView Q;
    private RadioButton a, b, c, d;
    private Button next;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);
        Game dt = new Game(this);

    }

}
