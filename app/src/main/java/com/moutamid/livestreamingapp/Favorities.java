package com.moutamid.livestreamingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.fxn.stash.Stash;

import java.util.ArrayList;

public class Favorities extends AppCompatActivity {

    private RecyclerView fav_recycler;
    private Adapter_Fav adapter_fav;
    ArrayList<Model_Channel> our_arraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorities);
         our_arraylist = Stash.getArrayList("name_of_arraylist" , Model_Channel.class);
        fav_recycler = findViewById(R.id.recyclerView_fav);
        loadFav();
    }

    private void loadFav() {
        adapter_fav = new Adapter_Fav(Favorities.this , our_arraylist);
        fav_recycler.setAdapter(adapter_fav);
    }
}