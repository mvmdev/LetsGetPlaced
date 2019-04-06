package com.ammar.letsgetplaced;

import android.animation.ObjectAnimator;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {

    public static final String Channel_id = "sc";
    public static final String Channel_name = "sc";
    public static final String Channel_desc = "sc";
    private Handler mHandler = new Handler();
    private Runnable mUpdateTimeTask;

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
                flip.setDuration(300);
                flip.start();

                mUpdateTimeTask = new Runnable() {
                    public void run() {
                        Intent intent = new Intent(Home.this,CompanyInfo.class);
                        startActivity(intent);
                    }
                };
                mHandler.postDelayed(mUpdateTimeTask,300);

            }
        });

        userinfobttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator flip = ObjectAnimator.ofFloat(view, "rotationX", 0f, 360f);
                flip.setDuration(300);
                flip.start();
                mUpdateTimeTask = new Runnable() {
                    public void run() {
                        Intent intent = new Intent(Home.this,UserInfo1.class);
                        startActivity(intent);
                    }
                };
                mHandler.postDelayed(mUpdateTimeTask,300);

            }
        });

        notificationsbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator flip = ObjectAnimator.ofFloat(view, "rotationX", 0f, 360f);
                flip.setDuration(300);
                flip.start();
                mUpdateTimeTask = new Runnable() {
                    public void run() {
                        Intent intent = new Intent(Home.this,Notifs.class);
                        startActivity(intent);
                    }
                };
                mHandler.postDelayed(mUpdateTimeTask,300);

            }
        });

        logoutbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator flip = ObjectAnimator.ofFloat(view, "rotationX", 0f, 360f);
                flip.setDuration(300);
                flip.start();
                mUpdateTimeTask = new Runnable() {
                    public void run() {
                        FirebaseAuth.getInstance().signOut();
                        finish();
                        startActivity(new Intent(Home.this,LoginActivity.class));
                    }
                };
                mHandler.postDelayed(mUpdateTimeTask,300);


            }
        });
    }

    public void displayNotification(Context context, String title, String message){


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(Channel_id,Channel_name,NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription(Channel_desc);
            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.createNotificationChannel(channel);
        }

        Intent intent = new Intent(context,Notifs.class);
        intent.putExtra("Title",title);
        intent.putExtra("Body",message);

        PendingIntent pendingIntent = PendingIntent.getActivity(context,100,intent,PendingIntent.FLAG_CANCEL_CURRENT);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context,Home.Channel_id)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_MAX);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
        managerCompat.notify(1,mBuilder.build());
    }


}
