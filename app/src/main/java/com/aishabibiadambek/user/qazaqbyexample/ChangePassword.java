package com.aishabibiadambek.user.qazaqbyexample;

import android.content.Context;
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

public class ChangePassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final EditText etOldPassword = (EditText) findViewById(R.id.oldPassword);
        final EditText etNewPassword = (EditText) findViewById(R.id.newPassword);
        final EditText etNewPasswordCheck = (EditText) findViewById(R.id.newPasswordCheck);
        final Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final String oldPW = etOldPassword.getText().toString();
                final String newPW = etNewPassword.getText().toString();
                final String newPWch = etNewPasswordCheck.getText().toString();

                SharedPreferences userInfo = getSharedPreferences("USER_INFO", Context.MODE_PRIVATE);
                final String password = userInfo.getString("password", "");
                final String name = userInfo.getString("name", "");
                final String username = userInfo.getString("username", "");

                if (!newPW.equals(newPWch) || !oldPW.equals(password)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ChangePassword.this,
                            R.style.AlertDialogCustom);
                    builder.setTitle("Ошибка")
                            .setMessage("Проверьте правильность введённых данных!")
                            .setNegativeButton("ОК", null)
                            .setIcon(R.drawable.ic_error_white_24dp);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                } else {

                    Response.Listener<String> responseListener = new Response.Listener<String>() {

                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                                if (success) {
                                    SharedPreferences userInfo = getSharedPreferences("USER_INFO", Context.MODE_PRIVATE);
                                    userInfo.edit().putString("password", newPW).apply();

                                    AlertDialog.Builder builder = new AlertDialog.Builder(ChangePassword.this,
                                            R.style.AlertDialogCustom);
                                    builder.setTitle("Поздравляем")
                                            .setMessage("Пароль успешно изменён")
                                            .setNegativeButton("ОК", null)
                                            .setIcon(R.drawable.ic_done_white_24dp);
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();

                                    etOldPassword.setText("");
                                    etNewPassword.setText("");
                                    etNewPasswordCheck.setText("");

                                } else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(ChangePassword.this,
                                            R.style.AlertDialogCustom);
                                    builder.setTitle("Ошибка")
                                            .setMessage("Неизвестная ошибка")
                                            .setNegativeButton("Попробуйте снова", null)
                                            .setIcon(R.drawable.ic_error_white_24dp);
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };

                    ChangePWRequest changePWtRequest = new ChangePWRequest(
                            name, username, newPW, responseListener);

                    RequestQueue queue = Volley.newRequestQueue(ChangePassword.this);
                    queue.add(changePWtRequest);
                }
            }
        });
    }
}
