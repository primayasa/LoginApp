package com.primayasa.loginapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

public class AccountDBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "com.primayasa.loginapp.db.account";
    public static final int DB_VERSION = 1;
    public static final String TABLE = "account";
    public static final String _ID = BaseColumns._ID;
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";

    public AccountDBHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlQuery =
                String.format("CREATE TABLE %s (" +
                                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                "%s TEXT, %s TEXT)", TABLE,
                        COLUMN_USERNAME, COLUMN_PASSWORD);

        Log.d("TaskDBHelper","Query to form table: "+sqlQuery);
        sqLiteDatabase.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(sqLiteDatabase);
    }
}
