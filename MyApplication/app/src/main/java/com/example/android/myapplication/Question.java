package com.example.android.myapplication;

/**
 * Created by android on 5/9/18.
 */

public class Question {

    private int ID;
    private String q;
    private String ans;
    private String a;
    private String b;
    private String c;
    private String d;

    public Question(String Q, String Ans, String A, String B, String C, String D) {
        q = Q;
        ans = Ans;
        a = A;
        b = B;
        c = C;
        d = D;
    }

    public Question() {
        ID = 0;
        q="";
        ans="";
        a="";
        b="";
        c="";
        d="";
    }


    public String getA(){
        return a;
    }

    public void setA(String A){
        a = A;
    }

    public String getB(){
        return b;
    }

    public void setB(String B){
        b = B;
    }
    public String getC(){
        return c;
    }

    public void setC(String C){
        c = C;
    }

    public String getD(){
        return d;
    }

    public void setD(String D){
        d = D;
    }

    public String getAns(){
        return ans;
    }

    public void setAns(String Ans){
        ans = Ans;
    }

    public String getQuestion(){
        return q;
    }

    public void setQuestion(String Q){
        q = Q;
    }

    public int getID(){
        return ID;
    }

    public void setID(int id){
        ID = id;
    }

}
