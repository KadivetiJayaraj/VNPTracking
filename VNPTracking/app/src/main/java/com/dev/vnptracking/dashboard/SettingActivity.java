package com.dev.vnptracking.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.dev.vnptracking.R;
import com.dev.vnptracking.addvehicle.AddVehicleActivity;
import com.dev.vnptracking.newvehicle.NewVehicleActivity;
import com.dev.vnptracking.settings.AppSettingsActivity;
import com.dev.vnptracking.settings.HelpActivity;
import com.dev.vnptracking.settings.ImmobilizeActivity;
import com.dev.vnptracking.settings.ManageGeofenceActivity;
import com.dev.vnptracking.settings.ManageVehiclesActivity;
import com.dev.vnptracking.settings.ProfileActivity;
import com.dev.vnptracking.settings.ReportsActivity;
import com.dev.vnptracking.settings.ShareActivity;
import com.dev.vnptracking.settings.SmsCommandActivity;
import com.dev.vnptracking.utils.BottomFunctionality;
import com.dev.vnptracking.utils.UtilsClass;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingActivity extends AppCompatActivity {

    @BindView(R.id.immobilize) ImageView immobilize;
    @BindView(R.id.report) ImageView report;
    @BindView(R.id.share) ImageView share;
    @BindView(R.id.profile) RelativeLayout profile;
    @BindView(R.id.geofence) RelativeLayout geofence;
    @BindView(R.id.managevehicles) RelativeLayout managevehicles;
    @BindView(R.id.sms_command) RelativeLayout smsCommand;
    @BindView(R.id.setting) RelativeLayout setting;
    @BindView(R.id.logout) RelativeLayout logout;
    @BindView(R.id.help) LinearLayout help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        BottomFunctionality bottomFunctionality = new BottomFunctionality(SettingActivity.this);
        bottomFunctionality.getfunctionality(this.findViewById(android.R.id.content));

        immobilize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingActivity.this, ImmobilizeActivity.class));
            }
        });
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingActivity.this, ReportsActivity.class));
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingActivity.this, ShareActivity.class));
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingActivity.this, ProfileActivity.class));
            }
        });
        managevehicles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingActivity.this, ManageVehiclesActivity.class));
            }
        });
        geofence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingActivity.this, ManageGeofenceActivity.class));
            }
        });
        smsCommand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingActivity.this, SmsCommandActivity.class));
            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingActivity.this, AppSettingsActivity.class));
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingActivity.this, HelpActivity.class));
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UtilsClass.getOnBackPressed(SettingActivity.this);
            }
        });

    }
    @Override
    public void onBackPressed() {
        UtilsClass.getOnBackPressed(SettingActivity.this);
    }
}
