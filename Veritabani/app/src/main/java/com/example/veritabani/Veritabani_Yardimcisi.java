package com.example.veritabani;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class Veritabani_Yardimcisi extends SQLiteOpenHelper {
    public Veritabani_Yardimcisi(@Nullable Context context) {
        super(context, "okul_vt", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table ogrenciler (og_no Integer primary key autoincrement,ad_soyad TEXT,tc_no Integer,adres TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists ogrenciler");
        onCreate(db);
    }
}
