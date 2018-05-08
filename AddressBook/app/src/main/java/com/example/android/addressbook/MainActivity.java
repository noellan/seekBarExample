package com.example.android.addressbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView contacts;
    private ArrayList<String> people;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contacts = findViewById(R.id.contacts);
        button = findViewById(R.id.btn);
        people = new ArrayList<String>();


    }
}
