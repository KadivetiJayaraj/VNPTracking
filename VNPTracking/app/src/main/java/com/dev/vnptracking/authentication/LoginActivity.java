package com.dev.vnptracking.authentication;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dev.vnptracking.dashboard.DashboardActivity;
import com.dev.vnptracking.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.forget_pass_tt)
    TextView forgetPassTt;
    @BindView(R.id.img_username)
    ImageView imgUsername;
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.img_pass)
    ImageView imgPass;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.tvLoginRel)
    RelativeLayout tvLoginRel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        forgetPassTt.setPaintFlags(forgetPassTt.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        forgetPassTt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ForgetPasswordActivity.class));
            }
        });
        tvLoginRel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
            }
        });
    }
    @Override
    public void onBackPressed(){

    }
}
