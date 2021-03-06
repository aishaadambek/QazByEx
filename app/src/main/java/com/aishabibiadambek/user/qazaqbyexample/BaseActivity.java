package com.aishabibiadambek.user.qazaqbyexample;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(getSharedPreferences("USER_INFO", Context.MODE_PRIVATE).getString("username", "").length() == 0){
            Intent intent = new Intent(BaseActivity.this, MainActivity.class);
            BaseActivity.this.startActivity(intent);
            finish();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    public void onBackPressed() {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);

        EditText searchEditText = (EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        searchEditText.setTextColor(ContextCompat.getColor(BaseActivity.this, R.color.textDefault));
        searchEditText.setHintTextColor(ContextCompat.getColor(BaseActivity.this, R.color.textDefault));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.miSettings:
                Intent settings = new Intent(BaseActivity.this, SettingsActivity.class);
                BaseActivity.this.startActivity(settings);
                return true;
            case R.id.miProfile:
                Intent profile = new Intent(BaseActivity.this, UserAccount.class);
                BaseActivity.this.startActivity(profile);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClickImg(View v){
        switch(v.getId()){
            case R.id.cafe:
                Intent cafe = new Intent(BaseActivity.this, Cafe.class);
                BaseActivity.this.startActivity(cafe);
                break;
            case R.id.city:
                Intent city = new Intent(BaseActivity.this, City.class);
                BaseActivity.this.startActivity(city);
                break;
            case R.id.doctors:
                Intent doctors = new Intent(BaseActivity.this, Doctors.class);
                BaseActivity.this.startActivity(doctors);
                break;
            case R.id.family:
                Intent family = new Intent(BaseActivity.this, Family.class);
                BaseActivity.this.startActivity(family);
                break;
            case R.id.food:
                Intent food = new Intent(BaseActivity.this, Food.class);
                BaseActivity.this.startActivity(food);
                break;
            case R.id.friendship:
                Intent friends = new Intent(BaseActivity.this, Friends.class);
                BaseActivity.this.startActivity(friends);
                break;
            case R.id.intrYourself:
                Intent intro = new Intent(BaseActivity.this, Intro.class);
                BaseActivity.this.startActivity(intro);
                break;
            case R.id.school:
                Intent school = new Intent(BaseActivity.this, School.class);
                BaseActivity.this.startActivity(school);
                break;
            case R.id.shopping:
                Intent shopping = new Intent(BaseActivity.this, Shopping.class);
                BaseActivity.this.startActivity(shopping);
                break;
            case R.id.travelling:
                Intent travelling = new Intent(BaseActivity.this, Travelling.class);
                BaseActivity.this.startActivity(travelling);
                break;
        }
    }


}
