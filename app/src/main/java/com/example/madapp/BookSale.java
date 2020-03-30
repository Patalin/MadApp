package com.example.madapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class BookSale extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ArrayList<ExampleItem> mExampleList;

    private RecyclerView mRecyclerView;

    private ExampleAdaptor mAdapter;

    private RecyclerView.LayoutManager mLayoutManager;

    DrawerLayout drawerLayout2;

    NavigationView navigationView2;

    Toolbar toolbar2;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_sale);

        createExampleList();

        buildRecycleView();

        drawerLayout2 = findViewById(R.id.drawer_layout_book);

        navigationView2 = findViewById(R.id.nav_view_book);

        toolbar2 = findViewById(R.id.toolbar_book);


        navigationView2.bringToFront();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout2, toolbar2, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout2.addDrawerListener(toggle);

        toggle.syncState();

        navigationView2.setNavigationItemSelectedListener(this);

        navigationView2.setCheckedItem(R.id.nav_booksale);

        final EditText searchBooks = findViewById(R.id.searchBooksSale);

        searchBooks.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                filter(s.toString());

            }
        });

    }

    public void filter(String text) {

        ArrayList<ExampleItem> filteredList = new ArrayList<>();

        for (ExampleItem item : mExampleList) {

            if (item.getText2().toLowerCase().contains(text.toLowerCase())) {

                filteredList.add(item);

            }

        }
        mAdapter.filterList(filteredList);

    }

    private void createExampleList() {

        mExampleList = new ArrayList<>();

        mExampleList.add(new ExampleItem(R.drawable.booklibrary_icon, "Line 1", "Mathematics"));

        mExampleList.add(new ExampleItem(R.drawable.booklibrary_icon, "Line 3", "Economy"));

        mExampleList.add(new ExampleItem(R.drawable.booklibrary_icon, "Line 5", "Biology"));

        mExampleList.add(new ExampleItem(R.drawable.booklibrary_icon, "Line 1", "Mathematics"));

        mExampleList.add(new ExampleItem(R.drawable.booklibrary_icon, "Line 3", "Economy"));

        mExampleList.add(new ExampleItem(R.drawable.booklibrary_icon, "Line 5", "Biology"));

        mExampleList.add(new ExampleItem(R.drawable.booklibrary_icon, "Line 1", "Mathematics"));

        mExampleList.add(new ExampleItem(R.drawable.booklibrary_icon, "Line 3", "Economy"));

    }

    private void buildRecycleView() {

        mRecyclerView = findViewById(R.id.recyclerView);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);

        mAdapter = new ExampleAdaptor(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onBackPressed() {

        if (drawerLayout2.isDrawerOpen(GravityCompat.START)) {
            drawerLayout2.isDrawerOpen(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_booksale:
                Intent intent = new Intent(BookSale.this, BookSale.class);
                startActivity(intent);
                break;
            case R.id.nav_library:
                Intent intent2 = new Intent(BookSale.this, Library.class);
                startActivity(intent2);
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Good job to us!!!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_floorplan:
                Intent intent3 = new Intent(BookSale.this, Floorplan.class);
                startActivity(intent3);
                break;
            case R.id.nav_Dashboard:
                Intent intent4 = new Intent(BookSale.this, HomeActivity.class);
                startActivity(intent4);
                break;
        }

        drawerLayout2.closeDrawer(GravityCompat.START);

        return true;
    }

}
