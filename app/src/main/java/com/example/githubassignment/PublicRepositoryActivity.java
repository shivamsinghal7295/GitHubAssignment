package com.example.githubassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.githubassignment.Utils.StaticFields;
import com.example.githubassignment.adapter.RepositoryListAdapter;

public class PublicRepositoryActivity extends AppCompatActivity {

    private RecyclerView rv_list = null;
    private ImageView iv_image = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_repository);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setTitle("Public Repository Data");

        //Initialize UI
        initUI();

        //setData
        setData();

    }

    private void setData() {
        if (StaticFields.publicRepositoryList != null){
            if (StaticFields.publicRepositoryList.size() > 0){
                rv_list.setVisibility(View.VISIBLE);
                 RepositoryListAdapter adapter = new RepositoryListAdapter(StaticFields.publicRepositoryList);
                rv_list.setHasFixedSize(true);
                rv_list.setLayoutManager(new LinearLayoutManager(this));
                rv_list.setAdapter(adapter);
            }else {
                // Show Image
                showImage();
            }
        }else {
            // SHOW Image
            showImage();
        }
    }

    private void showImage() {
        rv_list.setVisibility(View.GONE);
        iv_image.setVisibility(View.VISIBLE);

    }

    private void initUI() {
        rv_list = findViewById(R.id.rv_list);
        iv_image = findViewById(R.id.iv_image);
    }
}
