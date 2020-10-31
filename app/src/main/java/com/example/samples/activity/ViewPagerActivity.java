package com.example.samples.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.samples.R;
import com.example.samples.adapter.ViewPagerAdapter;

import java.util.Arrays;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        viewPager = findViewById(R.id.pager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapter.setTitles(listOf("Title 1", "Title 2", "Title 3"));
        viewPager.setAdapter(adapter);

    }

    private List<String> listOf(String... s) {
        return Arrays.asList(s);
    }
}