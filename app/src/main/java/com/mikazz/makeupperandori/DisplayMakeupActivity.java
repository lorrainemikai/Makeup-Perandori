package com.mikazz.makeupperandori;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mikazz.makeupperandori.adapters.MakeupDisplayListAdapter;
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

public class DisplayMakeupActivity extends AppCompatActivity {
    public static final String TAG = DisplayMakeupActivity.class.getSimpleName();
    public List<Makeup> makeups = new ArrayList<>();
    @BindView(R.id.recyclerView)RecyclerView mRecyclerView;
    private MakeupDisplayListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_makeup);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String brand = intent.getStringExtra("search");
        getBrand(brand);
    }

    private void getBrand(final String brand){
     final MakeupService makeupService=new MakeupService();
     makeupService.findBrand(brand, new Callback() {
         @Override
         public void onFailure(Call call, IOException e) {
             e.printStackTrace();
         }

         @Override
         public void onResponse(Call call, Response response) {

             makeups = makeupService.processResults(response);
             DisplayMakeupActivity.this.runOnUiThread(() -> {

                    mAdapter = new MakeupDisplayListAdapter(getApplicationContext(), makeups);
                    mRecyclerView.setAdapter(mAdapter);
                     RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DisplayMakeupActivity.this);
                     mRecyclerView.setLayoutManager(layoutManager);
                     mRecyclerView.setHasFixedSize(true);

             });

         }
     });
    }
}
