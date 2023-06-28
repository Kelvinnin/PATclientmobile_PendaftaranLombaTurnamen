package com.kelvin.pendaftarananroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

public class RegisterTeamActivity extends AppCompatActivity {
    private ArrayList<Game> listGameKelompok;
    private int idgame ;
    private Button btnDaftar;
    private EditText namaTeam, password;

    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_team);
        listGameKelompok = new ArrayList<>();
        String url= "http://10.0.2.2:7000/GameKelompok";
        spinner=findViewById(R.id.spinner2);
        idgame=-1;
        btnDaftar=findViewById(R.id.btnDaftar);
        namaTeam=findViewById(R.id.txtNamaTeam);
        password=findViewById(R.id.txtPasswordTeam);


spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String selectedItem =adapterView.getItemAtPosition(i).toString();
        for (int j = 0 ;j<listGameKelompok.toArray().length;j++){
            if (listGameKelompok.get(i).getNama_game().equals(selectedItem))
            {
                idgame=listGameKelompok.get(i).getIdgame();
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
});

btnDaftar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        /*Toast.makeText(RegisterTeamActivity.this, "Pinjam Berhasil", Toast.LENGTH_SHORT).show();*/
        String url = "http://10.0.2.2:7000/insertTeam";
        JSONObject object = new JSONObject();
        try {
            object.put("nama_team",namaTeam.getText().toString());
            object.put("password",password.getText().toString());
            object.put("idgame",idgame);
        }catch (JSONException e){
            e.printStackTrace();
        }
        JsonObjectRequest stringRequest = new JsonObjectRequest(
                Request.Method.POST,url,object,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {

                            String msg = response.getString("status");
                         if (msg.equals("200")){
                             Toast.makeText(RegisterTeamActivity.this, "Berhasil daftar", Toast.LENGTH_SHORT).show();
                         }



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
        Volley.newRequestQueue(RegisterTeamActivity.this).add(stringRequest);


    }

});
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
                                JSONObject gameTeam = arr.getJSONObject(i);
                                Game newGame = new Game(
                                        gameTeam.getInt("idgame"),
                                        gameTeam.getString("nama_game")
                                );
                                listGameKelompok.add(newGame);
                            }
                        ArrayList<String> daftarGame = new ArrayList<>();
                            for (Game game:listGameKelompok) {
                                daftarGame.add(game.getNama_game());
                            }
                            ArrayAdapter <String> arrayAdapter =new ArrayAdapter<>(RegisterTeamActivity.this,R.layout.spinneritem,R.id.textView18,daftarGame);
                      spinner.setAdapter(arrayAdapter);

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