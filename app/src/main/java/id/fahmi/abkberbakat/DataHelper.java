package id.fahmi.abkberbakat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Fahmi on 15/05/2017.
 */

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "pkm.db";
    private static final int DATABASE_VERSION = 2;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql = "CREATE TABLE IF NOT EXISTS kosakata(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, kosakata TEXT, ilustrasi TEXT, kategori TEXT, banyak_objek TEXT NULL, imbuhanawal TEXT NULL, imbuhanakhir TEXT NULL, katadepan TEXT NULL);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO kosakata VALUES (1,'asparagus','asparagus','kata benda sayur-sayuran','4','','','');";
        Log.d("Data", "Menambahkan: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO kosakata VALUES (2,'bawang bombay','bawang_bombay','kata benda sayur-sayuran','1','','','');";
        Log.d("Data", "Menambahkan: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO kosakata VALUES (3,'bawang merah','bawang_merah','kata benda sayur-sayuran','99','','','');";
        Log.d("Data", "Menambahkan: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO kosakata VALUES (4,'bawang putih','bawang_putih','kata benda sayur-sayuran','99','','','');";
        Log.d("Data", "Menambahkan: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO kosakata VALUES (5,'bayam','bayam','kata benda sayur-sayuran','1','','','');";
        Log.d("Data", "Menambahkan: " + sql);
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
    }
}
