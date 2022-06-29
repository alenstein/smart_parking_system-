package com.example.smart_parking;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    Dialog popupDialog;
    TextView slotID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Smart_parking);
        setContentView(R.layout.activity_main);

        ImageButton slot1 = findViewById(R.id.imageButton);
        ImageButton slot2 = findViewById(R.id.imageButton2);
        ImageButton slot3 = findViewById(R.id.imageButton3);
        ImageButton slot4 = findViewById(R.id.imageButton5);
        ImageButton slot5 = findViewById(R.id.imageButton4);
        ImageButton slot6 = findViewById(R.id.imageButton6);
        ImageButton slot7 = findViewById(R.id.imageButton7);
        ImageButton slot8 = findViewById(R.id.imageButton8);
        ImageButton slot9 = findViewById(R.id.imageButton9);

       popupDialog = new Dialog(this);
        slotID = findViewById(R.id.parkingSlotID);

        slot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupDialog.setContentView(R.layout.popup);
                popupDialog.show();
                popupDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            }
        });
        slot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupDialog.setContentView(R.layout.popup);
                popupDialog.show();
                popupDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            }
        });
        slot3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupDialog.setContentView(R.layout.popup);
                popupDialog.show();
                popupDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            }
        });
        slot4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupDialog.setContentView(R.layout.popup);
                popupDialog.show();
                popupDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            }
        });
        slot5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupDialog.setContentView(R.layout.popup);
                popupDialog.show();
                popupDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            }
        });
        slot6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupDialog.setContentView(R.layout.popup);
                popupDialog.show();
                popupDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            }
        });
        slot7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupDialog.setContentView(R.layout.popup);
                popupDialog.show();
                popupDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            }
        });
        slot8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupDialog.setContentView(R.layout.popup);
                popupDialog.show();
                popupDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            }
        });
        slot9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupDialog.setContentView(R.layout.popup);
                popupDialog.show();
                popupDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            }
        });



    }

    public void getStarted(){
        MainActivity.super.getParent();
        Toast parking_started = Toast.makeText(MainActivity.this, "Parking slots status ", Toast.LENGTH_SHORT);
        parking_started.show();
        //startActivity(new Intent(MainActivity.this, SignUpLogin.class) );
        finish();
    }
    public void takeMeThere(View view){
        Toast directMe = Toast.makeText(MainActivity.this, "Launching Google Maps API", Toast.LENGTH_SHORT);
        directMe.show();
        startActivity(new Intent(MainActivity.this,
                GetDirections.class) );
    }


    public void book(View view){
        startActivity(new Intent(MainActivity.this,
                booking.class) );
    }


}