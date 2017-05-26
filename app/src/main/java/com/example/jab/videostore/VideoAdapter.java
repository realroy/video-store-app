package com.example.jab.videostore;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    private Context context;
    private List<Video> videoList;

    public VideoAdapter(Context context, List<Video> videoList) {
        this.context = context;
        this.videoList = videoList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.video_card, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Video video = videoList.get(position);
        holder.text_video_price.setText("Price: " + String.valueOf(video.getPrice() + "$"));
        holder.text_video_name.setText(String.valueOf(video.getName()));
        holder.text_video_category.setText("Category: " + String.valueOf(video.getCategory()));
        holder.button_see_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Go to VideoDetail Activity
            }
        });
        holder.button_add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Add to cart
            }
        });
        Glide.with(context)
                .load(video.getImgUrl())
                .thumbnail(0.1f)
                .into(holder.image_video_thumbnail);
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView text_video_name;
        public TextView text_video_price;
        public TextView text_video_category;
        public ImageView image_video_thumbnail;
        public Button button_see_more;
        public Button button_add_to_cart;

        public ViewHolder(View itemView) {
            super(itemView);
            text_video_name = (TextView) itemView.findViewById(R.id.text_video_name);
            text_video_price = (TextView) itemView.findViewById(R.id.text_video_price);
            text_video_category = (TextView) itemView.findViewById(R.id.text_video_category);
            image_video_thumbnail = (ImageView) itemView.findViewById(R.id.image_video_thumbnail);
            button_see_more = (Button) itemView.findViewById(R.id.botton_see_more);
            button_add_to_cart = (Button) itemView.findViewById(R.id.botton_add_to_cart);
        }
    }


}
