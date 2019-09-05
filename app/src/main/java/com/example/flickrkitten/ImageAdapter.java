package com.example.flickrkitten;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flickrkitten.model.Item;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private List<Item> itemList;
    private Context context;
    private static final String TAG = "TAG_ImageAdapter";


    ImageAdapter(List<Item> itemList, Context context) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_list_item,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item curItem = itemList.get(position);
        String author = curItem.getAuthor();
        String title = curItem.getTitle();

        if (title.length() > 15) {
            title = title.substring(0,15).concat("...");
        }

        if (author.contains("nobody@flickr.com")) {
            author = "Author: "
                    .concat(author.substring(author.indexOf("\"") + 1,author.length()-2));
        }

        Picasso.get().load(curItem.getMedia().getM())
                .into(holder.itemImageView);

        holder.itemTitle.setText(title);
        holder.itemUser.setText(author);

        Log.d(TAG, curItem.getLink());
    }

    @Override
    public int getItemCount() { return itemList.size(); }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        ImageView itemImageView;
        TextView itemTitle;
        TextView itemUser;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImageView = itemView.findViewById(R.id.item_image);
            itemTitle = itemView.findViewById(R.id.item_title);
            itemUser = itemView.findViewById(R.id.item_user);
            itemView.setOnLongClickListener(this);

        }

        @Override
        public boolean onLongClick(View view) {
                    Log.d(TAG, "onLongClick: ");
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    Log.d(TAG, "onLongClick: ");
                    builder.setTitle("Open Image")
                            .setItems(new CharSequence[]{"Full Image", "Thumbnail"},
                                new MyDialogListener()) 
                            .create().show();


                    return false;
        }


        public class MyDialogListener implements DialogInterface.OnClickListener {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d(TAG, "onClick: ");

                switch (i) {
                    case 0:
                        Intent intent = new Intent(context,FullImageActivity.class);
                        Bundle bundle = new Bundle();
                        Drawable d = itemImageView.getDrawable();
                        byte[] imgBytes = drawableToByteArray(d);
                        bundle.putByteArray("image",imgBytes);
                        intent.putExtras(bundle);
                        context.startActivity(intent);
                        break;
                    case 1:
                        break;
                }
            }

            private byte[] drawableToByteArray(Drawable d) {

                Bitmap bitmap = ((BitmapDrawable)d).getBitmap();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                return stream.toByteArray();
            }
        }

    }
}
