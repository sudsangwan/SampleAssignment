package com.example.sud.sampleassignment;
//TODO : Change the package name
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sudarshan on 05/04/16.
 *
 * Adapter for displaying rows in recycler view vertically
 *
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    List<Data> list = Collections.emptyList();
    Context context;

    public RecyclerViewAdapter(List<Data> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        // Name of the item
        holder.name.setText(list.get(position).name);

        // Price of one item
        holder.price.setText(String.valueOf(list.get(position).price));

        // Quantity drop down list
        final ArrayList<Integer> qtys = list.get(position).qtys;

        final ArrayAdapter<Integer> spinnerArrayAdapter = new ArrayAdapter<>(context, R.layout.spinner_view, qtys);
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_items);
        holder.spinner.setAdapter(spinnerArrayAdapter);

        // Price based on quantity of items selected
        holder.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {

                try{
                    int qty = qtys.get(pos);
                    double priceTotal = qty*list.get(position).price;
                    holder.price.setText(String.valueOf(priceTotal));
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            // Nothing to do
            }
        });

        // Images' ViewPager
        CustomPagerAdapter mCustomPagerAdapter = new CustomPagerAdapter(context, list.get(position).imageIds);
        holder.viewPager.setAdapter(mCustomPagerAdapter);

        holder.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                // Visibility of arrows for scrolling
                if (position == 0) {
                    holder.leftArrow.setVisibility(View.GONE);
                    holder.rightArrow.setVisibility(View.VISIBLE);
                }

                else if (position == (list.get(position).imageIds.size() - 1)) {
                    holder.leftArrow.setVisibility(View.VISIBLE);
                    holder.rightArrow.setVisibility(View.GONE);
                }

                else {
                    holder.leftArrow.setVisibility(View.VISIBLE);
                    holder.rightArrow.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // Click event for left arrow
        holder.leftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                holder.viewPager.setCurrentItem((holder.viewPager.getCurrentItem()) - 1);
            }
        });

        // Click event for right arrow
        holder.rightArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                holder.viewPager.setCurrentItem((holder.viewPager.getCurrentItem()) + 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
