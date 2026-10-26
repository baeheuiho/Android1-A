package com.example.project;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPager2Adapter extends FragmentStateAdapter {

    public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0 :
                fragment = new BMIFragment();
                break;
            case 1 :
                fragment = new AreaFragment();
                break;
            case 2 :
                fragment = new GoogleFragment();
        }

        return fragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
