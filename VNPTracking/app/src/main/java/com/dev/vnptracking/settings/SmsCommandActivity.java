package com.dev.vnptracking.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.dev.vnptracking.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SmsCommandActivity extends AppCompatActivity {

    @BindView(R.id.relative) RelativeLayout relative;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_command);
        ButterKnife.bind(this);

        relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBox();
            }
        });
    }

    public void dialogBox()
    {

    }
}