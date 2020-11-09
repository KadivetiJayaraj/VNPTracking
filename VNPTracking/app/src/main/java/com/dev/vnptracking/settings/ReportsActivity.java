package com.dev.vnptracking.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.dev.vnptracking.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReportsActivity extends AppCompatActivity {

    @BindView(R.id.daily) Button daily;
    @BindView(R.id.trips) Button trips;
    @BindView(R.id.stops) Button stops;
    @BindView(R.id.linear1) LinearLayout linear1;
    @BindView(R.id.linear2) LinearLayout linear2;
    @BindView(R.id.linear3) LinearLayout linear3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);
        ButterKnife.bind(this);
        linear1.setVisibility(View.VISIBLE);
        daily.setBackgroundResource(R.drawable.et_rect_red);
        daily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                daily.setBackgroundResource(R.drawable.et_rect_red);
                trips.setBackgroundResource(R.drawable.et_rect_grey);
                stops.setBackgroundResource(R.drawable.et_rect_grey);
                linear1.setVisibility(View.VISIBLE);
                linear2.setVisibility(View.GONE);
                linear3.setVisibility(View.GONE);
            }
        });
        trips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                daily.setBackgroundResource(R.drawable.et_rect_grey);
                trips.setBackgroundResource(R.drawable.et_rect_red);
                stops.setBackgroundResource(R.drawable.et_rect_grey);
                linear1.setVisibility(View.GONE);
                linear2.setVisibility(View.VISIBLE);
                linear3.setVisibility(View.GONE);
            }
        });
        stops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                daily.setBackgroundResource(R.drawable.et_rect_grey);
                trips.setBackgroundResource(R.drawable.et_rect_grey);
                stops.setBackgroundResource(R.drawable.et_rect_red);
                linear1.setVisibility(View.GONE);
                linear2.setVisibility(View.GONE);
                linear3.setVisibility(View.VISIBLE);
            }
        });

    }
}