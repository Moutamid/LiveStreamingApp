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

import com.fxn.stash.Stash;

import java.util.ArrayList;

public class Adapter_Channel extends RecyclerView.Adapter<Adapter_Channel.HolderAndroid> {

    private Context context;
    private ArrayList<Model_Channel> androidArrayList;

    public Adapter_Channel(Context context, ArrayList<Model_Channel> androidArrayList) {
        this.context = context;
        this.androidArrayList = androidArrayList;
    }

    @NonNull
    @Override
    public HolderAndroid onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Stash.init(context);
        View view = LayoutInflater.from(context).inflate(R.layout.row_channels, parent, false);
        return new HolderAndroid(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderAndroid holder, int position) {
        Model_Channel modelAndroid = androidArrayList.get(position);

        String name_channel = modelAndroid.getName();
        String des_channel = modelAndroid.getDes();
        String cast_channel = modelAndroid.getCast();
        String time_channel = modelAndroid.getTime();
        String link_channel = modelAndroid.getLink();
        int image_1 = modelAndroid.getImage1();

        holder.name.setText(name_channel);
        holder.des.setText(des_channel);
        holder.cast.setText(cast_channel);
        holder.time.setText(time_channel);
        holder.link.setText(link_channel);
        holder.image1.setImageResource(image_1);

        holder.card_channel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String linkText = holder.link.getText().toString().trim();
                String nameText = holder.name.getText().toString().trim();
                Intent intent = new Intent(context , VedioActivity.class);
                intent.putExtra("link" , linkText);
                intent.putExtra("name" , nameText);
                context.startActivity(intent);
            }
        });

        holder.btn_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Model_Channel> our_arraylist = Stash.getArrayList("name_of_arraylist" , Model_Channel.class);
                our_arraylist.add(modelAndroid);
                Stash.put("name_of_arraylist" , our_arraylist);
                Toast.makeText(context, "Added to Favorities", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return androidArrayList.size();
    }

    class HolderAndroid extends RecyclerView.ViewHolder {

        private ImageView image1 ;
        private ImageView btn_fav ;
        private TextView name , des , cast , time , link;
        private CardView card_channel;

        HolderAndroid(@NonNull View itemView) {
            super(itemView);

            image1 = itemView.findViewById(R.id.channel_img);
            btn_fav = itemView.findViewById(R.id.btn_fav);
            name = itemView.findViewById(R.id.title_channel);
            des = itemView.findViewById(R.id.description_channel);
            cast = itemView.findViewById(R.id.cast_channel);
            time = itemView.findViewById(R.id.time_channel);
            link = itemView.findViewById(R.id.link_channel);
            card_channel = itemView.findViewById(R.id.card_channel);

        }
    }
}
