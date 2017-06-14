package com.biz.stampit.retailerapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.biz.stampit.retailerapp.Adapters.HomeAdapter;
import com.biz.stampit.retailerapp.Fragments.BakeryAndDiaryFragment;
import com.biz.stampit.retailerapp.Fragments.BeveragesFragment;
import com.biz.stampit.retailerapp.Fragments.GroceryAndStaplesFragment;
import com.biz.stampit.retailerapp.Fragments.HouseholdFragment;
import com.biz.stampit.retailerapp.Fragments.PersonalCareFragment;
import com.biz.stampit.retailerapp.Fragments.VegitablesFragmentScreen;
import com.biz.stampit.retailerapp.Helpers.MySharedPreference;
import com.biz.stampit.retailerapp.entities.HomeModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ClickListener {
    private MySharedPreference sharedPreference;

    private List<HomeModel> itemList = new ArrayList<>();
    private RecyclerView recyclerview;
    private HomeAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Home");

        recyclerview=(RecyclerView)findViewById(R.id.recycler_view);
        HomeItem();
        mAdapter = new HomeAdapter(itemList);
        mAdapter.setClickListener(this);
        RecyclerView.LayoutManager mLayoutManger = new LinearLayoutManager(getApplicationContext());
        recyclerview.setLayoutManager(mLayoutManger);
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.setAdapter(mAdapter);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void HomeItem() {

        HomeModel item = new HomeModel(R.drawable.veg,"Vegetables");
        itemList.add(item);

        item = new HomeModel(R.drawable.fmcg1,"PersonalCare");
        itemList.add(item);

        item = new HomeModel(R.drawable.bakary,"Bakery and Diary");
        itemList.add(item);

        item = new HomeModel(R.drawable.beverages,"Beverages");
        itemList.add(item);

        item = new HomeModel(R.drawable.grocery,"Grocery");
        itemList.add(item);

        item = new HomeModel(R.drawable.household2,"Houseghold");
        itemList.add(item);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
      if (id==R.id.home)
      {
          Intent intent=new Intent(getApplicationContext(),MainActivity.class);
          startActivity(intent);
      } else if (id == R.id.veg_fruits) {
            // Handle the camera action
            VegitablesFragmentScreen vegitablesFragmentScreen = new VegitablesFragmentScreen();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,vegitablesFragmentScreen)
                    .addToBackStack(null)
                    .commit();
        } else if (id == R.id.grocery_staples) {
            GroceryAndStaplesFragment groceryAndStaplesFragment = new GroceryAndStaplesFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,groceryAndStaplesFragment)
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.bakery_diary) {
          BakeryAndDiaryFragment diaryFragment = new BakeryAndDiaryFragment();
          getSupportFragmentManager().beginTransaction()
                  .replace(R.id.content_frame,diaryFragment)
                  .addToBackStack(null)
                  .commit();
        } else if (id == R.id.beverages) {
            BakeryAndDiaryFragment bakeryfragment = new BakeryAndDiaryFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,bakeryfragment)
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.personal_care) {
PersonalCareFragment personalFragment = new PersonalCareFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,personalFragment)
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.house_hold) {
            HouseholdFragment householdFragment = new HouseholdFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,householdFragment)
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.nav_share) {
            VegitablesFragmentScreen vegitablesFragmentScreen = new VegitablesFragmentScreen();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,vegitablesFragmentScreen)
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.nav_send) {
            VegitablesFragmentScreen vegitablesFragmentScreen = new VegitablesFragmentScreen();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,vegitablesFragmentScreen)
                    .addToBackStack(null)
                    .commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void itemClicked(View view, int position) {

        if (position == 0) {
            VegitablesFragmentScreen vegitablesFragmentScreen = new VegitablesFragmentScreen();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, vegitablesFragmentScreen)
                    .addToBackStack(null)
                    .commit();
        } else if (position == 1) {
            PersonalCareFragment personalCareFragment = new PersonalCareFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, personalCareFragment)
                    .addToBackStack(null)
                    .commit();
        } else if (position == 2) {
            BeveragesFragment beveragesFragment = new BeveragesFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, beveragesFragment)
                    .addToBackStack(null)
                    .commit();
        } else if (position == 3) {
            BakeryAndDiaryFragment bakeryAndDiaryFragment = new BakeryAndDiaryFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, bakeryAndDiaryFragment)
                    .addToBackStack(null)
                    .commit();
        }
             else if (position == 4) {
               GroceryAndStaplesFragment groceryAndStaplesFragment = new GroceryAndStaplesFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_frame,groceryAndStaplesFragment)
                        .addToBackStack(null)
                        .commit();
        }else if (position==5) {
            HouseholdFragment householdFragment = new HouseholdFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, householdFragment)
                    .addToBackStack(null)
                    .commit();
        }
        else{
                System.out.println("position...." + position);
            }
        }


    }

