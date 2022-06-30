package com.example.smart_parking;

import static android.app.Notification.*;

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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class booking extends AppCompatActivity {
    Button bookingButton;
    String CHANNEL_ID = "channel 2";
    Dialog popDialog;
    EditText bookingHours;
    TextView parkingSlotStatusUpdate;
    String bookedHours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        bookingButton = findViewById(R.id.BookSlotBtn);
        popDialog = new Dialog(this);
        bookingHours = findViewById(R.id.bookingHoursInput);
        parkingSlotStatusUpdate = findViewById(R.id.textView2);

        bookingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popDialog.setContentView(R.layout.book_popup);
                popDialog.show();
                popDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                            }
        });
    }



    public void bookNow(View view){

        NotificationChannel channel;
        if (bookingHours != null) bookedHours = bookingHours.getText().toString();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channel = new NotificationChannel(CHANNEL_ID, "Notification 1", NotificationManager.IMPORTANCE_HIGH);
            Builder builder = new Builder(getApplicationContext())
                    .setContentTitle("Smart Parking")
                    .setContentText("You have booked parking slot1 for " + bookedHours + " Hours.")
                    .setSmallIcon(R.drawable.book_notification)
                    .setChannelId(CHANNEL_ID);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
            notificationManager.notify(1, builder.build());
            Toast booking = Toast.makeText(booking.this, "Booked!", Toast.LENGTH_SHORT);
            booking.show();
            parkingSlotStatusUpdate.setText("BOOKED");
            popDialog.dismiss();

        }
    }

}
