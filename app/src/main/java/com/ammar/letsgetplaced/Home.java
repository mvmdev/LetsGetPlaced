package com.ammar.letsgetplaced;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    Button companybttn,userinfobttn,logoutbttn,notificationsbttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
                Intent intent = new Intent(Home.this,CompanyInfo.class);
                startActivity(intent);

            }
        });
    }
}
