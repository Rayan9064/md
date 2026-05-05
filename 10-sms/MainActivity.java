package com.example.smsdemo2;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    EditText et1, et2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // request permission for sms
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, PackageManager.PERMISSION_GRANTED);
        // create objects of views
        btn1 = findViewById(R.id.btnSendSMS);
        et1 = findViewById(R.id.editText1);
        et2 = findViewById(R.id.editText2);
        // on click listener
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = et1.getText().toString(); // fetching values of phone no. and message
                String sms = et2.getText().toString();
                try {
                    SmsManager smsmanager = SmsManager.getDefault(); // create object of smsmanager
                    smsmanager.sendTextMessage(number, null, sms, null, null);
                    Toast.makeText(getApplicationContext(), "Message sent success", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}