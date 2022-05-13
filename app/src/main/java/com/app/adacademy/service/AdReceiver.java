package com.app.adacademy.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Calendar;

public class AdReceiver extends BroadcastReceiver {

    private String valueGetTask;

    @Override
    public void onReceive(Context context, Intent intent) {

        try {

            valueGetTask = "1";
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            Intent i = new Intent(context, AdReceiver.class); // explicit

            PendingIntent intentExecuted = PendingIntent.getBroadcast(context, 0, i,
                    PendingIntent.FLAG_CANCEL_CURRENT);

            alarmManager.cancel(intentExecuted);
            if (!valueGetTask.equals("")){
                int valueTask = Integer.parseInt(valueGetTask);
                int INTERVAL_TRACK_PERIOD = 1000*60*valueTask;
                Calendar now1 = Calendar.getInstance();
                now1.add(Calendar.MINUTE, valueTask);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                        now1.getTimeInMillis(), INTERVAL_TRACK_PERIOD, intentExecuted);
               /* Intent service = new Intent(context, AdIntenService.class);
                context.startService(service)*/;
            }else {
                int INTERVAL_TRACK = 1000*60*2;
                Calendar now1 = Calendar.getInstance();
                now1.add(Calendar.MINUTE, 2);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                        now1.getTimeInMillis(), INTERVAL_TRACK, intentExecuted);

             /*   Intent service = new Intent(context, AdIntenService.class);
                context.startService(service);*/
            }

        }catch (Exception e){

            Log.d("AUT ERROR alarm",e.getMessage()) ;
            Log.d("AUT ERROR alarm1", String.valueOf(e.getStackTrace())) ;
        }

        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
    }
}
