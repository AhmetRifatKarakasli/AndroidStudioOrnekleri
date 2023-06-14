package com.example.veritabani;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText tc_txt,ad_txt,adres_txt;
    private Button kaydet_btn,liste_btn;
    private ListView liste;
    private Veritabani_Yardimcisi vt;
    private ArrayList<Ogrenci> ogrenci_listem = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private ArrayList<String> listeye_yazilacak = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tc_txt = findViewById(R.id.tc_txt);
        ad_txt = findViewById(R.id.ad_txt);
        adres_txt = findViewById(R.id.adres_txt);
        kaydet_btn = findViewById(R.id.kaydet_btn);
        liste_btn = findViewById(R.id.liste_btn);
        liste = findViewById(R.id.liste);
        vt = new Veritabani_Yardimcisi(this);

        kaydet_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Ogrenciler_dao().Ogrenci_ekle(vt,
                        Integer.parseInt(tc_txt.getText().toString()),
                        ad_txt.getText().toString(),adres_txt.getText().toString());
                Toast.makeText(MainActivity.this, "Kayıt yapıldı", Toast.LENGTH_SHORT).show();
                liste_yaz();
            }
        });

        liste_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                liste_yaz();
            }
        });
    }//create
    public void liste_yaz(){
        ogrenci_listem = new Ogrenciler_dao().tum_ogrencileri_getir(vt);
        listeye_yazilacak.clear();
        for (Ogrenci gelen_ogr:ogrenci_listem){
            listeye_yazilacak.add(gelen_ogr.toString());
        }//foreach
        adapter = new ArrayAdapter<String >
                (this, android.R.layout.simple_list_item_1,android.R.id.text1,listeye_yazilacak);
        liste.setAdapter(adapter);
    }
}