package com.aishabibiadambek.user.qazaqbyexample;

import android.app.Dialog;
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
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Friends extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    Button btn1, btn2,btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10,
            btn1p, btn2p,btn3p, btn4p, btn5p, btn6p, btn7p, btn8p, btn9p, btn10p;
    DB db;
    SimpleCursorAdapter scAdapter;
    String username;
    private static final int DEFINITION = 1;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        if(getSharedPreferences("INSTR", Context.MODE_PRIVATE).getBoolean("shown", false)){
            //do nothing
        } else {
            getSharedPreferences("INSTR", Context.MODE_PRIVATE).edit().putBoolean("shown", true).apply();
            dialog = new Dialog(Friends.this);
            dialog.setContentView(R.layout.instruction);
            Button btnOk = (Button) dialog.findViewById(R.id.btnOk);
            btnOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        }

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
        SharedPreferences sharedPreferences1 = getSharedPreferences("Buttonfr1" + username, Context.MODE_PRIVATE);
        if(sharedPreferences1.getBoolean("Green", false)){
            btn1.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
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

                btn1.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfr1" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn1.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Friends.this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
        });
        btn1p = (Button) view1.findViewById(R.id.progress);
        SharedPreferences sharedPreferences1p = getSharedPreferences("Buttonfr1p" + username, Context.MODE_PRIVATE);
        if(sharedPreferences1p.getBoolean("Green", false)){
            btn1p.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
        }
        if(!sharedPreferences1p.getBoolean("Enabled", true)){
            btn1p.setEnabled(false);
        }
        btn1p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProgress();

                btn1p.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfr1p" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn1p.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Friends.this, "Усвоено", Toast.LENGTH_SHORT).show();
            }
        });

        View view2 = findViewById(R.id.btn2);
        btn2 = (Button) view2.findViewById(R.id.save);
        SharedPreferences sharedPreferences2 = getSharedPreferences("Buttonfr2" + username, Context.MODE_PRIVATE);
        if(sharedPreferences2.getBoolean("Green", false)){
            btn2.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
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

                btn2.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfr2" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn2.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Friends.this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
        });
        btn2p = (Button) view2.findViewById(R.id.progress);
        SharedPreferences sharedPreferences2p = getSharedPreferences("Buttonfr2p" + username, Context.MODE_PRIVATE);
        if(sharedPreferences2p.getBoolean("Green", false)){
            btn2p.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
        }
        if(!sharedPreferences2p.getBoolean("Enabled", true)){
            btn2p.setEnabled(false);
        }
        btn2p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProgress();

                btn2p.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfr2p" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn2p.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Friends.this, "Усвоено", Toast.LENGTH_SHORT).show();
            }
        });

        View view3 = findViewById(R.id.btn3);
        btn3 = (Button) view3.findViewById(R.id.save);
        SharedPreferences sharedPreferences3 = getSharedPreferences("Buttonfr3" + username, Context.MODE_PRIVATE);
        if(sharedPreferences3.getBoolean("Green", false)){
            btn3.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
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

                btn3.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfr3" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn3.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Friends.this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
        });
        btn3p = (Button) view3.findViewById(R.id.progress);
        SharedPreferences sharedPreferences3p = getSharedPreferences("Buttonfr3p" + username, Context.MODE_PRIVATE);
        if(sharedPreferences3p.getBoolean("Green", false)){
            btn3p.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
        }
        if(!sharedPreferences3p.getBoolean("Enabled", true)){
            btn3p.setEnabled(false);
        }
        btn3p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProgress();

                btn3p.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfr3p" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn3p.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Friends.this, "Усвоено", Toast.LENGTH_SHORT).show();
            }
        });

        View view4 = findViewById(R.id.btn4);
        btn4 = (Button) view4.findViewById(R.id.save);
        SharedPreferences sharedPreferences4 = getSharedPreferences("Buttonfr4" + username, Context.MODE_PRIVATE);
        if(sharedPreferences4.getBoolean("Green", false)){
            btn4.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
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

                btn4.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfr4" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn4.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Friends.this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
        });
        btn4p = (Button) view4.findViewById(R.id.progress);
        SharedPreferences sharedPreferences4p = getSharedPreferences("Buttonfr4p" + username, Context.MODE_PRIVATE);
        if(sharedPreferences4p.getBoolean("Green", false)){
            btn4p.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
        }
        if(!sharedPreferences4p.getBoolean("Enabled", true)){
            btn4p.setEnabled(false);
        }
        btn4p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProgress();

                btn4p.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfr4p" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn4p.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Friends.this, "Усвоено", Toast.LENGTH_SHORT).show();
            }
        });

        View view5 = findViewById(R.id.btn5);
        btn5 = (Button) view5.findViewById(R.id.save);
        SharedPreferences sharedPreferences5 = getSharedPreferences("Buttonfr5" + username, Context.MODE_PRIVATE);
        if(sharedPreferences5.getBoolean("Green", false)){
            btn5.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
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

                btn5.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfr5" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn5.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Friends.this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
        });
        btn5p = (Button) view5.findViewById(R.id.progress);
        SharedPreferences sharedPreferences5p = getSharedPreferences("Buttonfr5p" + username, Context.MODE_PRIVATE);
        if(sharedPreferences5p.getBoolean("Green", false)){
            btn5p.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
        }
        if(!sharedPreferences5p.getBoolean("Enabled", true)){
            btn5p.setEnabled(false);
        }
        btn5p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProgress();

                btn5p.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfr5p" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn5p.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Friends.this, "Усвоено", Toast.LENGTH_SHORT).show();
            }
        });

        View view6 = findViewById(R.id.btn6);
        btn6 = (Button) view6.findViewById(R.id.save);
        SharedPreferences sharedPreferences6 = getSharedPreferences("Buttonfr6" + username, Context.MODE_PRIVATE);
        if(sharedPreferences6.getBoolean("Green", false)){
            btn6.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
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

                btn6.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfr6" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn6.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Friends.this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
        });
        btn6p = (Button) view6.findViewById(R.id.progress);
        SharedPreferences sharedPreferences6p = getSharedPreferences("Buttonfr6p" + username, Context.MODE_PRIVATE);
        if(sharedPreferences6p.getBoolean("Green", false)){
            btn6p.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
        }
        if(!sharedPreferences6p.getBoolean("Enabled", true)){
            btn6p.setEnabled(false);
        }
        btn6p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProgress();

                btn6p.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfr6p" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn6p.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Friends.this, "Усвоено", Toast.LENGTH_SHORT).show();
            }
        });

        View view7 = findViewById(R.id.btn7);
        btn7 = (Button) view7.findViewById(R.id.save);
        SharedPreferences sharedPreferences7 = getSharedPreferences("Buttonfr7" + username, Context.MODE_PRIVATE);
        if(sharedPreferences7.getBoolean("Green", false)){
            btn7.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
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

                btn7.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfr7" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn7.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Friends.this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
        });
        btn7p = (Button) view7.findViewById(R.id.progress);
        SharedPreferences sharedPreferences7p = getSharedPreferences("Buttonfr7p" + username, Context.MODE_PRIVATE);
        if(sharedPreferences7p.getBoolean("Green", false)){
            btn7p.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
        }
        if(!sharedPreferences7p.getBoolean("Enabled", true)){
            btn7p.setEnabled(false);
        }
        btn7p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProgress();

                btn7p.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfr7p" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn7p.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Friends.this, "Усвоено", Toast.LENGTH_SHORT).show();
            }
        });

        View view8 = findViewById(R.id.btn8);
        btn8 = (Button) view8.findViewById(R.id.save);
        SharedPreferences sharedPreferences8 = getSharedPreferences("Buttonfr8" + username, Context.MODE_PRIVATE);
        if(sharedPreferences8.getBoolean("Green", false)){
            btn8.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
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

                btn8.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfr8" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn8.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Friends.this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
        });
        btn8p = (Button) view8.findViewById(R.id.progress);
        SharedPreferences sharedPreferences8p = getSharedPreferences("Buttonfr8p" + username, Context.MODE_PRIVATE);
        if(sharedPreferences8p.getBoolean("Green", false)){
            btn8p.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
        }
        if(!sharedPreferences8p.getBoolean("Enabled", true)){
            btn8p.setEnabled(false);
        }
        btn8p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProgress();

                btn8p.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfr8p" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn8p.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Friends.this, "Усвоено", Toast.LENGTH_SHORT).show();
            }
        });

        View view9 = findViewById(R.id.btn9);
        btn9 = (Button) view9.findViewById(R.id.save);
        SharedPreferences sharedPreferences9 = getSharedPreferences("Buttonfr9" + username, Context.MODE_PRIVATE);
        if(sharedPreferences9.getBoolean("Green", false)){
            btn9.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
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

                btn9.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfr9" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn9.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Friends.this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
        });
        btn9p = (Button) view9.findViewById(R.id.progress);
        SharedPreferences sharedPreferences9p = getSharedPreferences("Buttonfr9p" + username, Context.MODE_PRIVATE);
        if(sharedPreferences9p.getBoolean("Green", false)){
            btn9p.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
        }
        if(!sharedPreferences9p.getBoolean("Enabled", true)){
            btn9p.setEnabled(false);
        }
        btn9p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProgress();

                btn9p.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfr9p" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn9p.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Friends.this, "Усвоено", Toast.LENGTH_SHORT).show();
            }
        });

        View view10 = findViewById(R.id.btn10);
        btn10 = (Button) view10.findViewById(R.id.save);
        SharedPreferences sharedPreferences10 = getSharedPreferences("Buttonfr10" + username, Context.MODE_PRIVATE);
        if(sharedPreferences10.getBoolean("Green", false)){
            btn10.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
        }
        if(!sharedPreferences1.getBoolean("Enabled", true)){
            btn10.setEnabled(false);
        }
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String main = ((TextView) findViewById(R.id.tv19)).getText().toString();
                String sub = ((TextView) findViewById(R.id.tv20)).getText().toString();
                db.addRecord(username, main, sub);
                getSupportLoaderManager().getLoader(0).forceLoad();

                btn10.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfr10" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn10.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Friends.this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
        });
        btn10p = (Button) view10.findViewById(R.id.progress);
        SharedPreferences sharedPreferences10p = getSharedPreferences("Buttonfr10p" + username, Context.MODE_PRIVATE);
        if(sharedPreferences10p.getBoolean("Green", false)){
            btn10p.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
        }
        if(!sharedPreferences10p.getBoolean("Enabled", true)){
            btn10p.setEnabled(false);
        }
        btn10p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProgress();

                btn10p.setTextColor(ContextCompat.getColor(Friends.this, R.color.green));
                SharedPreferences sharedPreferences = getSharedPreferences("Buttonfr10p" + username, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("Green", true).apply();

                btn10p.setEnabled(false);
                sharedPreferences.edit().putBoolean("Enabled", false).apply();

                Toast.makeText(Friends.this, "Усвоено", Toast.LENGTH_SHORT).show();
            }
        });

        final TextView tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                menu.removeItem(android.R.id.selectAll); // Remove the "select all" option
                menu.removeItem(android.R.id.cut); // Remove the "cut" option
                menu.removeItem(android.R.id.copy); // Remove the "copy all" option
                return true;
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                menu.add(Menu.NONE, DEFINITION, Menu.NONE, "Перевести"); // Called when action mode is first created. The menu supplied will be used to generate action buttons for the action mode
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // Called when an action mode is about to be exited and destroyed
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case DEFINITION:
                        int min = 0;
                        int max = tv1.getText().length();
                        if (tv1.isFocused()) {
                            final int selStart = tv1.getSelectionStart();
                            final int selEnd = tv1.getSelectionEnd();

                            min = Math.max(0, Math.min(selStart, selEnd));
                            max = Math.max(0, Math.max(selStart, selEnd));
                        }
                        // Perform your definition lookup with the selected text
                        final CharSequence selectedText = tv1.getText().subSequence(min, max);
                        final String input = selectedText.toString();

                        new getTranslation(input, Friends.this).execute(null, null, null);

                        // Finish and close the ActionMode
                        mode.finish();
                        return true;
                    default:
                        break;
                }
                return false;
            }

        });

        final TextView tv3 = (TextView) findViewById(R.id.tv3);
        tv3.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                menu.removeItem(android.R.id.selectAll); // Remove the "select all" option
                menu.removeItem(android.R.id.cut); // Remove the "cut" option
                menu.removeItem(android.R.id.copy); // Remove the "copy all" option
                return true;
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                menu.add(Menu.NONE, DEFINITION, Menu.NONE, "Перевести"); // Called when action mode is first created. The menu supplied will be used to generate action buttons for the action mode
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // Called when an action mode is about to be exited and destroyed
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case DEFINITION:
                        int min = 0;
                        int max = tv3.getText().length();
                        if (tv3.isFocused()) {
                            final int selStart = tv3.getSelectionStart();
                            final int selEnd = tv3.getSelectionEnd();

                            min = Math.max(0, Math.min(selStart, selEnd));
                            max = Math.max(0, Math.max(selStart, selEnd));
                        }
                        // Perform your definition lookup with the selected text
                        final CharSequence selectedText = tv3.getText().subSequence(min, max);
                        final String input = selectedText.toString();

                        new getTranslation(input, Friends.this).execute(null, null, null);

                        // Finish and close the ActionMode
                        mode.finish();
                        return true;
                    default:
                        break;
                }
                return false;
            }

        });

        final TextView tv5 = (TextView) findViewById(R.id.tv5);
        tv5.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                menu.removeItem(android.R.id.selectAll); // Remove the "select all" option
                menu.removeItem(android.R.id.cut); // Remove the "cut" option
                menu.removeItem(android.R.id.copy); // Remove the "copy all" option
                return true;
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                menu.add(Menu.NONE, DEFINITION, Menu.NONE, "Перевести"); // Called when action mode is first created. The menu supplied will be used to generate action buttons for the action mode
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // Called when an action mode is about to be exited and destroyed
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case DEFINITION:
                        int min = 0;
                        int max = tv5.getText().length();
                        if (tv5.isFocused()) {
                            final int selStart = tv5.getSelectionStart();
                            final int selEnd = tv5.getSelectionEnd();

                            min = Math.max(0, Math.min(selStart, selEnd));
                            max = Math.max(0, Math.max(selStart, selEnd));
                        }
                        // Perform your definition lookup with the selected text
                        final CharSequence selectedText = tv5.getText().subSequence(min, max);
                        final String input = selectedText.toString();

                        new getTranslation(input, Friends.this).execute(null, null, null);

                        // Finish and close the ActionMode
                        mode.finish();
                        return true;
                    default:
                        break;
                }
                return false;
            }

        });

        final TextView tv7 = (TextView) findViewById(R.id.tv7);
        tv7.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                menu.removeItem(android.R.id.selectAll); // Remove the "select all" option
                menu.removeItem(android.R.id.cut); // Remove the "cut" option
                menu.removeItem(android.R.id.copy); // Remove the "copy all" option
                return true;
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                menu.add(Menu.NONE, DEFINITION, Menu.NONE, "Перевести"); // Called when action mode is first created. The menu supplied will be used to generate action buttons for the action mode
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // Called when an action mode is about to be exited and destroyed
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case DEFINITION:
                        int min = 0;
                        int max = tv7.getText().length();
                        if (tv7.isFocused()) {
                            final int selStart = tv7.getSelectionStart();
                            final int selEnd = tv7.getSelectionEnd();

                            min = Math.max(0, Math.min(selStart, selEnd));
                            max = Math.max(0, Math.max(selStart, selEnd));
                        }
                        // Perform your definition lookup with the selected text
                        final CharSequence selectedText = tv7.getText().subSequence(min, max);
                        final String input = selectedText.toString();

                        new getTranslation(input, Friends.this).execute(null, null, null);

                        // Finish and close the ActionMode
                        mode.finish();
                        return true;
                    default:
                        break;
                }
                return false;
            }

        });

        final TextView tv9 = (TextView) findViewById(R.id.tv9);
        tv9.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                menu.removeItem(android.R.id.selectAll); // Remove the "select all" option
                menu.removeItem(android.R.id.cut); // Remove the "cut" option
                menu.removeItem(android.R.id.copy); // Remove the "copy all" option
                return true;
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                menu.add(Menu.NONE, DEFINITION, Menu.NONE, "Перевести"); // Called when action mode is first created. The menu supplied will be used to generate action buttons for the action mode
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // Called when an action mode is about to be exited and destroyed
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case DEFINITION:
                        int min = 0;
                        int max = tv9.getText().length();
                        if (tv9.isFocused()) {
                            final int selStart = tv9.getSelectionStart();
                            final int selEnd = tv9.getSelectionEnd();

                            min = Math.max(0, Math.min(selStart, selEnd));
                            max = Math.max(0, Math.max(selStart, selEnd));
                        }
                        // Perform your definition lookup with the selected text
                        final CharSequence selectedText = tv9.getText().subSequence(min, max);
                        final String input = selectedText.toString();

                        new getTranslation(input, Friends.this).execute(null, null, null);

                        // Finish and close the ActionMode
                        mode.finish();
                        return true;
                    default:
                        break;
                }
                return false;
            }

        });

        final TextView tv11 = (TextView) findViewById(R.id.tv11);
        tv11.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                menu.removeItem(android.R.id.selectAll); // Remove the "select all" option
                menu.removeItem(android.R.id.cut); // Remove the "cut" option
                menu.removeItem(android.R.id.copy); // Remove the "copy all" option
                return true;
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                menu.add(Menu.NONE, DEFINITION, Menu.NONE, "Перевести"); // Called when action mode is first created. The menu supplied will be used to generate action buttons for the action mode
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // Called when an action mode is about to be exited and destroyed
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case DEFINITION:
                        int min = 0;
                        int max = tv11.getText().length();
                        if (tv11.isFocused()) {
                            final int selStart = tv11.getSelectionStart();
                            final int selEnd = tv11.getSelectionEnd();

                            min = Math.max(0, Math.min(selStart, selEnd));
                            max = Math.max(0, Math.max(selStart, selEnd));
                        }
                        // Perform your definition lookup with the selected text
                        final CharSequence selectedText = tv11.getText().subSequence(min, max);
                        final String input = selectedText.toString();

                        new getTranslation(input, Friends.this).execute(null, null, null);

                        // Finish and close the ActionMode
                        mode.finish();
                        return true;
                    default:
                        break;
                }
                return false;
            }

        });

        final TextView tv13 = (TextView) findViewById(R.id.tv13);
        tv13.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                menu.removeItem(android.R.id.selectAll); // Remove the "select all" option
                menu.removeItem(android.R.id.cut); // Remove the "cut" option
                menu.removeItem(android.R.id.copy); // Remove the "copy all" option
                return true;
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                menu.add(Menu.NONE, DEFINITION, Menu.NONE, "Перевести"); // Called when action mode is first created. The menu supplied will be used to generate action buttons for the action mode
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // Called when an action mode is about to be exited and destroyed
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case DEFINITION:
                        int min = 0;
                        int max = tv13.getText().length();
                        if (tv13.isFocused()) {
                            final int selStart = tv13.getSelectionStart();
                            final int selEnd = tv13.getSelectionEnd();

                            min = Math.max(0, Math.min(selStart, selEnd));
                            max = Math.max(0, Math.max(selStart, selEnd));
                        }
                        // Perform your definition lookup with the selected text
                        final CharSequence selectedText = tv13.getText().subSequence(min, max);
                        final String input = selectedText.toString();

                        new getTranslation(input, Friends.this).execute(null, null, null);

                        // Finish and close the ActionMode
                        mode.finish();
                        return true;
                    default:
                        break;
                }
                return false;
            }

        });

        final TextView tv15 = (TextView) findViewById(R.id.tv15);
        tv15.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                menu.removeItem(android.R.id.selectAll); // Remove the "select all" option
                menu.removeItem(android.R.id.cut); // Remove the "cut" option
                menu.removeItem(android.R.id.copy); // Remove the "copy all" option
                return true;
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                menu.add(Menu.NONE, DEFINITION, Menu.NONE, "Перевести"); // Called when action mode is first created. The menu supplied will be used to generate action buttons for the action mode
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // Called when an action mode is about to be exited and destroyed
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case DEFINITION:
                        int min = 0;
                        int max = tv15.getText().length();
                        if (tv15.isFocused()) {
                            final int selStart = tv15.getSelectionStart();
                            final int selEnd = tv15.getSelectionEnd();

                            min = Math.max(0, Math.min(selStart, selEnd));
                            max = Math.max(0, Math.max(selStart, selEnd));
                        }
                        // Perform your definition lookup with the selected text
                        final CharSequence selectedText = tv15.getText().subSequence(min, max);
                        final String input = selectedText.toString();

                        new getTranslation(input, Friends.this).execute(null, null, null);

                        // Finish and close the ActionMode
                        mode.finish();
                        return true;
                    default:
                        break;
                }
                return false;
            }

        });

        final TextView tv17 = (TextView) findViewById(R.id.tv17);
        tv17.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                menu.removeItem(android.R.id.selectAll); // Remove the "select all" option
                menu.removeItem(android.R.id.cut); // Remove the "cut" option
                menu.removeItem(android.R.id.copy); // Remove the "copy all" option
                return true;
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                menu.add(Menu.NONE, DEFINITION, Menu.NONE, "Перевести"); // Called when action mode is first created. The menu supplied will be used to generate action buttons for the action mode
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // Called when an action mode is about to be exited and destroyed
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case DEFINITION:
                        int min = 0;
                        int max = tv17.getText().length();
                        if (tv17.isFocused()) {
                            final int selStart = tv17.getSelectionStart();
                            final int selEnd = tv17.getSelectionEnd();

                            min = Math.max(0, Math.min(selStart, selEnd));
                            max = Math.max(0, Math.max(selStart, selEnd));
                        }
                        // Perform your definition lookup with the selected text
                        final CharSequence selectedText = tv17.getText().subSequence(min, max);
                        final String input = selectedText.toString();

                        new getTranslation(input, Friends.this).execute(null, null, null);

                        // Finish and close the ActionMode
                        mode.finish();
                        return true;
                    default:
                        break;
                }
                return false;
            }

        });

        final TextView tv19 = (TextView) findViewById(R.id.tv19);
        tv19.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                menu.removeItem(android.R.id.selectAll); // Remove the "select all" option
                menu.removeItem(android.R.id.cut); // Remove the "cut" option
                menu.removeItem(android.R.id.copy); // Remove the "copy all" option
                return true;
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                menu.add(Menu.NONE, DEFINITION, Menu.NONE, "Перевести"); // Called when action mode is first created. The menu supplied will be used to generate action buttons for the action mode
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // Called when an action mode is about to be exited and destroyed
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case DEFINITION:
                        int min = 0;
                        int max = tv19.getText().length();
                        if (tv19.isFocused()) {
                            final int selStart = tv19.getSelectionStart();
                            final int selEnd = tv19.getSelectionEnd();

                            min = Math.max(0, Math.min(selStart, selEnd));
                            max = Math.max(0, Math.max(selStart, selEnd));
                        }
                        // Perform your definition lookup with the selected text
                        final CharSequence selectedText = tv19.getText().subSequence(min, max);
                        final String input = selectedText.toString();

                        new getTranslation(input, Friends.this).execute(null, null, null);

                        // Finish and close the ActionMode
                        mode.finish();
                        return true;
                    default:
                        break;
                }
                return false;
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
                Intent profile = new Intent(Friends.this, UserAccount.class);
                Friends.this.startActivity(profile);
                return true;
            case R.id.miSettings:
                Intent settings = new Intent(Friends.this, SettingsActivity.class);
                Friends.this.startActivity(settings);
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
