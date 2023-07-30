package com.example.aihelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GetStarted extends AppCompatActivity {
    TextView getStarted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_started);

        getStarted = findViewById(R.id.started);
        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iGoToRegister = new Intent(GetStarted.this, Register.class);
                startActivity(iGoToRegister);
                finish();
            }
        });

    }
}