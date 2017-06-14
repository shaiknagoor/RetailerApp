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
import android.widget.FrameLayout;

import com.biz.stampit.retailerapp.Adapters.VegitablesRecyclerViewAdapter;
import com.biz.stampit.retailerapp.Helpers.SpacesItemDecoration;
import com.biz.stampit.retailerapp.R;
import com.biz.stampit.retailerapp.entities.ProductObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stampit-PC1 on 5/24/2017.
 */

public class VegitablesFragmentScreen extends Fragment {
    private static final String TAG = VegitablesFragmentScreen.class.getSimpleName();
    private RecyclerView VegitableRecyclerView;
    private Context mContext;
    private View rootView;
    private FrameLayout addcart;

    public VegitablesFragmentScreen(){

        //Required defualt constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.vegitables_fragment,container,false);
        addcart = (FrameLayout) rootView.findViewById(R.id.counterPanel);

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mContext = getActivity();
        setViews();
        return rootView;
    }

    private void setViews() {

        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        VegitableRecyclerView = (RecyclerView) rootView.findViewById(R.id.product_list);
        GridLayoutManager mGrid = new GridLayoutManager(getActivity(), 1);
        VegitableRecyclerView.setLayoutManager(mGrid);
        VegitableRecyclerView.setHasFixedSize(true);
        VegitableRecyclerView.addItemDecoration(new SpacesItemDecoration(2, 12, false));
        VegitablesRecyclerViewAdapter shopAdapter = new VegitablesRecyclerViewAdapter(getActivity(), getAllProductsOnSale());
        VegitableRecyclerView.setAdapter(shopAdapter);
    }


    private List<ProductObject> getAllProductsOnSale(){
        List<ProductObject> products = new ArrayList<ProductObject>();
        products.add(new ProductObject(1,
                "Carrot",
                R.drawable.carrot,
                "The carrot is a root vegetable lengthy, narrow and cylindrical/cone shaped generally bright orange in color & available during the year.", 20, 38, "Black"));
        products.add(new ProductObject(1,
                "Apple-Fuji",
                R.drawable.apple,
                "Fuji apples are typically round, they contain between 9–11% sugars by weight and have a dense flesh that is sweeter and crisper than many other apple cultivars, It keeps well and supplies several different nutrients that are important for your health, such as vitamin C, Bioflavonoids, Fibre, Quercitin and Pectin. ", 20, 38, "Black"));
        products.add(new ProductObject(1,
                "Potato",
                R.drawable.potato,
                "Fresho Potatoes are nutrient-dense, non-fattening and have reasonable amount of calories. Include them in your regular meals so that the body receives a good supply of carbohydrates", 20, 38, "White"));
        products.add(new ProductObject(1,
                "Brinjal Nagpur/Nalla Vankaya",
                R.drawable.brinjal,
                "Brinjal Nagpur have a glossy skin and come in wide range of shapes, sizes and colors while the flesh is ceramic and spongy in texture and contains numerous small, soft edible seeds.", 20, 38, "Multi-color"));
        products.add(new ProductObject(1,
                "Tomato",
                R.drawable.tomato,
                "Tomato is an amazingly popular and versatile food that comes in several different varieties that vary in shape, color and size. ", 20, 38, "Dark Blue"));
        products.add(new ProductObject(1,
                "Water Melon-Kiran",
                R.drawable.watermelon,
                "Watermelon Kiran is sugary, juicy with a grainy texture. It is wealthy in electrolytes & water. It brings more nutrients per calorie making it an outstanding health product.", 20, 38, "Spotted Green"));
        products.add(new ProductObject(1,
                "Grapes Sonaka Seedless",
                R.drawable.grapes,
                "Fresho is our brand of fresh fruits and vegetables which are individually handpicked everyday by our experienced and technically competent buyers. ", 20, 38, "Multi-color"));
        products.add(new ProductObject(1,
                "Banana Robusta/Arati Pallu",
                R.drawable.banana,
                "Robusta Semi Ripe Bananas are around 6-7 inches long. Robusta has a dissimilar sweet flavor, good smell and the texture is mushy and smooth.", 20, 38, "Multi-color"));
        products.add(new ProductObject(1,
                "Banaganapalli Mangoes",
                R.drawable.mango,
                "Banganpalli are sourced from Andhra Pradesh and known for their unique sweet and rich taste. They are moderately juicy and aromatic with a maize-yellow colour.", 20, 38, "Multi-color"));
        return products;
    }
}
