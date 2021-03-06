package com.example.sud.sampleassignment;
//TODO : Change the package name and you good to go
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Sudarshan on 05/04/16.
 */
public class ViewHolder extends RecyclerView.ViewHolder {
    
    //TODO : Give these variables accordingly to your work but keep last three
    TextView name;
    TextView price;
    Spinner spinner;
    ViewPager viewPager;
    ImageView leftArrow;
    ImageView rightArrow;
    
    //TODO : Change accordingly from above 
    ViewHolder(View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.tvName);
        price = (TextView) itemView.findViewById(R.id.tvPrice);
        spinner = (Spinner) itemView.findViewById(R.id.spinner);
        viewPager = (ViewPager) itemView.findViewById(R.id.viewPager);
        leftArrow = (ImageView) itemView.findViewById(R.id.ivLeftArrow);
        rightArrow = (ImageView) itemView.findViewById(R.id.ivRightArrow);
    }
}
