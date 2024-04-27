package com.example.pract2_fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentTwo extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        TextView textView = view.findViewById(R.id.textView);
        // Receive data from FirstFragment
        Bundle bundle = getArguments();
        if (bundle != null) {
            String data = bundle.getString("data");
            textView.setText(data);
        }
        return view;
    }
}