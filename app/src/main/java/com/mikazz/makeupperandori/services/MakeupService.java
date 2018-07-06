package com.mikazz.makeupperandori.services;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mikazz.makeupperandori.Constants;
import com.mikazz.makeupperandori.MainActivity;
import com.mikazz.makeupperandori.models.Makeup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MakeupService {
    public static final String TAG = MakeupService.class.getSimpleName();
    public static void findBrand(String brand, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.MAKEUP_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.MAKEUP_QUERY_PARAMETER, brand);
        String url = urlBuilder.build().toString();

        Request request= new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static List<Makeup> processResults(Response response) {
        List<Makeup> result = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            JSONArray makeupJSON = new JSONArray(jsonData);
            if (response.isSuccessful()) {
                Log.v(TAG, makeupJSON.toString());
                Type collectionType = new TypeToken<List<Makeup>>() {}.getType();
                Gson gson = new GsonBuilder().create();
                result = gson.fromJson(makeupJSON.toString(), collectionType);
            }
        } catch (JSONException | NullPointerException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}