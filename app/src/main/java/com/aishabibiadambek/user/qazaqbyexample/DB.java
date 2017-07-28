package com.aishaadambek.user.qazaqbyexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 23.07.2017.
 */

public class DB {


    private static final String DB_NAME = "QazaqByExample";
    private static final String DB_TABLE = "myDict";
    private static final int DB_VERSION = 1;
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_USER = "user";
    public static final String COLUMN_TXT = "main";
    public static final String COLUMN_TXT1 = "sub";
    private static final String DB_CREATE = "create table " + DB_TABLE + "(" +
            COLUMN_ID + " integer primary key autoincrement, " +
            COLUMN_USER + " text, " +
            COLUMN_TXT + " text, " +
            COLUMN_TXT1 + " text" + ");";
    private static Context mContext;
    private DBHelper mDBHelper;
    private SQLiteDatabase mDB;
    private String username;

    public DB(Context context){
        mContext = context;
        username = context.getSharedPreferences("USER_INFO", Context.MODE_PRIVATE).getString("username", "");
    }

    public void open(){
        mDBHelper = new DBHelper(mContext, DB_NAME, null, DB_VERSION);
        mDB = mDBHelper.getWritableDatabase();
    }

    public void close(){
        if(mDBHelper != null) mDBHelper.close();
    }

    public Cursor getAllUserData(){
        return mDB.query
                (
                        DB_TABLE,
                        null,
                        COLUMN_USER + " = ?",
                        new String[] {username},
                        null, null, null
                );
    }

    public void addRecord(String user, String text, String text1){
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_USER, user);
        cv.put(COLUMN_TXT, text);
        cv.put(COLUMN_TXT1, text1);
        mDB.insert(DB_TABLE, null, cv);
    }

    public void deleteRecord(long id){
        mDB.delete(DB_TABLE, COLUMN_ID + " = " + id, null);
    }

    private class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DB_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }

    }

}
