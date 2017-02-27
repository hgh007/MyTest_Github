package com.example.hans.myintent;

import android.app.NotificationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.Notification;
import android.app.PendingIntent;
import android.support.v4.app.NotificationCompat;
import android.content.Intent;


public class Main_3 extends AppCompatActivity {

      NotificationCompat.Builder  notification;

    private static final int uniqueID = 45612;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_3);

         notification = new NotificationCompat.Builder(this);
         notification.setAutoCancel(true);

    }

    public void ClickforNoteficatio(View view){


        notification.setSmallIcon(R.drawable.ic_launcher);
        notification.setTicker("This is the ticker");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Hier  is de titel ");
        notification.setContentText("I am the boy text of your app");

        Intent intent = new Intent(this,Main_3.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        // Buil a issues


        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID,notification.build());

    }
}
