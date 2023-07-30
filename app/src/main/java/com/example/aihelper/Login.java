package com.example.aihelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    TextView doRegister;
    Button login;
    EditText ed1, ed2;
    FirebaseAuth auth;
    FirebaseFirestore db;

    String email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        doRegister = findViewById(R.id.textView7);
        login = findViewById(R.id.button3);
        ed1 = findViewById(R.id.editTextTextPersonName1);
        ed2 = findViewById(R.id.editTextTextPersonPassword1);
        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        doRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iGoToRegister1 = new Intent(Login.this, Register.class);
                startActivity(iGoToRegister1);
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = ed1.getText().toString();
                password = ed2.getText().toString();
                if(TextUtils.isEmpty(email)) {
                    Toast.makeText(Login.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(password)) {
                    Toast.makeText(Login.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                }

                Signin();




            }
        });


    }

    private void Signin() {
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();
                Intent goToMain2 = new Intent(Login.this, MainActivity.class);
                startActivity(goToMain2);
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Login.this, "Login failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}