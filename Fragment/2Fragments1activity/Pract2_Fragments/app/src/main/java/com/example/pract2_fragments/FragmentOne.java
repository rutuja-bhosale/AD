package com.example.pract2_fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentOne extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        Button btn = view.findViewById(R.id.btn_submit);
        EditText editText = view.findViewById(R.id.edit_txt);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = editText.getText().toString();
                // Pass data to SecondFragment
                Bundle bundle = new Bundle();
                bundle.putString("data", data);
                FragmentTwo secondFragment = new FragmentTwo();
                secondFragment.setArguments(bundle);
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, secondFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }
}