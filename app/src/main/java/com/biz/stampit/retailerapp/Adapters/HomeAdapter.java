package com.biz.stampit.retailerapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.biz.stampit.retailerapp.ClickListener;
import com.biz.stampit.retailerapp.R;
import com.biz.stampit.retailerapp.entities.HomeModel;

import java.util.List;

/**
 * Created by Stampit-PC1 on 5/31/2017.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    private List<HomeModel> homeModelList;
    private ClickListener clicklistener = null;
    public HomeAdapter(List<HomeModel>homeList){
        this.homeModelList = homeList;
    }

    @Override
    public HomeAdapter.HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return new HomeViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(HomeAdapter.HomeViewHolder holder, int position) {

        HomeModel row = homeModelList.get(position);
        holder.productname.setText(row.getTitle());
        holder.productimage.setImageResource(row.getImageId());
//        holder.productname.setText("some text");
    }

    @Override
    public int getItemCount() {
        return homeModelList.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder{

        public TextView productname;
        public ImageView productimage;
        private LinearLayout main;

        public HomeViewHolder(View rootView) {
            super(rootView);

            productname = (TextView) rootView.findViewById(R.id.product_name);
            productimage = (ImageView) rootView.findViewById(R.id.product_image);
           main = (LinearLayout) rootView.findViewById(R.id.main);
            main.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(itemView.getContext(), "Position:" + Integer.toString(getPosition()), Toast.LENGTH_SHORT).show();
                    if(clicklistener !=null){
                        clicklistener.itemClicked(v,getAdapterPosition());
                    }
                }
            });
        }
    }

    public void setClickListener(ClickListener clickListener){
        this.clicklistener = clickListener;
    }



}
