package com.moutamid.livestreamingapp;

import static android.content.Context.MODE_PRIVATE;
import static com.moutamid.livestreamingapp.Settings_Activity.SHARED_PREFS;
import static com.moutamid.livestreamingapp.Settings_Activity.TEXT1_1;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Radio_Fragment extends Fragment {

    FloatingActionButton fab_channel;

    RecyclerView mOnline_Recycler;
    ArrayList<Model_Radio> modelOnlines_list;
    private DatabaseReference databaseReference;
    ProgressDialog pd;

    TextView title_main;
    TextView title_lang;

    Context context;
    Resources resources;
    private String text1_1;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

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
        View view = inflater.inflate(R.layout.fragment_radio_, container, false);

        pd = new ProgressDialog(getContext());
        pd.setTitle("Loading...");
        pd.setMessage("Fetching data please wait or check your internet");
        pd.setCanceledOnTouchOutside(true);
        mOnline_Recycler = view.findViewById(R.id.recyclerView_radio);
        title_main = view.findViewById(R.id.title_main);
        title_lang = view.findViewById(R.id.title_lang);

        fab_channel = view.findViewById(R.id.fab_channel2);
        fab_channel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext() , Radio_List.class);
                startActivity(intent);
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext() , 2);
        mOnline_Recycler.setLayoutManager(gridLayoutManager);

        modelOnlines_list = new ArrayList<>();
        Adapter_Radio adapter_online = new Adapter_Radio(getContext() , modelOnlines_list);
        mOnline_Recycler.setAdapter(adapter_online);

        databaseReference = FirebaseDatabase.getInstance().getReference("Radio");
        pd.show();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                modelOnlines_list.clear();

                for (DataSnapshot itemSnapshot : snapshot.getChildren()) {
                    Model_Radio modelOnline = itemSnapshot.getValue(Model_Radio.class);
                    modelOnlines_list.add(modelOnline);
                }
                adapter_online.notifyDataSetChanged();
                pd.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                pd.dismiss();
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        loadData();
        String lang = title_lang.getText().toString().trim();
        if (lang.equals("English")){
            context = LocaleHelper.setLocale(getContext(), "en");
            resources = context.getResources();
            title_main.setText(resources.getString(R.string.live_radio));
        }
        if (lang.equals("French")){
            context = LocaleHelper.setLocale(getContext(), "fr");
            resources = context.getResources();
            title_main.setText(resources.getString(R.string.live_radio));
        }
        if (lang.equals("German")){
            context = LocaleHelper.setLocale(getContext(), "de");
            resources = context.getResources();
            title_main.setText(resources.getString(R.string.live_radio));
        }
        if (lang.equals("Arabic")){
            context = LocaleHelper.setLocale(getContext(), "ar");
            resources = context.getResources();
            title_main.setText(resources.getString(R.string.live_radio));
        }
        if (lang.equals("Turkish")){
            context = LocaleHelper.setLocale(getContext(), "tr");
            resources = context.getResources();
            title_main.setText(resources.getString(R.string.live_radio));
        }
        if (lang.equals("Russian")){
            context = LocaleHelper.setLocale(getContext(), "ru");
            resources = context.getResources();
            title_main.setText(resources.getString(R.string.live_radio));
        }
        if (lang.equals("Spanish")){
            context = LocaleHelper.setLocale(getContext(), "es");
            resources = context.getResources();
            title_main.setText(resources.getString(R.string.live_radio));
        }
        if (lang.equals("Urdu")){
            context = LocaleHelper.setLocale(getContext(), "ur");
            resources = context.getResources();
            title_main.setText(resources.getString(R.string.live_radio));
        }
        super.onStart();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS , MODE_PRIVATE);
        text1_1 = sharedPreferences.getString(TEXT1_1 , "English");
        title_lang.setText(text1_1);
    }
}