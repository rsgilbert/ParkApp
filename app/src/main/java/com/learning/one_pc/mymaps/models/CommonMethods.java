package com.learning.one_pc.mymaps.models;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


public class CommonMethods {
    private Context context;
    public void shortToast(String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
    private void longToast(String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

}
