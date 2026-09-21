package com.example.project;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;
import static android.widget.Toast.LENGTH_SHORT;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity2 extends AppCompatActivity {
    private String gender = "남자";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        LinearLayout layout1 = findViewById(R.id.layout1);
        LinearLayout layout2 = findViewById(R.id.layout2);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout1.setVisibility(VISIBLE);
                layout2.setVisibility(INVISIBLE);
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout1.setVisibility(INVISIBLE);
                layout2.setVisibility(VISIBLE);
            }
        });

        EditText editText1 = findViewById(R.id.editText11);
        TextView textView1 = findViewById(R.id.textView11);
        Button button11 = findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText1.getText().toString();
                if (name.isEmpty()) {
                    Toast.makeText(getBaseContext(), "이름 입력하세요", LENGTH_SHORT).show();
                } else {
                    textView1.setText("환영합니다....." + name + " 님");
                    editText1.setText("");
                }
            }
        });

        EditText editText2 = findViewById(R.id.editText21);
        TextView textView2 = findViewById(R.id.textView21);
        ImageView imageView = findViewById(R.id.imageView21);

        RadioGroup group = findViewById(R.id.group21);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
                if (checkedId == R.id.radio1) {
                    imageView.setImageResource(R.drawable.man1);
                    gender = "남자";
                } else {
                    imageView.setImageResource(R.drawable.woman1);
                    gender = "여자";
                }
            }
        });

        Button button21 = findViewById(R.id.button21);
        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText2.getText().toString();
                if (name.isEmpty()) {
                    Snackbar.make(v, "이름을 입력하세요", BaseTransientBottomBar.LENGTH_SHORT).show();
                } else {
                    textView2.setText(String.format("안녕하세요...%s (%s)님 ", name, gender));
                    editText2.setText("");
                }
            }
        });



    }
}