package com.example.myapp_db;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by practicant1.orpo_krg on 10.06.2014.
 */
public class Connection {

    HttpClient httpclient;
    HttpGet httpget;
    HttpResponse response;

    // method called to fetch info from th internet
    public String getFrom(String url) {

        String result = "";

        try {
            httpclient = new DefaultHttpClient();
            httpget = new HttpGet(url);
            response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream instream = entity.getContent();
                result = convertStreamToString(instream);
                instream.close();
            } else {
                result = "Nothing came from web";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    // convert input stream into string (still unreadable)
    private static String convertStreamToString(InputStream is){
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while((line=reader.readLine()) != null){
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
