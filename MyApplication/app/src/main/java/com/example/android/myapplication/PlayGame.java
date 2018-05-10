package com.example.android.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by android on 5/9/18.
 */

public class PlayGame extends AppCompatActivity{

    private int points = 0;
    private RadioButton a, b, c, d, a2, b2, c2, d2, a3, b3, c3, d3;
    private Button next;
    private RadioGroup q1, q2, q3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);

        q1 = findViewById(R.id.qs1);
        q2 = findViewById(R.id.qs2);
        q3 = findViewById(R.id.qs3);

        a = findViewById(R.id.OpA2);
        b = findViewById(R.id.OpB2);
        c = findViewById(R.id.OpC2);
        d = findViewById(R.id.OpD2);
        next = findViewById(R.id.nxtbtn);

        a2 = findViewById(R.id.OpA);
        b2 = findViewById(R.id.OpB);
        c2 = findViewById(R.id.OpC);
        d2 = findViewById(R.id.OpD);

        a3 = findViewById(R.id.A3);
        b3 = findViewById(R.id.B3);
        c3 = findViewById(R.id.C3);
        d3 = findViewById(R.id.D3);



        a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                math(compoundButton);
            }
        });
        b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                math(compoundButton);
            }
        });
        c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                math(compoundButton);
            }
        });
        d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                math(compoundButton);
            }
        });
        a2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                math(compoundButton);
            }
        });
        b2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                math(compoundButton);
            }
        });
        c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                math(compoundButton);
            }
        });
        d2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                math(compoundButton);
            }
        });
        a3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                math(compoundButton);
            }
        });
        b3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                math(compoundButton);
            }
        });
        c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                math(compoundButton);
            }
        });
        d3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                math(compoundButton);
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(PlayGame.this);
                    builder.setTitle("Results!");
                    if(points >= 10) {
                        builder.setMessage("You know your stuff!");
                    } else {
                        builder.setMessage("You got some studying to do, pal!");
                    }
                        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            q1.clearCheck();
                            q2.clearCheck();
                            q3.clearCheck();
                            dialogInterface.dismiss();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();

                    return;
                }
        });
    }

    public int math(View v) {
        int p;

        if (a2.isChecked()) {
            p = 5;
        } else {
            p = 0;
        }

        int p2;
        if (c.isChecked()) {
            p2 = 5;
        } else {
            p2 = 0;
        }

        int p3;
        if (c3.isChecked()) {
            p3 = 5;
        } else {
            p3 = 0;
        }

        points = p + p2 + p3;

        return points;
    }

}
