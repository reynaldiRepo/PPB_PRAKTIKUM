package com.reynaldlancer.praktikumonline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Modul6 extends AppCompatActivity {
    EditText editTextSahredPreference;
    Button saveSharedPreferenceBTN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul6);
        editTextSahredPreference = findViewById(R.id.ET_shared_pref);
        saveSharedPreferenceBTN = findViewById(R.id.btn_save_shared_pref);
        //for read
        editTextSahredPreference.setText(SharedPreference.getSecretKey(this));

        //for edit
        saveSharedPreferenceBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextSahredPreference.getText().toString() != "" ){
                    SharedPreference.setSecretKey(Modul6.this ,editTextSahredPreference.getText().toString());
                    Toast.makeText(Modul6.this, "Shared Preference Saved", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Modul6.this, "Input Kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
