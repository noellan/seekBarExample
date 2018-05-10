package com.example.android.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 5/9/18.
 */

public class Game extends SQLiteOpenHelper{

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "Trivia";
    private static final String TBL_NAME = "Trivia Table";
    private static final String KEY_ID = "ID", KEY_Q = "Q", KEY_ANS = "Ans", KEY_1 = "a", KEY_2 ="b", KEY_3 = "c", KEY_4 = "d";
    private SQLiteDatabase database;

    public Game(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE IF NOT EXISTS " + TBL_NAME + " (" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_Q + " TEXT, " + KEY_ANS + " TEXT, " +
                KEY_1 + " TEXT, " + KEY_2 + " TEXT, " +
                KEY_3 + " TEXT, " + KEY_4 + " TEXT" + ")";
        db.execSQL(create);
        Questions();

    }

    private void Questions(){
        Question ques1 = new Question("Which sea creature has three hearts?", "Octopus", "Whale","Goldfish","Octopus","Foraging Squid");
        this.Questions(ques1);
        Question ques2 = new Question("Which instrument has forty-seven strings and seven pedals?","Harp","Piano","Organ","Zither","Harp");
        this.Questions(ques2);
        Question ques3 = new Question("Which is the largest and most dense of the four rocky planets?","Earth","Venus","Earth","Mercury","Mars");
        this.Questions(ques3);
        Question ques4 = new Question("Who is the CEO of Google?","Sundar Pichai","Mark Zuckerburg","Sundar Pichai","Jeff Bezos","Susan Wojcicki");
        this.Questions(ques4);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TBL_NAME);
        onCreate(db);
    }

    public void Questions(Question q){
        ContentValues v = new ContentValues();
        v.put(KEY_Q,q.getQuestion());
        v.put(KEY_ANS,q.getAns());
        v.put(KEY_1, q.getA());
        v.put(KEY_2, q.getB());
        v.put(KEY_3, q.getC());
        v.put(KEY_4, q.getD());
        database.insert(TBL_NAME, null, v);
    }

    public List<Question> getQuestions(){
        List<Question> qlist = new ArrayList<>();
        String getQuery = "SELECT * FROM " + TBL_NAME;
        database=this.getReadableDatabase();
        Cursor c = database.rawQuery(getQuery, null);
        if(c.moveToFirst()) {
            do {
                Question q = new Question();
                q.setID(c.getInt(0));
                q.setQuestion(c.getString(1));
                q.setAns(c.getString(2));
                q.setA(c.getString(3));
                q.setB(c.getString(4));
                q.setC(c.getString(5));
                q.setD(c.getString(6));
                qlist.add(q);
            } while (c.moveToNext());
        }
        return qlist;

    }

    public int countrows(){
        int r = 0;
        String getQuery = "SELECT * FROM " + TBL_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(getQuery, null);
        r = c.getCount();
        return r;
    }
}
