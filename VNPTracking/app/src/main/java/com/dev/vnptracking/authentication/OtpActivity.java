package com.dev.vnptracking.authentication;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dev.vnptracking.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OtpActivity extends AppCompatActivity {

    @BindView(R.id.et_otp)
    EditText etOtp;
    @BindView(R.id.send_again_tt)
    TextView sendAgainTt;
    @BindView(R.id.tv_next_Rel)
    RelativeLayout tvNextRel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        ButterKnife.bind(this);
        sendAgainTt.setPaintFlags(sendAgainTt.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tvNextRel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    startActivity(new Intent(OtpActivity.this,TermsAndConditionActivity.class));
                }
            }
        });
    }

    private boolean validate() {
        if(etOtp.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(OtpActivity.this,"Please Enter OTP",Toast.LENGTH_LONG).show();
        }
        else {
            return true;
        }
        return false;
    }
}
