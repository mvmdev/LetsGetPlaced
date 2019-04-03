package com.ammar.letsgetplaced;

import android.animation.ObjectAnimator;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    Button companybttn,userinfobttn,logoutbttn,notificationsbttn;

    public static final String Channel_id = "sc";
    public static final String Channel_name = "sc";
    public static final String Channel_desc = "sc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(Channel_id,Channel_name,NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription(Channel_desc);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        companybttn = findViewById(R.id.companybutton);
        userinfobttn = findViewById(R.id.UserInfo);
        notificationsbttn = findViewById(R.id.Notifications);
        logoutbttn = findViewById(R.id.Logout);

        companybttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator flip = ObjectAnimator.ofFloat(view, "rotationX", 0f, 360f);
                flip.setDuration(3000);
                flip.start();
                Intent intent = new Intent(Home.this,CompanyInfo.class);
                startActivity(intent);
            }
        });

        userinfobttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator flip = ObjectAnimator.ofFloat(view, "rotationX", 0f, 360f);
                flip.setDuration(3000);
                flip.start();
                Intent intent = new Intent(Home.this,UserInfo1.class);
                startActivity(intent);

            }
        });

        notificationsbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator flip = ObjectAnimator.ofFloat(view, "rotationX", 0f, 360f);
                flip.setDuration(3000);
                flip.start();
                Intent intent = new Intent(Home.this,Notifs.class);
                startActivity(intent);

            }
        });

        logoutbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator flip = ObjectAnimator.ofFloat(view, "rotationX", 0f, 360f);
                flip.setDuration(3000);
                flip.start();

            }
        });
    }


}
