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

        ViewPager2 viewPager2 = findViewById(R.id.viewPager2);
        Pager2Adapter adapter = new Pager2Adapter(this);
        viewPager2.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        TabLayoutMediator mediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int i) {
                switch (i) {
                    case 0 :
                        tab.setText("Battery");
                        break;
                    case 1 :
                        tab.setText("Custom Broadcast");
                        break;
                    case 2 :
                        tab.setText("Ordered");
                        break;
                }
            }
        });
        mediator.attach();

    }
}