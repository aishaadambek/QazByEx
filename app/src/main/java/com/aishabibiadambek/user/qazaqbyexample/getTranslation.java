package com.aishabibiadambek.user.qazaqbyexample;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import dmax.dialog.SpotsDialog;

/**
 * Created by User on 23.08.2017.
 */

public class getTranslation  extends AsyncTask<Void, Void, String> {

    private String input;
    private Context context;
    private Dialog dialog;
    private AlertDialog progressDialog;


    public getTranslation(String input, Context context) {
        this.input = input.toLowerCase();
        this.context = context;
        progressDialog = new SpotsDialog(context, R.style.Custom);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.show();
    }

    protected String doInBackground(Void... urls) {
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
        if (response == null) {
            response = "Упс! Произошла ошибка.";
        }
        progressDialog.dismiss();
        String result = "Перевод";
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
            if(result.length() == 0 || result.equals("Перевод")){
                result = "К сожалению, перевод не найден. Функция перевода требует выделения только основы слова. Попробуйте снова.";
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.custom_dialog);
        TextView content = (TextView) dialog.findViewById(R.id.content);
        Button btnOk = (Button) dialog.findViewById(R.id.btnOk);
        content.setText(result);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}


