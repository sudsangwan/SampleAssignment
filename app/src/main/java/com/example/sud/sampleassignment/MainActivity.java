package com.example.sud.sampleassignment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();

        List<Data> data = fill_with_data();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        // Divider between the two rows
        Drawable divider = ContextCompat.getDrawable(this, R.drawable.line_divider);
        RecyclerView.ItemDecoration dividerItemDecoration = new DividerItemDecoration(divider);
        recyclerView.addItemDecoration(dividerItemDecoration);

        adapter = new RecyclerViewAdapter(data, getApplication());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    // Create a list of Data objects
    public List<Data> fill_with_data() {

        // Array of quantity's drop down list
        ArrayList<Integer> qtys = new ArrayList<>();

        for (int i=1; i <=20; i++) {
            qtys.add(i);
        }

        // Array of Images
        ArrayList<Integer> imageIds = new ArrayList<Integer>();
        imageIds.add(R.drawable.image1);
        imageIds.add(R.drawable.image2);

        List<Data> data = new ArrayList<>();

        data.add(new Data("Item 1", 10, qtys, imageIds));
        data.add(new Data("Item 2", 20, qtys, imageIds));
        data.add(new Data("Item 3", 30, qtys, imageIds));
        data.add(new Data("Item 4", 40, qtys, imageIds));
        data.add(new Data("Item 5", 50, qtys, imageIds));

        return data;
    }
}
