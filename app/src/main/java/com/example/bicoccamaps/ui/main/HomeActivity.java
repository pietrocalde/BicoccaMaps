package com.example.bicoccamaps.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.bicoccamaps.R;
import com.example.bicoccamaps.databinding.ActivityHomeBinding;


public class HomeActivity extends AppCompatActivity {
     ActivityHomeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_home);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Fragment fragment = new MapFragment();
        getSupportFragmentManager()
                .beginTransaction().replace(R.id.frame_layout,fragment)
                .commit();

        /* *****************************************************************/
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

                    if (item.getItemId()==R.id.home) {
                        replaceFragment(new MapFragment());
                    }else if (item.getItemId()==R.id.buildings){
                        replaceFragment(new BuildingsFragment());
                    }else if (item.getItemId()==R.id.events) {
                        replaceFragment(new EventsFragment());
                    }else if (item.getItemId()== R.id.favourite) {
                        replaceFragment(new FavouriteFragment());
                    }

            return true;

        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        MenuItem.OnActionExpandListener onActionExpandListener= new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                Toast.makeText(HomeActivity.this,"Search si è aperto", Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                Toast.makeText(HomeActivity.this,"Search si è chiuso", Toast.LENGTH_SHORT).show();
                return true;
            }
        };
        menu.findItem(R.id.search).setOnActionExpandListener(onActionExpandListener);
        SearchView searchView=(SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setQueryHint("Cerca qui...");
        Toast.makeText(HomeActivity.this,"Search si è aperto", Toast.LENGTH_SHORT).show();
        return true;
    }
}