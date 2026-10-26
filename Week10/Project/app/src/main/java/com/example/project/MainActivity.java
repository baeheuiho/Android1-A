package com.example.project;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tabLayout);

        ViewPager2 pager2 = findViewById(R.id.viewPager2);
        ViewPager2Adapter adapter = new ViewPager2Adapter(MainActivity.this);
        pager2.setAdapter(adapter);

        TabLayoutMediator mediator = new TabLayoutMediator(tabLayout, pager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int i) {
                switch (i)   { // 0 ~ 2
                    case 0 :
                        tab.setText("BMI 계산기");
                        tab.setIcon(R.mipmap.ic_launcher);
                        break;
                    case 1:
                        tab.setText("면적 계산기");
                        break;
                    case 2 :
                        tab.setText("Google");
                }
            }
        });
        mediator.attach();
    }


}