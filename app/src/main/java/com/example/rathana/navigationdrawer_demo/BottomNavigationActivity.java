package com.example.rathana.navigationdrawer_demo;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class BottomNavigationActivity extends AppCompatActivity {

    BottomNavigationView bottonNav;
    ViewPager viewPager;
    ViewPagerAdapter adapter;
    MenuItem prevMenuItem;
    List<Fragment> fragments=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        setupUI();
    }

    private void setupUI() {

        viewPager=findViewById(R.id.viewPager);
        bottonNav=findViewById(R.id.bottomNav);

        fragments.add(HomeFragment.newInstance());
        fragments.add(FavouriteFragment.newInstance());
        fragments.add(ShareFragment.newInstance());
        fragments.add(DownloadFragment.newInstance());

        adapter=new ViewPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if(prevMenuItem!=null)
                    prevMenuItem.setChecked(false);
                else
                    bottonNav.getMenu().getItem(0).setChecked(false);

                //set check true to current page
                bottonNav.getMenu().getItem(i).setChecked(true);
                prevMenuItem=bottonNav.getMenu().getItem(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        //clicked on each item
        bottonNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        viewPager.setCurrentItem(0);
                        return  true;
                    case R.id.favourite:
                        viewPager.setCurrentItem(1);
                        return true;
                    case R.id.share:
                        viewPager.setCurrentItem(2);
                        return  true;
                    case R.id.download:
                        viewPager.setCurrentItem(3);

                        return true;

                    default: return false;
                }
            }
        });

    }
}
