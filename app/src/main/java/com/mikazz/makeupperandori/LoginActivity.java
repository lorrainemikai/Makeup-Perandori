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

public class LoginActivity extends AppCompatActivity {
@BindView(R.id.emailEditTextView)EditText mEmailEditTextView;
@BindView(R.id.passwordEditTextView)EditText mPasswordEditTextView;
@BindView(R.id.loginButton)Button mLoginButton;
@BindView(R.id.signupTextView)TextView mSignupTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mSignupTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String name = mEmailEditTextView .getText().toString();
            String password = mPasswordEditTextView.getText().toString();
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);


            startActivity(intent);
            }
        });
    }
}
