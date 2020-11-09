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

public class DetailsSignUpActivity extends AppCompatActivity {

    @BindView(R.id.img_username)
    ImageView imgUsername;
    @BindView(R.id.et_fullName)
    EditText etFullName;
    @BindView(R.id.img_pass)
    ImageView imgPass;
    @BindView(R.id.etEmail)
    EditText etEmail;
    @BindView(R.id.tv_login_now_Rel)
    RelativeLayout tvLoginNowRel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_sign_up);
        ButterKnife.bind(this);
        tvLoginNowRel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vaidate()){
                    startActivity(new Intent(DetailsSignUpActivity.this,LoginActivity.class));
                }
            }
        });
    }

    private boolean vaidate() {
        if(etFullName.getText().toString().isEmpty()){
            Toast.makeText(DetailsSignUpActivity.this,"Please Enter Full Name",Toast.LENGTH_LONG).show();
        }
        else if(etEmail.getText().toString().isEmpty()){
            Toast.makeText(DetailsSignUpActivity.this,"Please Enter Email ID",Toast.LENGTH_LONG).show();
        }
        else {
            return true;
        }
        return false;
    }
}
