package id.fahmi.abkberbakat;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class GameTebakSuaraActivity extends AppCompatActivity {
    List<KosakataClass> DataTebakSuaraList;

    Button tebak_suara_jawaban_a, tebak_suara_jawaban_b, tebak_suara_jawaban_c, tebak_suara_jawaban_d, tebak_suara_soal;
    public int kode, batas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_tebak_suara);
        DataTebakSuaraList = DatabaseClass.getInstance(getApplicationContext()).getTebakSuaraList();

        tebak_suara_jawaban_a = (Button)findViewById(R.id.tebak_suara_jawaban_a);
        tebak_suara_jawaban_b = (Button)findViewById(R.id.tebak_suara_jawaban_b);
        tebak_suara_jawaban_c = (Button)findViewById(R.id.tebak_suara_jawaban_c);
        tebak_suara_jawaban_d = (Button)findViewById(R.id.tebak_suara_jawaban_d);
        tebak_suara_soal = (Button)findViewById(R.id.tebak_suara_soal);

        kode=0;
        batas = DataTebakSuaraList.get(kode).getJumlahData();

        tebak_suara_jawaban_a.setText("");
        int jawaban_a = getResources().getIdentifier(DataTebakSuaraList.get(kode).getJawaban_A() , "drawable", getPackageName());
        tebak_suara_jawaban_a.setBackgroundResource(jawaban_a);

        tebak_suara_jawaban_b.setText("");
        int jawaban_b = getResources().getIdentifier(DataTebakSuaraList.get(kode).getJawaban_B() , "drawable", getPackageName());
        tebak_suara_jawaban_b.setBackgroundResource(jawaban_b);

        tebak_suara_jawaban_c.setText("");
        int jawaban_c = getResources().getIdentifier(DataTebakSuaraList.get(kode).getJawaban_C() , "drawable", getPackageName());
        tebak_suara_jawaban_c.setBackgroundResource(jawaban_c);

        tebak_suara_jawaban_d.setText("");
        int jawaban_d = getResources().getIdentifier(DataTebakSuaraList.get(kode).getJawaban_D() , "drawable", getPackageName());
        tebak_suara_jawaban_d.setBackgroundResource(jawaban_d);


    }
    public void tombol_tebak_suara_soal(View view){
        int hasil_ilustrasi = getResources().getIdentifier(DataTebakSuaraList.get(kode).getSuara_Objek() , "raw", getPackageName());
        MediaPlayer audio_game_tebak_suara_soal = MediaPlayer.create(this, hasil_ilustrasi);
        audio_game_tebak_suara_soal.start();
    }

    public void tombol_tebak_jawaban_a(View view){
        if (kode == (batas - 1)) {
            Toast.makeText(this, "Selesai", Toast.LENGTH_SHORT).show();

        } else if (DataTebakSuaraList.get(kode).getJawaban_A().equals(DataTebakSuaraList.get(kode).getJawaban())){
            MediaPlayer audio_game_tebak_suara_benar = MediaPlayer.create(this, R.raw.jawaban_benar);
            audio_game_tebak_suara_benar.start();
            Toast.makeText(this, "Benar!", Toast.LENGTH_SHORT).show();
            kode++;
            int jawaban_a = getResources().getIdentifier(DataTebakSuaraList.get(kode).getJawaban_A() , "drawable", getPackageName());
            tebak_suara_jawaban_a.setBackgroundResource(jawaban_a);
            int jawaban_b = getResources().getIdentifier(DataTebakSuaraList.get(kode).getJawaban_B() , "drawable", getPackageName());
            tebak_suara_jawaban_b.setBackgroundResource(jawaban_b);
            int jawaban_c = getResources().getIdentifier(DataTebakSuaraList.get(kode).getJawaban_C() , "drawable", getPackageName());
            tebak_suara_jawaban_c.setBackgroundResource(jawaban_c);
            int jawaban_d = getResources().getIdentifier(DataTebakSuaraList.get(kode).getJawaban_D() , "drawable", getPackageName());
            tebak_suara_jawaban_d.setBackgroundResource(jawaban_d);

        }else{
            MediaPlayer audio_game_tebak_suara_salah = MediaPlayer.create(this, R.raw.jawaban_salah);
            audio_game_tebak_suara_salah.start();
            Toast.makeText(this, "Salah!", Toast.LENGTH_SHORT).show();
        }
    }

    public void tombol_tebak_jawaban_b(View view){
        if (kode == (batas - 1)) {
            Toast.makeText(this, "Selesai", Toast.LENGTH_SHORT).show();
        } else if(DataTebakSuaraList.get(kode).getJawaban_B().equals(DataTebakSuaraList.get(kode).getJawaban())){
            MediaPlayer audio_game_tebak_suara_benar = MediaPlayer.create(this, R.raw.jawaban_benar);
            audio_game_tebak_suara_benar.start();
            Toast.makeText(this, "Benar!", Toast.LENGTH_SHORT).show();
            kode++;
            int jawaban_a = getResources().getIdentifier(DataTebakSuaraList.get(kode).getJawaban_A() , "drawable", getPackageName());
            tebak_suara_jawaban_a.setBackgroundResource(jawaban_a);
            int jawaban_b = getResources().getIdentifier(DataTebakSuaraList.get(kode).getJawaban_B() , "drawable", getPackageName());
            tebak_suara_jawaban_b.setBackgroundResource(jawaban_b);
            int jawaban_c = getResources().getIdentifier(DataTebakSuaraList.get(kode).getJawaban_C() , "drawable", getPackageName());
            tebak_suara_jawaban_c.setBackgroundResource(jawaban_c);
            int jawaban_d = getResources().getIdentifier(DataTebakSuaraList.get(kode).getJawaban_D() , "drawable", getPackageName());
            tebak_suara_jawaban_d.setBackgroundResource(jawaban_d);
        }else{
            MediaPlayer audio_game_tebak_suara_salah = MediaPlayer.create(this, R.raw.jawaban_salah);
            audio_game_tebak_suara_salah.start();
            Toast.makeText(this, "Salah!", Toast.LENGTH_SHORT).show();
        }
    }

    public void tombol_tebak_jawaban_c(View view){
        if (kode == (batas - 1)) {
            Toast.makeText(this, "Selesai", Toast.LENGTH_SHORT).show();
        } else if(DataTebakSuaraList.get(kode).getJawaban_C().equals(DataTebakSuaraList.get(kode).getJawaban())){
            MediaPlayer audio_game_tebak_suara_benar = MediaPlayer.create(this, R.raw.jawaban_benar);
            audio_game_tebak_suara_benar.start();
            Toast.makeText(this, "Benar!", Toast.LENGTH_SHORT).show();
            kode++;
            int jawaban_a = getResources().getIdentifier(DataTebakSuaraList.get(kode).getJawaban_A() , "drawable", getPackageName());
            tebak_suara_jawaban_a.setBackgroundResource(jawaban_a);
            int jawaban_b = getResources().getIdentifier(DataTebakSuaraList.get(kode).getJawaban_B() , "drawable", getPackageName());
            tebak_suara_jawaban_b.setBackgroundResource(jawaban_b);
            int jawaban_c = getResources().getIdentifier(DataTebakSuaraList.get(kode).getJawaban_C() , "drawable", getPackageName());
            tebak_suara_jawaban_c.setBackgroundResource(jawaban_c);
            int jawaban_d = getResources().getIdentifier(DataTebakSuaraList.get(kode).getJawaban_D() , "drawable", getPackageName());
            tebak_suara_jawaban_d.setBackgroundResource(jawaban_d);
        }else{
            MediaPlayer audio_game_tebak_suara_salah = MediaPlayer.create(this, R.raw.jawaban_salah);
            audio_game_tebak_suara_salah.start();
            Toast.makeText(this, "Salah!", Toast.LENGTH_SHORT).show();
        }
    }

    public void tombol_tebak_jawaban_d(View view){
        if (kode == (batas - 1)) {
            Toast.makeText(this, "Selesai", Toast.LENGTH_SHORT).show();
        } else if(DataTebakSuaraList.get(kode).getJawaban_D().equals(DataTebakSuaraList.get(kode).getJawaban())){
            MediaPlayer audio_game_tebak_suara_benar = MediaPlayer.create(this, R.raw.jawaban_benar);
            audio_game_tebak_suara_benar.start();
            Toast.makeText(this, "Benar!", Toast.LENGTH_SHORT).show();
            kode++;
            int jawaban_a = getResources().getIdentifier(DataTebakSuaraList.get(kode).getJawaban_A() , "drawable", getPackageName());
            tebak_suara_jawaban_a.setBackgroundResource(jawaban_a);
            int jawaban_b = getResources().getIdentifier(DataTebakSuaraList.get(kode).getJawaban_B() , "drawable", getPackageName());
            tebak_suara_jawaban_b.setBackgroundResource(jawaban_b);
            int jawaban_c = getResources().getIdentifier(DataTebakSuaraList.get(kode).getJawaban_C() , "drawable", getPackageName());
            tebak_suara_jawaban_c.setBackgroundResource(jawaban_c);
            int jawaban_d = getResources().getIdentifier(DataTebakSuaraList.get(kode).getJawaban_D() , "drawable", getPackageName());
            tebak_suara_jawaban_d.setBackgroundResource(jawaban_d);
        }else{
            MediaPlayer audio_game_tebak_suara_salah = MediaPlayer.create(this, R.raw.jawaban_salah);
            audio_game_tebak_suara_salah.start();
            Toast.makeText(this, "Salah!", Toast.LENGTH_SHORT).show();
        }
    }

}
