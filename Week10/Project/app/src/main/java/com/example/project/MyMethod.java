package com.example.project;

import static android.widget.Toast.LENGTH_SHORT;

import android.content.Context;
import android.graphics.Color;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MyMethod {
    private Context context;
    final double Official = 3.305785;
    public MyMethod(Context context) {
        this.context = context;
    }

    public void bmi(EditText editText1, EditText editText2, TextView textView) {
        String height = editText1.getText().toString();
        String weight = editText2.getText().toString();

        if (height.isEmpty() || weight.isEmpty()) {
            Toast.makeText(context, "값을 입력하세요", LENGTH_SHORT).show();
        } else {
            double height1 = Double.parseDouble(height) / 100;
            double weight1 = Double.parseDouble(weight);
            double result = weight1 / (height1 * height1);

            if (result < 18.5) {
                textView.setTextColor(Color.RED);
                textView.setText(String.format("BMI : %.2f, %s", result, "체중 부족 !!"));
            } else if (result < 22.9) {
                textView.setTextColor(Color.GREEN);
                textView.setText(String.format("BMI : %.2f, %s", result, "정상!!"));
            } else if (result < 24.9) {
                textView.setTextColor(Color.RED);
                textView.setText(String.format("BMI : %.2f, %s", result, "과체중!!"));
            } else if (result > 25) {
                textView.setTextColor(Color.RED);
                textView.setText(String.format("BMI : %.2f, %s", result, "비만!!"));
            }
        }
    }

    public void changeToPyung(EditText editText, TextView textView) {
        String temp = editText.getText().toString();
        if (temp.isEmpty()) {
            Toast.makeText(context, "값을 입력하세요", LENGTH_SHORT).show();
        } else {
            double temp1 = Double.parseDouble(temp);
            double result = Math.round(temp1 / Official * 100) / 100.0;
            textView.setText(result + " 평");
        }
    }

    public void changeToMeter(EditText editText, TextView textView) {
        String temp = editText.getText().toString();

        if (temp.isEmpty()) {
            Toast.makeText(context, "값을 입력하세요", LENGTH_SHORT).show();
        } else {
            double temp1 = Double.parseDouble(temp);
            double result = temp1 * Official;
            textView.setText(result + " 제곱미터");
        }
    }
}
