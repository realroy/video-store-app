package com.example.jab.videostore;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class VideoListAdapter extends ArrayAdapter<Video> {

    private List<Video> videos;
    Context context;
    private static class ViewHolder {
        TextView text_name;
        TextView text_price;
        Button button_cancel;
    }

    public VideoListAdapter(@NonNull Context context, @NonNull List<Video> videos, String customerId) {
        super(context, R.layout.cart_list_item, videos);
        this.context = context;
        this.videos = videos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Video video = getItem(position);
        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.cart_list_item, parent, false);
            viewHolder.text_name = (TextView) convertView.findViewById(R.id.text_name);
            viewHolder.text_price = (TextView) convertView.findViewById(R.id.text_price);
            viewHolder.button_cancel = (Button) convertView.findViewById(R.id.button_cancel);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }
        viewHolder.text_name.setText(video.getName());
        viewHolder.text_price.setText(String.valueOf(video.getPrice())+ " $");
        viewHolder.button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //FirebaseDatabase.getInstance().getReference("orders").
            }
        });
        // Return the completed view to render on screen
        return convertView;
    }
}