package com.biz.stampit.retailerapp.Fragments;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.biz.stampit.retailerapp.Adapters.PersonalCareViewAdapter;
import com.biz.stampit.retailerapp.Helpers.SpacesItemDecoration;
import com.biz.stampit.retailerapp.R;
import com.biz.stampit.retailerapp.entities.ProductObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Nagoor on 6/3/2017.
 */

public class PersonalCareFragment extends Fragment {
    private static final String TAG = PersonalCareFragment.class.getName();
    private RecyclerView PersonalCareRecyclerView;
    private Context mContext;
    private View rootView;

    public PersonalCareFragment()

    {
        //Required defualt constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.personal_fragment, container, false);
        mContext = getActivity();
        setViews();
        return rootView;
    }

    private void setViews() {
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        PersonalCareRecyclerView = (RecyclerView) rootView.findViewById(R.id.product_list);
        GridLayoutManager mGrid = new GridLayoutManager(getActivity(), 1);
        PersonalCareRecyclerView.setLayoutManager(mGrid);
        PersonalCareRecyclerView.setHasFixedSize(true);
        PersonalCareRecyclerView.addItemDecoration(new SpacesItemDecoration(2, 12, false));
        PersonalCareViewAdapter shopAdapter = new PersonalCareViewAdapter(getActivity(), getAllProductsOnSale());
        PersonalCareRecyclerView.setAdapter(shopAdapter);
    }


    private List<ProductObject> getAllProductsOnSale() {
        List<ProductObject> products = new ArrayList<ProductObject>();
        products.add(new ProductObject(1, "Baby lotion",
                R.drawable.babylotion,
                "Special prepared babies for their cute skin", 20, 38, "Black"));
        products.add(new ProductObject(1,
                "loreal Black",
                R.drawable.lorealblack,
                "The Black Hair expect and giving age less look to you", 70, 32, "Black"));
        products.add(new ProductObject(1,
                "Johnsons baby soap",
                R.drawable.shampoo,
                "Beautiful glow hair .It is best option to every one", 70, 32, "White"));
        products.add(new ProductObject(1,
                "Johnsons baby shampoo",
                R.drawable.babyshampoo,
                "Baby Shampoo is a best option for babies it prroduct baby skin and gives good result.", 70, 32, "Dark Blue"));
        products.add(new ProductObject(1,
                "Herbal HandWash",
                R.drawable.herbalhandwash,
                "Helber Hand wash gives production. It is good for our body.", 70, 32, "Spotted Green"));
        products.add(new ProductObject(1, "Baby Lotion",
                R.drawable.babylotion,
                "Special prepared babies for their cute skin", 20, 38, "Black"));
        products.add(new ProductObject(1,
                "Herbal HandWash",
                R.drawable.herbalhandwash,
                "Helber Hand wash gives production. It is good for our body.", 70, 32, "Spotted Green"));
        return products;

    }
}