package com.example.flickrkitten;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.flickrkitten.model.Item;
import com.example.flickrkitten.model.Response;
import com.example.flickrkitten.model.datasource.remote.ImageAsyncTask;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

public class MainActivity extends AppCompatActivity {

//    private static final String TAG = "TAG_MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new Runnable() {
            @Override
            public void run() {
                new ImageAsyncTask().execute();
            }
        }.run();

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onImageEvent(Response response) {
        if (response != null) {
            populateRecyclerView(response.getItems());
        }
    }

    private void populateRecyclerView(List<Item> itemList) {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ImageAdapter(itemList,this));
    }
}
