package com.example.karthikvarma.profile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class resetPassword extends AppCompatActivity implements View.OnClickListener{

    EditText username,fullname,password;
    Button reset;
    DBHandler handler = new DBHandler(this);
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        username = (EditText) findViewById(R.id.username);
        fullname = (EditText) findViewById(R.id.fullname);
        password = (EditText) findViewById(R.id.password);
        reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(this);
    }

    public String getusername()
    {
        SharedPreferences shared = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String username = shared.getString("username","No user");
        return username;
    }


    @Override
    public void onClick(View v)
    {
        switch ( v.getId())
        {
            case R.id.reset:
                String uname = getusername();
                name = handler.getname(uname);
                if(name.equals(fullname.getText().toString()))
                {
                    handler.insertUser(uname,password.getText().toString());
                    startActivity(new Intent(this,login.class));
                }
                break;
        }
    }
}
