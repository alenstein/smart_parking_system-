package com.example.smart_parking;
import static android.content.ContentValues.TAG;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class GetDirections extends AppCompatActivity {
    Button getDirectionsBtn;
    String CHANNEL_ID = "channel 2", Title, context;
    Timer parkingTimer;
    int count = 0;
    boolean stopped = false;
    TextView parkingSLotStatus;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_directions);
        getDirectionsBtn = findViewById(R.id.directButton);
        parkingSLotStatus = findViewById(R.id.status);

        getDirectionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Title = "Smart Parking";
                context = "directing on google maps....";
                notifyPush(v, Title, context);
                directMe(v);
                parkingSLotStatus.setText("OCCUPIED");
                calculateParkingTime(v);
                if(stopped){
                    MainActivity reload = new MainActivity();
                    reload.getStarted();
                }
            }
        });
    }



    public void directMe(View view) {
        Toast booking = Toast.makeText(GetDirections.this, "Directing......", Toast.LENGTH_SHORT);
        booking.show();
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("google.navigation:q=22.659239,88.435534&mode=1"));
        intent.setPackage("com.google.android.apps.maps");
        if(intent.resolveActivity(getPackageManager()) != null) startActivity(intent);
     }

     public void calculateParkingTime(View view){
         parkingTimer = new Timer();
         parkingTimer.schedule(new TimerTask(){
             @Override
             public void run() {
                Log.d("testing", count + "s running!");
                count++;
                if(count == 15){
                    Title = "Smart Parking";
                    context = "Time for reaching parking slot 1 has elapsed, look for another free parking slot!";
                    notifyPush(view, Title, context);
                    parkingTimer.cancel();
                    parkingTimer = null;
                    count = 0;
                    stopped = true;
                }
             }

            }, 0, 15000);

     }

     public void notifyPush(View view, String nTitle, String nContext) {
         NotificationChannel channel;
         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
             channel = new NotificationChannel(CHANNEL_ID, "Notification 2", NotificationManager.IMPORTANCE_HIGH);
             Notification.Builder builder = new     Notification.Builder(getApplicationContext())
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