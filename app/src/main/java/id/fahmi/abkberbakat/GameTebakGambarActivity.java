package id.fahmi.abkberbakat;

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
import java.util.Random;

public class GameTebakGambarActivity extends AppCompatActivity {
    List<KosakataClass> KosakataList;
    public int kode;
    public int batas;
    String kunci_jawaban_tebak_gambar;
    TextView jawaban_tebak_gambar, angka_tebak_gambar;
    ImageSwitcher tebak_gambar;
    int hasil_ilustrasi;
    String kategori;
    String[] array_kategori = {"sayuran", "pohon", "tempat", "hewan", "kendaraan", "bunga", "buah", "anggota_tubuh", "perabotan", "profesi", "kata_kerja", "bendera", "huruf", "angka"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_tebak_gambar);
        Random random = new Random();
        kategori = array_kategori[random.nextInt(12)];
        kode=0;
        KosakataList = DatabaseClass.getInstance(getApplicationContext()).getAllKosakataList(kategori);
        jawaban_tebak_gambar = (TextView)findViewById(R.id.jawaban_tebak_gambar);
        angka_tebak_gambar = (TextView)findViewById(R.id.angka_tebak_gambar);

        angka_tebak_gambar.setText(String.valueOf(kode));
        batas = KosakataList.get(kode).getJumlahData();

        //tw.setText(String.valueOf(KosakataList.get(kode).getId()+" - "+KosakataList.get(kode).getKosakata().toUpperCase()+" - "+KosakataList.get(kode).getIlustrasi()+" - "+KosakataList.get(kode).getJumlahData()));
        // Gambarna teh dipailih dieu
        tebak_gambar = (ImageSwitcher) findViewById(R.id.tebak_gambar);
        // Set the ViewFactory of the ImageSwitcher that will create ImageView object when asked
        tebak_gambar.setFactory(new ViewSwitcher.ViewFactory() {

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
        tebak_gambar.setInAnimation(in);
        tebak_gambar.setOutAnimation(out);
        int hasil_ilustrasi = getResources().getIdentifier(KosakataList.get(kode).getIlustrasi() , "drawable", getPackageName());
        tebak_gambar.setImageResource(hasil_ilustrasi); // set the image in ImageSwitcher
        kunci_jawaban_tebak_gambar = (String.valueOf(KosakataList.get(kode).getKosakata().toUpperCase()));

    }

    public void tombol_cek_tebak_gambar(View view){
        if(kode==(batas-1)){
            Toast.makeText(this, "Selesai", Toast.LENGTH_SHORT).show();

        } else {
            if(jawaban_tebak_gambar.getText()==""){
                MediaPlayer audio_game_tebak_angka_salah = MediaPlayer.create(this, R.raw.jawaban_salah);
                audio_game_tebak_angka_salah.start();
                Toast.makeText(this, "Isi jawaban terlebih dahulu!", Toast.LENGTH_SHORT).show();
            }else{

                if(jawaban_tebak_gambar.getText().toString().toLowerCase().equals(String.valueOf(KosakataList.get(kode).getKosakata().toUpperCase()).toLowerCase())){
                    kode++;
                    angka_tebak_gambar.setText(String.valueOf(kode));
                    int hasil_ilustrasi = getResources().getIdentifier(KosakataList.get(kode).getIlustrasi() , "drawable", getPackageName());
                    tebak_gambar.setImageResource(hasil_ilustrasi); // set the image in ImageSwitcher
                    jawaban_tebak_gambar.setText("");
                    MediaPlayer audio_game_tebak_angka_benar = MediaPlayer.create(this, R.raw.jawaban_benar);
                    audio_game_tebak_angka_benar.start();
                    Toast.makeText(this, "Jawaban Anda Benar!", Toast.LENGTH_SHORT).show();
                }else {
                    MediaPlayer audio_game_tebak_angka_salah = MediaPlayer.create(this, R.raw.jawaban_salah);
                    audio_game_tebak_angka_salah.start();
                    Toast.makeText(this, "Jawaban Anda Salah", Toast.LENGTH_SHORT).show();

                }
            }
        }
    }
}
