package com.example.user.qazaqbyexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;

public class ChangePassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final EditText etOldPassword = (EditText) findViewById(R.id.etUsername);
        final EditText etNewPassword = (EditText) findViewById(R.id.etPassword);
        final Button regButton = (Button) findViewById(R.id.buttonReg);
    }
}
