package com.example.user.qazaqbyexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Travelling extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{

    Button btn1, btn2,btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10,
            btn1p, btn2p,btn3p, btn4p, btn5p, btn6p, btn7p, btn8p, btn9p, btn10p;
    DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travelling);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences userInfo = getSharedPreferences("USER_INFO", Context.MODE_PRIVATE);
        String username = userInfo.getString("username", null);

        db = new DB(this);
        db.open();

        View view1 = findViewById(R.id.btn1);
        btn1 = (Button) view1.findViewById(R.id.save);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String main = ((TextView) findViewById(R.id.tv1)).getText().toString();
                String sub = ((TextView) findViewById(R.id.tv2)).getText().toString();
                db.addRecord(main, sub);
                getSupportLoaderManager().getLoader(0).forceLoad();
                btn1.setEnabled(false);
                Toast.makeText(Travelling.this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
        });
        btn1p = (Button) view1.findViewById(R.id.progress);

        View view2 = findViewById(R.id.btn2);
        btn2 = (Button) view2.findViewById(R.id.save);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String main = ((TextView) findViewById(R.id.tv3)).getText().toString();
                String sub = ((TextView) findViewById(R.id.tv4)).getText().toString();
                db.addRecord(main, sub);
                getSupportLoaderManager().getLoader(0).forceLoad();
                btn2.setEnabled(false);
                Toast.makeText(Travelling.this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
        });
        btn2p = (Button) view2.findViewById(R.id.progress);

        View view3 = findViewById(R.id.btn3);
        btn3 = (Button) view3.findViewById(R.id.save);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String main = ((TextView) findViewById(R.id.tv5)).getText().toString();
                String sub = ((TextView) findViewById(R.id.tv6)).getText().toString();
                db.addRecord(main, sub);
                getSupportLoaderManager().getLoader(0).forceLoad();
                btn3.setEnabled(false);
                Toast.makeText(Travelling.this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
        });
        btn3p = (Button) view3.findViewById(R.id.progress);

        View view4 = findViewById(R.id.btn4);
        btn4 = (Button) view4.findViewById(R.id.save);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String main = ((TextView) findViewById(R.id.tv7)).getText().toString();
                String sub = ((TextView) findViewById(R.id.tv8)).getText().toString();
                db.addRecord(main, sub);
                getSupportLoaderManager().getLoader(0).forceLoad();
                btn4.setEnabled(false);
                Toast.makeText(Travelling.this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
        });
        btn4p = (Button) view4.findViewById(R.id.progress);

        View view5 = findViewById(R.id.btn5);
        btn5 = (Button) view5.findViewById(R.id.save);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String main = ((TextView) findViewById(R.id.tv9)).getText().toString();
                String sub = ((TextView) findViewById(R.id.tv10)).getText().toString();
                db.addRecord(main, sub);
                getSupportLoaderManager().getLoader(0).forceLoad();
                btn5.setEnabled(false);
                Toast.makeText(Travelling.this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
        });
        btn5p = (Button) view5.findViewById(R.id.progress);

        View view6 = findViewById(R.id.btn6);
        btn6 = (Button) view6.findViewById(R.id.save);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String main = ((TextView) findViewById(R.id.tv11)).getText().toString();
                String sub = ((TextView) findViewById(R.id.tv12)).getText().toString();
                db.addRecord(main, sub);
                getSupportLoaderManager().getLoader(0).forceLoad();
                btn6.setEnabled(false);
                Toast.makeText(Travelling.this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
        });
        btn6p = (Button) view6.findViewById(R.id.progress);
        View view7 = findViewById(R.id.btn7);

        btn7 = (Button) view7.findViewById(R.id.save);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String main = ((TextView) findViewById(R.id.tv13)).getText().toString();
                String sub = ((TextView) findViewById(R.id.tv14)).getText().toString();
                db.addRecord(main, sub);
                getSupportLoaderManager().getLoader(0).forceLoad();
                btn7.setEnabled(false);
                Toast.makeText(Travelling.this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
        });
        btn7p = (Button) view7.findViewById(R.id.progress);

        View view8 = findViewById(R.id.btn8);
        btn8 = (Button) view8.findViewById(R.id.save);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String main = ((TextView) findViewById(R.id.tv15)).getText().toString();
                String sub = ((TextView) findViewById(R.id.tv16)).getText().toString();
                db.addRecord(main, sub);
                getSupportLoaderManager().getLoader(0).forceLoad();
                btn8.setEnabled(false);
                Toast.makeText(Travelling.this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
        });
        btn8p = (Button) view8.findViewById(R.id.progress);

        View view9 = findViewById(R.id.btn9);
        btn9 = (Button) view9.findViewById(R.id.save);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String main = ((TextView) findViewById(R.id.tv17)).getText().toString();
                String sub = ((TextView) findViewById(R.id.tv18)).getText().toString();
                db.addRecord(main, sub);
                getSupportLoaderManager().getLoader(0).forceLoad();
                btn9.setEnabled(false);
                Toast.makeText(Travelling.this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
        });
        btn9p = (Button) view9.findViewById(R.id.progress);

        View view10 = findViewById(R.id.btn10);
        btn10 = (Button) view10.findViewById(R.id.save);
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String main = ((TextView) findViewById(R.id.tv19)).getText().toString();
                String sub = ((TextView) findViewById(R.id.tv20)).getText().toString();
                db.addRecord(main, sub);
                getSupportLoaderManager().getLoader(0).forceLoad();
                btn10.setEnabled(false);
                Toast.makeText(Travelling.this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
        });
        btn10p = (Button) view10.findViewById(R.id.progress);

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
                Intent profile = new Intent(Travelling.this, UserAccount.class);
                Travelling.this.startActivity(profile);
                return true;
            case R.id.miSettings:
                Intent settings = new Intent(Travelling.this, SettingsActivity.class);
                Travelling.this.startActivity(settings);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new MyList.MyCursorLoader(this, db);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
