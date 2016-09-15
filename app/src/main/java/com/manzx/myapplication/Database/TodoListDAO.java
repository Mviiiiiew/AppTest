package com.manzx.myapplication.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by MAN on 9/15/2016.
 */
public class TodoListDAO {
    private SQLiteDatabase database;
    private DbHelper dbHelper;

    public TodoListDAO(Context context) {
        dbHelper = new DbHelper(context);

    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public ArrayList<String> getAllTodoList() {
        ArrayList<String> todoList = new ArrayList<String>();
        Cursor cursor = database.rawQuery("SELECT * FROM todo_list limit 50;",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            todoList.add(cursor.getString(1));
            cursor.moveToNext();
        }
        cursor.close();
        return todoList;
    }
}
