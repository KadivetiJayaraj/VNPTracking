package com.dev.vnptracking.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.dev.vnptracking.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImmobilizeActivity extends AppCompatActivity {

    @BindView(R.id.mobilize) Button mobilize;
    @BindView(R.id.immobilize) Button immobilize;
    @BindView(R.id.linear1) LinearLayout linear1;
    @BindView(R.id.linear2) LinearLayout linear2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immobilize);
        ButterKnife.bind(this);

        linear1.setVisibility(View.VISIBLE);
        mobilize.setBackgroundResource(R.drawable.et_rect_red);
        mobilize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobilize.setBackgroundResource(R.drawable.et_rect_red);
                immobilize.setBackgroundResource(R.drawable.et_rect_grey);
                linear1.setVisibility(View.VISIBLE);
                linear2.setVisibility(View.GONE);
            }
        });
        immobilize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobilize.setBackgroundResource(R.drawable.et_rect_grey);
                immobilize.setBackgroundResource(R.drawable.et_rect_red);
                linear1.setVisibility(View.GONE);
                linear2.setVisibility(View.VISIBLE);
            }
        });
    }
}