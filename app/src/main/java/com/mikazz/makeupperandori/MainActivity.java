    package com.mikazz.makeupperandori;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

    public class MainActivity extends AppCompatActivity {
@BindView(R.id.searchBrandEditText)EditText mSearchBrandEditText;
@BindView(R.id.searchBrandButton)Button mSearchBrandButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSearchBrandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search = mSearchBrandButton.getText().toString();
                Intent intent = new Intent(MainActivity.this,DisplayMakeupActivity.class);
                startActivity(intent);
            }
        });
    }
}
