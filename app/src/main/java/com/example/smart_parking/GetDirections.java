package com.example.smart_parking;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GetDirections extends AppCompatActivity {
    Button getDirectionsBtn;
    String CHANNEL_ID = "channel 2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_directions);
        getDirectionsBtn = findViewById(R.id.directButton);

        getDirectionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationChannel channel;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    channel = new NotificationChannel(CHANNEL_ID, "Notification 2", NotificationManager.IMPORTANCE_HIGH);
                    Notification.Builder builder = new Notification.Builder(getApplicationContext())
                            .setContentTitle("Smart Parking")
                            .setContentText("directing on google maps....")
                            .setSmallIcon(R.drawable.book_notification)
                            .setChannelId(CHANNEL_ID);
                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    notificationManager.createNotificationChannel(channel);
                    notificationManager.notify(2, builder.build());
                }
            }
        });
    }


    public void directMe(View view) {
        Toast booking = Toast.makeText(GetDirections.this, "Directing......", Toast.LENGTH_SHORT);
        booking.show();
    }

}