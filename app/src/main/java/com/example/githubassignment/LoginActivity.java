package com.example.githubassignment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.githubassignment.Models.Profile;
import com.example.githubassignment.Utils.StaticFields;
import com.example.githubassignment.Utils.UsedMethods;
import com.example.githubassignment.Utils.UsedUrls;

import org.json.JSONException;


public class LoginActivity extends AppCompatActivity {
    private static final String TAG = LoginActivity.class.getSimpleName();

    private EditText et_username = null;
    private Button   bt_login = null;

    private ProgressDialog progressDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setTitle("Enter User name");
        //Initialize UI components
        init();

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!et_username.getText().toString().trim().equalsIgnoreCase("")){
                    progressDialog.show();
                    StaticFields.username = et_username.getText().toString().trim();
                    verifyUserCredentials();
                }else {
                    UsedMethods.displayCustomToast(LoginActivity.this,getResources().getString(R.string.enter_user));
                }
            }
        });
    }

    private void verifyUserCredentials() {
        RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);

        String url = UsedUrls.CHECK_USERNAME +  StaticFields.username;

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e(TAG, "onResponse:------------- " + response );
                try {
                    StaticFields.profile = ParseData.parseProfileData(response);

                    if (StaticFields.profile.public_repos > 0){
                        requestForPublicRepos(StaticFields.profile);
                    }else {

                        //open home screen here
                        openHomeScreen();
                    }
                }catch (JSONException e){
                    Log.e(TAG, "onResponse: " + e.toString() );
                    progressDialog.dismiss();
                    UsedMethods.displayCustomToast(LoginActivity.this,getResources().getString(R.string.something_wrong));
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                progressDialog.dismiss();
                if (error instanceof TimeoutError || error instanceof NoConnectionError){
                    UsedMethods.displayCustomToast(LoginActivity.this, getResources().getString(R.string.check_connection));
                }else {
                    if (error.networkResponse.statusCode == 404 || error.networkResponse.statusCode == 401){
                        UsedMethods.displayCustomToast(LoginActivity.this, getResources().getString(R.string.enter_correct_user));
                        return;
                    }
                    UsedMethods.displayCustomToast(LoginActivity.this, getResources().getString(R.string.something_wrong));
                }

            }
        });

        request.setRetryPolicy(new DefaultRetryPolicy(
                6000,
                5,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);

    }

    private void requestForPublicRepos(final Profile profile) {
        RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);

        String url;

        if (profile.repos_url.equalsIgnoreCase("")){

            url = "https://api.github.com/users/"+StaticFields.username+"/repos";
            Log.e(TAG, "requestForPublicRepos: custom " + url );
        }else {
            url = profile.repos_url;
            Log.e(TAG, "requestForPublicRepos: api " + url );
        }

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e(TAG, "onResponse:Repositories " + response );
                try {

                    StaticFields.publicRepositoryList = ParseData.parseRepositoryResponse(response);
                    //open home screen here
                    openHomeScreen();

                }catch (JSONException e){
                    Log.e(TAG, "onResponse: error in repository data " + e.toString() );
                    progressDialog.dismiss();
                    UsedMethods.displayCustomToast(LoginActivity.this,getResources().getString(R.string.something_wrong));
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();

                if (error instanceof TimeoutError || error instanceof NoConnectionError){
                    UsedMethods.displayCustomToast(LoginActivity.this,getResources().getString(R.string.check_connection));
                }else {
                    if (error.networkResponse.statusCode == 404){
                        UsedMethods.displayCustomToast(LoginActivity.this,getResources().getString(R.string.enter_correct_user));
                        return;
                    }
                    UsedMethods.displayCustomToast(LoginActivity.this,getResources().getString(R.string.something_wrong));
                }

            }
        });

        request.setRetryPolicy(new DefaultRetryPolicy(
                6000,
                5,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);
    }

    private void openHomeScreen() {
        progressDialog.dismiss();
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }


    private void init() {
        et_username = findViewById(R.id.et_username);
        bt_login    = findViewById(R.id.bt_login);

        progressDialog = new ProgressDialog(LoginActivity.this);
    }
}
