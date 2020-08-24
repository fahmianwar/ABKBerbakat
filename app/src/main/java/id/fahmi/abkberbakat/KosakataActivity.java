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

import org.w3c.dom.Text;

import java.util.List;

public class KosakataActivity extends AppCompatActivity {
    List<KosakataClass> KosakataList;
    TextView imbuhan_awal, imbuhan_akhir, kata_dasar, angka_kosakata, kosakata, tambah_awal, tambah_akhir;
    public int kode_kosakata;
    public int batas;
    String kategori = "kata_kerja";
    ImageSwitcher gambar_kosakata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kosakata);

        kode_kosakata=0;
        KosakataList = DatabaseClass.getInstance(getApplicationContext()).getAllKosakataList(kategori);
        imbuhan_awal = (TextView)findViewById(R.id.imbuhan_awal);
        imbuhan_akhir = (TextView)findViewById(R.id.imbuhan_akhir);
        kata_dasar = (TextView)findViewById(R.id.kata_dasar);
        kosakata = (TextView)findViewById(R.id.kosakata);
        angka_kosakata = (TextView)findViewById(R.id.angka_kosakata);
        tambah_awal = (TextView)findViewById(R.id.tambah_awal);
        tambah_akhir = (TextView)findViewById(R.id.tambah_akhir);
        batas = KosakataList.get(kode_kosakata).getJumlahData();
        angka_kosakata.setText(String.valueOf(kode_kosakata));
        if(String.valueOf(KosakataList.get(kode_kosakata).getImbuhanAwal().toUpperCase()).equals("KOSONG")){
            imbuhan_awal.setText("");
            tambah_awal.setText("");
        } else {
            imbuhan_awal.setText(String.valueOf(KosakataList.get(kode_kosakata).getImbuhanAwal().toUpperCase()));
            tambah_awal.setText("+");

        }
        if(String.valueOf(KosakataList.get(kode_kosakata).getImbuhanAkhir().toUpperCase()).equals("KOSONG")){
            imbuhan_akhir.setText("");
            tambah_akhir.setText("");
        } else {
            imbuhan_akhir.setText(String.valueOf(KosakataList.get(kode_kosakata).getImbuhanAkhir().toUpperCase()));
            tambah_akhir.setText("+");
        }
        kosakata.setText(String.valueOf(KosakataList.get(kode_kosakata).getKosakata().toUpperCase()));
        //imbuhan_awal.setText(String.valueOf(KosakataList.get(kode_kosakata).getImbuhanAwal().toUpperCase()));
        //imbuhan_akhir.setText(String.valueOf(KosakataList.get(kode_kosakata).getImbuhanAkhir().toUpperCase()));
        kata_dasar.setText(String.valueOf(KosakataList.get(kode_kosakata).getKataDasar().toUpperCase()));
        gambar_kosakata = (ImageSwitcher) findViewById(R.id.gambar_kosakata);

        gambar_kosakata.setFactory(new ViewSwitcher.ViewFactory() {

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
        gambar_kosakata.setInAnimation(in);
        gambar_kosakata.setOutAnimation(out);
        int hasil_ilustrasi = getResources().getIdentifier(KosakataList.get(kode_kosakata).getIlustrasi() , "drawable", getPackageName());
        gambar_kosakata.setImageResource(hasil_ilustrasi); // set the image in ImageSwitcher

    }
    public void tombol_back_kosakata(View view) {
        if(kode_kosakata==0){
            Toast.makeText(this, "Tidak bisa mundur", Toast.LENGTH_SHORT).show();
        } else {
            kode_kosakata--;
            angka_kosakata.setText(String.valueOf(kode_kosakata));
            //kosakata.setText(String.valueOf(KosakataList.get(kode_kosakata).getKosakata().toUpperCase()));
            if(String.valueOf(KosakataList.get(kode_kosakata).getImbuhanAwal().toUpperCase()).equals("KOSONG")){
                imbuhan_awal.setText("");
                tambah_awal.setText("");
            } else {
                imbuhan_awal.setText(String.valueOf(KosakataList.get(kode_kosakata).getImbuhanAwal().toUpperCase()));
                tambah_awal.setText("+");

            }
            if(String.valueOf(KosakataList.get(kode_kosakata).getImbuhanAkhir().toUpperCase()).equals("KOSONG")){
                imbuhan_akhir.setText("");
                tambah_akhir.setText("");
            } else {
                imbuhan_akhir.setText(String.valueOf(KosakataList.get(kode_kosakata).getImbuhanAkhir().toUpperCase()));
                tambah_akhir.setText("+");
            }
            int hasil_ilustrasi = getResources().getIdentifier(KosakataList.get(kode_kosakata).getIlustrasi() , "drawable", getPackageName());
            gambar_kosakata.setImageResource(hasil_ilustrasi); // set the image in ImageSwitcher
            kosakata.setText(String.valueOf(KosakataList.get(kode_kosakata).getKosakata().toUpperCase()));
            //imbuhan_awal.setText(String.valueOf(KosakataList.get(kode_kosakata).getImbuhanAwal().toUpperCase()));
            //imbuhan_akhir.setText(String.valueOf(KosakataList.get(kode_kosakata).getImbuhanAkhir().toUpperCase()));
            kata_dasar.setText(String.valueOf(KosakataList.get(kode_kosakata).getKataDasar().toUpperCase()));
        }
    }

    public void tombol_audio_kosakata(View view){
        int hasil_audio_kosakata = getResources().getIdentifier(KosakataList.get(kode_kosakata).getAudioKosakata() , "raw", getPackageName());
        MediaPlayer audio_kosakata = MediaPlayer.create(this, hasil_audio_kosakata);
        if(audio_kosakata.isPlaying()){
            audio_kosakata.stop();
        } else {
            audio_kosakata.start();
        }
    }
    public void tombol_next_kosakata(View view) {
        if(kode_kosakata==(batas-1)){
            Toast.makeText(this, "Tidak bisa maju", Toast.LENGTH_SHORT).show();
        } else {
            kode_kosakata++;
            angka_kosakata.setText(String.valueOf(kode_kosakata));
            if(String.valueOf(KosakataList.get(kode_kosakata).getImbuhanAwal().toUpperCase()).equals("KOSONG")){
                imbuhan_awal.setText("");
                tambah_awal.setText("");
            } else {
                imbuhan_awal.setText(String.valueOf(KosakataList.get(kode_kosakata).getImbuhanAwal().toUpperCase()));
                tambah_awal.setText("+");

            }
            if(String.valueOf(KosakataList.get(kode_kosakata).getImbuhanAkhir().toUpperCase()).equals("KOSONG")){
                imbuhan_akhir.setText("");
                tambah_akhir.setText("");
            } else {
                imbuhan_akhir.setText(String.valueOf(KosakataList.get(kode_kosakata).getImbuhanAkhir().toUpperCase()));
                tambah_akhir.setText("+");
            }
            int hasil_ilustrasi = getResources().getIdentifier(KosakataList.get(kode_kosakata).getIlustrasi() , "drawable", getPackageName());
            gambar_kosakata.setImageResource(hasil_ilustrasi); // set the image in ImageSwitcher
            kosakata.setText(String.valueOf(KosakataList.get(kode_kosakata).getKosakata().toUpperCase()));
            //imbuhan_awal.setText(String.valueOf(KosakataList.get(kode_kosakata).getImbuhanAwal().toUpperCase()));
            //imbuhan_akhir.setText(String.valueOf(KosakataList.get(kode_kosakata).getImbuhanAkhir().toUpperCase()));
            kata_dasar.setText(String.valueOf(KosakataList.get(kode_kosakata).getKataDasar().toUpperCase()));
        }
    }

}
