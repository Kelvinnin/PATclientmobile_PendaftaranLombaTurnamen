package com.kelvin.pendaftarananroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Gameindiv> gameindivArrayList , gameTeamlist ;
    private RvGameIndivAdapter rvGameIndivAdapter;
    private RvGameTeamAdapter rvGameTeamAdapter;
    private Button btnDaftar;

    private RecyclerView myRv , myRv2;
    private BottomNavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRv = findViewById(R.id.rvIndiv);
        myRv2=findViewById(R.id.rvKelompok);
        nav = findViewById(R.id.bottomNavigationView);
        nav.setSelectedItemId(R.id.itemLeaderboard);
        btnDaftar=findViewById(R.id.btnCekStatus);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        String url1 = "http://10.0.2.2:7000/leaderboardIndiv";
        useRv1(url1);
        String url2 = "http://10.0.2.2:7000/leaderboardTeam";
        useRv2(url2);

        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.itemTeam:
                        Intent intent = new Intent(MainActivity.this, RegisterTeamActivity.class);
                        startActivity(intent);

                        return true;
                    case R.id.itemIndividu:
                        Intent intent2 = new Intent(MainActivity.this, RegisterIndividuActivity.class);
                        startActivity(intent2);

                        return true;
                    case R.id.itemLeaderboard:
                        Intent intent3 = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent3);
                }
                return false;
            }
        });

    }





    protected void useRv1(String url){

        gameindivArrayList= new ArrayList<>();

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("apiresult", response);
                        JSONObject object ;
                        try {
                            object= new JSONObject(response);
                            JSONArray arr = object.getJSONArray("response");
                            for (int i = 0; i < arr.length(); i++) {
                                JSONObject leaderIndivData = arr.getJSONObject(i);
                                Gameindiv leaderIndiv = new Gameindiv(
                                        leaderIndivData.getString("nama_game"),
                                        leaderIndivData.getString("nama"),
                                        leaderIndivData.getInt("win"),
                                        leaderIndivData.getInt("lose")

                                );
                                gameindivArrayList.add(leaderIndiv);
                            }
                            rvGameIndivAdapter = new RvGameIndivAdapter(gameindivArrayList,MainActivity.this);


                            myRv.setAdapter(rvGameIndivAdapter);
                            myRv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            myRv.invalidate();

                            rvGameIndivAdapter.notifyDataSetChanged();

                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("apiresult", error.getMessage() != null ? error.getMessage() : "Unknown error");
                    }
                });

        // Add the request to the RequestQueue.
        Volley.newRequestQueue(this).add(stringRequest);
    }
    protected void useRv2(String url){

        gameTeamlist= new ArrayList<>();

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("apiresult", response);
                        JSONObject object ;
                        try {
                            object= new JSONObject(response);
                            JSONArray arr = object.getJSONArray("response");
                            for (int i = 0; i < arr.length(); i++) {
                                JSONObject leaderIndivData = arr.getJSONObject(i);
                                Gameindiv leaderIndiv = new Gameindiv(
                                        leaderIndivData.getString("nama_game"),
                                        leaderIndivData.getString("nama_team"),
                                        leaderIndivData.getInt("win"),
                                        leaderIndivData.getInt("lose")

                                );
                                gameTeamlist.add(leaderIndiv);
                            }
                            rvGameTeamAdapter = new RvGameTeamAdapter(gameTeamlist,MainActivity.this);


                            myRv2.setAdapter(rvGameTeamAdapter);
                            myRv2.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            myRv2.invalidate();

                            rvGameTeamAdapter.notifyDataSetChanged();

                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("apiresult", error.getMessage() != null ? error.getMessage() : "Unknown error");
                    }
                });

        // Add the request to the RequestQueue.
        Volley.newRequestQueue(this).add(stringRequest);
    }
}