package com.dev.vnptracking.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dev.vnptracking.R;

import butterknife.ButterKnife;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        ButterKnife.bind(this);
    }
}