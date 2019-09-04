package com.example.flickrkitten.model.datasource.remote;

import android.os.AsyncTask;
import com.example.flickrkitten.model.Response;
import com.google.gson.Gson;
import org.greenrobot.eventbus.EventBus;
import java.io.IOException;

public class ImageAsyncTask extends AsyncTask<Void,Void, Response> {

    @Override
    protected Response doInBackground(Void... voids) {
        String result;
        try {
            result = new OkHttpHelper().executeSyncOkHttpRequest();
            Gson gson = new Gson();
            return gson.fromJson(result, Response.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(Response item) {
        super.onPostExecute(item);
        EventBus.getDefault().post(item);
    }
}
