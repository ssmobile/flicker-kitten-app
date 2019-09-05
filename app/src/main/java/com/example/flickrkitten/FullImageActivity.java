package com.example.flickrkitten;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class FullImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        assert b != null;
        byte[] imgBytes = b.getByteArray("image");

        assert imgBytes != null;
        Bitmap bmp = BitmapFactory.decodeByteArray(imgBytes,0,imgBytes.length);
        ImageView fullImage = findViewById(R.id.full_image);
        fullImage.setImageBitmap(bmp);
    }
}
