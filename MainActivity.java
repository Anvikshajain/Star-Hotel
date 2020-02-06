package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText pwd;
    private Button button0,button1,button2;
    private TextView info1,infor2;
    private ImageView beginlogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.etName);
        pwd = (EditText)findViewById(R.id.etPassword);
        button0 = (Button)findViewById(R.id.btnLogin);
        beginlogo = (ImageView)findViewById(R.id.imageView3);
        button1 = (Button)findViewById(R.id.btnreg);
        button2 = (Button)findViewById(R.id.btnfrgt);

        button0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(), pwd.getText().toString());
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,FpwdActivity.class));
            }
        });


    }

    private void validate (String username , String password )
    {
        if (username.equals("Su") && password.equals("12345")){
            startActivity(new Intent(MainActivity.this,SignupActivity.class));
        }
    }
}

