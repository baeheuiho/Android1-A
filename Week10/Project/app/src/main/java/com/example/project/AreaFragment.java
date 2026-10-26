package com.example.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AreaFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_area, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText editText = view.findViewById(R.id.editText2);
        TextView textView = view.findViewById(R.id.textView2);
        Button button1 = view.findViewById(R.id.button21);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyMethod method = new MyMethod(getActivity());
                method.changeToPyung(editText, textView);

            }
        });

        Button button2 = view.findViewById(R.id.button22);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyMethod method = new MyMethod(getActivity());
                method.changeToMeter(editText, textView);
            }
        });
    }
}
