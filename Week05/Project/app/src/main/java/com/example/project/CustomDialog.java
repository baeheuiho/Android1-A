package com.example.project;

import static android.widget.Toast.LENGTH_SHORT;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.Objects;

public class CustomDialog extends Dialog {
    private Context context;

    public CustomDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Objects.requireNonNull(getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams window = new WindowManager.LayoutParams();
        window.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        window.dimAmount= 0.5f;
        getWindow().setAttributes(window);
        setContentView(R.layout.custom_dialog);

        EditText editText = findViewById(R.id.editText);
        Button button81 = findViewById(R.id.button81);
        button81.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        Button button82 = findViewById(R.id.button82);
        button82.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();
                if (message.isEmpty()) {
                    Toast.makeText(getContext(), "입력해주세요", LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), message, LENGTH_SHORT).show();
                    dismiss();
                }

            }
        });
    }
}
