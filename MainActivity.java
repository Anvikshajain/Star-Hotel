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
    private Button button;
    private TextView info;
    private ImageView beginlogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.etName);
        pwd = (EditText)findViewById(R.id.etPassword);
        button = (Button)findViewById(R.id.btnLogin);
        beginlogo = (ImageView)findViewById(R.id.imageView3);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(), pwd.getText().toString());
            }
        });
    }

    private void validate (String username , String password )
    {
        if (username.equals("Shubhangi7765@gmail.com") && password.equals("SomeOneYouLoved")){
            startActivity(new Intent(MainActivity.this,SecondActivity.class));
        }
    }
}

