package com.anugrah.uts_10120018.main.diary;
//20 mei 2023, 10120018, M Anugrah Ikhsan K, IF1


import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.anugrah.uts_10120018.model.DBHelper;
import com.anugrah.uts_10120018.R;
import com.anugrah.uts_10120018.model.DBHelper;



public class SaveCategoryActivity extends AppCompatActivity {
    private EditText titleInput;
    private EditText contentInput;
    private Button btn_simpan, btn_kembali;
    DBHelper dbHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_category);

        dbHelper = new DBHelper(this);
        titleInput = findViewById(R.id.input_title);
        contentInput = findViewById(R.id.input_content);
        btn_simpan = findViewById(R.id.button_submit);
        btn_kembali = findViewById(R.id.button_back);

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into kategori(kategori) values('" + titleInput.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Kategori Berhasil Dibuat", Toast.LENGTH_LONG).show();
                CategoriActivity.ma.RefreshList();
                finish();
            }
        });

        btn_kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
}