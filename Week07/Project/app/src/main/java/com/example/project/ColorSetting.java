package com.example.project;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;

public class ColorSetting {
    private Context context;
    private ActionBar actionBar;

    public ColorSetting(Context context, ActionBar actionBar) {
        this.context = context;
        this.actionBar = actionBar;
    }

    public void setting() {
        View view = LayoutInflater.from(context).inflate(R.layout.color_dialog, null);

        TextView textView1 = view.findViewById(R.id.textView1);
        TextView textView2 = view.findViewById(R.id.textView2);
        TextView textView3 = view.findViewById(R.id.textView3);

        Button button = view.findViewById(R.id.button);
        button.setBackgroundColor(MainActivity.current);

        SeekBar seekBar1 = view.findViewById(R.id.seekBar1);
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                MainActivity.color[0] = progress;
                changeColor(button, textView1, textView2, textView3);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        SeekBar seekBar2 = view.findViewById(R.id.seekBar2);
        seekBar2.setProgress(MainActivity.color[1]);
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                MainActivity.color[1] = progress;
                changeColor(button, textView1, textView2, textView3);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        SeekBar seekBar3 = view.findViewById(R.id.seekBar3);
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                MainActivity.color[2] = progress;
                changeColor(button, textView1, textView2, textView3);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("ActionBar 배경색을 선택해주세요");
        builder.setView(view);
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                actionBar.setBackgroundDrawable(new ColorDrawable(MainActivity.current));
            }
        });

        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setCancelable(false);
        builder.create();
        builder.show();
        changeColor(button, textView1, textView2, textView3);
    }

    private void changeColor(Button button, TextView textView1, TextView textView2, TextView textView3) {
        MainActivity.current = Color.rgb(MainActivity.color[0], MainActivity.color[1], MainActivity.color[2]);

        textView1.setText("Red : " + MainActivity.color[0] + "(" +
                (MainActivity.color[0] == 0 ? "00" : String.format("%2H", MainActivity.color[0])) + ")");
        textView2.setText("Green : " + MainActivity.color[1] + "(" +
                (MainActivity.color[1] == 0 ? "00" : String.format("%2H", MainActivity.color[1])) + ")");
        textView3.setText("Blue : " + MainActivity.color[2] + "(" +
                (MainActivity.color[2] == 0 ? "00" : String.format("%2H", MainActivity.color[2])) + ")");
        button.setBackgroundColor(MainActivity.current);
    }
}
