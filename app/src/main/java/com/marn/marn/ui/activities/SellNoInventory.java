package com.marn.marn.ui.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.marn.marn.R;
import com.marn.marn.ui.fragments.AllFragment;
import com.marn.marn.ui.fragments.BurgersFragment;
import com.marn.marn.ui.fragments.DescriptionFragment;
import com.marn.marn.ui.fragments.DrinkFragment;
import com.marn.marn.ui.fragments.PriceFragment;
import com.marn.marn.ui.fragments.SidesFragment;
import com.marn.marn.ui.fragments.SweetsFragment;
import com.marn.marn.utils.KeyboardUtil;

import java.util.ArrayList;

public class SellNoInventory extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    ArrayList<Fragment> arrayListFragments = new ArrayList<>();
    MyPagerAdapter adapter;
    ArrayList<String> arrayListTitle = new ArrayList<>();
    private ImageView backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_no_inventory);
        getSupportActionBar().hide();

        viewPager = findViewById(R.id.viewPager);
        backButton = findViewById(R.id.backButton);

        setupViewPager(viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KeyboardUtil.hideKeyboard(SellNoInventory.this);
                onBackPressed();
            }
        });
    }
    private void setupViewPager(ViewPager viewPager) {
        adapter = new MyPagerAdapter(getSupportFragmentManager());

        PriceFragment priceFragment = new PriceFragment();
        DescriptionFragment descriptionFragment = new DescriptionFragment();

        arrayListFragments.add(priceFragment);
        arrayListFragments.add(descriptionFragment);

        arrayListTitle.add("PRICE");
        arrayListTitle.add("DESCRIPTION");

        viewPager.setAdapter(adapter);
    }
    private class MyPagerAdapter extends FragmentStatePagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return arrayListFragments.get(position);

        }

        @Override
        public int getCount() {
            return arrayListFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return arrayListTitle.get(position);
        }

        @Override
        public int getItemPosition(Object object) {
            //Log.e(TAG, "object");
            return POSITION_NONE;
        }
    }


}
