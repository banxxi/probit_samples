package com.example.samples.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.samples.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.helloWorld:
                i = new Intent(this, HelloWorldActivity.class);
                i.putExtra("title", "Hello World");
                startActivity(i);
                break;
            case R.id.fragment:
                i = new Intent(this, FragmentActivity.class);
                i.putExtra("title", "Fragment Activity");
                startActivity(i);
                break;
            case R.id.list:
                i = new Intent(this, ListActivity.class);
                i.putExtra("title", "List Activity");
                startActivity(i);
                break;
            case R.id.permissions:
                i = new Intent(this, PermissionsActivity.class);
                i.putExtra("title", "Permissions Activity");
                startActivity(i);
                break;
            case R.id.camera:
                i = new Intent(this, CameraActivity.class);
                i.putExtra("title", "Camera Activity");
                startActivity(i);
                break;
        }
    }
}