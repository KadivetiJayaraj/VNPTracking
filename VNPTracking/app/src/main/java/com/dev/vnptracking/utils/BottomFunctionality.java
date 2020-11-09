package com.dev.vnptracking.utils;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.dev.vnptracking.R;
import com.dev.vnptracking.dashboard.DashboardActivity;
import com.dev.vnptracking.dashboard.FasttagActivity;
import com.dev.vnptracking.dashboard.SettingActivity;
import com.dev.vnptracking.dashboard.SpyModeActivity;
import com.dev.vnptracking.dashboard.VehiclesActivity;

public class BottomFunctionality {
    public final Context context;
    public LinearLayout homeLL,trackLL,menuLL,spy_modeLL,notificationLL;

    public BottomFunctionality(Context context) {
        this.context=context;
    }

    public void getfunctionality(View view) {
        homeLL=(LinearLayout)view.findViewById(R.id.home_bottom_LL);
        trackLL=(LinearLayout)view.findViewById(R.id.vehicle_bottom_LL);
        menuLL=(LinearLayout)view.findViewById(R.id.setting_bottom_LL);
        notificationLL=(LinearLayout)view.findViewById(R.id.fast_tag_bottom_ll);
        spy_modeLL=(LinearLayout)view.findViewById(R.id.spy_mode_bottom);
        homeLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(context instanceof DashboardActivity)){
                    context.startActivity(new Intent(context, DashboardActivity.class));
                }
            }
        });
        trackLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(context instanceof VehiclesActivity)){
                    context.startActivity(new Intent(context,VehiclesActivity.class));
                }
            }
        });
        menuLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(context instanceof SettingActivity)){
                    context.startActivity(new Intent(context,SettingActivity.class));
                }
            }
        });
        notificationLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(context instanceof FasttagActivity)){
                    context.startActivity(new Intent(context,FasttagActivity.class));
                }
            }
        });
        spy_modeLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(context instanceof SpyModeActivity)){
                    context.startActivity(new Intent(context,SpyModeActivity.class));
                }
            }
        });
    }
}
