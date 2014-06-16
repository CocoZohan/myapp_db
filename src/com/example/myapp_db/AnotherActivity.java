package com.example.myapp_db;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Practicant1.ORPO_KRG on 12.06.2014.
 */
public class AnotherActivity extends Activity implements View.OnClickListener{

    TextView textviewUrl1, textviewUrl2, textviewUrl3;
    EditText edittextUrl1, edittextUrl2, edittextUrl3;
    Button btnSave, btnCancel;
    SharedPrefs sharedPrefs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another_activity);

        sharedPrefs = new SharedPrefs();

        textviewUrl1 = (TextView)findViewById(R.id.tvurl1);
        textviewUrl2 = (TextView)findViewById(R.id.tvurl2);
        textviewUrl3 = (TextView)findViewById(R.id.tvurl3);

        edittextUrl1 = (EditText)findViewById(R.id.eturl1);
        edittextUrl2 = (EditText)findViewById(R.id.eturl2);
        edittextUrl3 = (EditText)findViewById(R.id.eturl3);

        btnSave = (Button)findViewById(R.id.btnsave);
        btnCancel = (Button)findViewById(R.id.btncancel);

        btnSave.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        // it there are saved urls, they are displayed in the edittexts
        loadUrls();
    }

    // save button is clicked to save urls written in edittexts
    // cancel button is clicked to leave the activity without changing url addresses
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnsave:
                saveUrls();
                onBackPressed();
                break;
            case R.id.btncancel:
                onBackPressed();
                break;
        }
    }

    // save urls written in the edittexts
    private void saveUrls(){
        sharedPrefs.setMyStringPref(this, "url1", edittextUrl1.getText().toString());
        sharedPrefs.setMyStringPref(this, "url2", edittextUrl2.getText().toString());
        sharedPrefs.setMyStringPref(this, "url3", edittextUrl3.getText().toString());
    }

    // display urls in the edittexts
    public void loadUrls(){
        edittextUrl1.setText(sharedPrefs.getMyStringPref(this, "url1"));
        edittextUrl2.setText(sharedPrefs.getMyStringPref(this, "url2"));
        edittextUrl3.setText(sharedPrefs.getMyStringPref(this, "url3"));
    }
}
