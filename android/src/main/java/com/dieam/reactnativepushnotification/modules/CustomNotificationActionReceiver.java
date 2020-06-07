package com.dieam.reactnativepushnotification.modules;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * A broadcast receiver which receives intent when the actions in the notification is clicked
 */
public class CustomNotificationActionReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getBundleExtra("notification");

        Intent notificationActionIntent = new Intent(context, CustomNotificationActionService.class);
        notificationActionIntent.putExtras(bundle);
        context.startService(notificationActionIntent);

        // Dismiss the notification popup.
        NotificationManager manager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        int notificationID = Integer.parseInt(bundle.getString("id"));
        manager.cancel(notificationID);
    }
}
