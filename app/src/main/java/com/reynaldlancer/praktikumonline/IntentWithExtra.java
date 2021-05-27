package com.reynaldlancer.praktikumonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class IntentWithExtra extends AppCompatActivity {

    TextView resultExtra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_with_extra);
        Intent intentWIthExtra = getIntent();
        String result = intentWIthExtra.getStringExtra("data");
        Toast.makeText(this, "Data Extra Anda : "+result, Toast.LENGTH_SHORT).show();
        resultExtra = findViewById(R.id.resultExtra);
        resultExtra.setText(result);
    }
}
