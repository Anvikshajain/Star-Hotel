package com.example.hotelmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private Button btn,reg;
    private EditText name,password,mail;
    private TextView info;
    private FirebaseAuth firebaseAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn = (Button)findViewById(R.id.btnback);
        reg = (Button)findViewById(R.id.rgtr);
        name = (EditText)findViewById(R.id.usrname);
        password = (EditText)findViewById(R.id.password);
        mail = (EditText)findViewById(R.id.mail);
        info = (TextView) findViewById(R.id.Info);
        firebaseAuth = FirebaseAuth.getInstance();

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    String user_email = mail.getText().toString().trim();
                    String user_password = password.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(RegisterActivity.this, "Registration successfull", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                            }
                            else{
                                Toast.makeText(RegisterActivity.this,"Registration Failed!",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }

    private Boolean validate(){
        Boolean result=false;

        String nm=name.getText().toString();
        String pwd=password.getText().toString();
        String ma=mail.getText().toString();

        if (nm.isEmpty() || pwd.isEmpty() || ma.isEmpty()){
            Toast.makeText(this,"Please Fill all the details completely!",Toast.LENGTH_SHORT).show();
        }
        else{
            result=true;
        }
        return result;
    }
}
