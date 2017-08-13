package com.aishabibiadambek.user.qazaqbyexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Family extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    Button btn1, btn2,btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10,
            btn1p, btn2p,btn3p, btn4p, btn5p, btn6p, btn7p, btn8p, btn9p, btn10p;
    DB db;
    SimpleCursorAdapter scAdapter;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences userInfo = getSharedPreferences("USER_INFO", Context.MODE_PRIVATE);
        username = userInfo.getString("username", null);

        db = new DB(this);
        db.open();

        String[] from = new String[] { db.COLUMN_TXT, db.COLUMN_TXT1 };
        int[] to = new int[]{ R.id.tvMain, R.id.tvSub };

        scAdapter = new SimpleCursorAdapter(this, R.layout.item, null, from, to, 0);

        getSupportLoaderManager().initLoader(0, null, this);

        View view1 = findViewById(R.id.btn1);
        btn1 = (Button) view1.findViewById(R.id.save);
        SharedPreferences sharedPreferences1 = getSharedPreferences("Buttonfm1" + username, Context.MODE_PRIVATE);
        if(sharedPreferences1.getBoolean("Green", false)){
            btn1.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
        }
        if(!sharedPreferences1.getBoolean("Enabled", true)){
            btn1.setEnabled(false);
        }
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String main = ((TextView) findViewById(R.id.tv1)).getText().toString();
                String sub = ((TextView) findViewById(R.id.tv2)).getText().toString();
                db.addRecord(username, main, sub);
                getSupportLoaderManager().getLoader(0).forceLoad();

                btn1.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfm1" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn1.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Family.this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
        });
        btn1p = (Button) view1.findViewById(R.id.progress);
        SharedPreferences sharedPreferences1p = getSharedPreferences("Buttonfm1p" + username, Context.MODE_PRIVATE);
        if(sharedPreferences1p.getBoolean("Green", false)){
            btn1p.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
        }
        if(!sharedPreferences1p.getBoolean("Enabled", true)){
            btn1p.setEnabled(false);
        }
        btn1p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProgress();

                btn1p.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfm1p" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn1p.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Family.this, "Усвоено", Toast.LENGTH_SHORT).show();
            }
        });

        View view2 = findViewById(R.id.btn2);
        btn2 = (Button) view2.findViewById(R.id.save);
        SharedPreferences sharedPreferences2 = getSharedPreferences("Buttonfm2" + username, Context.MODE_PRIVATE);
        if(sharedPreferences2.getBoolean("Green", false)){
            btn2.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
        }
        if(!sharedPreferences2.getBoolean("Enabled", true)){
            btn2.setEnabled(false);
        }
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String main = ((TextView) findViewById(R.id.tv3)).getText().toString();
                String sub = ((TextView) findViewById(R.id.tv4)).getText().toString();
                db.addRecord(username, main, sub);
                getSupportLoaderManager().getLoader(0).forceLoad();

                btn2.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfm2" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn2.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Family.this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
        });
        btn2p = (Button) view2.findViewById(R.id.progress);
        SharedPreferences sharedPreferences2p = getSharedPreferences("Buttonfm2p" + username, Context.MODE_PRIVATE);
        if(sharedPreferences2p.getBoolean("Green", false)){
            btn2p.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
        }
        if(!sharedPreferences2p.getBoolean("Enabled", true)){
            btn2p.setEnabled(false);
        }
        btn2p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProgress();

                btn2p.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfm2p" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn2p.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Family.this, "Усвоено", Toast.LENGTH_SHORT).show();
            }
        });

        View view3 = findViewById(R.id.btn3);
        btn3 = (Button) view3.findViewById(R.id.save);
        SharedPreferences sharedPreferences3 = getSharedPreferences("Buttonfm3" + username, Context.MODE_PRIVATE);
        if(sharedPreferences3.getBoolean("Green", false)){
            btn3.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
        }
        if(!sharedPreferences3.getBoolean("Enabled", true)){
            btn3.setEnabled(false);
        }
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String main = ((TextView) findViewById(R.id.tv5)).getText().toString();
                String sub = ((TextView) findViewById(R.id.tv6)).getText().toString();
                db.addRecord(username, main, sub);
                getSupportLoaderManager().getLoader(0).forceLoad();

                btn3.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfm3" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn3.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Family.this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
        });
        btn3p = (Button) view3.findViewById(R.id.progress);
        SharedPreferences sharedPreferences3p = getSharedPreferences("Buttonfm3p" + username, Context.MODE_PRIVATE);
        if(sharedPreferences3p.getBoolean("Green", false)){
            btn3p.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
        }
        if(!sharedPreferences3p.getBoolean("Enabled", true)){
            btn3p.setEnabled(false);
        }
        btn3p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProgress();

                btn3p.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfm3p" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn3p.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Family.this, "Усвоено", Toast.LENGTH_SHORT).show();
            }
        });

        View view4 = findViewById(R.id.btn4);
        btn4 = (Button) view4.findViewById(R.id.save);
        SharedPreferences sharedPreferences4 = getSharedPreferences("Buttonfm4" + username, Context.MODE_PRIVATE);
        if(sharedPreferences4.getBoolean("Green", false)){
            btn4.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
        }
        if(!sharedPreferences4.getBoolean("Enabled", true)){
            btn4.setEnabled(false);
        }
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String main = ((TextView) findViewById(R.id.tv7)).getText().toString();
                String sub = ((TextView) findViewById(R.id.tv8)).getText().toString();
                db.addRecord(username, main, sub);
                getSupportLoaderManager().getLoader(0).forceLoad();

                btn4.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfm4" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn4.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Family.this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
        });
        btn4p = (Button) view4.findViewById(R.id.progress);
        SharedPreferences sharedPreferences4p = getSharedPreferences("Buttonfm4p" + username, Context.MODE_PRIVATE);
        if(sharedPreferences4p.getBoolean("Green", false)){
            btn4p.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
        }
        if(!sharedPreferences4p.getBoolean("Enabled", true)){
            btn4p.setEnabled(false);
        }
        btn4p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProgress();

                btn4p.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfm4p" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn4p.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Family.this, "Усвоено", Toast.LENGTH_SHORT).show();
            }
        });

        View view5 = findViewById(R.id.btn5);
        btn5 = (Button) view5.findViewById(R.id.save);
        SharedPreferences sharedPreferences5 = getSharedPreferences("Buttonfm5" + username, Context.MODE_PRIVATE);
        if(sharedPreferences5.getBoolean("Green", false)){
            btn5.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
        }
        if(!sharedPreferences5.getBoolean("Enabled", true)){
            btn5.setEnabled(false);
        }
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String main = ((TextView) findViewById(R.id.tv9)).getText().toString();
                String sub = ((TextView) findViewById(R.id.tv10)).getText().toString();
                db.addRecord(username, main, sub);
                getSupportLoaderManager().getLoader(0).forceLoad();

                btn5.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfm5" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn5.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Family.this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
        });
        btn5p = (Button) view5.findViewById(R.id.progress);
        SharedPreferences sharedPreferences5p = getSharedPreferences("Buttonfm5p" + username, Context.MODE_PRIVATE);
        if(sharedPreferences5p.getBoolean("Green", false)){
            btn5p.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
        }
        if(!sharedPreferences5p.getBoolean("Enabled", true)){
            btn5p.setEnabled(false);
        }
        btn5p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProgress();

                btn5p.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfm5p" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn5p.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Family.this, "Усвоено", Toast.LENGTH_SHORT).show();
            }
        });

        View view6 = findViewById(R.id.btn6);
        btn6 = (Button) view6.findViewById(R.id.save);
        SharedPreferences sharedPreferences6 = getSharedPreferences("Buttonfm6" + username, Context.MODE_PRIVATE);
        if(sharedPreferences6.getBoolean("Green", false)){
            btn6.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
        }
        if(!sharedPreferences6.getBoolean("Enabled", true)){
            btn6.setEnabled(false);
        }
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String main = ((TextView) findViewById(R.id.tv11)).getText().toString();
                String sub = ((TextView) findViewById(R.id.tv12)).getText().toString();
                db.addRecord(username, main, sub);
                getSupportLoaderManager().getLoader(0).forceLoad();

                btn6.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfm6" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn6.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Family.this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
        });
        btn6p = (Button) view6.findViewById(R.id.progress);
        SharedPreferences sharedPreferences6p = getSharedPreferences("Buttonfm6p" + username, Context.MODE_PRIVATE);
        if(sharedPreferences6p.getBoolean("Green", false)){
            btn6p.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
        }
        if(!sharedPreferences6p.getBoolean("Enabled", true)){
            btn6p.setEnabled(false);
        }
        btn6p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProgress();

                btn6p.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfm6p" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn6p.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Family.this, "Усвоено", Toast.LENGTH_SHORT).show();
            }
        });

        View view7 = findViewById(R.id.btn7);
        btn7 = (Button) view7.findViewById(R.id.save);
        SharedPreferences sharedPreferences7 = getSharedPreferences("Buttonfm7" + username, Context.MODE_PRIVATE);
        if(sharedPreferences7.getBoolean("Green", false)){
            btn7.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
        }
        if(!sharedPreferences7.getBoolean("Enabled", true)){
            btn7.setEnabled(false);
        }
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String main = ((TextView) findViewById(R.id.tv13)).getText().toString();
                String sub = ((TextView) findViewById(R.id.tv14)).getText().toString();
                db.addRecord(username, main, sub);
                getSupportLoaderManager().getLoader(0).forceLoad();

                btn7.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfm7" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn7.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Family.this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
        });
        btn7p = (Button) view7.findViewById(R.id.progress);
        SharedPreferences sharedPreferences7p = getSharedPreferences("Buttonfm7p" + username, Context.MODE_PRIVATE);
        if(sharedPreferences7p.getBoolean("Green", false)){
            btn7p.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
        }
        if(!sharedPreferences7p.getBoolean("Enabled", true)){
            btn7p.setEnabled(false);
        }
        btn7p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProgress();

                btn7p.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfm7p" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn7p.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Family.this, "Усвоено", Toast.LENGTH_SHORT).show();
            }
        });

        View view8 = findViewById(R.id.btn8);
        btn8 = (Button) view8.findViewById(R.id.save);
        SharedPreferences sharedPreferences8 = getSharedPreferences("Buttonfm8" + username, Context.MODE_PRIVATE);
        if(sharedPreferences8.getBoolean("Green", false)){
            btn8.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
        }
        if(!sharedPreferences8.getBoolean("Enabled", true)){
            btn8.setEnabled(false);
        }
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String main = ((TextView) findViewById(R.id.tv15)).getText().toString();
                String sub = ((TextView) findViewById(R.id.tv16)).getText().toString();
                db.addRecord(username, main, sub);
                getSupportLoaderManager().getLoader(0).forceLoad();

                btn8.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfm8" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn8.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Family.this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
        });
        btn8p = (Button) view8.findViewById(R.id.progress);
        SharedPreferences sharedPreferences8p = getSharedPreferences("Buttonfm8p" + username, Context.MODE_PRIVATE);
        if(sharedPreferences8p.getBoolean("Green", false)){
            btn8p.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
        }
        if(!sharedPreferences8p.getBoolean("Enabled", true)){
            btn8p.setEnabled(false);
        }
        btn8p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProgress();

                btn8p.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfm8p" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn8p.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Family.this, "Усвоено", Toast.LENGTH_SHORT).show();
            }
        });

        View view9 = findViewById(R.id.btn9);
        btn9 = (Button) view9.findViewById(R.id.save);
        SharedPreferences sharedPreferences9 = getSharedPreferences("Buttonfm9" + username, Context.MODE_PRIVATE);
        if(sharedPreferences9.getBoolean("Green", false)){
            btn9.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
        }
        if(!sharedPreferences9.getBoolean("Enabled", true)){
            btn9.setEnabled(false);
        }
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String main = ((TextView) findViewById(R.id.tv17)).getText().toString();
                String sub = ((TextView) findViewById(R.id.tv18)).getText().toString();
                db.addRecord(username, main, sub);
                getSupportLoaderManager().getLoader(0).forceLoad();

                btn9.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfm9" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn9.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Family.this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
        });
        btn9p = (Button) view9.findViewById(R.id.progress);
        SharedPreferences sharedPreferences9p = getSharedPreferences("Buttonfm9p" + username, Context.MODE_PRIVATE);
        if(sharedPreferences9p.getBoolean("Green", false)){
            btn9p.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
        }
        if(!sharedPreferences9p.getBoolean("Enabled", true)){
            btn9p.setEnabled(false);
        }
        btn9p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProgress();

                btn9p.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfm9p" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn9p.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Family.this, "Усвоено", Toast.LENGTH_SHORT).show();
            }
        });

        View view10 = findViewById(R.id.btn10);
        btn10 = (Button) view10.findViewById(R.id.save);
        SharedPreferences sharedPreferences10 = getSharedPreferences("Buttonfm10" + username, Context.MODE_PRIVATE);
        if(sharedPreferences10.getBoolean("Green", false)){
            btn10.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
        }
        if(!sharedPreferences10.getBoolean("Enabled", true)){
            btn10.setEnabled(false);
        }
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String main = ((TextView) findViewById(R.id.tv19)).getText().toString();
                String sub = ((TextView) findViewById(R.id.tv20)).getText().toString();
                db.addRecord(username, main, sub);
                getSupportLoaderManager().getLoader(0).forceLoad();

                btn10.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfm10" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn10.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Family.this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
        });
        btn10p = (Button) view10.findViewById(R.id.progress);
        SharedPreferences sharedPreferences10p = getSharedPreferences("Buttonfm10p" + username, Context.MODE_PRIVATE);
        if(sharedPreferences10p.getBoolean("Green", false)){
            btn10p.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
        }
        if(!sharedPreferences10p.getBoolean("Enabled", true)){
            btn10p.setEnabled(false);
        }
        btn10p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProgress();

                btn10p.setTextColor(ContextCompat.getColor(Family.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfm10p" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn10p.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Family.this, "Усвоено", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void saveProgress(){
        SharedPreferences sharedPreferences = getSharedPreferences("Button" + username, Context.MODE_PRIVATE);
        int score = sharedPreferences.getInt("Progress", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("Progress", score + 10);
        editor.apply();
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
                Intent profile = new Intent(Family.this, UserAccount.class);
                Family.this.startActivity(profile);
                return true;
            case R.id.miSettings:
                Intent settings = new Intent(Family.this, SettingsActivity.class);
                Family.this.startActivity(settings);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new MyCursorLoader(this, db);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        scAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
    }

    static class MyCursorLoader extends CursorLoader {

        DB db;

        public MyCursorLoader(Context context, DB db) {
            super(context);
            this.db = db;
        }

        @Override
        public Cursor loadInBackground(){
            return db.getAllUserData();
        }
    }
}
