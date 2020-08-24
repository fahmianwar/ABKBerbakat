package id.fahmi.abkberbakat;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.List;

public class GameTebakAngkaActivity extends AppCompatActivity {
    List<KosakataClass> KosakataList;
    public int kode;
    public int batas;
    String kunci_jawaban_tebak_gambar;
    TextView jawaban_tebak_gambar, angka_tebak_gambar;
    ImageSwitcher tebak_gambar;
    int hasil_ilustrasi;
    Button tebak_angka_jawaban_a, tebak_angka_jawaban_b, tebak_angka_jawaban_c, tebak_angka_jawaban_d;
    ImageSwitcher tebak_angka_soal;
    String tebak_angka_jawaban;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_tebak_jumlah_objek);

        KosakataList = DatabaseClass.getInstance(getApplicationContext()).getTebakAngkaList();
        tebak_angka_soal = (ImageSwitcher) findViewById(R.id.tebak_angka_soal);
        tebak_angka_jawaban_a = (Button) findViewById(R.id.tebak_angka_jawaban_a);
        tebak_angka_jawaban_b = (Button) findViewById(R.id.tebak_angka_jawaban_b);
        tebak_angka_jawaban_c = (Button) findViewById(R.id.tebak_angka_jawaban_c);
        tebak_angka_jawaban_d = (Button) findViewById(R.id.tebak_angka_jawaban_d);
        kode=0;

        batas = KosakataList.get(kode).getJumlahData();
        tebak_angka_soal.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                // TODO Auto-generated method stub

                // Create a new ImageView and set it's properties
                ImageView imageView = new ImageView(getApplicationContext());
                // set Scale type of ImageView to Fit Center
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                // set the Height And Width of ImageView To FIll PARENT
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
                return imageView;


            }

        });

        // Declare in and out animations and load them using AnimationUtils class
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        tebak_angka_soal.setInAnimation(in);
        tebak_angka_soal.setOutAnimation(out);
        int hasil_ilustrasi = getResources().getIdentifier(KosakataList.get(kode).getSoal(), "drawable", getPackageName());
        tebak_angka_soal.setImageResource(hasil_ilustrasi); // set the image in ImageSwitcher

        tebak_angka_jawaban_a.setText(String.valueOf(KosakataList.get(kode).getJawaban_A()));
        tebak_angka_jawaban_b.setText(String.valueOf(KosakataList.get(kode).getJawaban_B()));
        tebak_angka_jawaban_c.setText(String.valueOf(KosakataList.get(kode).getJawaban_C()));
        tebak_angka_jawaban_d.setText(String.valueOf(KosakataList.get(kode).getJawaban_D()));
        tebak_angka_jawaban = (String.valueOf(KosakataList.get(kode).getJawaban()));


    }

    public void tombol_tebak_angka_jawaban_a(View view) {
        if (kode == (batas - 1)) {
            Toast.makeText(this, "Selesai", Toast.LENGTH_SHORT).show();

        } else if (tebak_angka_jawaban_a.getText().toString().equals(String.valueOf(KosakataList.get(kode).getJawaban()))) {
            kode++;
            //angka_tebak_gambar.setText(String.valueOf(kode));
            int hasil_ilustrasi = getResources().getIdentifier(KosakataList.get(1).getSoal(), "drawable", getPackageName());
            tebak_angka_soal.setImageResource(hasil_ilustrasi); // set the image in ImageSwitcher
            MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.jawaban_benar);
            mPlayer.start();
            Toast.makeText(this, "Jawaban Anda Benar!", Toast.LENGTH_SHORT).show();
        } else {
            MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.jawaban_salah);
            mPlayer.start();
            Toast.makeText(this, "Jawaban Anda Salah", Toast.LENGTH_SHORT).show();

        }
    }
}
