package com.manzx.myapplication.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by MAN on 9/15/2016.
 */
public class DbHelper extends SQLiteOpenHelper {
    private static final String databaseName = "todolist.sqlite";
    private static final int databaseVersion = 1;
    Context myContext;

    private static final String tableCreateSQL = "CREATE TABLE todo_list(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "todo_text TEXT" +
            ");";

    public DbHelper(Context context) {
        super(context, databaseName, null, databaseVersion);
        this.myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(tableCreateSQL);
        for (int i = 1; i <= 1000; i++) {
            db.execSQL("INSERT INTO todo_list (todo_text) VALUES('Todo Text "+i+"');");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS todo_list");
        onCreate(db);
    }
}
