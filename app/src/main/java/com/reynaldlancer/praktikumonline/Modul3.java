package com.reynaldlancer.praktikumonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Modul3 extends AppCompatActivity {

    Button ImplicitIntentBTN, ExplicitIntentBTN, IntentExtraBTN;
    EditText ExtraDataET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul3);
        ImplicitIntentBTN = findViewById(R.id.intentOtherActivity);
        ExplicitIntentBTN = findViewById(R.id.intentOtherAplication);
        IntentExtraBTN = findViewById(R.id.intentWIthExtra);
        ExtraDataET = findViewById(R.id.ET_Extra);

        ImplicitIntentBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Modul3.this, ImplicitIntent.class);
                startActivity(i);
            }
        });


        ExplicitIntentBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://google.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
              }
        });

        IntentExtraBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = ExtraDataET.getText().toString();
                Intent i = new Intent(Modul3.this, IntentWithExtra.class);
                i.putExtra("data", data);
                startActivity(i);
            }
        });



    }
}
