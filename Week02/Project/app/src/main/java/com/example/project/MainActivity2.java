package com.example.project;

import static android.widget.Toast.LENGTH_SHORT;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity2 extends AppCompatActivity {
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle(R.string.app2);

        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(100);
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);

        TextView textView1 = findViewById(R.id.textView1);
        textView1.setSelected(true);
        textView1.startAnimation(anim);

        TextView textView2 = findViewById(R.id.textView2);
        textView2.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.red));
        textView2.startAnimation(anim);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    button.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.blue));
                    Toast.makeText(getBaseContext(), "Button Clicked", LENGTH_SHORT).show();
                } else {
                    button.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.gray));
                    Snackbar.make(v, "Button Clicked", BaseTransientBottomBar.LENGTH_SHORT).show();
                }
                flag = !flag;
            }
        });

        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getBaseContext(), "Long Clicked", LENGTH_SHORT).show();
                return true;
            }
        });

    }

    public void textViewClicked(View view) {
        Toast.makeText(getBaseContext(), "클릭했습니다", LENGTH_SHORT).show();
    }
}