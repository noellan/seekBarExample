package com.example.android.addressbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by android on 5/8/18.
 */

public class People  extends AppCompatActivity {

    private EditText name;
    private EditText phone;
    private EditText email;
    private EditText address;
    private EditText notes;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.people_add);
        name = findViewById(R.id.name_input);
        phone = findViewById(R.id.phone_input);
        email = findViewById(R.id.email_input);
        address = findViewById(R.id.address_input);
        notes = findViewById(R.id.notes_input);
    }

}
