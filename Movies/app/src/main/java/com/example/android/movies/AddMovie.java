package com.example.android.movies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by android on 4/3/18.
 */

public class AddMovie extends AppCompatActivity {

    private EditText movietitle;
    private EditText imbdcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_movie);
        movietitle = findViewById(R.id.movietitle);
        imbdcode = findViewById(R.id.imbdcode);

    }

   @Override
   public void onBackPressed(){
       Intent data = new Intent();
       data.putExtra("movie", movietitle.getText().toString());
       data.putExtra("imbd", imbdcode.getText().toString());
       setResult(MainActivity.RESULT_OK, data);
       finish();
   }

}
