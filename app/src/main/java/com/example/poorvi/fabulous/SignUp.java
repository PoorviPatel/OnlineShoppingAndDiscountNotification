package com.example.poorvi.fabulous;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        TextView loginScreen = (TextView) findViewById(R.id.link_signup);
        Button signup = (Button)findViewById(R.id.btnSingup);
        EditText uname = (EditText)findViewById(R.id.username);
        EditText emailacc = (EditText)findViewById(R.id.email);
        EditText pass = (EditText)findViewById(R.id.password);

        loginScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getApplicationContext(), Home.class);
                startActivity(i);

            }
        });
    }
}
