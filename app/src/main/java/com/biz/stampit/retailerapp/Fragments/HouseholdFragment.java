package com.biz.stampit.retailerapp.Fragments;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.biz.stampit.retailerapp.Adapters.HouseholdRecyclerViewAdapter;
import com.biz.stampit.retailerapp.Helpers.SpacesItemDecoration;
import com.biz.stampit.retailerapp.R;
import com.biz.stampit.retailerapp.entities.ProductObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 6/5/2017.
 */

public class HouseholdFragment extends Fragment{
    private static final String TAG = HouseholdFragment.class.getName();
    private RecyclerView HouseholdRecyclerView;
    private Context mContext;
    private View rootView;

    public HouseholdFragment(){

        //Required defualt constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.household_fragment,container,false);
        mContext = getActivity();
        setViews();
        return rootView;
    }

    private void setViews() {
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
         HouseholdRecyclerView= (RecyclerView) rootView.findViewById(R.id.product_list);
        GridLayoutManager mGrid = new GridLayoutManager(getActivity(), 1);
        HouseholdRecyclerView.setLayoutManager(mGrid);
        HouseholdRecyclerView.setHasFixedSize(true);
        HouseholdRecyclerView.addItemDecoration(new SpacesItemDecoration(2, 12, false));
        HouseholdRecyclerViewAdapter shopAdapter = new HouseholdRecyclerViewAdapter(getActivity(), getAllProductsOnSale());
        HouseholdRecyclerView.setAdapter(shopAdapter);
    }


    private List<ProductObject> getAllProductsOnSale(){
        List<ProductObject> products = new ArrayList<ProductObject>();
        products.add(new ProductObject(1, "",
                R.drawable.c1,
                "Special prepared for Cooking", 20, 38, "Black"));
        products.add(new ProductObject(1,
                "loreal Black",
                R.drawable.c2,
                "The Black Hair expect and giving age less look to you", 70, 32, "Black"));
        products.add(new ProductObject(1,
                "Johnsons baby soap",
                R.drawable.c3,
                "Beautiful glow hair .It is best option to every one", 70, 32, "White"));
        products.add(new ProductObject(1,
                "Johnsons baby shampoo",
                R.drawable.c4,
                "Baby Shampoo is a best option for babies it prroduct baby skin and gives good result.", 70, 32, "Dark Blue"));
        products.add(new ProductObject(1,
                "Herbal HandWash",
                R.drawable.dishwash,
                "Helber Hand wash gives production. It is good for our body.", 70, 32, "Spotted Green"));
        products.add(new ProductObject(1, "Baby Lotion",
                R.drawable.comfort,
                "Special prepared babies for their cute skin", 20, 38, "Black"));
        products.add(new ProductObject(1,
                "loreal Black",
                R.drawable.dishwash,
                "The Black Hair expect and giving age less look to you", 70, 32, "Black"));
        products.add(new ProductObject(1,
                "Herbal HandWash",
                R.drawable.comfort,
                "Helber Hand wash gives production. It is good for our body.", 70, 32, "Spotted Green"));
        return products;

    }
}

