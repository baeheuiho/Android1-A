package com.example.project;

import static android.widget.Toast.LENGTH_SHORT;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setLogo(R.mipmap.ic_launcher);
            actionBar.setDisplayUseLogoEnabled(true); // 로고 표시 활성화
            actionBar.setDisplayShowHomeEnabled(true); // 홈 아이콘 표시 활성화
        }

        TextView textView = findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    textView.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.red));
                    Toast.makeText(getBaseContext(), "눌렀네요", LENGTH_SHORT).show();
                } else {
                    textView.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.black));
                    Snackbar.make(v, "눌렀네요", BaseTransientBottomBar.LENGTH_SHORT).show();
                }
                flag = !flag;
            }
        });

    }
}