package com.boy.learning.kotlinlearningtravel.javavskotlin;

/**
 * @author jingang.li
 */
public class Student {
    private String mName;
    private int mScore;
    public Student(String name,int score){
        mName=name;
        mScore=score;
    }
    public String getName() {
        return this.mName;
    }
    public int getScore() {
        return this.mScore;
    }
    public void setName(String name){
        mName=name;
    }
    public void setScore(int score){
        mScore=score;
    }
    @Override
    public String toString(){
        return "Student:name="+mName+",score="+mScore;
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
