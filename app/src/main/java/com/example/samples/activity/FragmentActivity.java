package com.example.samples.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.samples.fragment.BlankFragment;
import com.example.samples.R;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);
        Bundle bundle = savedInstanceState != null ? savedInstanceState : getIntent().getExtras();
        getSupportActionBar().setTitle(bundle.getString("title", "Title"));
        getSupportFragmentManager().beginTransaction()
                .add(android.R.id.content, BlankFragment.newInstance("First Param", "Second Param"))
                .commit();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("title", getSupportActionBar().getTitle().toString());
    }
}