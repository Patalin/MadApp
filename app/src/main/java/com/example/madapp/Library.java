package com.example.madapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Library extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {


    DrawerLayout drawerLayout3;

    NavigationView navigationView3;

    Toolbar toolbar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);


        drawerLayout3 = findViewById(R.id.drawer_layout_library);

        navigationView3 = findViewById(R.id.nav_view_library);

        toolbar3 = findViewById(R.id.toolbar_book);


        navigationView3.bringToFront();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout3, toolbar3, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout3.addDrawerListener(toggle);

        toggle.syncState();

        navigationView3.setNavigationItemSelectedListener(this);

        navigationView3.setCheckedItem(R.id.nav_booksale);

    }

    @Override
    public void onBackPressed() {

        if (drawerLayout3.isDrawerOpen(GravityCompat.START)) {
            drawerLayout3.isDrawerOpen(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_booksale:
                Intent intent = new Intent(Library.this, BookSale.class);
                startActivity(intent);
                break;
            case R.id.nav_library:
                Intent intent2 = new Intent(Library.this, Library.class);
                startActivity(intent2);
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Good job to us!!!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_floorplan:
                Intent intent3 = new Intent(Library.this, Floorplan.class);
                startActivity(intent3);
                break;
            case R.id.nav_Dashboard:
                Intent intent4 = new Intent(Library.this, HomeActivity.class);
                startActivity(intent4);
                break;
        }

        drawerLayout3.closeDrawer(GravityCompat.START);

        return true;
    }

}



