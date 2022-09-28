package com.moutamid.livestreamingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Radio_Fragment extends Fragment {

    private String[] radio_name = {
            "GEO NEW",
            "HUM NEWS",
            "ARY NEWS",
            "PTV SPORTS",
            "DISNEY",
            "EXPRESS NEWS",

            "GEO NEW",
            "HUM NEWS",
            "ARY NEWS",
            "PTV SPORTS",
            "DISNEY",
            "EXPRESS NEWS",

            "GEO NEW",
            "HUM NEWS",
            "ARY NEWS",
            "PTV SPORTS",
            "DISNEY",
            "EXPRESS NEWS",

            "GEO NEW",
            "HUM NEWS",
    };

    private String[] radio_link = {
            "https://radio-live-mg.rtr-vesti.ru/live/smil:r1.smil/variant.m3u8",
            "https://radio-live-mg.rtr-vesti.ru/live/smil:r1.smil/variant.m3u8",
            "https://radio-live-mg.rtr-vesti.ru/live/smil:r1.smil/variant.m3u8",
            "https://radio-live-mg.rtr-vesti.ru/live/smil:r1.smil/variant.m3u8",
            "https://radio-live-mg.rtr-vesti.ru/live/smil:r1.smil/variant.m3u8",
            "https://radio-live-mg.rtr-vesti.ru/live/smil:r1.smil/variant.m3u8",

            "https://radio-live-mg.rtr-vesti.ru/live/smil:r1.smil/variant.m3u8",
            "https://radio-live-mg.rtr-vesti.ru/live/smil:r1.smil/variant.m3u8",
            "https://radio-live-mg.rtr-vesti.ru/live/smil:r1.smil/variant.m3u8",
            "https://radio-live-mg.rtr-vesti.ru/live/smil:r1.smil/variant.m3u8",
            "https://radio-live-mg.rtr-vesti.ru/live/smil:r1.smil/variant.m3u8",
            "https://radio-live-mg.rtr-vesti.ru/live/smil:r1.smil/variant.m3u8",

            "https://radio-live-mg.rtr-vesti.ru/live/smil:r1.smil/variant.m3u8",
            "https://radio-live-mg.rtr-vesti.ru/live/smil:r1.smil/variant.m3u8",
            "https://radio-live-mg.rtr-vesti.ru/live/smil:r1.smil/variant.m3u8",
            "https://radio-live-mg.rtr-vesti.ru/live/smil:r1.smil/variant.m3u8",
            "https://radio-live-mg.rtr-vesti.ru/live/smil:r1.smil/variant.m3u8",
            "https://radio-live-mg.rtr-vesti.ru/live/smil:r1.smil/variant.m3u8",

            "https://radio-live-mg.rtr-vesti.ru/live/smil:r1.smil/variant.m3u8",
            "https://radio-live-mg.rtr-vesti.ru/live/smil:r1.smil/variant.m3u8",
    };

    private int[] images1_radio = {
            R.drawable.geo,
            R.drawable.hum,
            R.drawable.ary,
            R.drawable.ptv,
            R.drawable.disney,
            R.drawable.express,

            R.drawable.geo,
            R.drawable.hum,
            R.drawable.ary,
            R.drawable.ptv,
            R.drawable.disney,
            R.drawable.express,

            R.drawable.geo,
            R.drawable.hum,
            R.drawable.ary,
            R.drawable.ptv,
            R.drawable.disney,
            R.drawable.express,

            R.drawable.geo,
            R.drawable.hum,
    };

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private RecyclerView radio_recycler;
    private ArrayList<Model_Radio> model_radioArrayList;
    private Adapter_Radio adapter_radio;

    public Radio_Fragment() {
    }

    public static Radio_Fragment newInstance(String param1, String param2) {
        Radio_Fragment fragment = new Radio_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_channel_, container, false);
        radio_recycler = view.findViewById(R.id.recyclerView_channel);
        radio_recycler.setLayoutManager(new GridLayoutManager(getContext(), 2));

        loadradio();
        return view;
    }

    private void loadradio() {
        model_radioArrayList = new ArrayList<>();

        for (int i = 0; i < radio_name.length; i++) {
            Model_Radio modelAndroid = new Model_Radio(
                    radio_name[i],
                    radio_link[i],
                    images1_radio[i]
            );
            model_radioArrayList.add(modelAndroid);
        }
        adapter_radio = new Adapter_Radio(getContext(), model_radioArrayList);
        radio_recycler.setAdapter(adapter_radio);
    }
}