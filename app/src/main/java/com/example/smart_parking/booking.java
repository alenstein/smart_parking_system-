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
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class booking extends AppCompatActivity {
    Button bookingButton;
    String CHANNEL_ID = "channel 2";

    EditText bookTheseHours;
    TextView parkingSlotStatusUpdate, bookingCounter;
    String  title, context;
    int bookedHours, seconds;
    private CountDownTimer bookingTimer;
    private long timeLeftInMilliseconds = 60000;
    boolean timerRunning;

    static int count, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        bookingButton = findViewById(R.id.BookSlotBtn);

        bookTheseHours = findViewById(R.id.bookingHoursInput);
        bookingCounter = findViewById(R.id.countDown);
        parkingSlotStatusUpdate = findViewById(R.id.textView2);

    }

    public void start(){
        if (timerRunning){
            stopTimer();
        }else{
            startTimer();
        }
    }



    private void startTimer() {
        bookingTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();
        timerRunning = true;
    }

    public void updateTimer() {
        int minutes = (int) timeLeftInMilliseconds/60000;
        int seconds = (int) timeLeftInMilliseconds % 600000 / 1000;
        String timeLeft;
        timeLeft = "" + minutes;
        timeLeft += ":";
        if (seconds < 10){
            timeLeft += "0";
        }
        timeLeft += seconds;
        bookingCounter.setText(timeLeft);
    }

    private void stopTimer() {
        bookingTimer.cancel();
        timerRunning = false;
    }

    public void bookSlot(View view){
        bookedHours = Integer.parseInt(bookTheseHours.getText().toString());
        Toast booking = Toast.makeText(booking.this, "preparing to book slot", Toast.LENGTH_SHORT);
        booking.show();

        title = "Smart Parking";
        context = "Booked parking slot1 for " + bookedHours + " hours";
        notifyPush(view, title, context);

        parkingSlotStatusUpdate.setText("BOOKED for " + bookedHours + "h");
        timeLeftInMilliseconds = (long) bookedHours;
        //bookingCounter.setText(bookedHours);
        start();

        //startActivity(new Intent(booking.this, SignUpLogin.class) );
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
