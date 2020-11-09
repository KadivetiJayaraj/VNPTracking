package com.dev.vnptracking.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.dev.vnptracking.R;
import com.dev.vnptracking.geofence.AddGeofenceActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ManageGeofenceActivity extends AppCompatActivity {

    @BindView(R.id.geofence) Button geofence;
    @BindView(R.id.vehicles) Button vehicles;
    @BindView(R.id.linear1) LinearLayout linear1;
    @BindView(R.id.linear2) LinearLayout linear2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_geofence);
        ButterKnife.bind(this);

        linear1.setVisibility(View.VISIBLE);
        geofence.setBackgroundResource(R.drawable.et_rect_red);

        geofence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                geofence.setBackgroundResource(R.drawable.et_rect_red);
                vehicles.setBackgroundResource(R.drawable.et_rect_grey);
                linear1.setVisibility(View.VISIBLE);
                linear2.setVisibility(View.GONE);
            }
        });
        vehicles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                geofence.setBackgroundResource(R.drawable.et_rect_grey);
                vehicles.setBackgroundResource(R.drawable.et_rect_red);
                linear1.setVisibility(View.GONE);
                linear2.setVisibility(View.VISIBLE);
            }
        });

        linear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManageGeofenceActivity.this, AddGeofenceActivity.class));
            }
        });

    }
}