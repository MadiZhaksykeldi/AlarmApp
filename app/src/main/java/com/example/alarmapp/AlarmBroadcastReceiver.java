package com.example.alarmapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.example.alarmapp.activities.DismissAlarmActivity;

public class AlarmBroadcastReceiver extends BroadcastReceiver {
    public static final String KEY_IS_ONE_TIME = "onetime";
    DismissAlarmNotificationController dismissAlarmNotificationController;

    @Override
    public void onReceive(Context context, Intent intent) {
        dismissAlarmNotificationController = new DismissAlarmNotificationController(context);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.P) {
            dismissAlarmNotificationController.showNotification();
        } else {
            Intent dismissAlarmIntent = new Intent(context, DismissAlarmActivity.class);
            context.startActivity(dismissAlarmIntent);
        }
    }
}
