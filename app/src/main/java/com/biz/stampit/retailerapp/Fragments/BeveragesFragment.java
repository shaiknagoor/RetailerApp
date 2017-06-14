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

import com.biz.stampit.retailerapp.Adapters.BeveragesRecyclerViewAdapter;
import com.biz.stampit.retailerapp.Adapters.VegitablesRecyclerViewAdapter;
import com.biz.stampit.retailerapp.Helpers.SpacesItemDecoration;
import com.biz.stampit.retailerapp.R;
import com.biz.stampit.retailerapp.entities.ProductObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stampit-PC1 on 5/30/2017.
 */

public class BeveragesFragment extends Fragment {

    private static final String TAG = BeveragesFragment.class.getSimpleName();
    private RecyclerView BeverageRecyclerView;
    private Context mContext;
    private View rootView;

    public BeveragesFragment(){

        //Required defualt constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.beverages_fragment,container,false);
        mContext = getActivity();
        setViews();
        return rootView;
    }

    private void setViews() {
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        BeverageRecyclerView = (RecyclerView) rootView.findViewById(R.id.product_list);
        GridLayoutManager mGrid = new GridLayoutManager(getActivity(), 1);
        BeverageRecyclerView.setLayoutManager(mGrid);
        BeverageRecyclerView.setHasFixedSize(true);
        BeverageRecyclerView.addItemDecoration(new SpacesItemDecoration(1, 12, false));
        BeveragesRecyclerViewAdapter shopAdapter = new BeveragesRecyclerViewAdapter(getActivity(), getAllProductsOnSale());
        BeverageRecyclerView.setAdapter(shopAdapter);
    }


    private List<ProductObject> getAllProductsOnSale(){
        List<ProductObject> products = new ArrayList<ProductObject>();
        products.add(new ProductObject(1, "Combo Pepsi with Lays",
                R.drawable.combopepsi,
                "On hot summer days, a chilled glass of Pepsi Soft Drink can be relaxing and refreshing. This sweetened and carbonated drink is deliciously fizzy and goes well with all kinds of snacks. No party, be it for a birthday or anniversary, is complete without Pepsi.", 20, 38, "Black"));
        products.add(new ProductObject(1,
                "Coke Dite",
                R.drawable.cokediet,
                "Diet Coke is a sugar-free soft drink, and not just drink, whole range food. It is one of our best-loved drinks. It is stimulating, great tasting and provides only 1kcal per 250ml serving.", 70, 32, "Black"));
        products.add(new ProductObject(1,
                "Boost energy Drink",
                R.drawable.boost,
                "Beautiful sleek black top for casual outfit and evening walk", 70, 32, "White"));
        products.add(new ProductObject(1,
                "organic Juice Aloevera",
                R.drawable.organicjuicealoevera,
                "Aloe Vera Juice Is Extracted From The Aloe Plant And Has Been Credited With The Ability To Support Health.", 70, 32, "Dark Blue"));
        products.add(new ProductObject(1,
                "Organic Juice Apple",
                R.drawable.organicjuiceapple,
                "24 Mantra Apple Juice is prepared using fresh organic apples. It is good for our body and is preferred by health conscious people.", 70, 32, "Spotted Green"));
        products.add(new ProductObject(1,
                "Thumsup",
                R.drawable.thumsup,
                "Thums Up Soft Drink is one of the most ideal beverages and greatest to satisfy your thirst. Thums Ups has been merged well with great flavor and strong aromatic. ", 70, 32, "Multi-color"));
        products.add(new ProductObject(1,
                "Pepsi Mini",
                R.drawable.pepsimini,
                "Play in Fun Times Together with Pepsi Mini Can. Its all the irresistible taste and refreshment of Pepsi, in the perfect, fun-sized package. Grab one today and enjoy life to the fullest!", 70, 32, "Multi-color"));
        products.add(new ProductObject(1,
                "Organic Assam Tea",
                R.drawable.organicassamtea,
                "Assam tea is a type of black tea known for its robust body, briskness, tart, malty flavor, and bright color. It is typically marketed as \"breakfast\" teas and some of its common generic names are English breakfast tea, Irish breakfast tea and Scottish breakfast tea.Assam tea is made from the leaves of the camellia sinensis (assamica) plant.", 70, 32, "Multi-color"));
        return products;
    }
}
