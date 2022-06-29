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

    EditText bookTheseHours;
    TextView parkingSlotStatusUpdate;
    String bookedHours, title, context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        bookingButton = findViewById(R.id.BookSlotBtn);

        bookTheseHours = findViewById(R.id.bookingHoursInput);
        parkingSlotStatusUpdate = findViewById(R.id.textView2);

    }



    public void bookSlot(View view){
        bookedHours = bookTheseHours.getText().toString();
        Toast booking = Toast.makeText(booking.this, "preparing to book slot", Toast.LENGTH_SHORT);
        booking.show();

        title = "Smart Parking";
        context = "Booked parking slot1 for " + bookedHours + " hours";
        notifyPush(view, title, context);

        parkingSlotStatusUpdate.setText("BOOKED");

        //startActivity(new Intent(MainActivity.this, SignUpLogin.class) );
    }

    public void notifyPush(View view, String nTitle, String nContext) {
        NotificationChannel channel;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channel = new NotificationChannel(CHANNEL_ID, "Notification 2", NotificationManager.IMPORTANCE_HIGH);
            Notification.Builder builder = new    Notification.Builder(getApplicationContext())
                    .setContentTitle(nTitle)
                    .setContentText(nContext)
                    .setSmallIcon(R.drawable.book_notification)
                    .setChannelId(CHANNEL_ID);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
            notificationManager.notify(2, builder.build());
        }
    }
}
