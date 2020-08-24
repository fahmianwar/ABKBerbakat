package id.fahmi.abkberbakat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Fahmi on 25/05/2017.
 */

class DBHelper extends SQLiteAssetHelper{

    private static final String DATABASE_NAME = "pkm.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
