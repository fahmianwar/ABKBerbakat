package id.fahmi.abkberbakat;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import java.util.Random;

public class KataBendaSayuranActivity extends AppCompatActivity {

    List<KosakataClass> KosakataList;
    TextView tw;
    protected Cursor cursor;
    Database dbhelper;
    public static KataBendaSayuranActivity ba;


    private ImageSwitcher gambar;
    Button btnNext, btnPrev;
    TextView textKata;

    // Array anu lebeut na aya nami gambar sareung file gambarna dina ImageSwitcher
    //int[] array_gambar = {R.drawable.alpukat, R.drawable.anggur, R.drawable.angsa, R.drawable.anjing};
    int[] array_gambar = new int[1000];
    //String[] array_nama = {"Alpukat", "Anggur", "Angsa", "Anjing"};
    String[] array_nama = new String[1000];
    int count;
    // kangge masihan nilai kangge ImageSwitcher
    int currentIndex = 0;
    int[] banyak = new int[1000];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belajar);

        //KosakataList = DatabaseClass.getInstance(getApplicationContext()).getAllKosakataList();
        tw = (TextView)findViewById(R.id.tw);
        tw.setText(String.valueOf(KosakataList.get(0).getId()+" - "+KosakataList.get(0).getKosakata()+" - "+KosakataList.get(0).getIlustrasi()+" - "+KosakataList.get(0).getJumlahData()));

        // get The references of Button and ImageSwitcher
        btnNext = (Button) findViewById(R.id.tombol_maju);
        btnPrev = (Button) findViewById(R.id.tombol_mundur);
        textKata = (TextView) findViewById(R.id.nama_objek);
        gambar = (ImageSwitcher) findViewById(R.id.gambar);
        // Set the ViewFactory of the ImageSwitcher that will create ImageView object when asked
        gambar.setFactory(new ViewSwitcher.ViewFactory() {

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

        ba = this;
        dbhelper = new Database(this);
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

        /*
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            array_nama[0] = cursor.getString(0).toString();
            array_nama[1] = cursor.getString(1).toString();
            array_nama[2] = cursor.getString(2).toString();
            array_nama[3] = cursor.getString(3).toString();

        }
        */

        // set the animation type to ImageSwitcher
        gambar.setInAnimation(in);
        gambar.setOutAnimation(out);
        textKata.setAnimation(in);
        textKata.setAnimation(out);

        // ClickListener for NEXT button
        // When clicked on Button ImageSwitcher will switch between Images
        // The current Image will go OUT and next Image  will come in with specified animation
        gambar.setImageResource(array_gambar[0]); // set the image in ImageSwitcher
        textKata.setText(array_nama[0].toUpperCase());

        for(int i = 0; i < count; i++) {
            banyak[i] = i;
        }

        for(int i = 0; i < count; i++) {
            int sementara_acak = banyak[i];
            int r = new Random().nextInt(i + count);
            banyak[i] = banyak[r];
            banyak[r] = sementara_acak;
        }


    }

    public void tombol_maju(View v) {
        // TODO Auto-generated method stub

        //  Check If index reaches maximum then reset it
        if (currentIndex == count) {
            Toast.makeText(KataBendaSayuranActivity.this, "Maaaf anda tidak bisa melanjutkan", Toast.LENGTH_SHORT).show();
        } else {
            currentIndex++;
        }

        if ((currentIndex >= -1) && (currentIndex < count)){
            textKata.setText(array_nama[banyak[currentIndex]].toUpperCase());
            gambar.setImageResource(array_gambar[banyak[currentIndex]]); // set the image in ImageSwitcher
        }

    }

    public void tombol_mundur(View v) {
        if (currentIndex == 0) {
            currentIndex = 0;
            Toast.makeText(KataBendaSayuranActivity.this, "Maaaf anda tidak bisa kembali", Toast.LENGTH_SHORT).show();
        } else {
            currentIndex -= 1;
            textKata.setText(array_nama[banyak[currentIndex]].toUpperCase());
            gambar.setImageResource(array_gambar[banyak[currentIndex]]);
        }

    }

}