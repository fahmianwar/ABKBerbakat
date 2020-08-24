package id.fahmi.abkberbakat;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fahmi on 25/05/2017.
 */

class DatabaseClass {

    private static DatabaseClass INSTANCE;
    private static Context context;

    private static SQLiteDatabase database;
    private static DBHelper dbhelper;

    public DatabaseClass() {
        dbhelper = new DBHelper(context);
    }

    public static DatabaseClass getInstance(Context context) {
        DatabaseClass.context = context;

        if(INSTANCE == null){
            INSTANCE = new DatabaseClass();
        }
        return INSTANCE;
    }

    public List<KosakataClass> getAllKosakataList(String nama_kategori) {
        List<KosakataClass> KosakataList = new ArrayList<KosakataClass>();

        openDB();
        String sql = "SELECT * FROM kosakata WHERE kategori ='"+nama_kategori+"'";

        KosakataClass kosakata;

        Cursor cr = database.rawQuery(sql,null);
        if(cr!=null && cr.getCount()!=0){
            //cr.moveToFirst();
            while(cr.moveToNext()){
                kosakata = new KosakataClass();
                kosakata.setId(cr.getInt(0));
                kosakata.setKosakata(cr.getString(cr.getColumnIndex("kosakata")));
                kosakata.setAlias(cr.getString(cr.getColumnIndex("alias")));
                kosakata.setIlustrasi(cr.getString(cr.getColumnIndex("ilustrasi")));
                kosakata.setKategori(cr.getString(cr.getColumnIndex("kategori")));
                kosakata.setBanyakObjek(cr.getInt(cr.getColumnIndex("banyak_objek")));
                kosakata.setKataDasar(cr.getString(cr.getColumnIndex("kata_dasar")));
                kosakata.setImbuhanAwal(cr.getString(cr.getColumnIndex("imbuhan_awal")));
                kosakata.setImbuhanAkhir(cr.getString(cr.getColumnIndex("imbuhan_akhir")));
                kosakata.setNamaLatin(cr.getString(cr.getColumnIndex("nama_latin")));
                kosakata.setSumberIlustasi(cr.getString(cr.getColumnIndex("sumber_ilustrasi")));
                kosakata.setSumberKeterangan(cr.getString(cr.getColumnIndex("sumber_keterangan")));
                kosakata.setKeterangan(cr.getString(cr.getColumnIndex("keterangan")));
                kosakata.setAudioKosakata(cr.getString(cr.getColumnIndex("audio_kosakata")));
                kosakata.setAudioKeterangan(cr.getString(cr.getColumnIndex("audio_keterangan")));

                kosakata.setJumlahData(cr.getCount());

                KosakataList.add(kosakata);
            }
        }

        closeDB();

        return KosakataList;
    }


    public List<KosakataClass> getDataKosakataList(String kosakata) {
        List<KosakataClass> DataKosakataList = new ArrayList<KosakataClass>();

        openDB();
        String data_sql = "SELECT * FROM kosakata WHERE kosakata ='"+kosakata+"'";

        KosakataClass data_kosakata;

        Cursor data_cr = database.rawQuery(data_sql,null);
        if(data_cr!=null && data_cr.getCount()!=0){
                data_cr.moveToFirst();
                data_kosakata = new KosakataClass();
                data_kosakata.setId(data_cr.getInt(0));
                data_kosakata.setKosakata(data_cr.getString(data_cr.getColumnIndex("kosakata")));
                data_kosakata.setAlias(data_cr.getString(data_cr.getColumnIndex("alias")));
                data_kosakata.setIlustrasi(data_cr.getString(data_cr.getColumnIndex("ilustrasi")));
                data_kosakata.setKategori(data_cr.getString(data_cr.getColumnIndex("kategori")));
                data_kosakata.setBanyakObjek(data_cr.getInt(data_cr.getColumnIndex("banyak_objek")));
                data_kosakata.setKataDasar(data_cr.getString(data_cr.getColumnIndex("kata_dasar")));
                data_kosakata.setImbuhanAwal(data_cr.getString(data_cr.getColumnIndex("imbuhan_awal")));
                data_kosakata.setImbuhanAkhir(data_cr.getString(data_cr.getColumnIndex("imbuhan_akhir")));
                data_kosakata.setNamaLatin(data_cr.getString(data_cr.getColumnIndex("nama_latin")));
                data_kosakata.setSumberIlustasi(data_cr.getString(data_cr.getColumnIndex("sumber_ilustrasi")));
                data_kosakata.setSumberKeterangan(data_cr.getString(data_cr.getColumnIndex("sumber_keterangan")));
                data_kosakata.setKeterangan(data_cr.getString(data_cr.getColumnIndex("keterangan")));
                data_kosakata.setAudioKosakata(data_cr.getString(data_cr.getColumnIndex("audio_kosakata")));
                data_kosakata.setAudioKeterangan(data_cr.getString(data_cr.getColumnIndex("audio_keterangan")));

                data_kosakata.setJumlahData(data_cr.getCount());

                DataKosakataList.add(data_kosakata);
            }

        closeDB();

        return DataKosakataList;
    }

