package com.example.smart_parking;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


public class Forgot_Password_Activity extends AppCompatActivity {
    private Button sendMailBtn;
    private EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        initComponents();
        attachListeners();
    }

    private void initComponents() {
        Intent in = getIntent();
        String prevEmail = in.getStringExtra("EMAIL");
        sendMailBtn=findViewById(R.id.confirm_button);
        email=findViewById(R.id.emailField);
        email.setText(prevEmail);
        email.setSelection(email.getText().length());
    }

    private void attachListeners() {
        sendMailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_email=email.getText().toString();
                if(TextUtils.isEmpty(txt_email)){
                    Toast.makeText(Forgot_Password_Activity.this,"Email can't be blank!",Toast.LENGTH_SHORT).show();
                }else{
                    resetPasswordMail(txt_email);
                }
            }
        });
    }

    private void resetPasswordMail(final String resetEmail) {

            FirebaseAuth.getInstance().sendPasswordResetEmail(resetEmail)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Forgot_Password_Activity.this, "Password Reset Email has been sent to ".concat(resetEmail), Toast.LENGTH_SHORT).show();
                                Forgot_Password_Activity.this.startActivity(new Intent(Forgot_Password_Activity.this.getApplicationContext(), SignUpLogin.class));
                                Forgot_Password_Activity.this.finish();
                            } else {
                                Toast.makeText(Forgot_Password_Activity.this, "Fail", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

    }
}