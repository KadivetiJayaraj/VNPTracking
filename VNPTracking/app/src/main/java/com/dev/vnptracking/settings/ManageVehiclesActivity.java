package com.dev.vnptracking.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.dev.vnptracking.R;
import com.dev.vnptracking.newvehicle.NewVehicleActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ManageVehiclesActivity extends AppCompatActivity {

    @BindView(R.id.add_vehicle) RelativeLayout addVehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_vehicles);
        ButterKnife.bind(this);

        addVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManageVehiclesActivity.this, NewVehicleActivity.class));
            }
        });
    }
}