    public List<KosakataClass> getTebakSuaraList() {
        List<KosakataClass> DataTebakSuaraList = new ArrayList<KosakataClass>();

        openDB();
        String data_sql_tebak_suara = "SELECT * FROM tebak_suara";

        KosakataClass data_tebak_suara;

        Cursor data_cr_tebak_suara = database.rawQuery(data_sql_tebak_suara,null);
        if(data_cr_tebak_suara!=null && data_cr_tebak_suara.getCount()!=0){
            //data_cr_tebak_suara.moveToFirst();
            while(data_cr_tebak_suara.moveToNext()) {
                data_tebak_suara = new KosakataClass();
                data_tebak_suara.setId(data_cr_tebak_suara.getInt(0));
                data_tebak_suara.setSuara_Objek(data_cr_tebak_suara.getString(data_cr_tebak_suara.getColumnIndex("suara_objek")));
                data_tebak_suara.setJawaban_A(data_cr_tebak_suara.getString(data_cr_tebak_suara.getColumnIndex("jawaban_a")));
                data_tebak_suara.setJawaban_B(data_cr_tebak_suara.getString(data_cr_tebak_suara.getColumnIndex("jawaban_b")));
                data_tebak_suara.setJawaban_C(data_cr_tebak_suara.getString(data_cr_tebak_suara.getColumnIndex("jawaban_c")));
                data_tebak_suara.setJawaban_D(data_cr_tebak_suara.getString(data_cr_tebak_suara.getColumnIndex("jawaban_d")));
                data_tebak_suara.setJawaban(data_cr_tebak_suara.getString(data_cr_tebak_suara.getColumnIndex("jawaban")));

                data_tebak_suara.setJumlahData(data_cr_tebak_suara.getCount());

                DataTebakSuaraList.add(data_tebak_suara);
            }
        }

        closeDB();

        return DataTebakSuaraList;
    }

    public List<KosakataClass> getTebakGambarList() {
        List<KosakataClass> DataTebakGambarList = new ArrayList<KosakataClass>();

        openDB();
        String data_sql_tebak_gambar = "SELECT * FROM tebak_gambar";

        KosakataClass data_tebak_gambar;

        Cursor data_cr_tebak_gambar = database.rawQuery(data_sql_tebak_gambar,null);
        if(data_cr_tebak_gambar!=null && data_cr_tebak_gambar.getCount()!=0){
            data_cr_tebak_gambar.moveToFirst();
            data_tebak_gambar = new KosakataClass();
            data_tebak_gambar.setId(data_cr_tebak_gambar.getInt(0));
            data_tebak_gambar.setSuara_Objek(data_cr_tebak_gambar.getString(data_cr_tebak_gambar.getColumnIndex("soal")));
            data_tebak_gambar.setJawaban_A(data_cr_tebak_gambar.getString(data_cr_tebak_gambar.getColumnIndex("jawaban_a")));
            data_tebak_gambar.setJawaban_B(data_cr_tebak_gambar.getString(data_cr_tebak_gambar.getColumnIndex("jawaban_b")));
            data_tebak_gambar.setJawaban_C(data_cr_tebak_gambar.getString(data_cr_tebak_gambar.getColumnIndex("jawaban_c")));
            data_tebak_gambar.setJawaban_D(data_cr_tebak_gambar.getString(data_cr_tebak_gambar.getColumnIndex("jawaban_d")));
            data_tebak_gambar.setJawaban(data_cr_tebak_gambar.getString(data_cr_tebak_gambar.getColumnIndex("jawaban")));

            data_tebak_gambar.setJumlahData(data_cr_tebak_gambar.getCount());

            DataTebakGambarList.add(data_tebak_gambar);
        }

        closeDB();

        return DataTebakGambarList;
    }

    public List<KosakataClass> getTebakAngkaList() {
        List<KosakataClass> DataTebakAngkaList = new ArrayList<KosakataClass>();

        openDB();
        String data_sql_tebak_angka = "SELECT * FROM tebak_angka";

        KosakataClass data_tebak_angka;

        Cursor data_cr_tebak_angka = database.rawQuery(data_sql_tebak_angka,null);
        if(data_cr_tebak_angka!=null && data_cr_tebak_angka.getCount()!=0){
            //data_cr_tebak_angka.moveToFirst();
            while(data_cr_tebak_angka.moveToNext()) {
                data_tebak_angka = new KosakataClass();
                data_tebak_angka.setId(data_cr_tebak_angka.getInt(0));
                data_tebak_angka.setSoal(data_cr_tebak_angka.getString(data_cr_tebak_angka.getColumnIndex("soal")));
                data_tebak_angka.setJawaban_A(data_cr_tebak_angka.getString(data_cr_tebak_angka.getColumnIndex("jawaban_a")));
                data_tebak_angka.setJawaban_B(data_cr_tebak_angka.getString(data_cr_tebak_angka.getColumnIndex("jawaban_b")));
                data_tebak_angka.setJawaban_C(data_cr_tebak_angka.getString(data_cr_tebak_angka.getColumnIndex("jawaban_c")));
                data_tebak_angka.setJawaban_D(data_cr_tebak_angka.getString(data_cr_tebak_angka.getColumnIndex("jawaban_d")));
                data_tebak_angka.setJawaban(data_cr_tebak_angka.getString(data_cr_tebak_angka.getColumnIndex("jawaban")));

                data_tebak_angka.setJumlahData(data_cr_tebak_angka.getCount());

                DataTebakAngkaList.add(data_tebak_angka);
            }
        }

        closeDB();

        return DataTebakAngkaList;
    }

    private void closeDB() {
        database.close();
    }

    private void openDB() throws SQLiteException{
        database = dbhelper.getWritableDatabase();

    }
}
