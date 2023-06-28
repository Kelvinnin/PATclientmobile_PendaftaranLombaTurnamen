package com.kelvin.pendaftarananroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BracketActivity extends AppCompatActivity {
    private RecyclerView myRv;
    private ArrayList<Bracket> bracketList ;
    private RvBracketAdapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bracket);

        myRv = findViewById(R.id.rvBracket);
        String url = "http://10.0.2.2:7000/bracketIndiv";
        useRv(url);
    }

    protected void useRv(String url){

        bracketList= new ArrayList<>();

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
                                JSONObject bracketData = arr.getJSONObject(i);
                                Bracket listBracket = new Bracket(
                                        bracketData.getString("peserta1"),
                                        bracketData.getString("peserta2"),
                                        bracketData.getString("date"),
                                        bracketData.getString("date")

                                );
                                bracketList.add(listBracket);
                            }
                            rvAdapter = new RvBracketAdapter(bracketList,BracketActivity.this);


                            myRv.setAdapter(rvAdapter);
                            myRv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            myRv.invalidate();

                            rvAdapter.notifyDataSetChanged();

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