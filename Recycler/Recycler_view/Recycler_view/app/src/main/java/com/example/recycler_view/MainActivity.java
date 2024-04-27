package com.example.recycler_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // data to populate the RecyclerView with
        ArrayList<String> RestoNames = new ArrayList<>();
        RestoNames.add("AltoVino");
        RestoNames.add("aasmana");
        RestoNames.add("paasha");
        RestoNames.add("Spice");
        RestoNames.add("aldila");
        RestoNames.add("cobblercrew");
        RestoNames.add("coriander");
        RestoNames.add("elephant");
        RestoNames.add("outdoor");
        RestoNames.add("ukiyo");
        RestoNames.add("westerngrills");


        ArrayList<Integer> RestoImages = new ArrayList<>();
        RestoImages.add(R.drawable.alto);
        RestoImages.add(R.drawable.aasmana);
        RestoImages.add(R.drawable.paasha);
        RestoImages.add(R.drawable.spice);
        RestoImages.add(R.drawable.aldila);
        RestoImages.add(R.drawable.cobblercrew);
        RestoImages.add(R.drawable.coriander);
        RestoImages.add(R.drawable.elephant);
        RestoImages.add(R.drawable.outdoor);
        RestoImages.add(R.drawable.ukiyo);
        RestoImages.add(R.drawable.westerngrills);


        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.Restaurants);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, RestoNames, RestoImages);
        adapter.setClickListener((MyRecyclerViewAdapter.ItemClickListener) this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}