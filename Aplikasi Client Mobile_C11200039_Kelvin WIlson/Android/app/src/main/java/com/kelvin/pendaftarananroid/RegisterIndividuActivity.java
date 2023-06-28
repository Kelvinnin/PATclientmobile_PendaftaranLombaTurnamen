package com.kelvin.pendaftarananroid;

import androidx.appcompat.app.AppCompatActivity;

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

public class RegisterIndividuActivity extends AppCompatActivity {
    private ArrayList<Game> listGameIndividu;
    private int idgame ;
    private Button btnDaftarIndiv;
    private EditText nama ,tanggal_lahir,no_telfon,nrp,angkatan,alamat,program;
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_individu);

        listGameIndividu = new ArrayList<>();
        String url= "http://10.0.2.2:7000/GameIndividu";
        spinner=findViewById(R.id.spinner);
        idgame=-1;
        btnDaftarIndiv=findViewById(R.id.btnDaftarIndiv);
        nama=findViewById(R.id.txtNama);
        tanggal_lahir=findViewById(R.id.txtTanggalLahir);
        no_telfon=findViewById(R.id.txtNoTelfon);
        nrp=findViewById(R.id.txtNRP);
        angkatan=findViewById(R.id.txtAngkatan);
        alamat=findViewById(R.id.txtAlamat);
        program=findViewById(R.id.txtProgram);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem =adapterView.getItemAtPosition(i).toString();
                for (int j = 0 ;j<listGameIndividu.toArray().length;j++){
                    if (listGameIndividu.get(i).getNama_game().equals(selectedItem))
                    {
                        idgame=listGameIndividu.get(i).getIdgame();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnDaftarIndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Toast.makeText(RegisterTeamActivity.this, "Pinjam Berhasil", Toast.LENGTH_SHORT).show();*/
                String url = "http://10.0.2.2:7000/insertPemain_individu";
                JSONObject object = new JSONObject();
                try {
                    object.put("nama",nama.getText().toString());
                    object.put("alamat",alamat.getText().toString());
                    object.put("tanggal_lahir",tanggal_lahir.getText().toString());
                    object.put("no_handphone",no_telfon.getText().toString());
                    object.put("nrp",nrp.getText().toString());
                    object.put("program_studi",program.getText().toString());
                    object.put("angkatan",angkatan.getText().toString());
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
                                        Toast.makeText(RegisterIndividuActivity.this, "Berhasil daftar", Toast.LENGTH_SHORT).show();
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
                Volley.newRequestQueue(RegisterIndividuActivity.this).add(stringRequest);


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
                                listGameIndividu.add(newGame);
                            }
                            ArrayList<String> daftarGame = new ArrayList<>();
                            for (Game game:listGameIndividu) {
                                daftarGame.add(game.getNama_game());
                            }
                            ArrayAdapter<String> arrayAdapter =new ArrayAdapter<>(RegisterIndividuActivity.this,R.layout.spinneritem,R.id.textView18,daftarGame);
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

