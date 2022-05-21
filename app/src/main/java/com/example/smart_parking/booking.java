package com.example.smart_parking;

import static android.app.Notification.*;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class booking extends AppCompatActivity {
    Button bookingButton;
    String CHANNEL_ID = "channel 1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        bookingButton = findViewById(R.id.bookButton);
        bookingButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                NotificationChannel channel;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    channel = new NotificationChannel(CHANNEL_ID, "Notification 1", NotificationManager.IMPORTANCE_HIGH);
                    Builder builder = new Builder(getApplicationContext())
                            .setContentTitle("Smart Parking")
                            .setContentText("You have booked parking slot1")
                            .setSmallIcon(R.drawable.book_notification)
                            .setChannelId(CHANNEL_ID);
                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    notificationManager.createNotificationChannel(channel);
                    notificationManager.notify(1, builder.build());
                }
            }
        });
    }


    public void directMe(View view){
        NotificationChannel channel;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channel = new NotificationChannel(CHANNEL_ID,"Notification 1", NotificationManager.IMPORTANCE_HIGH);
            Builder builder = new Builder(getApplicationContext())
                    .setContentTitle("Smart Parking")
                    .setContentText("You have booked parking slot1")
                    .setSmallIcon(R.drawable.book_notification)
                    .setChannelId(CHANNEL_ID);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
            notificationManager.notify(1, builder.build());
        }
    }
}
