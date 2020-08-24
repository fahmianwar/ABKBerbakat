package id.fahmi.abkberbakat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.ViewSwitcher;


import java.util.List;

public class KeteraanganKosakataActivity extends AppCompatActivity {
    List<KosakataClass> DataKosakataList;
    String id_kosakata;
    ImageSwitcher gambar_data_objek;
    int ilustrasi_data_objek;
    TextView nama_data_objek, keterangan_data_objek, sumber_keterangan_data_objek, sumber_ilustrasi_data_objek, nama_latin_data_objek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keteraangan_kosakata);

        Intent intent = getIntent();
        id_kosakata = intent.getStringExtra("id_kosakata");
        DataKosakataList = DatabaseClass.getInstance(getApplicationContext()).getDataKosakataList(id_kosakata);
        nama_data_objek = (TextView)findViewById(R.id.nama_data_objek);
        keterangan_data_objek = (TextView)findViewById(R.id.keterangan_data_objek);
        sumber_keterangan_data_objek = (TextView)findViewById(R.id.sumber_keterangan_data_objek);
        sumber_ilustrasi_data_objek = (TextView)findViewById(R.id.sumber_ilustrasi_data_objek);
        nama_latin_data_objek = (TextView)findViewById(R.id.nama_latin_data_objek);
        gambar_data_objek = (ImageSwitcher)findViewById(R.id.gambar_data_objek);
        nama_data_objek.setText(DataKosakataList.get(0).getKosakata().toUpperCase());
        keterangan_data_objek.setText(DataKosakataList.get(0).getKeterangan());
        sumber_keterangan_data_objek.setText(DataKosakataList.get(0).getSumberKeterangan().toLowerCase());
        sumber_ilustrasi_data_objek.setText(DataKosakataList.get(0).getSumberIlustasi().toLowerCase());
        if(DataKosakataList.get(0).getNamalatin().equals("kosong")){
            nama_latin_data_objek.setText("");
        } else {
            nama_latin_data_objek.setText(DataKosakataList.get(0).getNamalatin());
        }

        gambar_data_objek.setFactory(new ViewSwitcher.ViewFactory() {

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
        gambar_data_objek.setInAnimation(in);
        gambar_data_objek.setOutAnimation(out);

        ilustrasi_data_objek = getResources().getIdentifier(DataKosakataList.get(0).getIlustrasi(),"drawable", getPackageName());
        gambar_data_objek.setImageResource(ilustrasi_data_objek);
    }
}
