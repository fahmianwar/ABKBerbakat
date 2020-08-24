package id.fahmi.abkberbakat;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameAritmatikaActivity extends AppCompatActivity {
    TextView aritmetika_angka_1, aritmetika_angka_2;
    Button tombol_cek_aritmetika;
    TextView aritmetika_jawaban, aritmetika_operator;
    Random random = new Random();
    String[] operator = {"x", "/", "+", "-"};
    int acak1, acak2,acak3, hasil, banding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_aritmatika);
        aritmetika_angka_1 = (TextView)findViewById(R.id.aritmetika_angka_1);
        aritmetika_angka_2 = (TextView)findViewById(R.id.aritmetika_angka_2);
        aritmetika_operator = (TextView)findViewById(R.id.aritmetika_operator);
        aritmetika_jawaban = (TextView)findViewById(R.id.aritmetika_jawaban);
        tombol_cek_aritmetika = (Button)findViewById(R.id.tombol_cek_aritmetika);
        acak1 = random.nextInt(5)*2;
        if(acak1==0){
            acak1=2;
        }
        aritmetika_angka_1.setText(String.valueOf(acak1));
        acak2 = random.nextInt(5)*2;
        if(acak2==0){
            acak2=2;
        }
        aritmetika_angka_2.setText(String.valueOf(acak2));
        acak3 = random.nextInt(3);
        aritmetika_operator.setText(operator[acak3]);
        if(operator[acak3].equals("x")){
            hasil = (acak1 * acak2);
        }
        if(operator[acak3].equals("/")){
            if(acak1>acak2){
                hasil = (acak1 / acak2);

            } else {
                hasil = (acak2 / acak1);
                aritmetika_angka_2.setText(String.valueOf(acak1));
                aritmetika_angka_1.setText(String.valueOf(acak2));

            }

        }
        if(operator[acak3].equals("+")){
            hasil = (acak1 + acak2);
        }
        if(operator[acak3].equals("-")){
            hasil = (acak1 - acak2);
        }
        //hasil = ((acak1 )+(acak3)+(acak2));
    }

    public void tombol_cek_aritmetika(View view){
        //banding = aritmetika_jawaban.getText();
        if(aritmetika_jawaban.getText().toString().equals(String.valueOf(hasil))){
            MediaPlayer audio_game_aritmatika_benar = MediaPlayer.create(this, R.raw.jawaban_benar);
            audio_game_aritmatika_benar.start();
            Toast.makeText(this, "Benar", Toast.LENGTH_SHORT).show();
            aritmetika_jawaban.setText("");
            acak1 = random.nextInt(5)*2;
            if(acak1==0){
                acak1=2;
            }
            aritmetika_angka_1.setText(String.valueOf(acak1));
            acak2 = random.nextInt(5)*2;
            if(acak2==0){
                acak2=2;
            }
            aritmetika_angka_2.setText(String.valueOf(acak2));
            acak3 = random.nextInt(3);
            aritmetika_operator.setText(operator[acak3]);
            if(operator[acak3].equals("x")){
                hasil = (acak1 * acak2);
            }
            if(operator[acak3].equals("/")){
                if(acak1>acak2){
                    hasil = (acak1 / acak2);

                } else {
                    hasil = (acak2 / acak1);
                    aritmetika_angka_2.setText(String.valueOf(acak1));
                    aritmetika_angka_1.setText(String.valueOf(acak2));

                }
            }
            if(operator[acak3].equals("+")){
                hasil = (acak1 + acak2);
            }
            if(operator[acak3].equals("-")){
                hasil = (acak1 - acak2);
            }
        } else {
            MediaPlayer audio_game_aritmatika_salah = MediaPlayer.create(this, R.raw.jawaban_salah);
            audio_game_aritmatika_salah.start();
            Toast.makeText(this, "Salah seharusnya : "+hasil, Toast.LENGTH_SHORT).show();
        }
    }
}
