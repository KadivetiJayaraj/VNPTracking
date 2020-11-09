package com.dev.vnptracking.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dev.vnptracking.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity {

    @BindView(R.id.img_username)
    ImageView imgUsername;
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.img_pass)
    ImageView imgPass;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.eye_pass_show)
    ImageView eyePassShow;
    @BindView(R.id.eye_pass_hide)
    ImageView eyePassHide;
    @BindView(R.id.eye_pass_rel)
    RelativeLayout eyePassRel;
    @BindView(R.id.img_confirm_pass)
    ImageView imgConfirmPass;
    @BindView(R.id.et_confirm_password)
    EditText etConfirmPassword;
    @BindView(R.id.eye_confirm_pass_show)
    ImageView eyeConfirmPassShow;
    @BindView(R.id.eye_confirm_pass_hide)
    ImageView eyeConfirmPassHide;
    @BindView(R.id.eye_confirm_pass_rel)
    RelativeLayout eyeConfirmPassRel;
    @BindView(R.id.tvCreateAccount)
    RelativeLayout tvCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        tvCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    startActivity(new Intent(SignUpActivity.this,OtpActivity.class));
                }
            }
        });
    }

    private boolean validate() {
        if(etUsername.getText().toString().isEmpty()){
            Toast.makeText(SignUpActivity.this,"Please Enter Username",Toast.LENGTH_LONG).show();
        }
        else if(etPassword.getText().toString().isEmpty()){
            Toast.makeText(SignUpActivity.this,"Please Enter Password",Toast.LENGTH_LONG).show();
        }
        else if(etPassword.getText().toString().length() < 6){
            Toast.makeText(SignUpActivity.this,"Please Enter six digit password",Toast.LENGTH_LONG).show();
        }
        else if(etConfirmPassword.getText().toString().isEmpty()){
            Toast.makeText(SignUpActivity.this,"Please Enter Confirm Password",Toast.LENGTH_LONG).show();
        }
        else if(!etPassword.getText().toString().equalsIgnoreCase(etConfirmPassword.getText().toString())){
            Toast.makeText(SignUpActivity.this,"Password and Confirm password not matched",Toast.LENGTH_LONG).show();
        }
        else {
            return true;
        }
        return false;
    }
}
