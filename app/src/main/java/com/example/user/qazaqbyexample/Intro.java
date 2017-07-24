package com.example.user.qazaqbyexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.miProfile:
                Intent profile = new Intent(Intro.this, UserAccount.class);
                Intro.this.startActivity(profile);
                return true;
            case R.id.miSettings:
                Intent settings = new Intent(Intro.this, SettingsActivity.class);
                Intro.this.startActivity(settings);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClickBtn(View view){
        switch(view.getId()){
            case R.id.save:
                break;
            case R.id.progress:
                break;
            default:
                break;
        }
    }

}
