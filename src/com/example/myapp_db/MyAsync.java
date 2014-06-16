package com.example.myapp_db;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Practicant1.ORPO_KRG on 11.06.2014.
 */
public class MyAsync  extends AsyncTask<String, Void, String> {

    Connection connection;
    Context ctx;

    MyAsync (Context ctx){
        this.ctx = ctx;
    }

    // display text "Downloading" before the action takes place
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(ctx, "Donwloading", Toast.LENGTH_SHORT).show();
        MyActivity.progressBar.setVisibility(View.VISIBLE);
    }

    // actual action happens
    // fetches web info according to input urls
    @Override
    protected String doInBackground(String... strings) {
        String result = "";
        for(String url: strings){
            connection = new Connection();
            result = connection.getFrom(url);
        }
        return result;
    }

    //display "Finished" after finishing the action
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Toast.makeText(ctx, "Finished", Toast.LENGTH_SHORT).show();
        MyActivity.progressBar.setVisibility(View.GONE);

        //
        MyActivity.textView.setText(result);
    }
}
