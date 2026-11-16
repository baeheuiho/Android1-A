package com.example.project;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class StaticReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
       String action = intent.getAction();
       if (action != null) {
           if (action.equals(Intent.ACTION_POWER_CONNECTED)) {
               BatteryFragment.textView.setText(BatteryFragment.textView.getText() +
                       "\n [정적] 전원 연결됨");
           } else if (action.equals(Intent.ACTION_POWER_DISCONNECTED)){
               BatteryFragment.textView.setText(BatteryFragment.textView.getText() +
                       "\n [정적] 전원 해제됨");
           }
       }
    }
}