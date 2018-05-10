package com.example.android.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by android on 5/9/18.
 */

public class PlayGame extends AppCompatActivity{

    private List<Question> qlist;
    private int points = 0;
    private int qid = 0;
    private Question ques;
    private TextView Q;
    RadioGroup qg;
    private RadioButton a, b, c, d;
    private Button next;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);

        Q = findViewById(R.id.question1);
        a = findViewById(R.id.OpA);
        b = findViewById(R.id.OpB);
        c = findViewById(R.id.OpC);
        d = findViewById(R.id.OpD);
        qg = findViewById(R.id.qs1);
        next = findViewById(R.id.nxtbtn);

        Game database = new Game(this);
        qlist = database.getQuestions();
        ques = qlist.get(qid);

        QuestionView();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton ans = (RadioButton) findViewById(qg.getCheckedRadioButtonId());
                if(ques.getAns().equals(ans.getText())){
                    points+=5;
                } if (qid < 4){
                    ques=qlist.get(qid);
                    QuestionView();
                } else {
                    AlertDialog 
                }
            }
        });




    }

    public void QuestionView(){
        Q.setText(ques.getQuestion());
        a.setText(ques.getA());
        b.setText(ques.getB());
        c.setText(ques.getC());
        d.setText(ques.getD());
        qid++;
    }

}
