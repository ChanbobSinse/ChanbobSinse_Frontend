package com.oechyeochangmen.chanbapsinse.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.oechyeochangmen.chanbapsinse.Fonts;
import com.oechyeochangmen.chanbapsinse.Model.RestaurantInfo;
import com.oechyeochangmen.chanbapsinse.R;

import java.util.ArrayList;

/**
 * Created by eka on 2017. 7. 18..
 */

public class RestaurantRecyclerViewAdapter extends RecyclerView.Adapter<RestaurantRecyclerViewAdapter.ViewHolder> {
    ArrayList<RestaurantInfo> items = new ArrayList<>();
    private onItemClick onItemClick;
    Context context;
    Fonts fonts;

    public RestaurantRecyclerViewAdapter(ArrayList<RestaurantInfo> items, Context context) {
        this.items = items;
        this.context = context;
        fonts = new Fonts(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_restaurant, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        RestaurantInfo item = items.get(position);

        holder.name.setTypeface(fonts.tfRegular);
        holder.address.setTypeface(fonts.tfLight);
        holder.number.setTypeface(fonts.tfLight);
        holder.category.setTypeface(fonts.tfLight);

        holder.name.setText(item.getName());
        holder.address.setText(item.getAddress());
        holder.number.setText(item.getNumber());
        holder.category.setText(item.getCategory());

        holder.ratingBar.setRating(item.getRating());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onItemClick(v, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView category;
        TextView address;
        TextView number;
        RatingBar ratingBar;
        ImageButton btn;

        public ViewHolder(View itemView) {
            super(itemView);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            itemView.setLayoutParams(params);
            name = (TextView) itemView.findViewById(R.id.restaurant_name);
            category = (TextView) itemView.findViewById(R.id.restaurant_category);
            address = (TextView) itemView.findViewById(R.id.restaurant_address);
            number = (TextView) itemView.findViewById(R.id.restaurant_number);
            ratingBar = (RatingBar) itemView.findViewById(R.id.restaurant_ratingBar);
            btn = (ImageButton) itemView.findViewById(R.id.restaurant_button);
        }
    }


    public interface onItemClick {
        void onItemClick(View view, int position);
    }

    public void setOnItemClick(RestaurantRecyclerViewAdapter.onItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }
}
