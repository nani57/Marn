package com.marn.marn.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.marn.marn.R;
import com.marn.marn.ui.fragments.AllFragment;
import com.marn.marn.ui.fragments.BurgersFragment;
import com.marn.marn.ui.fragments.DrinkFragment;
import com.marn.marn.ui.fragments.SettingsFragment;
import com.marn.marn.ui.fragments.SidesFragment;
import com.marn.marn.ui.fragments.SweetsFragment;

import java.util.ArrayList;

public class CheckoutActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private LinearLayout checkoutLinearLayout, settingsLinearLayout;
    private SearchView searchView;
    private RecyclerView peopleRecyclerView;
    private ImageView backButton,nonInventory;
    private boolean list;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    ArrayList<Fragment> arrayListFragments = new ArrayList<>();
    MyPagerAdapter adapter;
    ArrayList<String> arrayListTitle = new ArrayList<>();
    private Button cartItemsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorBlack));
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        checkoutLinearLayout = findViewById(R.id.checkout);
        settingsLinearLayout = findViewById(R.id.settings);
        cartItemsButton = findViewById(R.id.cart_items_button);
        nonInventory = findViewById(R.id.iv_non_inventory);

        viewPager = findViewById(R.id.viewPager);

        setupViewPager(viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        checkoutLinearLayout.setOnClickListener(this);
        settingsLinearLayout.setOnClickListener(this);
        cartItemsButton.setOnClickListener(this);
        nonInventory.setOnClickListener(this);

    }
    private void setupViewPager(ViewPager viewPager) {
        adapter = new MyPagerAdapter(getSupportFragmentManager());

        AllFragment allFragment = new AllFragment();
        BurgersFragment burgersFragment = new BurgersFragment();
        SweetsFragment sweetsFragment = new SweetsFragment();
        SidesFragment sidesFragment = new SidesFragment();
        DrinkFragment drinkFragment = new DrinkFragment();

        arrayListFragments.add(allFragment);
        arrayListFragments.add(burgersFragment);
        arrayListFragments.add(sweetsFragment);
        arrayListFragments.add(sidesFragment);
        arrayListFragments.add(drinkFragment);

        arrayListTitle.add("ALL");
        arrayListTitle.add("BURGERS");
        arrayListTitle.add("SWEETS");
        arrayListTitle.add("SIDES");
        arrayListTitle.add("DRINK");

        viewPager.setAdapter(adapter);
    }

    public void onClick(int value,Double totalValue) {
        Log.v("CheckOut", "" + value);
        cartItemsButton.setText(value + " Items = " + totalValue +  " SAR");

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

    @Override
    public void onBackPressed() {
       closeDrawer();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.checkout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.add_customers) {
            Intent i = new Intent(CheckoutActivity.this, AddCustomers.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_checkout) {
            // Handle the camera action
        } else if (id == R.id.nav_products) {

        } else if (id == R.id.nav_customers) {

        } else if (id == R.id.nav_transactions) {

        } else if (id == R.id.nav_analytics) {

        } else if (id == R.id.nav_users) {

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_support) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.settings:
                closeDrawer();
                changeFragment(new SettingsFragment(), "Settings");
                break;
            case R.id.cart_items_button:
                Intent i = new Intent(CheckoutActivity.this, CartActivity.class);
                startActivity(i);
                break;
            case R.id.iv_non_inventory:
                Intent inventory = new Intent(CheckoutActivity.this, SellNoInventory.class);
                startActivity(inventory);
                break;

        }
    }

    private void changeFragment(Fragment fragment, String title) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment, title).commit();
        setTitle(title);
    }
    private void closeDrawer() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


}
