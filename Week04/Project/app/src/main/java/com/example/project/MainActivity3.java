package com.example.project;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {
    private int redProgress = 0;
    private int greenProgress = 0;
    private int blueProgress = 0;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView textView1 = findViewById(R.id.textView1);
        textView1.setText(redProgress == 0 ? "0(00)" : String.format("%d(%2H)", redProgress, redProgress));
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText(greenProgress == 0 ? "0(00)" : String.format("%d(%2H)", greenProgress, greenProgress));
        TextView textView3 = findViewById(R.id.textView3);
        textView3.setText(blueProgress == 0 ? "0(00)" : String.format("%d(%2H)", blueProgress, blueProgress));
        result = findViewById(R.id.result);
        result.setText("000000");
        result.setBackgroundColor(Color.rgb(redProgress, greenProgress, blueProgress));

        SeekBar seekBar1 = findViewById(R.id.seekBar1);
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                redProgress = progress;
                textView1.setText(redProgress == 0 ? "0(00)" : String.format("%d(%2H)", redProgress, redProgress));
                changeColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar seekBar2 = findViewById(R.id.seekBar2);
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                greenProgress = progress;
                textView2.setText(greenProgress == 0 ? "0(00)" : String.format("%d(%2H)", greenProgress, greenProgress));
                changeColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar seekBar3 = findViewById(R.id.seekBar3);
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blueProgress = progress;
                textView3.setText(blueProgress == 0 ? "0(00)" : String.format("%d(%2H)", blueProgress, blueProgress));
                changeColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void changeColor() {
        int change = Color.rgb(redProgress, greenProgress, blueProgress);
        result.setText(
                (redProgress == 0 ? "00" : String.format("%2H", redProgress)) +
                        (greenProgress == 0 ? "00" : String.format("%2H", greenProgress)) +
                        (blueProgress == 0 ? "00" : String.format("%2H", blueProgress)));

        result.setBackgroundColor(change);
    }
}