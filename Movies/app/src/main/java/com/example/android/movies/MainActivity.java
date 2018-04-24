package com.example.android.movies;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    private ArrayList<String> movieTitles;
    private Button button;
    private ArrayList<String> movies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=findViewById(R.id.list);
        button=findViewById(R.id.btn);
        movieTitles = new ArrayList<String>();
        movies = new ArrayList<String>();
        final ArrayAdapter<String> adapter;

        movieTitles.add("Black Panther");
        movieTitles.add("The Hunger Games");
        movieTitles.add("John Wick");
        movieTitles.add("Beauty and the Beast");

        movies.add("1825683/");
        movies.add("1392170/");
        movies.add("2911666/");
        movies.add("2771200/");

        adapter = new ArrayAdapter<String>(this, R.layout.list_item_view, movieTitles);
        list.setAdapter(adapter);
        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.imdb.com/title/tt"+movies.get(i)));
                        startActivity(in);
                    }
                }
        );

        list.setOnItemLongClickListener(
                new OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                        movieTitles.remove(i);
                        movies.remove(i);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Movie Terminated. It Will Not Be Back", Toast.LENGTH_LONG).show();
                        return true;
                    }
                }
        );
    }

    public void buttonPressed(View v) {
        Intent i = new Intent(this, AddMovie.class);
        startActivityForResult(i, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                String title = data.getStringExtra("movie");
                String code = data.getStringExtra("imbd");
                movieTitles.add(title);
                movies.add(code);
                ArrayAdapter<String> adapter;
                adapter = new ArrayAdapter<String>(this, R.layout.list_item_view, movieTitles);
                list.setAdapter(adapter);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
    }
}
