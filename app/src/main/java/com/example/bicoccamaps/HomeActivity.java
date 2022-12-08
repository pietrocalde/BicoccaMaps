package com.example.bicoccamaps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().hide();
        // Initialize fragment
        Fragment fragment = new MapFragment();
        // Open fragment
        getSupportFragmentManager()
                .beginTransaction().replace(R.id.frame_layout,fragment)
                .commit();

    }
}