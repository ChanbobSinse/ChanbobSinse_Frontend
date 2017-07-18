package com.oechyeochangmen.chanbapsinse.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.oechyeochangmen.chanbapsinse.Fonts;
import com.oechyeochangmen.chanbapsinse.Model.Category;
import com.oechyeochangmen.chanbapsinse.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by eka on 2017. 7. 17..
 */

public class CategoryRecyclerViewAdpater extends RecyclerView.Adapter<CategoryRecyclerViewAdpater.ViewHolder> {
    Context context;
    ArrayList<Category> items = new ArrayList<>();
    Fonts fonts;

    public CategoryRecyclerViewAdpater(Context context, ArrayList<Category> items) {
        this.context = context;
        this.items = items;
        fonts = new Fonts(context);
    }

    @Override
    public CategoryRecyclerViewAdpater.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_category, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CategoryRecyclerViewAdpater.ViewHolder holder, final int position) {


        holder.korTitle.setTypeface(fonts.tfRegular);
        holder.engTitle.setTypeface(fonts.tfLight);
        holder.content.setTypeface(fonts.tfLight);

        holder.imageView.setImageDrawable(items.get(position).getImg());
        holder.korTitle.setText(items.get(position).getKorTitle());
        holder.engTitle.setText(items.get(position).getEngTitle());
        holder.content.setText(items.get(position).getContent());
        holder.checkBox.setChecked(items.get(position).isChecked());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (items.get(position).isChecked()) {
                    holder.checkBox.setChecked(false);
                    items.get(position).setChecked(false);
                } else {
                    holder.checkBox.setChecked(true);
                    items.get(position).setChecked(true);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imageView;
        TextView korTitle;
        TextView engTitle;
        TextView content;
        CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            itemView.setLayoutParams(params);
            imageView = (CircleImageView) itemView.findViewById(R.id.category_img);
            korTitle = (TextView) itemView.findViewById(R.id.category_korTitle);
            engTitle = (TextView) itemView.findViewById(R.id.category_engTitle);
            content = (TextView) itemView.findViewById(R.id.category_content);
            checkBox = (CheckBox) itemView.findViewById(R.id.category_checkbox);
        }
    }
}
