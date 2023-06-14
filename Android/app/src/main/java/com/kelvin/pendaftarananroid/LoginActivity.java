package com.kelvin.pendaftarananroid;

import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import com.android.volley.toolbox.Volley;
public class LoginActivity extends AppCompatActivity {
    EditText username , password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btnLogin = findViewById(R.id.btnLogin);
        EditText edtUsername = findViewById(R.id.txtUsername);
        EditText edtPassword = findViewById(R.id.txtPassword);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                String url = "http://10.0.2.2:7000/loginTeam";
                JSONObject object = new JSONObject();
                try {
                    object.put("nama_team",username);
                    object.put("password",password);
                }catch (JSONException e){
                    e.printStackTrace();
                }
                JsonObjectRequest stringRequest = new JsonObjectRequest(
                        Request.Method.POST,url,object,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    Toast.makeText(LoginActivity.this, response.getString("message"), Toast.LENGTH_SHORT).show();
                                    String msg = response.getString("message");
                                    String idteam = response.getString("idteam").toString();
                                    if (msg.equals("Login successful") ){
                                        Intent intent = new Intent(LoginActivity.this,RegisterAnggotaActivity.class);
                                        intent.putExtra("idteam",idteam);
                                        startActivity(intent);
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
                Volley.newRequestQueue(LoginActivity.this).add(stringRequest);


            }

        });
    }

}
