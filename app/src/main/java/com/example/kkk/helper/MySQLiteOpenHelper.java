package com.example.kkk.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    public MySQLiteOpenHelper(@Nullable Context context) {
        super(context, "pinkStar.db", null, 1);
    }

    /**
     * 创建表，在应用目录下产生对应的db文件
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE user(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "account VARCHAR(20), " +
                "email VARCHAR(20), " +
                "password VARCHAR(20))");
    }

    /**
     * 修改数据库表结构or其他，只有新视图的version比旧的大才执行
     * @param db 数据库
     * @param oldVersion 旧视图的version
     * @param newVersion 新视图的version
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
