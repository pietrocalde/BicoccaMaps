package com.example.bicoccamaps;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class EdificioActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edificio);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_edifici);
        new FirebaseDatabaseHelper().readEdifici(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Edificio> edifici, List<String> keys) {
                new RecyclerView_Config().setConfig(mRecyclerView, EdificioActivity.this, edifici, keys);
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
