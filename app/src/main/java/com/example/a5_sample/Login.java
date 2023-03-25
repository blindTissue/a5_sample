package com.example.a5_sample;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;


public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Context context = getApplicationContext();
        SharedPreferences myPrefs = PreferenceManager.getDefaultSharedPreferences(context);


        //Get saved login name if there is one.
        String savedName = myPrefs.getString("loginName", "Owner");
        //Set saveName to the loginName field.
        EditText loginNameField = (EditText) findViewById(R.id.login_name);
        loginNameField.setText(savedName);



        Button lbtn = (Button) findViewById(R.id.login_button);
        lbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginName = ((EditText) findViewById(R.id.login_name)).getText().toString();

                SharedPreferences.Editor peditor = myPrefs.edit();
                peditor.putString("loginName", loginName);
                peditor.apply();

                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
