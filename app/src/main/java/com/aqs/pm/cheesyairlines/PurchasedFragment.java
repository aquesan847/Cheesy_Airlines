package com.aqs.pm.cheesyairlines;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PurchasedFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_purchased, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();

        String sir = bundle.getString("sir");
        String name = bundle.getString("name");
        String from = bundle.getString("from");
        String to = bundle.getString("to");
        String dateDeparture = bundle.getString("dateDeparture");
        String dateDestination = bundle.getString("dateDestination");
        TextView tvPurchase = view.findViewById(R.id.tv_purchase);
        tvPurchase.setText(sir + name + ", your travel from " + from + " to " + to + " have been purchased." + "\n\n" +
                "Departure date: " + dateDeparture + "\n" + "Arrival date: " + dateDestination);
    }
}