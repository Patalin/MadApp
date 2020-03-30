package com.example.madapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Button btnLogout;

    FirebaseAuth mFirebaseAuth;

    private FirebaseAuth.AuthStateListener mAuthStateListener;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        /*-------------------Hooks------------------*/

        drawerLayout = findViewById(R.id.drawer_layout);

        navigationView = findViewById(R.id.nav_view);

        toolbar = findViewById(R.id.toolbar);




        /*------------------Tool bar ----------------*/


//        setSupportActionBar(toolbar);



        /*------------Navigation drawer menu----------*/
        navigationView.bringToFront();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_Dashboard);


        btnLogout = findViewById(R.id.logout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();

                Intent intToMain = new Intent(HomeActivity.this, MainActivity.class);

                startActivity(intToMain);

            }
        });
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.isDrawerOpen(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_booksale:
                Intent intent = new Intent(HomeActivity.this, BookSale.class);
                startActivity(intent);
                break;
            case R.id.nav_library:
                Intent intent2 = new Intent(HomeActivity.this, Library.class);
                startActivity(intent2);
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Good job to us!!!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_floorplan:
                Intent intent3 = new Intent(HomeActivity.this, Floorplan.class);
                startActivity(intent3);
                break;
            case R.id.nav_moodle:
                Intent intent4 = new Intent(HomeActivity.this, MSG.class);
                startActivity(intent4);
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}
