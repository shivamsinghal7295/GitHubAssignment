package com.example.githubassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private TextView tv_name = null;
    private TextView tv_email = null;
    private TextView tv_company = null;
    private TextView tv_location = null;
    private TextView tv_bio = null;
    private TextView tv_twitter_name = null;
    private TextView tv_no_of_public_repos = null;
    private TextView tv_no_of_private_repos = null;
    private TextView tv_followers = null;
    private TextView tv_user_type = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
}
