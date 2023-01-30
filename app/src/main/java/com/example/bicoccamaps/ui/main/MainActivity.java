package com.example.bicoccamaps.ui.main;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.example.bicoccamaps.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.search.SearchBar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_fake);


        //toolbar.setVisibility(View.GONE);
        //getSupportActionBar().hide();

        //AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.bar_layout);
        //SearchBar topbar = (SearchBar) findViewById(R.id.search_bar);

        //topbar.setNavigationIcon(R.drawable.home_24);
        //topbar.setLogo(R.drawable.home_24);
        //topbar.setNavigationIcon(R.drawable.favorite_24);
        //topbar.setCollapseIcon(R.drawable.home_24);
        //topbar.setOverflowIcon(R.drawable.building_24);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().
                findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.mapFragment, R.id.buildingFragment,
                R.id.eventsFragment, R.id.favouriteFragment).build();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNav, navController);

    }
}