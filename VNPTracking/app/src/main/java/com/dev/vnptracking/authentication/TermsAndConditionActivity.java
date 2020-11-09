package com.dev.vnptracking.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.dev.vnptracking.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TermsAndConditionActivity extends AppCompatActivity {

    @BindView(R.id.tv_yes_agree)
    RelativeLayout tvYesAgree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_condition);
        ButterKnife.bind(this);
        tvYesAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TermsAndConditionActivity.this,DetailsSignUpActivity.class));
            }
        });
    }
}
