package com.example.sud.sampleassignment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int VERTICAL_ITEM_SPACE = 30;
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
        recyclerView.addItemDecoration(new SimpleDivider(context));
        recyclerView.addItemDecoration(new SpacesItemDecoration(VERTICAL_ITEM_SPACE));

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
