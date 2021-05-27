package com.reynaldlancer.praktikumonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget. RelativeLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class ListModulActivity extends AppCompatActivity {

    ArrayList<RelativeLayout> ButtonsToModuls = new ArrayList<RelativeLayout>();
    ArrayList<Class> classActivitys = new ArrayList<Class>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_modul);
        //adding all button to activiry
        ButtonsToModuls.add(( RelativeLayout) findViewById(R.id.modul2));
        ButtonsToModuls.add(( RelativeLayout) findViewById(R.id.modul3));
        ButtonsToModuls.add(( RelativeLayout) findViewById(R.id.modul4));
        ButtonsToModuls.add(( RelativeLayout) findViewById(R.id.modul5));
        ButtonsToModuls.add(( RelativeLayout) findViewById(R.id.modul6));
        ButtonsToModuls.add(( RelativeLayout) findViewById(R.id.modul7));

        //adding all class moduls
        classActivitys.add(Modul2.class);
        classActivitys.add(Modul3.class);
        classActivitys.add(Modul4.class);
        classActivitys.add(Modul5.class);
        classActivitys.add(Modul6.class);
        classActivitys.add(Modul7.class);

        //loop on al button
        for (final  RelativeLayout btn : ButtonsToModuls){
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final  RelativeLayout btnOnLoop = btn;
                    Intent i = new Intent(ListModulActivity.this ,classActivitys.get(ButtonsToModuls.indexOf(btnOnLoop)));
                    startActivity(i);
                }
            });
        }
    }
}
