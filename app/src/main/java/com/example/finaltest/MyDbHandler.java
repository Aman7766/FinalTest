package com.example.finaltest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDbHandler extends SQLiteOpenHelper {

    private static final int database_version = 1;
    private static final String key_question = "question_details";
    private static final String key_question_num = "question_number";
    private static final String key_answer = "answer";
    private static final String key_table = "question_table";
    private static final String key_database = "Final_db";

    public MyDbHandler(@Nullable Context context) {
        super(context, key_database, null, database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + key_table + " (" +
                key_question_num + " TEXT PRIMARY KEY, " +
                key_question + " TEXT, " +
                key_answer + " TEXT);");
    }


    public int insertData(QuizDetails quizDetails) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(key_question_num, quizDetails.getQuestion_num());
        contentValues.put(key_question, quizDetails.getQuestion_detail());
        contentValues.put(key_answer, quizDetails.getAnswer());
        sqLiteDatabase.insert(key_table, null, contentValues);
        return 1;
    }


    public int DeleteData(String question_num) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(key_table, key_question_num + "=?", new String[]{question_num});
        sqLiteDatabase.close();
        return 1;
    }

    public ArrayList<QuizDetails> ViewData(String id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "SELECT * FROM " + key_table + " WHERE " + key_question_num + " = " + id;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        ArrayList<QuizDetails> arrayList = new ArrayList<QuizDetails>();
        // moving our cursor to first position.
        if (cursor.moveToFirst()) {
            do {
                QuizDetails quizDetails = new QuizDetails();
                quizDetails.setQuestion_num(cursor.getString(0));
                quizDetails.setQuestion_detail(cursor.getString(1));
                quizDetails.setAnswer(cursor.getString(2));
                arrayList.add(quizDetails);
            } while (cursor.moveToNext());
            // moving our cursor to next.
        }
        cursor.close();
        return arrayList;
    }


    public ArrayList<QuizDetails> ViewAllData() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "SELECT * FROM " + key_table;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        ArrayList<QuizDetails> arrayList = new ArrayList<QuizDetails>();
        // moving our cursor to first position.
        if (cursor.moveToFirst()) {
            do {
                QuizDetails quizDetails = new QuizDetails();
                quizDetails.setQuestion_num(cursor.getString(0));
                quizDetails.setQuestion_detail(cursor.getString(1));
                quizDetails.setAnswer(cursor.getString(2));
                arrayList.add(quizDetails);
            } while (cursor.moveToNext());
            // moving our cursor to next.
        }
        cursor.close();
        return arrayList;
    }

    public int UpdateData(QuizDetails quizDetails) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(key_question_num, quizDetails.getQuestion_num());
        contentValues.put(key_question, quizDetails.getQuestion_detail());
        contentValues.put(key_answer, quizDetails.getAnswer());
        sqLiteDatabase.update(key_table, contentValues, "question_number=?", new String[]{quizDetails.getQuestion_num()});
        return 1;
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + key_table);
        onCreate(sqLiteDatabase);
    }
}
