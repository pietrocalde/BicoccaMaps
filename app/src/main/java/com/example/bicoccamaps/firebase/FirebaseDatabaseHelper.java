package com.example.bicoccamaps.firebase;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.bicoccamaps.model.Building;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceBuildings;
    private List<Building> buildings = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Building> buildings, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseHelper() {
        mDatabase = FirebaseDatabase.getInstance("https://bicoccamaps-default-rtdb.europe-west1.firebasedatabase.app/");
        mReferenceBuildings = mDatabase.getReference("Buildings");
    }

    public void readEdifici(final DataStatus dataStatus){
        mReferenceBuildings.addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                buildings.clear();
                List<String> keys = new ArrayList<>();

                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Building building = keyNode.getValue(Building.class);
                    buildings.add(building);
                }
                dataStatus.DataIsLoaded(buildings, keys);
            }

            //***************************************************************
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                DatabaseError databaseError = null;
                Log.w("ErroreDATABASE", "loadPost:onCancelled", databaseError.toException());
            }
        });
    }
}
