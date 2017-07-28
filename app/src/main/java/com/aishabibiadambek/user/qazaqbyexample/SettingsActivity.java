package com.aishaadambek.user.qazaqbyexample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.aboutUs:
                Intent aboutUs = new Intent(SettingsActivity.this, AboutUs.class);
                startActivity(aboutUs);
                break;
            case R.id.rateUs:
                Intent rateUs = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + this.getPackageName()));
                SettingsActivity.this.startActivity(rateUs);
                break;
            case R.id.share:
                String shareBody = "Попробуй новое приложение - Qazaq by Example. Подтянешь разговорный казахский!";
                Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Qazaq by Example");
                shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(shareIntent, "Поделиться"));
                break;
        }
    }
}
