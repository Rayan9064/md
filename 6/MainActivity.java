package com.example.uidemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    CheckBox exampleCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Declaring view objects and finding them by their id
        Button example = findViewById(R.id.buttonExample);
        exampleCheckBox = findViewById(R.id.checkBoxExample);
        RadioGroup exampleRadioGroup = findViewById(R.id.radioGroupExample);
        ToggleButton exampletoggleButton = findViewById(R.id.toggleButtonExample);
        ImageButton exampleImageButton = findViewById(R.id.imageButtonExample);

        // Button Listener method implementation
        example.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Image Button Listener method implementation
        exampleImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Calling Image button", Toast.LENGTH_SHORT).show();
            }
        });

        // Toggle Button Listener method implementation
        exampletoggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (exampletoggleButton.isChecked()) {
                    Toast.makeText(getApplicationContext(), "ON Button clicked", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "OFF Button clicked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // CheckBox Listener method implementation
        exampleCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "Checked", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // RadioGroup Listener method implementation
        exampleRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedButtonId) {
                if (checkedButtonId == R.id.radioBtn1) {
                    Toast.makeText(getApplicationContext(), "Course selected-Arts", Toast.LENGTH_SHORT).show();
                }
                if (checkedButtonId == R.id.radioBtn2) {
                    Toast.makeText(getApplicationContext(), "Course selected-Science", Toast.LENGTH_SHORT).show();
                }
                if (checkedButtonId == R.id.radioBtn3) {
                    Toast.makeText(getApplicationContext(), "Course selected-Commerce", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
