package com.example.githubassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.githubassignment.R;
import com.example.githubassignment.Utils.StaticFields;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RelativeLayout rl_profile = null;
    private RelativeLayout rl_repos = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setTitle("Welcome, "  + StaticFields.username);

        //initialize
        initUI();


        // TODO : Click on Profile
        rl_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO : Open Profile Screen
                Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });

        // TODO : Click on Repositories
        rl_repos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO : Open Repositories Screen
                Intent intent = new Intent(MainActivity.this,PublicRepositoryActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initUI() {
        rl_profile = findViewById(R.id.rl_profile);
        rl_repos   = findViewById(R.id.rl_repos);
    }
}
