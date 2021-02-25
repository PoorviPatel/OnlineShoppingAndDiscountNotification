package com.example.poorvi.fabulous;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class SignIn extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        TextView signupscreen = (TextView) findViewById(R.id.link_signup);
        Button signin = (Button)findViewById(R.id.btnSingup);
        EditText emailacc = (EditText)findViewById(R.id.email);
        EditText pass = (EditText)findViewById(R.id.password);
        TextView changepas = (TextView) findViewById(R.id.link_forgetpass);
       // emailacc.setText("poorvipatel6608@gmail.com");
        //pass.setText("12345");


        signupscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SignUp.class);
                startActivity(i);
            }
        });
        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getApplicationContext(), Home.class);
                startActivity(i);


            }
        });
        changepas.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){

                Intent chgpass = new Intent(getApplicationContext(), ChangePassword.class);
                startActivity(chgpass);
            }

        });
    }
}
