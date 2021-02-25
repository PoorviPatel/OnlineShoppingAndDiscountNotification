package com.example.poorvi.fabulous;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class singlelist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singlelist);
        TextView txt = (TextView)findViewById(R.id.textView);

        Intent i = getIntent();
        String product = i.getStringExtra("product");
        txt.setText(product);
    }
}
