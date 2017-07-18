package com.oechyeochangmen.chanbapsinse.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oechyeochangmen.chanbapsinse.Fonts;
import com.oechyeochangmen.chanbapsinse.Model.Category;
import com.oechyeochangmen.chanbapsinse.R;

import java.util.ArrayList;

/**
 * Created by eka on 2017. 7. 18..
 */

public class SelectedCategoryRecyclerViewAdapter extends RecyclerView.Adapter<SelectedCategoryRecyclerViewAdapter.ViewHolder> {
    ArrayList<Category> items = new ArrayList<>();
    Context context;
    Fonts fonts;

    public SelectedCategoryRecyclerViewAdapter(ArrayList<Category> items, Context context) {
        this.items = items;
        this.context = context;
        fonts = new Fonts(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_selected_category, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Category item = items.get(position);

        holder.textView.setTypeface(fonts.tfLight);
        if (item.isChecked()) {
            String content = "#" + item.getKorTitle();
            holder.textView.setText(content);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.selected_category_textView);
        }
    }
}
