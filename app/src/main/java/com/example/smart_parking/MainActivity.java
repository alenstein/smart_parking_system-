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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {
    Button getDirectionsBtn;
    Button bookingButton;


    private ImageButton slot1, slot2, slot3, slot4, slot5, slot6, slot7, slot8, slot9;
    Dialog popDialog;
    private static final String CHANNEL_ID = "book_id";
    DatabaseReference ref;
    boolean slotStatus = false;
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

        bookingButton = findViewById(R.id.BookSlotBtn);

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
        slotID = findViewById(R.id.parkingSlotID);


        //get the status of parking slot from firebase database
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                slotStatus= (boolean) dataSnapshot.child("status").getValue();
                if(slotStatus==true){
                    slot1.setImageResource(R.drawable.slot_occupied);
                }else{
                    slot1.setImageResource(R.drawable.slot_free);
                }

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        slot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(slotStatus==false){
                    popDialog.setContentView(R.layout.popup);
                    popDialog.show();
                    popDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));

                }else{
                    Toast.makeText(MainActivity.this, "Slot Booked", Toast.LENGTH_SHORT).show();
                }


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