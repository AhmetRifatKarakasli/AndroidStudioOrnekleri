package com.example.veritabani;

import android.support.annotation.NonNull;

public class Ogrenci {
    private int og_no;
    private String ad_soyad;
    private int tc_no;
    private String adres;

    public Ogrenci(String ad_soyad, int tc_no, String adres, int og_no) {
        this.og_no = og_no;
        this.ad_soyad = ad_soyad;
        this.tc_no = tc_no;
        this.adres = adres;
    }

    @NonNull
    @Override
    public String toString() {
        return "Ogrenci no: "+og_no+" Ad: "+ad_soyad+" Tc: "+tc_no+" Adres: "+adres;
    }

    public int getOg_no() {
        return og_no;
    }

    public void setOg_no(int og_no) {
        this.og_no = og_no;
    }

    public String getAd_soyad() {
        return ad_soyad;
    }

    public void setAd_soyad(String ad_soyad) {
        this.ad_soyad = ad_soyad;
    }

    public int getTc_no() {
        return tc_no;
    }

    public void setTc_no(int tc_no) {
        this.tc_no = tc_no;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}
