package com.example.githubassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TextView;

import com.example.githubassignment.Models.Profile;
import com.example.githubassignment.Utils.StaticFields;

public class ProfileActivity extends AppCompatActivity {

    private TextView tv_name = null;
    private TextView tv_email = null;
    private TextView tv_company = null;
    private TextView tv_location = null;
    private TextView tv_bio = null;
    private TextView tv_twitter_name = null;
    private TextView tv_no_of_public_repos = null;
    private TextView tv_followers = null;
    private TextView tv_user_type = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setTitle("Profile");

        //Initialize UI components
        initUI();

        //set data to UI
        setData();
    }

    private void setData() {
        Profile profile = StaticFields.profile;
        if (profile.name.equalsIgnoreCase("")){
            tv_name.setText("Name Not Defined");
        }else {
            tv_name.setText(profile.name);
        }
        if (profile.email.equalsIgnoreCase("")){
            tv_email.setText("Email not public");
        }else {
            tv_email.setText(profile.email);
        }

        if (profile.company.equalsIgnoreCase("")){
            tv_company.setText("company not defined");
        }else {
            tv_company.setText(profile.company);
        }

        if (profile.location.equalsIgnoreCase("")) {
            tv_location.setText("No location added");
        }else {
            tv_location.setText(profile.location);
        }

        if (profile.bio.equalsIgnoreCase("")){
            tv_bio.setText("No bio added");
        }else {
            tv_bio.setText(profile.bio);
        }

        if (profile.twitter_username.equalsIgnoreCase("")){
            tv_twitter_name.setText("No Twitter Name added");
        }else {
            tv_twitter_name.setText(profile.twitter_username);
        }
        tv_no_of_public_repos.setText(""+profile.public_repos);
        tv_followers.setText(""+profile.followers);
        tv_user_type.setText(profile.type);
    }

    private void initUI() {
        tv_name = findViewById(R.id.tv_name);
        tv_email = findViewById(R.id.tv_email);
        tv_company = findViewById(R.id.tv_company);
        tv_location = findViewById(R.id.tv_location);
        tv_bio = findViewById(R.id.tv_bio);
        tv_twitter_name = findViewById(R.id.tv_twitter_name);
        tv_no_of_public_repos = findViewById(R.id.tv_no_of_public_repos);
        tv_followers = findViewById(R.id.tv_followers);
        tv_user_type = findViewById(R.id.tv_user_type);
    }
}
