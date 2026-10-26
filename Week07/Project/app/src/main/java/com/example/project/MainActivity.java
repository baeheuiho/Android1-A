package com.example.project;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListPopupWindow;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ActionBar actionBar;
    private EditText editText;
    static int current = Color.GREEN;
    static int[] color = new int[] {0, 255, 0};

    private TextView textView;
    private int type = 1;
    private ListPopupWindow window;
    private PopupMenu popupMenu;
    String[] colors = {"버튼 배경색 선택", "Red", "Green", "Blue", "Yellow",
            "Cyan", "Magenta"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CheckBox checkBox = findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBox.setText("StatusBar 감추기");
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                } else {
                    checkBox.setText("StatusBar 보이기");
                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                            WindowManager.LayoutParams.FLAG_FULLSCREEN);
                }
            }
        });
        checkBox.performClick();

        actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));

        ToggleButton toggleButton = findViewById(R.id.toggle);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    actionBar.show();
                } else {
                    actionBar.hide();
                }
            }
        });
        toggleButton.performClick();

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        registerForContextMenu(textView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (window.isShowing()){
                    window.dismiss();
                } else {
                    window.show();
                }
            }
        });

        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                popupMenu.show();
                return false;
            }
        });

        window = new ListPopupWindow(MainActivity.this);
        window.setWidth(450);
        window.setHeight(600);
        window.setAnchorView(button);
        window.setAdapter(new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, colors));
        window.setModal(true);
        window.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1:
                        button.setBackgroundColor(Color.RED);
                        break;
                    case 2:
                        button.setBackgroundColor(Color.GREEN);
                        break;
                }
            }
        });

        popupMenu = new PopupMenu(MainActivity.this, button);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.buttonmenu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.itemBlack) {
                    button.setTextColor(Color.BLACK);
                } else if (item.getItemId() == R.id.itemRed) {
                    button.setTextColor(Color.RED);
                }else if (item.getItemId() == R.id.itemBlue) {
                    button.setTextColor(Color.BLUE);
                }
                item.setChecked(true);

                return true;
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("TextView 메뉴");
        menu.add(0, 1, 0, "글자색 Black").setChecked(true);
        menu.add(0, 2, 1, "글자색 Red" );
        menu.add(0, 3, 2, "글자색 Blue");
        menu.setGroupCheckable(0, true, true);
        menu.findItem(type).setChecked(true);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == 1){
            textView.setTextColor(Color.BLACK);
            type = 1;
        } else if (item.getItemId() == 2) {
            textView.setTextColor(Color.RED);
            type = 2;
        } else if (item.getItemId() == 3) {
            textView.setTextColor(Color.BLUE);
            type = 3;
        }

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item1) {
            ColorSetting colorSetting = new ColorSetting(MainActivity.this, actionBar);
            colorSetting.setting();

        } else if (item.getItemId() == R.id.size1) {
            editText.setTextSize(24.0f);
        } else if (item.getItemId() == R.id.size2) {
            editText.setTextSize(14.0f);

        } else if (item.getItemId() == R.id.size3) {
            editText.setTextSize(18.0f);
        }
        item.setChecked(true);
        return true;
    }


}