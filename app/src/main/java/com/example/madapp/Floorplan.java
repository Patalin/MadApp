package com.example.madapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Floorplan extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    ImageView floorPlan;

    DrawerLayout drawerLayout4;

    NavigationView navigationView4;

    Toolbar toolbar4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floorplan);

        Toolbar toolbar = findViewById(R.id.toolbar_timetable);

        setSupportActionBar(toolbar);

        floorPlan = findViewById(R.id.floorplan_img);

        drawerLayout4 = findViewById(R.id.drawer_layout_floorplan);

        navigationView4 = findViewById(R.id.nav_view_floorplan);

        toolbar4 = findViewById(R.id.toolbar_timetable);


        navigationView4.bringToFront();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout4, toolbar4, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout4.addDrawerListener(toggle);

        toggle.syncState();

        navigationView4.setNavigationItemSelectedListener(this);

        navigationView4.setCheckedItem(R.id.nav_booksale);
    }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {

            MenuInflater inflater = getMenuInflater();

            inflater.inflate(R.menu.floorplan_menu, menu);

            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            switch (item.getItemId()) {

                case R.id.dropdown1:
                    Toast.makeText(this, "Ground Floor", Toast.LENGTH_SHORT).show();

                    floorPlan.setImageResource(R.drawable.ground_floor_icon);

                    return true;

                case R.id.dropdown2:
                    Toast.makeText(this, "First Floor", Toast.LENGTH_SHORT).show();

                    floorPlan.setImageResource(R.drawable.first_floor_icon);

                    return true;

                case R.id.dropdown3:
                    Toast.makeText(this, "Second Floor", Toast.LENGTH_SHORT).show();

                    floorPlan.setImageResource(R.drawable.second_floor_icon);
                    return true;



                default:
                    return super.onOptionsItemSelected(item);

            }

        }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_booksale:
                Intent intent = new Intent(Floorplan.this, BookSale.class);
                startActivity(intent);
                break;
            case R.id.nav_library:
                Intent intent2 = new Intent(Floorplan.this, Library.class);
                startActivity(intent2);
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Good job to us!!!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_floorplan:
                Intent intent3 = new Intent(Floorplan.this, Floorplan.class);
                startActivity(intent3);
                break;
            case R.id.nav_Dashboard:
                Intent intent4 = new Intent(Floorplan.this, HomeActivity.class);
                startActivity(intent4);
                break;
            case R.id.nav_moodle:
                Intent intent5 = new Intent(Floorplan.this, MSG.class);
                startActivity(intent5);
                break;
        }

        drawerLayout4.closeDrawer(GravityCompat.START);

        return true;
    }
    }

