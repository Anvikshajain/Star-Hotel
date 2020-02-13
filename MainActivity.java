package com.example.hotelmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText pwd;
    private Button button0,button1,button2;
    private ImageView beginlogo;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

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

        firebaseAuth = FirebaseAuth.getInstance();

        final FirebaseUser user= firebaseAuth.getCurrentUser();

        progressDialog =new ProgressDialog(this);


        button0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (user!=null){
                    startActivity(new Intent(MainActivity.this,SignupActivity.class));
                    finish();
                }
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
        progressDialog.setMessage("Please Wait For a While!");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this,"Login Successfull!",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,SignupActivity.class));
                }else{
                    Toast.makeText(MainActivity.this,"Login Failed!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

