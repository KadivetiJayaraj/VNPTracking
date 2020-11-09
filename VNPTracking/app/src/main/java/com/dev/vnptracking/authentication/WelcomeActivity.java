package com.dev.vnptracking.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.dev.vnptracking.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.tvLoginRel)
    RelativeLayout tvLoginRel;
    @BindView(R.id.tv_signUp_rel)
    RelativeLayout tvSignUpRel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        tvLoginRel.setOnClickListener(this);
        tvSignUpRel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==tvLoginRel){
            startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
        }
        if(v==tvSignUpRel){
            startActivity(new Intent(WelcomeActivity.this, SignUpActivity.class));
        }
    }
}
