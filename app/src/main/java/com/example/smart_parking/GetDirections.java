package com.example.smart_parking;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GetDirections extends AppCompatActivity {
    Button getDirectionsBtn;
    String CHANNEL_ID = "channel 1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_directions);
    }
}
