package com.anugrah.uts_10120018.model;
//20 mei 2023, 10120018, M Anugrah Ikhsan K, IF1

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "note.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CreateTableKategori = "create table kategori(id_kategori INTEGER PRIMARY KEY AUTOINCREMENT, kategori text null);";
        String CreateTableNote = "create table note(id INTEGER PRIMARY KEY AUTOINCREMENT, tanggal text null, " +
                "waktu text null, judul text null, isi text null, id_kategori INTEGER, " +
                "FOREIGN KEY (id_kategori)" +
                "    REFERENCES kategori (id_kategori)" +
                "       ON UPDATE CASCADE" +
                "       ON DELETE CASCADE);";

        Log.d("Data", "onCreate " + CreateTableKategori);
        db.execSQL(CreateTableKategori);

        Log.d("Data", "onCreate " + CreateTableNote);
        db.execSQL(CreateTableNote);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}