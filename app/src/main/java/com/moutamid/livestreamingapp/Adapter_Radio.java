package com.moutamid.livestreamingapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_Radio extends RecyclerView.Adapter<Adapter_Radio.HolderAndroid> {

    private Context context;
    private ArrayList<Model_Radio> androidArrayList;

    public Adapter_Radio(Context context, ArrayList<Model_Radio> androidArrayList) {
        this.context = context;
        this.androidArrayList = androidArrayList;
    }

    @NonNull
    @Override
    public HolderAndroid onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_radio, parent, false);
        return new HolderAndroid(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderAndroid holder, int position) {
        Model_Radio modelAndroid = androidArrayList.get(position);

        String name_channel = modelAndroid.getName();
        String link_channel = modelAndroid.getLink();
        int image_1 = modelAndroid.getImage1();

        holder.name.setText(name_channel);
        holder.link.setText(link_channel);
        holder.image1.setImageResource(image_1);

        if (position % 2 == 0){
            holder.view_top.setVisibility(View.VISIBLE);
        }
        else {
            holder.view_top.setVisibility(View.GONE);
        }

        holder.card_channel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, "Item Clicked", Toast.LENGTH_SHORT).show();
                String linkText = holder.link.getText().toString().trim();
                String nameText = holder.name.getText().toString().trim();
                Intent intent = new Intent(context , MusicActivity.class);
                intent.putExtra("link" , linkText);
                intent.putExtra("name" , nameText);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return androidArrayList.size();
    }

    class HolderAndroid extends RecyclerView.ViewHolder {

        private ImageView image1 ;
        private TextView name, link;
        private CardView card_channel;
        private View view_top;

        HolderAndroid(@NonNull View itemView) {
            super(itemView);

            image1 = itemView.findViewById(R.id.radio_img);
            name = itemView.findViewById(R.id.title_radio);
            link = itemView.findViewById(R.id.link_radio);
            card_channel = itemView.findViewById(R.id.card_radio);
            view_top = itemView.findViewById(R.id.view_top);

        }
    }
}
