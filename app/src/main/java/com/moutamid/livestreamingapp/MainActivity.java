package com.moutamid.livestreamingapp;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private Channel_Fragment channel_fragment;
    private Radio_Fragment radio_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // get the reference of Toolbar
        setSupportActionBar(toolbar); // Setting/replace toolbar as the ActionBar

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this , drawer , toolbar , R.string.navigation_drawer_open , R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mTabLayout = findViewById(R.id.tabLayout);
        mViewPager = findViewById(R.id.viewPager);

        setupViewPager(mViewPager);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager mViewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager() , BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        channel_fragment = new Channel_Fragment();
        radio_fragment = new Radio_Fragment();

        adapter.addFragment(channel_fragment, "TV Channels");
        adapter.addFragment(radio_fragment, "Radio");

        mViewPager.setAdapter(adapter);
    }

    public class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> fragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm, int behaviour) {
            super(fm, behaviour);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            fragmentList.add(fragment);
            fragmentTitleList.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id==R.id.item1){
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"));
            startActivity(browserIntent);
        }
        else
        /*if(id==R.id.item2){
            Intent intent = new Intent(MainActivity.this , Profile_Activity.class);
            startActivity(intent);
        }
        else*/
        if(id==R.id.item3){
            Intent intent = new Intent(MainActivity.this , Settings_Activity.class);
            startActivity(intent);
        }
        else
        if(id==R.id.item4){
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"));
            startActivity(browserIntent);
        }
        else
        if(id==R.id.item5){
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"));
            startActivity(browserIntent);
        }
        else
        if(id==R.id.item6){
            startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:to@gmail.com")));
        }
        else
        if(id==R.id.item7){
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=$packageName")));
        }
        return false;
    }
}