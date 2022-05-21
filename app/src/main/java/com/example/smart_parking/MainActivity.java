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
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button getDirectionsBtn;
    Button bookingButton;

    private ImageButton slot1, slot2, slot3, slot4, slot5, slot6, slot7, slot8, slot9;
    Dialog popDialog;
    private static final String CHANNEL_ID = "book_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bookingButton = findViewById(R.id.bookButton);

        slot1 = findViewById(R.id.imageButton);
        slot2 = findViewById(R.id.imageButton2);
        slot3 = findViewById(R.id.imageButton3);
        slot4 = findViewById(R.id.imageButton5);
        slot5 = findViewById(R.id.imageButton4);
        slot6 = findViewById(R.id.imageButton6);
        slot7 = findViewById(R.id.imageButton7);
        slot8 = findViewById(R.id.imageButton8);
        slot9 = findViewById(R.id.imageButton9);

        popDialog = new Dialog(this);
        getDirectionsBtn = findViewById(R.id.directButton);

        slot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popDialog.setContentView(R.layout.popup);
                popDialog.show();
                popDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            }
        });
        slot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popDialog.setContentView(R.layout.popup);
                popDialog.show();
                popDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            }
        });
        slot3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popDialog.setContentView(R.layout.popup);
                popDialog.show();
                popDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            }
        });
        slot4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popDialog.setContentView(R.layout.popup);
                popDialog.show();
                popDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            }
        });
        slot5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popDialog.setContentView(R.layout.popup);
                popDialog.show();
                popDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            }
        });
        slot6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popDialog.setContentView(R.layout.popup);
                popDialog.show();
                popDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            }
        });
        slot7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popDialog.setContentView(R.layout.popup);
                popDialog.show();
                popDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            }
        });
        slot8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popDialog.setContentView(R.layout.popup);
                popDialog.show();
                popDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            }
        });
        slot9.setOnClickListener(new View.OnClickListener() {
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