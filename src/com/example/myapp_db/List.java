package com.example.myapp_db;

import android.app.ListFragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by practicant1.orpo_krg on 10.06.2014.
 */
public class List extends ListFragment {

    final String ATTR_NAME_TEXT = "main_text";
    final String ATTR_NAME_SUBTEXT = "subtext";
    final String ATTR_NAME_IMG = "img";

    Intent intent;
    SharedPrefs sharedPrefs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        intent = new Intent(getActivity(), AnotherActivity.class);
        sharedPrefs = new SharedPrefs();

        // fill List with data (image, text, subtext)
        ArrayList<Map<String, Object>> data = new ArrayList<Map<String,
                Object>>(getResources().getStringArray(R.array.buttons).length);
        Map<String, Object> map;


        for(int i = 0; i<getResources().getStringArray(R.array.buttons).length; i++){
            map = new HashMap<String, Object>();
            map.put(ATTR_NAME_IMG, R.drawable.ic_launcher);
            map.put(ATTR_NAME_TEXT, getResources().getStringArray(R.array.buttons)[i].toString());
            map.put(ATTR_NAME_SUBTEXT, getResources().getStringArray(R.array.descr)[i].toString());
            data.add(map);
        }

        String [] from = {ATTR_NAME_IMG, ATTR_NAME_TEXT, ATTR_NAME_SUBTEXT};
        int[] to = {R.id.icon, R.id.text, R.id.subtext};

        // simple adapter as an adapter, my_item_list as a layout
        SimpleAdapter adapter = new SimpleAdapter(this.getActivity(), data, R.layout.my_item_list, from, to);
        setListAdapter(adapter);
    }

    /**
     * when item in the list is clicked:
     * if it is "Go to Url...", it connects to that Url
     * if it is "Set Urls", it goes to AnotherActivity to set/change Url addresses
     *
     * If there is problems with internet connection or with url addresses,
     * toasts are displayed
     */
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        switch(position){
            case 0:
                /*if(MyActivity.connection) {
                    if (sharedPrefs.getMyStringPref(this.getActivity(), "url1") != null) {
                        new MyAsync(this.getActivity()).execute(sharedPrefs.getMyStringPref(this.getActivity(), "url1"));
                    } else {
                        Toast.makeText(this.getActivity(), "Url address is empty", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this.getActivity(), "No internet connection", Toast.LENGTH_SHORT).show();
                }*/
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://fapl.ru/")));
                break;
            case 1:
                if(MyActivity.connection) {
                    if (sharedPrefs.getMyStringPref(this.getActivity(), "url3") != null) {
                        new MyAsync(this.getActivity()).execute(sharedPrefs.getMyStringPref(this.getActivity(), "url3"));
                    } else {
                        Toast.makeText(this.getActivity(), "Url address is empty", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this.getActivity(), "No internet connection", Toast.LENGTH_SHORT).show();
                }
                break;
            case 2:
                if(MyActivity.connection) {
                    if (sharedPrefs.getMyStringPref(this.getActivity(), "url3") != null) {
                        new MyAsync(this.getActivity()).execute(sharedPrefs.getMyStringPref(this.getActivity(), "url3"));
                    } else {
                        Toast.makeText(this.getActivity(), "Url address is empty", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this.getActivity(), "No internet connection", Toast.LENGTH_SHORT).show();
                }
                break;
            case 3:
                startActivity(intent);
                break;
        }
    }

}
