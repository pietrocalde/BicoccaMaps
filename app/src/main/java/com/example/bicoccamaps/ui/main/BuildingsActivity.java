package com.example.bicoccamaps.ui.main;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bicoccamaps.firebase.FirebaseDatabaseHelper;
import com.example.bicoccamaps.R;
import com.example.bicoccamaps.model.Building;
import com.example.bicoccamaps.ui.RecyclerView_Config;

import java.util.List;

public class BuildingsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buildings);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_buildings);
        new FirebaseDatabaseHelper().readEdifici(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Building> edifici, List<String> keys) {
                new RecyclerView_Config().setConfig(mRecyclerView, BuildingsActivity.this, edifici, keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
    }
}
