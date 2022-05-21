package com.example.smart_parking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class SignUpLogin extends AppCompatActivity {
    private Button SignIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SignIn = findViewById(R.id.signInButton);
        setContentView(R.layout.activity_sign_up_login);
    }
    

}