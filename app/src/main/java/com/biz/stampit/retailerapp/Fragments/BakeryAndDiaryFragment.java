package com.biz.stampit.retailerapp.Fragments;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.biz.stampit.retailerapp.Adapters.BakeryAndDiaryViewAdapter;
import com.biz.stampit.retailerapp.Adapters.BeveragesRecyclerViewAdapter;
import com.biz.stampit.retailerapp.Helpers.SpacesItemDecoration;
import com.biz.stampit.retailerapp.R;
import com.biz.stampit.retailerapp.entities.ProductObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 6/1/2017.
 */

public class BakeryAndDiaryFragment extends Fragment {
    private static final  String TAG = BakeryAndDiaryFragment.class.getName();
    private RecyclerView BakeryAndDiaryRecyclerView;
    private Context mContext;
    private View rootView;


    public BakeryAndDiaryFragment(){
        //default constuctor;

    }
    @Nullable
@Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.bakery_and_diary_fragment,container,false);
        mContext = getActivity();
        setViews();
        return rootView;
    }

    private void setViews() {
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        BakeryAndDiaryRecyclerView = (RecyclerView) rootView.findViewById(R.id.product_list);
        GridLayoutManager mGrid = new GridLayoutManager(getActivity(), 1);
        BakeryAndDiaryRecyclerView.setLayoutManager(mGrid);
        BakeryAndDiaryRecyclerView.setHasFixedSize(true);
        BakeryAndDiaryRecyclerView.addItemDecoration(new SpacesItemDecoration(1, 12, false));
        BakeryAndDiaryViewAdapter shopAdapter = new BakeryAndDiaryViewAdapter(getActivity(), getAllProductsOnSale());
        BakeryAndDiaryRecyclerView.setAdapter(shopAdapter);
    }

    private List<ProductObject> getAllProductsOnSale() {
        List<ProductObject> products = new ArrayList<ProductObject>();
        products.add(new ProductObject(1, "Motherdairy",
                R.drawable.motherdairydahimadefromtonedmilk,
                "in hot summer amul ice cream gives coolness with badam flavour", 20, 30, "Black"));
        products.add(new ProductObject(2, "Heritage",
                R.drawable.heritagepaneer,
                "milky mist cooking butter very branded product in the market", 20, 30, "Black"));
        products.add(new ProductObject(3, "Milky mist cook",
                R.drawable.heritagepaneer,
                "in hot summer amul ice cream gives coolness with badam flavour", 20, 30, "Black"));
        products.add(new ProductObject(4, "Jersey tone",
                R.drawable.motherdairydahimadefromtonedmilk,
                "in hot summer amul ice cream gives coolness with badam flavour", 20, 30, "Black"));
        products.add(new ProductObject(5, "Amul paneeer",
                R.drawable.motherdairydahimadefromtonedmilk,
                "in hot summer amul ice cream gives coolness with badam flavour", 20, 30, "Black"));
        products.add(new ProductObject(6, "Amul Ice cream",
                R.drawable.heritagepaneer,
                "in hot summer amul ice cream gives coolness with badam flavour", 20, 30, "Black"));

return products;
    }
}
