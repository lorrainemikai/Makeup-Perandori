    package com.mikazz.makeupperandori;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mikazz.makeupperandori.models.Makeup;
import com.mikazz.makeupperandori.services.MakeupService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

    public class MainActivity extends AppCompatActivity {


        @BindView(R.id.searchBrandEditText)EditText mSearchBrandEditText;
        @BindView(R.id.searchBrandButton)Button mSearchBrandButton;
public List<Makeup> makeup = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSearchBrandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search = mSearchBrandEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this,DisplayMakeupActivity.class);
                intent.putExtra("search", search);
                startActivity(intent);
            }
        });
    }

}
