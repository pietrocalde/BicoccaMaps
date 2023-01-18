package com.example.bicoccamaps;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceEdifici;
    private List<Edificio> edifici = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Edificio> books, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseHelper() {
        mDatabase = FirebaseDatabase.getInstance("https://bicoccamaps-default-rtdb.europe-west1.firebasedatabase.app/"
        );
        mReferenceEdifici = mDatabase.getReference("Edifici");
    }

    public void readEdifici(final DataStatus dataStatus){
        mReferenceEdifici.addValueEventListener(new ValueEventListener() {
            @Override
            /*
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                edifici.clear();
                List<String> keys = new ArrayList<>();

                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Edificio edificio = keyNode.getValue(Edificio.class);
                    edifici.add(edificio);
                }
                dataStatus.DataIsLoaded(edifici, keys);
            }
*/
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Edificio value = dataSnapshot.getValue(Edificio.class);
                Log.d("VALORE", "Value is: " + value.getNome());
            }
            //***************************************************************
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                DatabaseError databaseError = null;
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        });
    }
}
