package com.example.githubassignment.Utils;

import android.content.Context;
import android.widget.Toast;

public class UsedMethods {
    public static void displayCustomToast(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
