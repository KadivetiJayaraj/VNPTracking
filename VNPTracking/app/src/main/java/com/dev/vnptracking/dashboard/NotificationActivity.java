package com.dev.vnptracking.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dev.vnptracking.R;
import com.dev.vnptracking.utils.BottomFunctionality;
import com.dev.vnptracking.utils.UtilsClass;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        BottomFunctionality bottomFunctionality = new BottomFunctionality(NotificationActivity.this);
        bottomFunctionality.getfunctionality(this.findViewById(android.R.id.content));
    }
    @Override
    public void onBackPressed() {
        UtilsClass.getOnBackPressed(NotificationActivity.this);
    }
}
