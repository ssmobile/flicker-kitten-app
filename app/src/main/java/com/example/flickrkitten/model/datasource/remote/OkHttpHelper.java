package com.example.flickrkitten.model.datasource.remote;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpHelper {

    private static final String API_URL = "https://api.flickr.com/services/feeds/photos_public.gne?tag=kitten&format=json&nojsoncallback=1";

    public String executeSyncOkHttpRequest() throws IOException {
        Request request = new Request.Builder()
                .url(API_URL)
                .build();

        Response response = new OkHttpClient().newCall(request).execute();

        return response.body().string();
    }
}
