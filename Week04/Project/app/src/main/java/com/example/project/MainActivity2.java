package com.example.project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    private int progress = 0;
    private final int MAX = 100;
    private final int MIN = 0;
    private TextView textView1, textView2, textView3;
    private ProgressBar progressBar1, progressBar2, progressBar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView1 = findViewById(R.id.textView1);
        progressBar1 = findViewById(R.id.progress1);
        textView2 = findViewById(R.id.textView2);
        progressBar2 = findViewById(R.id.progress2);
        textView3 = findViewById(R.id.textView3);
        progressBar3 = findViewById(R.id.progress3);
        print();

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress += 10;
                if (progress >= MAX)
                    progress = MAX;
                print();
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress -= 10;
                if (progress <= MIN)
                    progress = MIN;
                print();
            }
        });
    }

    private void print() {
        textView1.setText(String.format("%d %%", progress));
        progressBar1.setProgress(progress);
        textView2.setText(String.format("%d %%", progress));
        progressBar2.setProgress(progress);
        textView3.setText(String.format("%d %%", progress));
        progressBar3.setProgress(progress);
    }
}