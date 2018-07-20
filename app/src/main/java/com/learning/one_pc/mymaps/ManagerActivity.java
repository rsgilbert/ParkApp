package com.learning.one_pc.mymaps;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.learning.one_pc.mymaps.models.UserInformation;

import java.util.ArrayList;

public class ManagerActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private  FirebaseAuth.AuthStateListener mAuthListener;
    private String userID;
    private ListView mListView;


    //widgets
    private EditText lots;
    private TextView parkName, owner, currentLots;
    private Button update;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infolist);
        //lots = findViewById(R.id.lots);
        parkName = findViewById(R.id.parkName);
        owner = findViewById(R.id.parkowner);
        currentLots = findViewById(R.id.currentLots);
        update = findViewById(R.id.update);
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null)
                    Toast.makeText(ManagerActivity.this, "signed in: " + user.getUid(), Toast.LENGTH_SHORT).show();
                else Toast.makeText(ManagerActivity.this, "signed out", Toast.LENGTH_SHORT).show();
            }
        };
        // Read from the database
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                showData(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(ManagerActivity.this, "Failed to read Database"+ error.toException(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void showData(DataSnapshot dataSnapshot){
        for (DataSnapshot ds : dataSnapshot.getChildren()){
            UserInformation userInformation = new UserInformation();
            userInformation.setParkName(ds.child(userID).getValue(UserInformation.class).getParkName());
            userInformation.setCapacity(ds.child(userID).getValue(UserInformation.class).getCapacity());
            userInformation.setCurrentLots(ds.child(userID).getValue(UserInformation.class).getCurrentLots());
            userInformation.setOwner(ds.child(userID).getValue(UserInformation.class).getOwner());

            ArrayList<String> userArray =  new ArrayList<>();
            userArray.add(userInformation.getCapacity());
            userArray.add(userInformation.getCurrentLots());
            userArray.add(userInformation.getOwner());
            userArray.add(userInformation.getParkName());

            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, userArray);
            mListView.setAdapter(arrayAdapter);
        }

    }
}
