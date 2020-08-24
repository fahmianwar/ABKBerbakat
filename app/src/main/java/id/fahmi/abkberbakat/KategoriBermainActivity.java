package id.fahmi.abkberbakat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class KategoriBermainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori_bermain);
    }
    public void tombol_tebak_gambar(View view){
        Intent intent_tombol_tebak_gambar = new Intent(this, GameTebakGambarActivity.class);
        //intent_tombol_tebak_gambar.putExtra("kategori", "bendera");
        startActivity(intent_tombol_tebak_gambar);
    }
    public void tombol_game_aritmatika(View view){
        Intent intent_tombol_game_aritmatika = new Intent(this, GameAritmatikaActivity.class);
        //intent_tombol_game_aritmatika.putExtra("kategori", "bendera");
        startActivity(intent_tombol_game_aritmatika);
    }
    public void tombol_game_tebak_angka(View view){
        Intent intent_tombol_game_tebak_angka = new Intent(this, GameTebakJumlahObjekActivity.class);
        //intent_tombol_game_aritmatika.putExtra("kategori", "bendera");
        startActivity(intent_tombol_game_tebak_angka);
    }
    public void tombol_game_tebak_suara(View view){
        // acan di edit euyy
        Intent intent_tombol_game_tebak_suara = new Intent(this, GameTebakSuaraActivity.class);
        //intent_tombol_game_aritmatika.putExtra("kategori", "bendera");
        startActivity(intent_tombol_game_tebak_suara);
    }
}
