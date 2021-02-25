package com.example.poorvi.fabulous;

import android.app.ListActivity;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.poorvi.fabulous.adapter.CustomAdapter;

public class Listview extends Fragment {

    ListView simpleList;
    String countryList[] = {"India", "China", "australia", "Portugle", "America", "NewZealand"};
    int flags[] = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v= inflater.inflate(R.layout.activity_listview, container, false);
        setHasOptionsMenu(true);

        simpleList = (ListView)v.findViewById(R.id.listview);
        CustomAdapter customAdapter = new CustomAdapter(getContext(), countryList, flags);
        simpleList.setAdapter(customAdapter);


        //Notification.Builder builder = new Notification.Builder()

        return v;
    }


}
