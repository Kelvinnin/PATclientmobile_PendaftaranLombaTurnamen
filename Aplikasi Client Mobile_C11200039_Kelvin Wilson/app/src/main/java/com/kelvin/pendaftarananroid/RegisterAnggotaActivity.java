package com.kelvin.pendaftarananroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterAnggotaActivity extends AppCompatActivity {
    private int idgame ;
    private Button btnDaftarAnggota;
    private EditText nama ,tanggal_lahir,no_telfon,nrp,angkatan,alamat,program;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_anggota);

        btnDaftarAnggota=findViewById(R.id.btnDaftarIndiv);
        nama=findViewById(R.id.txtNama);
        tanggal_lahir=findViewById(R.id.txtTanggalLahir);
        no_telfon=findViewById(R.id.txtNoTelfon);
        nrp=findViewById(R.id.txtNRP);
        angkatan=findViewById(R.id.txtAngkatan);
        alamat=findViewById(R.id.txtAlamat);
        program=findViewById(R.id.txtProgramAnggota);

        btnDaftarAnggota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                if (intent!=null){

                }
                String idteam = intent.getStringExtra("idteam");
                /*Toast.makeText(RegisterTeamActivity.this, "Pinjam Berhasil", Toast.LENGTH_SHORT).show();*/
                String url = "http://10.0.2.2:7000/insertPemain_kelompok";
                JSONObject object = new JSONObject();
                try {
                    object.put("nama",nama.getText().toString());
                    object.put("alamat",alamat.getText().toString());
                    object.put("tanggal_lahir",tanggal_lahir.getText().toString());
                    object.put("no_handphone",no_telfon.getText().toString());
                    object.put("nrp",nrp.getText().toString());
                    object.put("program_studi",program.getText().toString());
                    object.put("angkatan",angkatan.getText().toString());
                    object.put("idteam",idteam);
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
                                        Toast.makeText(RegisterAnggotaActivity.this, "Berhasil daftar Anggota", Toast.LENGTH_SHORT).show();
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
                Volley.newRequestQueue(RegisterAnggotaActivity.this).add(stringRequest);


            }

        });
    }
}