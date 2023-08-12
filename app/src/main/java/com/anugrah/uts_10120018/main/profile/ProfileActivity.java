package com.anugrah.uts_10120018.main.profile;
//20 mei 2023, 10120018, M Anugrah Ikhsan K, IF1

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.anugrah.uts_10120018.auth.LoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.anugrah.uts_10120018.R;
import com.anugrah.uts_10120018.main.diary.CategoriActivity;
import com.google.firebase.auth.FirebaseAuth;


public class ProfileActivity extends AppCompatActivity {

    Button btn_logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        btn_logout = findViewById(R.id.btn_logout);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.ProfileId);

        // Logout
        btn_logout.setOnClickListener(v -> {
            // Logout
            FirebaseAuth.getInstance().signOut();

            // Back to login page
            Toast.makeText(this, "Already logged out",
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ProfileId:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.CatatanHarian:
                        startActivity(new Intent(getApplicationContext(), CategoriActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.About:
                        final Dialog dialog = new Dialog(ProfileActivity.this);

                        //Memasang Title / Judul pada Custom Dialog
                        dialog.setTitle("About");

                        //Memasang Desain Layout untuk Custom Dialog
                        dialog.setContentView(R.layout.custom_design_dialog);

                        //Memasang Listener / Aksi saat tombol OK di Klik
                        Button DialogButton = dialog.findViewById(R.id.ok);
                        DialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });

                        dialog.show();
                        return true;
                }

                return false;
            }
        });
    }
}