package id.fahmi.abkberbakat;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.List;

public class CobaActivity extends AppCompatActivity {
    List<KosakataClass> KosakataList;
    TextView tw;
    public int kode;
    public int batas;
    TextView angka;
    ImageSwitcher gambarna;
    int hasil_ilustrasi;
    String kategori;
    String id_kosakata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coba);

        Intent intent = getIntent();
        kategori = intent.getStringExtra("kategori");

        kode=0;
        KosakataList = DatabaseClass.getInstance(getApplicationContext()).getAllKosakataList(kategori);
        tw = (TextView)findViewById(R.id.tw);
        angka = (TextView)findViewById(R.id.angka);
        angka.setText(String.valueOf(kode));
        batas = KosakataList.get(kode).getJumlahData();
        //tw.setText(String.valueOf(KosakataList.get(kode).getId()+" - "+KosakataList.get(kode).getKosakata().toUpperCase()+" - "+KosakataList.get(kode).getIlustrasi()+" - "+KosakataList.get(kode).getJumlahData()));
        // Gambarna teh dipailih dieu
        gambarna = (ImageSwitcher) findViewById(R.id.gambarna);
        // Set the ViewFactory of the ImageSwitcher that will create ImageView object when asked
        gambarna.setFactory(new ViewSwitcher.ViewFactory() {

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
        gambarna.setInAnimation(in);
        gambarna.setOutAnimation(out);
        tw.setAnimation(in);
        tw.setAnimation(out);
        int hasil_ilustrasi = getResources().getIdentifier(KosakataList.get(kode).getIlustrasi() , "drawable", getPackageName());
        gambarna.setImageResource(hasil_ilustrasi); // set the image in ImageSwitcher
        tw.setText(String.valueOf(KosakataList.get(kode).getKosakata().toUpperCase()));

    }
    public void tombol_back(View view) {
        if(kode==0){
            Toast.makeText(this, "Tidak bisa mundur", Toast.LENGTH_SHORT).show();
        } else {
            kode--;
            angka.setText(String.valueOf(kode));
            int hasil_ilustrasi = getResources().getIdentifier(KosakataList.get(kode).getIlustrasi() , "drawable", getPackageName());
            gambarna.setImageResource(hasil_ilustrasi); // set the image in ImageSwitcher
            tw.setText(String.valueOf(KosakataList.get(kode).getKosakata().toUpperCase()));
        }
    }
    public void tombol_next(View view) {
        if(kode==(batas-1)){
            Toast.makeText(this, "Tidak bisa maju", Toast.LENGTH_SHORT).show();
        } else {
            kode++;
            angka.setText(String.valueOf(kode));
            int hasil_ilustrasi = getResources().getIdentifier(KosakataList.get(kode).getIlustrasi() , "drawable", getPackageName());
            gambarna.setImageResource(hasil_ilustrasi); // set the image in ImageSwitcher
            tw.setText(String.valueOf(KosakataList.get(kode).getKosakata().toUpperCase()));
        }
    }
    public void tombol_audio(View view){
        int hasil_audio_kosakata = getResources().getIdentifier(KosakataList.get(kode).getAudioKosakata() , "raw", getPackageName());
        MediaPlayer audio_kosakata = MediaPlayer.create(this, hasil_audio_kosakata);
        if(audio_kosakata.isPlaying()){
            audio_kosakata.stop();
        } else {
            audio_kosakata.start();
        }
    }

    public void tombol_selengkapnya(View view){
        Intent intent_tombol_selengkapnya = new Intent(this, KeteraanganKosakataActivity.class);
        id_kosakata = KosakataList.get(kode).getKosakata();
        intent_tombol_selengkapnya.putExtra("id_kosakata", id_kosakata);
        startActivity(intent_tombol_selengkapnya);
    }
}
