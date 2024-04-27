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
        ArrayList<String> movieNames = new ArrayList<>();
        movieNames.add("Forrest Gump");
        movieNames.add("Hamilton");
        movieNames.add("Inception");
        movieNames.add("Interstellar");
        movieNames.add("Parasite");
        movieNames.add("Shawshank Redemption");
        movieNames.add("The Godfather");
        movieNames.add("The Matrix");
        movieNames.add("The Irishmen");
        movieNames.add("Justice League");
        movieNames.add("The Road");


        ArrayList<Integer>movieImages = new ArrayList<>();
        movieImages.add(R.drawable.forrestgump);
        movieImages.add(R.drawable.hamilton);
        movieImages.add(R.drawable.inception);
        movieImages.add(R.drawable.interstellar);
        movieImages.add(R.drawable.parasite);
        movieImages.add(R.drawable.shawshankrede);
        movieImages.add(R.drawable.thegodfather);
        movieImages.add(R.drawable.thematrix);
        movieImages.add(R.drawable.theirishmen);
        movieImages.add(R.drawable.justiceleague);
        movieImages.add(R.drawable.theroad);


        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.Movies);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, movieNames, movieImages);
        adapter.setClickListener((MyRecyclerViewAdapter.ItemClickListener) this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}