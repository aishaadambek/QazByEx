package com.aishabibiadambek.user.qazaqbyexample;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by User on 23.08.2017.
 */

public class getTranslation  extends AsyncTask<Void, Void, String> {

    String input;
    Context context;
    ProgressDialog progress;

    public getTranslation(String input, Context context) {
        this.input = input.toLowerCase();
        this.context = context;
    }

    protected void onPreExecute() {
        super.onPreExecute();
        progress = new ProgressDialog(context);
        progress.setMessage("Загрузка");
        progress.show();
    }

    protected String doInBackground(Void... urls) {
        // Do some validation here

        try {
            URL url = new URL("https://glosbe.com/gapi/translate?from=kaz&dest=rus&format=json&phrase=" + input + "&pretty=true");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                return stringBuilder.toString();
            } finally {
                urlConnection.disconnect();
            }
        } catch (Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return null;
        }
    }

    protected void onPostExecute(String response) {
        super.onPostExecute(response);
        progress.dismiss();
        if (response == null) {
            response = "Упс! Произошла ошибка.";
        }
        Log.i("INFO", response);
        String result = "";
        try {
            JSONObject obj = new JSONObject(response);
            JSONArray arr = obj.getJSONArray("tuc");
            String[] entries = new String[arr.length()];
            for (int i = 0; i < arr.length(); i++) {
                entries[i] = arr.getJSONObject(i).getJSONObject("phrase").getString("text");
            }
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < arr.length(); i++) {
                builder.append(entries[i] + "\n");
            }
            result = builder.toString();
            if(result.length() == 0){
                result = "К сожалению, перевод не найден. Функция перевода требует выделения только основы слова. Попробуйте снова";
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context,
                R.style.AlertDialogCustom);
        builder.setTitle("Перевод")
                .setMessage(result)
                .setIcon(R.drawable.ic_search_white_24dp)
                .setPositiveButton("ОК", null)
                .create()
                .show();
    }
}


