package com.aishabibiadambek.user.qazaqbyexample;

import android.app.SearchManager;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SearchResultsActivity extends AppCompatActivity {

    ListView lvData;
    TextView mTextView;
    DatabaseTable db;
    SimpleCursorAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvData = (ListView) findViewById(R.id.lvData);

        db = new DatabaseTable(this);

        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            showResults(query);
        }
    }

    private void showResults(String query) {

        Cursor cursor = db.getWordMatches(query, null);

        if (cursor == null) {
            Toast.makeText(this, "Ничего не найдено", Toast.LENGTH_LONG).show();
        } else {
            String[] from = new String[] { db.COL_KZ, db.COL_RUS};
            int[] to = new int[]{ R.id.tvMain, R.id.tvSub };

            mAdapter = new SimpleCursorAdapter(this, R.layout.item, cursor, from, to, 0);
            lvData.setAdapter(mAdapter);
        }
    }

}
