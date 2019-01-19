package com.example.rathana.navigationdrawer_demo;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawerLayout);
        toolbar =findViewById(R.id.toolbar);
        navigationView=findViewById(R.id.navigationView);


        //add toolbar
        setSupportActionBar(toolbar);
        setTitle("Home");
        ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        //add fragment to layout

        HomeFragment homeFragment=HomeFragment.newInstance();
        final FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.add(R.id.container,homeFragment);
        t.commit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                //add fragment

                menuItem.setChecked(true);
                Fragment fragment=null;
                String title="";

                switch (menuItem.getItemId()){
                    case R.id.home:
                        fragment=HomeFragment.newInstance();
                        title="Home";
                        break;
                    case R.id.favourite:
                        fragment=FavouriteFragment.newInstance();
                        title="Favourite";
                        break;
                    case R.id.share:
                        fragment=ShareFragment.newInstance();
                        title="Share";
                        break;

                    case R.id.download:
                        fragment=DownloadFragment.newInstance();
                        title="Download";
                        break;
                }

                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container,fragment);
                transaction.commit();
                drawerLayout.closeDrawers();
                setTitle(title);
                return true;
            }
        });

    }


    //set event on hamburger button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
