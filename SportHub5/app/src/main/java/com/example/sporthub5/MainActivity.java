package com.example.sporthub5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.room.Room;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.sporthub5.PagerAdapter.ViewPagerDelete;
import com.example.sporthub5.PagerAdapter.ViewPagerQuery;
import com.example.sporthub5.PagerAdapter.ViewPagerInsert;
import com.example.sporthub5.PagerAdapter.ViewPagerUpdate;
import com.example.sporthub5.RoomDatabase.MyDatabase;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static MyDatabase myAppDatabase;
    public static FirebaseFirestore myFirebaseFireStore;

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;


    ViewPager query, insert, update, delete;
    TabLayout tabLayout;

    PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myFirebaseFireStore = FirebaseFirestore.getInstance();
        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "SportHub").allowMainThreadQueries().build();

        toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawerLayout = findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        drawerLayout.addDrawerListener(toggle);

        query = findViewById(R.id.ViewPagerQuery);
        insert = findViewById(R.id.ViewPagerInsert);
        update = findViewById(R.id.ViewPagerUpdate);
        delete = findViewById(R.id.ViewPagerDelete);

        tabLayout = findViewById(R.id.tablayout);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);

        if (item.getItemId() == R.id.Home) {
            query.setVisibility(View.VISIBLE);
            insert.setVisibility(View.INVISIBLE);
            update.setVisibility(View.INVISIBLE);
            delete.setVisibility(View.INVISIBLE);


            adapter = new ViewPagerQuery(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, tabLayout.getTabCount());
            query.setAdapter(adapter);

            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    query.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
            query.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        }
        if (item.getItemId() == R.id.insert) {
            query.setVisibility(View.INVISIBLE);
            insert.setVisibility(View.VISIBLE);
            update.setVisibility(View.INVISIBLE);
            delete.setVisibility(View.INVISIBLE);


            adapter = new ViewPagerInsert(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, tabLayout.getTabCount());
            insert.setAdapter(adapter);

            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    insert.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
            insert.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        }
        if (item.getItemId() == R.id.update) {
            query.setVisibility(View.INVISIBLE);
            insert.setVisibility(View.INVISIBLE);
            update.setVisibility(View.VISIBLE);
            delete.setVisibility(View.INVISIBLE);


            adapter = new ViewPagerUpdate(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, tabLayout.getTabCount());
            update.setAdapter(adapter);

            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    update.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
            update.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        }
        if (item.getItemId() == R.id.delete) {
            query.setVisibility(View.INVISIBLE);
            insert.setVisibility(View.INVISIBLE);
            update.setVisibility(View.INVISIBLE);
            delete.setVisibility(View.VISIBLE);


            adapter = new ViewPagerDelete(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, tabLayout.getTabCount());
            delete.setAdapter(adapter);

            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    delete.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
            delete.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        }
        return false;
    }
}