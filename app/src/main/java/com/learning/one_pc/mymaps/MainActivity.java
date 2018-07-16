package com.learning.one_pc.mymaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class MainActivity extends AppCompatActivity {



    public static final String TAG = "MainActivity";
    public static final int ERROR_DIALOG_REQUEST = 9001;
    Button btnmap;
    private Button button_Parking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(isServicesOK()) {
            ButtonInitialise();
        }

        manager_register();


    }
    public void manager_register(){
        button_Parking = (Button) findViewById(R.id.button_manager);
        button_Parking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toregister = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(toregister);
            }
        });
    }


    public boolean isServicesOK(){
        int availability = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);
        if(availability == ConnectionResult.SUCCESS) {
            Log.d(TAG, "isServicesOK: Google Play Services is OK");
            Toast.makeText(this, "Services are OK", Toast.LENGTH_SHORT).show();
             return true;
        }
        else if (GoogleApiAvailability.getInstance().isUserResolvableError(availability)) {
            GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this, availability, ERROR_DIALOG_REQUEST).show();
            return false;
        }
        else {
            Toast.makeText(this, "Cant make map requests", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    public void ButtonInitialise(){
        btnmap = findViewById(R.id.btnmap);
        btnmap.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, MapActivity.class);
                        startActivity(intent);
                    }
                }
        );

    }
}
