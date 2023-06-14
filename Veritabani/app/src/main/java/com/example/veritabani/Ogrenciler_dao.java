package com.example.veritabani;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Ogrenciler_dao {
    public void Ogrenci_ekle(Veritabani_Yardimcisi vt,int tc_no,String ad_soyad,String adres){
        SQLiteDatabase dbx = vt.getWritableDatabase();
        ContentValues degerler = new ContentValues();
        degerler.put("tc_no",tc_no);
        degerler.put("ad_soyad",ad_soyad);
        degerler.put("adres",adres);
        dbx.insertOrThrow("ogrenciler",null,degerler);
        dbx.close();
    }
    public ArrayList<Ogrenci> tum_ogrencileri_getir(Veritabani_Yardimcisi vt){
        ArrayList<Ogrenci> ogrenci_listemiz = new ArrayList<>();
        SQLiteDatabase dbx = vt.getWritableDatabase();
        Cursor verilerim = dbx.rawQuery("select * from ogrenciler order by ad_soyad asc",null);
        while(verilerim.moveToNext()){
            @SuppressLint("Range") Ogrenci yeni_ogr = new Ogrenci(
                    verilerim.getString(verilerim.getColumnIndex("ad_soyad")),
                    verilerim.getInt(verilerim.getColumnIndex("tc_no")),
                    verilerim.getString(verilerim.getColumnIndex("adres")),
                    verilerim.getInt(verilerim.getColumnIndex("og_no")));
            ogrenci_listemiz.add(yeni_ogr);
        }
        return ogrenci_listemiz;
    }
}
