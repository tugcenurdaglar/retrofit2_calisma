package com.tugcenurdaglar.retrofitcalismasi;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private KisilerDaoInterface kisilerDIF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kisilerDIF = ApiUtils.getKisilerDaoInterface();
//        tumKisiler();
//        kisiAra();
//        kisiSil();
//        kisiEkle();
        kisiGuncelle();
    }

    public void tumKisiler() {
        kisilerDIF.tumKisiler().enqueue(new Callback<KisilerCevap>() {
            @Override
            public void onResponse(Call<KisilerCevap> call, Response<KisilerCevap> response) {

                List<Kisiler> kisilerListe = response.body().getKisiler();

                for (Kisiler k : kisilerListe) {
                    Log.e("**********", "**********");
                    Log.e("kisi id", k.getKisiId());
                    Log.e("kisi ad", k.getKisiAd());
                    Log.e("kisi tel", k.getKisiTel());
                    Log.e("**********", "**********");
                }
            }

            @Override
            public void onFailure(Call<KisilerCevap> call, Throwable t) {

            }
        });
    }

    public void kisiAra() {
        kisilerDIF.kisiAra("t").enqueue(new Callback<KisilerCevap>() {
            @Override
            public void onResponse(Call<KisilerCevap> call, Response<KisilerCevap> response) {
                List<Kisiler> kisilerListe = response.body().getKisiler();

                for (Kisiler k : kisilerListe) {
                    Log.e("**********", "**********");
                    Log.e("kisi id", k.getKisiId());
                    Log.e("kisi ad", k.getKisiAd());
                    Log.e("kisi tel", k.getKisiTel());
                    Log.e("**********", "**********");
                }
            }

            @Override
            public void onFailure(Call<KisilerCevap> call, Throwable t) {

            }
        });
    }

    public void kisiSil() {
        kisilerDIF.kisiSil(34).enqueue(new Callback<CRUDCevap>() {
            @Override
            public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) {
                Log.e("Başarı", response.body().getSuccess().toString());
                Log.e("Mesaj", response.body().getMessage().toString());
            }

            @Override
            public void onFailure(Call<CRUDCevap> call, Throwable t) {

            }
        });
    }

    public void kisiEkle() {
        kisilerDIF.kisiEkle("AHMET", "9999999999").enqueue(new Callback<CRUDCevap>() {
            @Override
            public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) {
                Log.e("Başarı", response.body().getSuccess().toString());
                Log.e("Mesaj", response.body().getMessage().toString());
            }

            @Override
            public void onFailure(Call<CRUDCevap> call, Throwable t) {

            }
        });
    }

    public void kisiGuncelle() {
        kisilerDIF.kisiGuncelle(5, "Tuğçe", "5555555555").enqueue(
                new Callback<CRUDCevap>() {
                    @Override
                    public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) {
                        Log.e("Başarı", response.body().getSuccess().toString());
                        Log.e("Mesaj", response.body().getMessage().toString());
                    }

                    @Override
                    public void onFailure(Call<CRUDCevap> call, Throwable t) {

                    }
                }
        );
    }


}