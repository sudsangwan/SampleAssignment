package com.example.sud.sampleassignment;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Sudarshan on 05/04/16.
 */
public class View_Holder extends RecyclerView.ViewHolder {

    TextView name;
    TextView price;
    Spinner spinner;
    ViewPager viewPager;
    ImageView leftArrow;
    ImageView rightArrow;

    View_Holder(View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.tvName);
        price = (TextView) itemView.findViewById(R.id.tvPrice);
        spinner = (Spinner) itemView.findViewById(R.id.spinner);
        viewPager = (ViewPager) itemView.findViewById(R.id.viewPager);
        leftArrow = (ImageView) itemView.findViewById(R.id.ivLeftArrow);
        rightArrow = (ImageView) itemView.findViewById(R.id.ivRightArrow);
    }
}
