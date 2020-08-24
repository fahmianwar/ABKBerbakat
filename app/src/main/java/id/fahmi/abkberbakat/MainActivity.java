package id.fahmi.abkberbakat;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Switch saklar_audio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saklar_audio = (Switch)findViewById(R.id.saklar_audio);
        final Intent perintahNyalaAudioBackground = new Intent(this, AudioBackground.class);
        perintahNyalaAudioBackground.addFlags(Intent.FLAG_FROM_BACKGROUND);
        final Intent perintahMatiAudioBackground = new Intent(this, AudioBackground.class);
        perintahMatiAudioBackground.addFlags(Intent.FLAG_FROM_BACKGROUND);
        saklar_audio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    startService(new Intent(perintahNyalaAudioBackground));
                }else{
                    stopService(new Intent(perintahMatiAudioBackground));

                }
            }
        });
        if(saklar_audio.isChecked()){
            startService(new Intent(perintahNyalaAudioBackground));
        }

        /*
        if(audio_status==0){
            startService(new Intent(this, AudioBackground.class));
            audio_status=1;
            tombol_audiobg_mati.setEnabled(true);
            tombol_audiobg_nyala.setEnabled(false);

        }
        */


        //tombol_audiobg_nyala.setEnabled(false);



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        final Intent perintahMatiAudioBackground = new Intent(this, AudioBackground.class);
        perintahMatiAudioBackground.addFlags(Intent.FLAG_FROM_BACKGROUND);
        stopService(new Intent(perintahMatiAudioBackground));
    }
    /*
    protected void onStop() {
        super.onStop();
        final Intent perintahMatiAudioBackground = new Intent(this, AudioBackground.class);
        perintahMatiAudioBackground.addFlags(Intent.FLAG_FROM_BACKGROUND);
        stopService(new Intent(perintahMatiAudioBackground));
    }
    protected void onResume() {
        super.onResume();
        final Intent perintahNyalaAudioBackground = new Intent(this, AudioBackground.class);
        perintahNyalaAudioBackground.addFlags(Intent.FLAG_FROM_BACKGROUND);
        startService(new Intent(perintahNyalaAudioBackground));
    }
    public void onBackPressed() {
        super.onBackPressed();
        final Intent perintahMatiAudioBackground = new Intent(this, AudioBackground.class);
        perintahMatiAudioBackground.addFlags(Intent.FLAG_FROM_BACKGROUND);
        stopService(new Intent(perintahMatiAudioBackground));
    }

    protected void onPause() {
        super.onPause();
        final Intent perintahMatiAudioBackground = new Intent(this, AudioBackground.class);
        perintahMatiAudioBackground.addFlags(Intent.FLAG_FROM_BACKGROUND);
        stopService(new Intent(perintahMatiAudioBackground));
    }
    */

    /** Tombol Mulai ke KataBendaSayuranActivity */
    public void tombol_belajar(View view) {
        Intent intent_tombol_belajar = new Intent(this, KategoriBelajarActivity.class);
        startActivity(intent_tombol_belajar);
    }

    public void tombol_bermain(View view) {
        Intent intent_tombol_bermain = new Intent(this, KategoriBermainActivity.class);
        startActivity(intent_tombol_bermain);
    }

    public void tombol_pengaturan(View view) {
        //Intent intent_tombol_pengaturan = new Intent(this, GameAritmatikaActivity.class);
        //startActivity(intent_tombol_pengaturan);
        Toast.makeText(this, "Duh wayahna can aya", Toast.LENGTH_SHORT).show();

    }

    public void tombol_ristekdikti(View view) {
        Toast.makeText(this, "Didukung oleh Kementrian Ristekdikti", Toast.LENGTH_SHORT).show();
    }

    public void tombol_unsil(View view) {
        Toast.makeText(this, "Didukung oleh Universitas Siliwangi", Toast.LENGTH_SHORT).show();
    }
    public void tombol_panduan(View view) {
        String test = "Fahmi";
        char[] chars = test.toCharArray();
        Toast.makeText(this, String.valueOf(chars[0]), Toast.LENGTH_SHORT).show();
    }
    public void tombol_coba(View view) {
        Intent intent_tombol_coba = new Intent(this, CobaActivity.class);
        startActivity(intent_tombol_coba);
    }

    public void tombol_tentang(View view) {
        Intent intent_tombol_tentang = new Intent(this, TentangActivity.class);
        startActivity(intent_tombol_tentang);
    }
}
