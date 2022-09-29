package com.moutamid.livestreamingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Channel_Fragment extends Fragment {

        private String[] channel_name = {
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

            "DISNEY",
            "EXPRESS NEWS",
    };

    private String[] channel_des = {
            "Get in touch with all siyuations of All countries with GEO news." ,
            "Get in touch with all siyuations of All countries with HUM news." ,
            "Get in touch with all siyuations of All countries with ARY news." ,
            "Get in touch with all siyuations of All countries with PTV sports." ,
            "Get in touch with all siyuations of All countries with Disney Cartoon Channel." ,
            "Get in touch with all siyuations of All countries with Express news." ,

            "Get in touch with all siyuations of All countries with GEO news." ,
            "Get in touch with all siyuations of All countries with HUM news." ,
            "Get in touch with all siyuations of All countries with ARY news." ,
            "Get in touch with all siyuations of All countries with PTV sports." ,
            "Get in touch with all siyuations of All countries with Disney Cartoon Channel." ,
            "Get in touch with all siyuations of All countries with Express news." ,

            "Get in touch with all siyuations of All countries with GEO news." ,
            "Get in touch with all siyuations of All countries with HUM news." ,
            "Get in touch with all siyuations of All countries with ARY news." ,
            "Get in touch with all siyuations of All countries with PTV sports." ,
            "Get in touch with all siyuations of All countries with Disney Cartoon Channel." ,
            "Get in touch with all siyuations of All countries with Express news." ,

            "Get in touch with all siyuations of All countries with GEO news." ,
            "Get in touch with all siyuations of All countries with HUM news." ,
            "Get in touch with all siyuations of All countries with ARY news." ,
            "Get in touch with all siyuations of All countries with PTV sports." ,
            "Get in touch with all siyuations of All countries with Disney Cartoon Channel." ,
            "Get in touch with all siyuations of All countries with Express news." ,

            "Get in touch with all siyuations of All countries with GEO news." ,
            "Get in touch with all siyuations of All countries with HUM news." ,
            "Get in touch with all siyuations of All countries with ARY news." ,
            "Get in touch with all siyuations of All countries with PTV sports." ,
            "Get in touch with all siyuations of All countries with Disney Cartoon Channel." ,
            "Get in touch with all siyuations of All countries with Express news." ,

            "Get in touch with all siyuations of All countries with GEO news." ,
            "Get in touch with all siyuations of All countries with HUM news." ,
            "Get in touch with all siyuations of All countries with ARY news." ,
            "Get in touch with all siyuations of All countries with PTV sports." ,
            "Get in touch with all siyuations of All countries with Disney Cartoon Channel." ,
            "Get in touch with all siyuations of All countries with Express news." ,

            "Get in touch with all siyuations of All countries with GEO news." ,
            "Get in touch with all siyuations of All countries with HUM news." ,
            "Get in touch with all siyuations of All countries with ARY news." ,
            "Get in touch with all siyuations of All countries with PTV sports." ,
            "Get in touch with all siyuations of All countries with Disney Cartoon Channel." ,
            "Get in touch with all siyuations of All countries with Express news." ,

            "Get in touch with all siyuations of All countries with GEO news." ,
            "Get in touch with all siyuations of All countries with HUM news." ,
            "Get in touch with all siyuations of All countries with ARY news." ,
            "Get in touch with all siyuations of All countries with PTV sports." ,
            "Get in touch with all siyuations of All countries with Disney Cartoon Channel." ,
            "Get in touch with all siyuations of All countries with Express news." ,

            "Get in touch with all siyuations of All countries with Disney Cartoon Channel." ,
            "Get in touch with all siyuations of All countries with Express news." ,
    };

    private String[] channel_cast = {
            "Headlines:",
            "Kasoti:" ,
            "Startup Pak:",
            "Live Match:",
            "Doraemon:",
            "Khabarhaar:",

            "Headlines:",
            "Kasoti:" ,
            "Startup Pak:",
            "Live Match:",
            "Doraemon:",
            "Khabarhaar:",

            "Headlines:",
            "Kasoti:" ,
            "Startup Pak:",
            "Live Match:",
            "Doraemon:",
            "Khabarhaar:",

            "Headlines:",
            "Kasoti:" ,
            "Startup Pak:",
            "Live Match:",
            "Doraemon:",
            "Khabarhaar:",

            "Headlines:",
            "Kasoti:" ,
            "Startup Pak:",
            "Live Match:",
            "Doraemon:",
            "Khabarhaar:",

            "Headlines:",
            "Kasoti:" ,
            "Startup Pak:",
            "Live Match:",
            "Doraemon:",
            "Khabarhaar:",

            "Headlines:",
            "Kasoti:" ,
            "Startup Pak:",
            "Live Match:",
            "Doraemon:",
            "Khabarhaar:",

            "Headlines:",
            "Kasoti:" ,
            "Startup Pak:",
            "Live Match:",
            "Doraemon:",
            "Khabarhaar:",

            "Doraemon:",
            "Khabarhaar:",
    };

    private String[] channel_time = {
            "03:13",
            "04:55",
            "08:12",
            "12:30",
            "07:51",
            "11:55",

            "03:13",
            "04:55",
            "08:12",
            "12:30",
            "07:51",
            "11:55",

            "03:13",
            "04:55",
            "08:12",
            "12:30",
            "07:51",
            "11:55",

            "03:13",
            "04:55",
            "08:12",
            "12:30",
            "07:51",
            "11:55",

            "03:13",
            "04:55",
            "08:12",
            "12:30",
            "07:51",
            "11:55",

            "03:13",
            "04:55",
            "08:12",
            "12:30",
            "07:51",
            "11:55",

            "03:13",
            "04:55",
            "08:12",
            "12:30",
            "07:51",
            "11:55",

            "03:13",
            "04:55",
            "08:12",
            "12:30",
            "07:51",
            "11:55",

            "07:51",
            "11:55",
    };

    private String[] channel_link = {
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

    private int[] images1_channel = {
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

    private RecyclerView channel_recycler;
    private ArrayList<Model_Channel> modelChannelArrayList;
    private Adapter_Channel adapter_channel;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Channel_Fragment() {
    }

    public static Channel_Fragment newInstance(String param1, String param2) {
        Channel_Fragment fragment = new Channel_Fragment();
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
        channel_recycler = view.findViewById(R.id.recyclerView_channel);
        loadchannel();
        return view;
    }

    private void loadchannel() {
        modelChannelArrayList = new ArrayList<>();

        for (int i = 0; i < channel_name.length; i++) {
            Model_Channel modelAndroid = new Model_Channel(
                    channel_name[i],
                    channel_des[i],
                    channel_cast[i],//SAVE KAHAN KAR RHY ?
                    channel_time[i],
                    channel_link[i],
                    images1_channel[i]
            );
            modelChannelArrayList.add(modelAndroid);
        }
        adapter_channel = new Adapter_Channel(getContext(), modelChannelArrayList);
        channel_recycler.setAdapter(adapter_channel);
    }
}