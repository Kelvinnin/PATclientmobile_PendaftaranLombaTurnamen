package com.kelvin.pendaftarananroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BracketTeamActivity extends AppCompatActivity {
    private RecyclerView myRv;
    private ArrayList<BracketTeam> bracketList ;
    private RvBracketTeamAdapter rvAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bracket_team);
        myRv = findViewById(R.id.rvBracketTeam);
        String url = "http://10.0.2.2:7000/bracketTeamOngoing";
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
                                BracketTeam listBracket = new BracketTeam(
                                        bracketData.getString("team1"),
                                        bracketData.getString("team2"),
                                        bracketData.getString("date"),
                                        bracketData.getString("date")

                                );
                                bracketList.add(listBracket);
                            }
                            rvAdapter = new RvBracketTeamAdapter(bracketList,BracketTeamActivity.this);


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