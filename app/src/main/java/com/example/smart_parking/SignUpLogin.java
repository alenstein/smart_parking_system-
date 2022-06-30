package com.example.smart_parking;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;



public class SignUpLogin extends AppCompatActivity {
    private Button SignIn;

    private EditText email;
    private EditText password;
    private Button signIn, registerSwitchText;
    private TextView forgotPasswordText;

    private FirebaseAuth auth;
    private FirebaseDatabase db;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SignIn = findViewById(R.id.signInButton);
        setContentView(R.layout.activity_sign_up_login);

        initComponents();
        attachListeners();

    }
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = auth.getCurrentUser();
        if(currentUser != null){
            startActivity(new Intent(SignUpLogin.this, MainActivity.class) );
        }
    }


    private void initComponents() {

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        signIn=findViewById(R.id.signInButton);
        registerSwitchText=findViewById(R.id.signUpButton);
        forgotPasswordText=findViewById(R.id.forgotPassword);

        auth=FirebaseAuth.getInstance();

    }

    private void attachListeners() {
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_email=email.getText().toString();
                String txt_password=password.getText().toString();
                if(TextUtils.isEmpty(txt_email)){
                    Toast.makeText(SignUpLogin.this,"Email can't be blank!",Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(txt_password)){
                    Toast.makeText(SignUpLogin.this,"Password can't be blank!",Toast.LENGTH_SHORT).show();
                }else{
                    //if email and password are not empty log the user
                    loginUser(txt_email, txt_password);
                }

            }
        });

        registerSwitchText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // register the user
                startActivity(new Intent(SignUpLogin.this, registerUser.class) );

            }
        });

        forgotPasswordText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call class to handle forgot password
                startActivity(new Intent(SignUpLogin.this, Forgot_Password_Activity.class) );
            }
        });
    }
    private void loginUser(String email, String password) {
        //method user in logging in the user
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //start the MainActivity
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));

                        } else {
                            Toast.makeText(SignUpLogin.this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }

}





