package com.oechyeochangmen.chanbapsinse.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.oechyeochangmen.chanbapsinse.Fonts;
import com.oechyeochangmen.chanbapsinse.Model.MenuInfo;
import com.oechyeochangmen.chanbapsinse.R;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by eka on 2017. 7. 19..
 */

public class Menu2RecyclerViewAdapter extends RecyclerView.Adapter<Menu2RecyclerViewAdapter.ViewHolder> {
    ArrayList<MenuInfo> items = new ArrayList<>();
    Context context;
    Fonts fonts;

    public Menu2RecyclerViewAdapter(ArrayList<MenuInfo> items, Context context) {
        this.items = items;
        this.context = context;
        fonts = new Fonts(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_menu2, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final MenuInfo item = items.get(position);

        holder.name.setTypeface(fonts.tfRegular);
        holder.price.setTypeface(fonts.tfRegular);
        holder.text.setTypeface(fonts.tfRegular);

        DecimalFormat format = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        DecimalFormatSymbols symbols = format.getDecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        format.setDecimalFormatSymbols(symbols);

        String price = format.format(item.getPrice());

        holder.name.setText(item.getName());
        holder.price.setText(price);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView price;
        TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            itemView.setLayoutParams(params);
            name = (TextView) itemView.findViewById(R.id.menu2_name);
            price = (TextView) itemView.findViewById(R.id.menu2_price);
            text = (TextView) itemView.findViewById(R.id.menu2_text);
        }
    }
}