package id.fahmi.abkberbakat;

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

import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.lang.Math;

public class BermainActivity extends AppCompatActivity {
    private ImageSwitcher gambar_kuis;
    Button tombol_cek;
    TextView kotak_nama;

    // Array anu lebeut na aya nami gambar_kuis sareung file gambar_kuisna dina ImageSwitcher
    int[] array_gambar_kuis = {R.drawable.alpukat, R.drawable.anggur, R.drawable.angsa, R.drawable.anjing};
    String[] array_nama_kuis_dari_sqlite = {"Alpukat", "Anggur", "Angsa", "Anjing"};
    String[] array_nama_kuis = array_nama_kuis_dari_sqlite;
    int count = array_gambar_kuis.length;
    // kangge masihan nilai kangge ImageSwitcher
    int currentIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bermain);


        // get The references of Button and ImageSwitcher
        tombol_cek = (Button) findViewById(R.id.tombol_cek);
        kotak_nama = (TextView) findViewById(R.id.kotak_nama);
        gambar_kuis = (ImageSwitcher) findViewById(R.id.gambar_kuis);
        // Set the ViewFactory of the ImageSwitcher that will create ImageView object when asked
        gambar_kuis.setFactory(new ViewSwitcher.ViewFactory() {

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

        // set the animation type to ImageSwitcher
        gambar_kuis.setInAnimation(in);
        gambar_kuis.setOutAnimation(out);


        // ClickListener for NEXT button
        // When clicked on Button ImageSwitcher will switch between Images
        // The current Image will go OUT and next Image  will come in with specified animation
        currentIndex = 0;
        gambar_kuis.setImageResource(array_gambar_kuis[0]);

    }

    public void tombol_cek(View view) {

        if(array_nama_kuis[currentIndex].toLowerCase().equals(kotak_nama.getText().toString().toLowerCase())){
            Toast.makeText(BermainActivity.this, "Benar", Toast.LENGTH_SHORT).show();
            currentIndex++;
            gambar_kuis.setImageResource(array_gambar_kuis[currentIndex]);
            kotak_nama.setText("");
        } else {
            Toast.makeText(BermainActivity.this, "Salah, Bukan " + kotak_nama.getText().toString() + " jawabannya", Toast.LENGTH_SHORT).show();
            //Toast.makeText(BermainActivity.this, "Anda Pembuat aplikasi, silakan lanjutkan", Toast.LENGTH_SHORT).show();
            //currentIndex++;
            gambar_kuis.setImageResource(array_gambar_kuis[currentIndex]);
            kotak_nama.setText("");
        }


    }

}
