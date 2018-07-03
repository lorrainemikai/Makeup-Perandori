package com.mikazz.makeupperandori;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity {
@BindView(R.id.userNameEditTextView)EditText mUserNameEditTextView;
@BindView(R.id.emailEditText)EditText mEmailEditText;
@BindView(R.id.firstPasswordEditText)EditText mFirstPasswordEditText;
@BindView(R.id.secondPasswordEditText)EditText mSecondPasswordEditText;
@BindView(R.id.loginTextView)TextView mLoginTextView;
@BindView(R.id.signupButton)Button mSignupButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        mLoginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        mSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mUserNameEditTextView.getText().toString();
                String email = mEmailEditText.getText().toString();
                String password = mFirstPasswordEditText.getText().toString();
                String passwordSecond =mSecondPasswordEditText.getText().toString();
                Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
