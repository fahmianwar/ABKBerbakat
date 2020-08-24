package id.fahmi.abkberbakat;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.media.Image;
import android.provider.BaseColumns;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
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

import java.util.Arrays;
import java.util.Random;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MiniGame2Activity extends AppCompatActivity {


    protected Cursor cursor;
    DataHelper dbhelper;
    public static MiniGame2Activity mg2;

    int array_gambar[] = new int[1000];
    //int[] array_gambar = {R.drawable.alpukat, R.drawable.anggur, R.drawable.angsa, R.drawable.anjing};
    //String[] array_nama = {"Alpukat", "Anggur", "Angsa", "Anjing"};
    String array_nama[] = new String[1000];
    int count;
    int panjang_data_array_gambar = array_gambar.length;
    Button Tombol_A, Tombol_B, Tombol_C, Tombol_D, Tombol_E, Tombol_F, Tombol_G, Tombol_H, Tombol_I, Tombol_J, Tombol_K, Tombol_L, Tombol_M, Tombol_N, Tombol_O, Tombol_P;
    TextView Kotak_Jawaban_MiniGame2;
    private ImageSwitcher Gambar_MiniGame2;
    int idx = new Random().nextInt(array_nama.length);
    String random = (array_nama[idx]);
    int objectLength = 16;
    Button buttons[] = new Button[objectLength];
    int banyak[] = new int[objectLength];
    Random rand = new Random();
    int i, r, sementara_acak;
    char array_karakter_nama_objek[] = new char[objectLength];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mini_game2);
        buttons[0] = (Button)findViewById(R.id.Tombol_A);
        buttons[1] = (Button)findViewById(R.id.Tombol_B);
        buttons[2] = (Button)findViewById(R.id.Tombol_C);
        buttons[3] = (Button)findViewById(R.id.Tombol_D);
        buttons[4] = (Button)findViewById(R.id.Tombol_E);
        buttons[5] = (Button)findViewById(R.id.Tombol_F);
        buttons[6] = (Button)findViewById(R.id.Tombol_G);
        buttons[7] = (Button)findViewById(R.id.Tombol_H);
        buttons[8] = (Button)findViewById(R.id.Tombol_I);
        buttons[9] = (Button)findViewById(R.id.Tombol_J);
        buttons[10] = (Button)findViewById(R.id.Tombol_K);
        buttons[11] = (Button)findViewById(R.id.Tombol_L);
        buttons[12] = (Button)findViewById(R.id.Tombol_M);
        buttons[13] = (Button)findViewById(R.id.Tombol_N);
        buttons[14] = (Button)findViewById(R.id.Tombol_O);
        buttons[15] = (Button)findViewById(R.id.Tombol_P);
        Gambar_MiniGame2 = (ImageSwitcher)findViewById(R.id.Gambar_MiniGame2);
        Kotak_Jawaban_MiniGame2 = (TextView)findViewById(R.id.Kotak_Jawaban_MiniGame2);

        for(int i = 0; i < objectLength; i++) {
            buttons[i].setText("#");
        }

        Gambar_MiniGame2.setFactory(new ViewSwitcher.ViewFactory() {

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

        mg2 = this;
        dbhelper = new DataHelper(this);
        SQLiteDatabase db = dbhelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM kosakata WHERE kategori='kata benda sayur-sayuran'",null);
        cursor.moveToFirst();
        //String[] array = new String[cursor.getCount()];
        //count = cursor.getCount();
        count =0;
        while(cursor.moveToNext()){
            String kosakata = cursor.getString(cursor.getColumnIndex("kosakata"));
            String ilustrasi = cursor.getString(cursor.getColumnIndex("ilustrasi"));
            int hasil_ilustrasi = getResources().getIdentifier(ilustrasi , "drawable", getPackageName());
            array_nama[count] = kosakata;
            array_gambar[count] = hasil_ilustrasi;
            count++;
        }

        for(i = 0; i < objectLength; i++) {
            banyak[i] = i;
        }

        for(i = 0; i < objectLength; i++) {
            sementara_acak = banyak[i];
            r = (objectLength - 2);
            banyak[i] = banyak[r];
            banyak[r] = sementara_acak;
        }



        // set the animation type to ImageSwitcher
        Gambar_MiniGame2.setInAnimation(in);
        Gambar_MiniGame2.setOutAnimation(out);
        Gambar_MiniGame2.setImageResource(array_gambar[banyak[0]]);
        array_karakter_nama_objek = array_nama[0].toCharArray();
        //array_karakter_nama_objek = array_nama[i].toCharArray();

        for(i = 0; i < objectLength; i++) {
            buttons[i].setText(array_nama[i]);
        }
        //for (int i = array_nama.length - 1; i > 0; i++){
            //acan aya nanaon;

        //}

    }
    public void memilih_jawaban(View view){
        Toast.makeText(this, "Lamun di klik muncul ieu nya :)", Toast.LENGTH_SHORT).show();
        Kotak_Jawaban_MiniGame2.setText(array_nama[banyak[0]]);
    }
}
