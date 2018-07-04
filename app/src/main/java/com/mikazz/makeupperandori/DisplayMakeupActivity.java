package com.mikazz.makeupperandori;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.mikazz.makeupperandori.models.Makeup;
import com.mikazz.makeupperandori.services.MakeupService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class DisplayMakeupActivity extends AppCompatActivity {
    public static final String TAG = DisplayMakeupActivity.class.getSimpleName();
    public List<Makeup> makeups = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_makeup);
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
         public void onResponse(Call call, Response response) throws IOException {
             String jsonData = response.toString();
             if(response.isSuccessful()){
                 Log.v(TAG, "MYRESPONSE" + jsonData);
                 //        brand = makeupService.processResults(response);
             }

         }
     });
 }
}
