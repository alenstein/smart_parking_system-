package com.example.smart_parking;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class  registerUser extends AppCompatActivity  {

    private EditText editTextPlateNumber, editTextEmail, editTextPassword, editTextPhone;
    private ProgressBar progressBar;
    private Button signUp;

    private FirebaseAuth userAuth;
    private View v;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

      initialiseComponents();
      createUserAccount();

    }




    private void initialiseComponents(){
        editTextPlateNumber = findViewById(R.id.plateNumber);
        editTextEmail = findViewById(R.id.email1);
        editTextPassword = findViewById(R.id.password1);
        editTextPhone = findViewById(R.id.phoneNumber);


        //progressBar.setVisibility(View.GONE);

        userAuth = FirebaseAuth.getInstance();

        signUp=findViewById(R.id.signUpButton);
    }

    private void createUserAccount() {
        String password = editTextPassword.getText().toString().trim();
        final String email1 = editTextEmail.getText().toString().trim();

        final String phone = editTextPhone.getText().toString().trim();
        final String plateNumber = editTextPlateNumber.getText().toString().trim();



        if (email1.isEmpty()||password.isEmpty()||phone.isEmpty()) {
            Toast.makeText(registerUser.this,"Please fill in all your details!",Toast.LENGTH_SHORT).show();
            editTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email1).matches()) {
            Toast.makeText(registerUser.this,"Please Enter a valid email",Toast.LENGTH_SHORT).show();
            editTextEmail.requestFocus();
            return;
        }



        if (password.length() < 6) {
            Toast.makeText(registerUser.this,"password too short!",Toast.LENGTH_SHORT).show();
            editTextPassword.requestFocus();
            return;
        }

        if (phone.length() != 10) {
            Toast.makeText(registerUser.this,"Please enter a valid phone number",Toast.LENGTH_SHORT).show();
            editTextPhone.requestFocus();
            return;
        }


        signUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Task<AuthResult> authResultTask = userAuth.createUserWithEmailAndPassword(email1, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {

                                    User user = new User(
                                            plateNumber,
                                            email1,
                                            phone
                                    );

                                    FirebaseDatabase.getInstance().getReference("Users")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(user).addOnCompleteListener(task1 -> {
                                                if (task1.isSuccessful()) {
                                                    Toast.makeText(registerUser.this, "Account Created Successfully", Toast.LENGTH_LONG).show();
                                                    registerUser.this.startActivity(new Intent(registerUser.this, MainActivity.class));
                                                } else {
                                                    //display a failure message
                                                    Toast.makeText(registerUser.this, "Registration Failed, Please Try again!", Toast.LENGTH_SHORT).show();
                                                }
                                            });

                                } else {
                                    Toast.makeText(registerUser.this, "try again", Toast.LENGTH_LONG).show();
                                }
                            }
                        });

            }
        });


    }


}