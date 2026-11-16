package com.example.project;

import static android.widget.Toast.LENGTH_SHORT;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;

public class BatteryFragment extends Fragment {
     static TextView textView;
     private boolean dynamic = true;

    private final BroadcastReceiver dynamicReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
             int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
             int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
             String msg = (status == BatteryManager.BATTERY_STATUS_CHARGING) ? "충전 중" : "충전 아님";
             textView.setText(String.format("Battery : %d %% (%s)", level, msg));
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.battery_fragment, container, false);

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        textView = view.findViewById(R.id.textView);
        textView.setText("수신 모드 : " + (dynamic ? "동적" : "정적"));

        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@org.jspecify.annotations.NonNull Menu menu, @org.jspecify.annotations.NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.menu, menu);
            }

            @Override
            public boolean onMenuItemSelected(@org.jspecify.annotations.NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.item1) {
                    dynamic = true;
                    textView.setText("Receiver Mode : Dynamic");
                    Toast.makeText(getContext(), "Switched to Dynamic Receiver", LENGTH_SHORT).show();
                    onStart();
                } else {
                    dynamic = false;
                    requireActivity().unregisterReceiver(dynamicReceiver);
                    textView.setText("Receiver Mode : Static");
                    Toast.makeText(getContext(), "Switched to Static Receiver", LENGTH_SHORT).show();
                }
                menuItem.setChecked(true);
                return true;
            }
        }, getViewLifecycleOwner(), Lifecycle.State.RESUMED);
    }


    @Override
    public void onStart() {
        super.onStart();
        if (dynamic) {
            IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
            filter.addAction(Intent.ACTION_BATTERY_OKAY);
            filter.addAction(Intent.ACTION_BATTERY_LOW);
            requireActivity().registerReceiver(dynamicReceiver, filter);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        requireActivity().unregisterReceiver(dynamicReceiver);
    }
}
