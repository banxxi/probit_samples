package com.example.samples.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.PendingIntent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.samples.R;

public class PermissionsActivity extends AppCompatActivity {

    private static int SMS_PERMISSION_CODE = 11;
    private EditText phoneNumber;
    private EditText message;
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);
        phoneNumber = findViewById(R.id.number);
        message = findViewById(R.id.message);
        send = findViewById(R.id.send);
        send.setOnClickListener(v -> prepareSMS());
    }

    private void prepareSMS() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED)
            sendMessage();
        else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.SEND_SMS}, SMS_PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == SMS_PERMISSION_CODE && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            sendMessage();
    }

    private void sendMessage() {
        String number = phoneNumber.getText().toString();
        String msg = message.getText().toString();
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(number, null, msg, null, null);
        Toast.makeText(this, "SMS sent", Toast.LENGTH_SHORT).show();
    }
}