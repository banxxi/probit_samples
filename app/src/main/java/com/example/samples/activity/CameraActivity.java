package com.example.samples.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.samples.R;

public class CameraActivity extends AppCompatActivity {

    private static final int CAMERA_PERMISSION_REQUEST_CODE = 10;
    private static final int CAMERA_CAPTURE_REQUEST_CODE = 11;

    private Button takeAPicture;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        Bundle bundle = savedInstanceState != null ? savedInstanceState : getIntent().getExtras();
        getSupportActionBar().setTitle(bundle.getString("title", "Title"));
        takeAPicture = findViewById(R.id.takeAPicture);
        image = findViewById(R.id.image);
        takeAPicture.setOnClickListener(v -> {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                openCamera();
            } else if (android.os.Build.VERSION.SDK_INT > 23) {
                requestPermissions(new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_REQUEST_CODE);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            openCamera();
        }
    }

    private void openCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA_CAPTURE_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_CAPTURE_REQUEST_CODE && resultCode == RESULT_OK) {
            takeAPicture.setVisibility(View.INVISIBLE);
            image.setVisibility(View.VISIBLE);
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            image.setImageBitmap(bitmap);
        }
    }
}