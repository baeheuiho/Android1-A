package com.example.project;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class Pager2Adapter extends FragmentStateAdapter {

    public Pager2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new BatteryFragment();
                break;
            case 1:
                fragment = new CustomFragment();
                break;
            case 2:
                fragment = new OrderedFragment();
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
