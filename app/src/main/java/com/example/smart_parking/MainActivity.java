package com.example.smart_parking;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button popUpParkingButton;
    Button bookingButton;
    private Button getDirectionsBtn;
    Dialog popDialog;
    private static final String CHANNEL_ID = "book_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        popUpParkingButton = findViewById(R.id.popUpParkingButton);
        bookingButton = findViewById(R.id.bookButton);
        popDialog = new Dialog(this);
        getDirectionsBtn = findViewById(R.id.directButton);

        popUpParkingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popDialog.setContentView(R.layout.popup);
                popDialog.show();
                popDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            }
        });

    }

    public void getStarted(View view){
        Toast parking_started = Toast.makeText(MainActivity.this, "Parking Started", Toast.LENGTH_SHORT);
        parking_started.show();
        startActivity(new Intent(MainActivity.this,
                SignUpLogin.class) );
        finish();
    }
    public void takeMeThere(View view){
        Toast directMe = Toast.makeText(MainActivity.this, "Launching Google Maps API", Toast.LENGTH_SHORT);
        directMe.show();
        startActivity(new Intent(MainActivity.this,
                GetDirections.class) );
        finish();
    }
    public void bookSlot(View view){
        Toast booking = Toast.makeText(MainActivity.this, "preparing to book slot", Toast.LENGTH_SHORT);
        booking.show();
        startActivity(new Intent(MainActivity.this,
                booking.class) );
        finish();
    }

    public void googleMapsLaunch(View view){
        Toast gmaps = Toast.makeText(MainActivity.this, "searching location... ", Toast.LENGTH_SHORT);
        gmaps.show();

        finish();
    }

}