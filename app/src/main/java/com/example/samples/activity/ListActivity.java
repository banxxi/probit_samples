package com.example.samples.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.samples.adapter.NameAdapter;
import com.example.samples.R;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Bundle bundle = savedInstanceState != null ? savedInstanceState : getIntent().getExtras();
        getSupportActionBar().setTitle(bundle.getString("title", "Title"));
        RecyclerView recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        List<String> names = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            names.add(String.format("Number %d", i));
        }
        recyclerView.setAdapter(new NameAdapter(names));
    }
}