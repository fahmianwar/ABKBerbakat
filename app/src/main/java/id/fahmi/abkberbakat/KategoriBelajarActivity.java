package id.fahmi.abkberbakat;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class KategoriBelajarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori_belajar);
    }
    public void tombol_kata_sayuran(View view){
        MediaPlayer audio_kategori_sayuran = MediaPlayer.create(this, R.raw.sayuran);
        audio_kategori_sayuran.start();
        Intent intent_tombol_kata_sayuran = new Intent(this, CobaActivity.class);
        intent_tombol_kata_sayuran.putExtra("kategori", "sayuran");
        startActivity(intent_tombol_kata_sayuran);
    }
    public void tombol_kata_bendera(View view){
        MediaPlayer audio_kategori_bendera = MediaPlayer.create(this, R.raw.bendera);
        audio_kategori_bendera.start();
        Intent intent_tombol_kata_bendera = new Intent(this, CobaActivity.class);
        intent_tombol_kata_bendera.putExtra("kategori", "bendera");
        startActivity(intent_tombol_kata_bendera);
    }
    public void tombol_kata_tempat(View view){
        MediaPlayer audio_kategori_tempat = MediaPlayer.create(this, R.raw.tempat);
        audio_kategori_tempat.start();
        Intent intent_tombol_kata_tempat = new Intent(this, CobaActivity.class);
        intent_tombol_kata_tempat.putExtra("kategori", "tempat");
        startActivity(intent_tombol_kata_tempat);
    }
    public void tombol_kata_hewan(View view){
        MediaPlayer audio_kategori_hewan = MediaPlayer.create(this, R.raw.hewan);
        audio_kategori_hewan.start();
        Intent intent_tombol_kata_hewan = new Intent(this, CobaActivity.class);
        intent_tombol_kata_hewan.putExtra("kategori", "hewan");
        startActivity(intent_tombol_kata_hewan);
    }
    public void tombol_kata_kendaraan(View view){
        MediaPlayer audio_kategori_kendaraan = MediaPlayer.create(this, R.raw.kendaraan);
        audio_kategori_kendaraan.start();
        Intent intent_tombol_kata_kendaraan = new Intent(this, CobaActivity.class);
        intent_tombol_kata_kendaraan.putExtra("kategori", "kendaraan");
        startActivity(intent_tombol_kata_kendaraan);
    }
    public void tombol_kata_keluarga(View view){
        Intent intent_tombol_kata_keluarga = new Intent(this, CobaActivity.class);
        intent_tombol_kata_keluarga.putExtra("kategori", "keluarga");
        startActivity(intent_tombol_kata_keluarga);
    }
    public void tombol_kata_bunga(View view){
        MediaPlayer audio_kategori_bunga = MediaPlayer.create(this, R.raw.bunga);
        audio_kategori_bunga.start();
        Intent intent_tombol_kata_bunga = new Intent(this, CobaActivity.class);
        intent_tombol_kata_bunga.putExtra("kategori", "bunga");
        startActivity(intent_tombol_kata_bunga);
    }
    public void tombol_kata_buah(View view){
        MediaPlayer audio_kategori_buah = MediaPlayer.create(this, R.raw.buah);
        audio_kategori_buah.start();
        Intent intent_tombol_kata_buah = new Intent(this, CobaActivity.class);
        intent_tombol_kata_buah.putExtra("kategori", "buah");
        startActivity(intent_tombol_kata_buah);
    }
    public void tombol_kata_anggota_tubuh(View view){
        MediaPlayer audio_kategori_anggota_tubuh = MediaPlayer.create(this, R.raw.anggota_tubuh);
        audio_kategori_anggota_tubuh.start();
        Intent intent_tombol_kata_anggota_tubuh = new Intent(this, CobaActivity.class);
        intent_tombol_kata_anggota_tubuh.putExtra("kategori", "anggota_tubuh");
        startActivity(intent_tombol_kata_anggota_tubuh);
    }
    public void tombol_kata_perabotan(View view){
        MediaPlayer audio_kategori_perabotan = MediaPlayer.create(this, R.raw.perabotan);
        audio_kategori_perabotan.start();
        Intent intent_tombol_kata_perabotan = new Intent(this, CobaActivity.class);
        intent_tombol_kata_perabotan.putExtra("kategori", "perabotan");
        startActivity(intent_tombol_kata_perabotan);
    }
    public void tombol_kata_profesi(View view){
        MediaPlayer audio_kategori_profesi = MediaPlayer.create(this, R.raw.profesi);
        audio_kategori_profesi.start();
        Intent intent_tombol_kata_profesi = new Intent(this, CobaActivity.class);
        intent_tombol_kata_profesi.putExtra("kategori", "profesi");
        startActivity(intent_tombol_kata_profesi);
    }
    public void tombol_kata_kerja(View view){
        MediaPlayer audio_kategori_kerja = MediaPlayer.create(this, R.raw.kata_kerja);
        audio_kategori_kerja.start();
        Intent intent_tombol_kata_kerja = new Intent(this, KosakataActivity.class);
        //intent_tombol_kata_kerja.putExtra("kategori", "kata kerja");
        startActivity(intent_tombol_kata_kerja);
    }
    public void tombol_pohon(View view){
        MediaPlayer audio_kategori_pohon = MediaPlayer.create(this, R.raw.pohon);
        audio_kategori_pohon.start();
        Intent intent_tombol_pohon = new Intent(this, CobaActivity.class);
        intent_tombol_pohon.putExtra("kategori", "pohon");
        startActivity(intent_tombol_pohon);
    }
    public void tombol_huruf(View view){
        MediaPlayer audio_kategori_huruf = MediaPlayer.create(this, R.raw.huruf);
        audio_kategori_huruf.start();
        Intent intent_tombol_huruf= new Intent(this, CobaActivity.class);
        intent_tombol_huruf.putExtra("kategori", "huruf");
        startActivity(intent_tombol_huruf);
    }
    public void tombol_angka(View view){
        MediaPlayer audio_kategori_angka = MediaPlayer.create(this, R.raw.angka);
        audio_kategori_angka.start();
        Intent intent_tombol_angka = new Intent(this, CobaActivity.class);
        intent_tombol_angka.putExtra("kategori", "angka");
        startActivity(intent_tombol_angka);
    }

}
