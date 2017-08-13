package com.aishabibiadambek.user.qazaqbyexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername;
    EditText etPassword;
    Button logButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login2);

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            etUsername = (EditText) findViewById(R.id.etUsername);
            etPassword = (EditText) findViewById(R.id.etPassword);
            logButton = (Button) findViewById(R.id.buttonLogin);

            logButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final String username = etUsername.getText().toString();
                    final String password = etPassword.getText().toString();

                    Response.Listener<String> listener = new Response.Listener<String>() {

                        @Override
                        public void onResponse(String response) {

                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                                if (success) {
                                    String name = jsonResponse.getString("name");

                                    SharedPreferences userInfo = getSharedPreferences("USER_INFO", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = userInfo.edit();
                                    editor.putString("name", name);
                                    editor.putString("username", username);
                                    editor.putString("password", password);
                                    editor.apply();

                                    Intent intent = new Intent(LoginActivity.this, UserAreaActivity.class);
                                    LoginActivity.this.startActivity(intent);

                                    finish();
                                } else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this,
                                            R.style.AlertDialogCustom);
                                    builder.setTitle("Ошибка")
                                            .setMessage("Неверный логин или пароль")
                                            .setNegativeButton("Попробуйте снова", null)
                                            .setIcon(R.drawable.ic_error_white_24dp)
                                            .create()
                                            .show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    };

                    LoginRequest loginRequest = new LoginRequest(username, password, listener);
                    RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                    queue.add(loginRequest);

                }
            });
        }
}
