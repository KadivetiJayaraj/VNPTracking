package com.dev.vnptracking.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.dev.vnptracking.R;
import com.dev.vnptracking.addvehicle.AddVehicleActivity;
import com.dev.vnptracking.utils.BottomFunctionality;
import com.dev.vnptracking.utils.UtilsClass;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VehiclesActivity extends AppCompatActivity {

    @BindView(R.id.mainRel)
    RelativeLayout mainRel;
    @BindView(R.id.add_vehicle)
    RelativeLayout addVehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicles);
        ButterKnife.bind(this);
        BottomFunctionality bottomFunctionality = new BottomFunctionality(VehiclesActivity.this);
        bottomFunctionality.getfunctionality(this.findViewById(android.R.id.content));
        addVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VehiclesActivity.this, AddVehicleActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        UtilsClass.getOnBackPressed(VehiclesActivity.this);
    }
}
