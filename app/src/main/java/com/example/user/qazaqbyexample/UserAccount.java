package com.example.user.qazaqbyexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class UserAccount extends AppCompatActivity {

    TextView nameTV;
    TextView usernameTV;
    ProgressBar userScorePB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);

        nameTV = (TextView) findViewById(R.id.name);
        usernameTV = (TextView) findViewById(R.id.username);
        userScorePB = (ProgressBar) findViewById(R.id.progressBar);
        userScorePB.setMax(1000);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        displayInfo();

    }

    public void displayInfo(){

        SharedPreferences userInfo = getSharedPreferences("USER_INFO", Context.MODE_PRIVATE);
        String name = userInfo.getString("name", "");
        String username = userInfo.getString("username", "");
        nameTV.setText("  " + name);
        usernameTV.setText("  " + username);

    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.myDict:
                Intent myDict = new Intent(UserAccount.this, MyList.class);
                UserAccount.this.startActivity(myDict);
                break;
            case R.id.changePW:
                Intent changePW = new Intent(UserAccount.this, ChangePassword.class);
                UserAccount.this.startActivity(changePW);
                break;
            case R.id.logOut:
                Intent logout = new Intent(UserAccount.this, MainActivity.class);
                logout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                logout.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                UserAccount.this.startActivity(logout);

                SharedPreferences userInfo = getSharedPreferences("USER_INFO", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = userInfo.edit();
                editor.clear();
                editor.commit();

                finish();
                break;
            default:
                break;
        }
    }
}
