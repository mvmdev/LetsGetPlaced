package com.ammar.letsgetplaced;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Notifs extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifs);

        Intent intent = new Intent();
        String title = intent.getStringExtra("Title");
        String message = intent.getStringExtra("Body");

        tv = findViewById(R.id.notiftext);
        tv.setText(message);
    }
}
