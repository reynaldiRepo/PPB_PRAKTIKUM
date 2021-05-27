package com.reynaldlancer.praktikumonline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Modul4 extends AppCompatActivity {

    NavigationView sideNav;
    Button clickToOpenMenu;
    DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul4);
        sideNav = findViewById(R.id.side_nav);
        clickToOpenMenu = findViewById(R.id.clickOpenMenu);
        drawer = findViewById(R.id.drawer);
        clickToOpenMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(sideNav);
            }
        });

        sideNav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.modul2_menu:
                        startActivity(new Intent(Modul4.this, Modul2.class));
                        break;
                    case R.id.modul3_menu:
                        startActivity(new Intent(Modul4.this, Modul3.class));
                        break;
                    case R.id.modul4_menu:
                        startActivity(new Intent(Modul4.this, Modul4.class));
                        break;
                    case R.id.modul5_menu:
                        startActivity(new Intent(Modul4.this, Modul5.class));
                        break;
                    case R.id.modul6_menu:
                        startActivity(new Intent(Modul4.this, Modul6.class));
                        break;
                    case R.id.modul7_menu:
                        startActivity(new Intent(Modul4.this, Modul7.class));
                        break;
                }
                return false ;
            }
        });
    }
}
