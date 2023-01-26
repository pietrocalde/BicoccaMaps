package com.example.bicoccamaps.firebase;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.bicoccamaps.model.Building;
import com.google.android.gms.tasks.Task;
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
        mReferenceBuildings = mDatabase.getReference().getRef();
    }

    public void readBuildings(final DataStatus dataStatus){
        mReferenceBuildings.addValueEventListener(new ValueEventListener() {

            public void onDataChange(@NonNull Task <DataSnapshot> task) {
                buildings.clear();
                List<String> keys = new ArrayList<>();

                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    for(DataSnapshot keyNode : task.getResult().getChildren()){
                        keys.add(keyNode.getKey());
                        Building building = keyNode.getValue(Building.class);
                        buildings.add(building);
                    }
                    dataStatus.DataIsLoaded(buildings, keys);
                }

            }


            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

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
