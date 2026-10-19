package com.example.project;

import static android.widget.Toast.LENGTH_SHORT;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        ArrayList<CutomItem> items = new ArrayList<>();
        items.add(new CutomItem(R.drawable.apple, "Apple(사과)"));
        items.add(new CutomItem(R.drawable.banana, "Banana(바나나)"));
        items.add(new CutomItem(R.drawable.cherry, "Cherry(체리)"));
        items.add(new CutomItem(R.drawable.mango, "Mango(망고)"));
        items.add(new CutomItem(R.drawable.melon, "Melon(멜론)"));
        items.add(new CutomItem(R.drawable.pear, "Pear(배)"));
        items.add(new CutomItem(R.drawable.persimmon, "Persimmon(감)"));
        items.add(new CutomItem(R.drawable.pineapple, "PineApple(파인애플)"));
        items.add(new CutomItem(R.drawable.strawberry, "Strawberry(딸기)"));


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(RecyclerViewActivity.this);
        recyclerView.setLayoutManager(manager);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(RecyclerViewActivity.this, items);
        recyclerView.setAdapter(adapter);

        Button button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        EditText editText = findViewById(R.id.editText);
        Button button1 = findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                if (name.isEmpty()) {
                    Toast.makeText(getBaseContext(), "과일 이름 입력", LENGTH_SHORT).show();
                } else {
                    items.add(new CutomItem(R.mipmap.ic_launcher, name));
                    adapter.notifyItemInserted(items.size() - 1);
                    editText.setText("");
                }

            }
        });
    }
}