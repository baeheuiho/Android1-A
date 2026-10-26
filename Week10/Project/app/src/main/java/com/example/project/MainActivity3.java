package com.example.project;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;

public class MainActivity3 extends AppCompatActivity {
    private BMIFragment bmiFragment;
    private AreaFragment areaFragment;
    private GoogleFragment googleFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        bmiFragment = new BMIFragment();
        areaFragment = new AreaFragment();
        googleFragment = new GoogleFragment();

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragment, bmiFragment);
        transaction.add(R.id.fragment, areaFragment);
        transaction.hide(areaFragment);
        transaction.add(R.id.fragment, googleFragment);
        transaction.hide(googleFragment);
        transaction.commit();

        TabLayout tabLayout = findViewById(R.id.tabLayout);

        TabLayout.Tab tab1 = tabLayout.newTab();
        tab1.setText("BMI 계산기");
        tabLayout.addTab(tab1);

        TabLayout.Tab tab2 = tabLayout.newTab();
        tab2.setText("면적 계산기");
        tabLayout.addTab(tab2);

        TabLayout.Tab tab3 = tabLayout.newTab();
        tab3.setText("Google");
        tabLayout.addTab(tab3);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switchFragment(manager, tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void switchFragment(FragmentManager manager, int position) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.hide(bmiFragment);
        transaction.hide(areaFragment);
        transaction.hide(googleFragment);
        if (position == 0)
            transaction.show(bmiFragment);
        else if (position == 1)
            transaction.show(areaFragment);
        else
            transaction.show(googleFragment);
        transaction.commit();
    }
}