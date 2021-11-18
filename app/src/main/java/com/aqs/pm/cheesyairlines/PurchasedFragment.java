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

    String sir;
    TextView mTextView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_purchased, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextView = view.findViewById(R.id.tv_purchase);
        FragmentActivity fragmentActivity = new FragmentActivity();
        String string = fragmentActivity.getStringPurchase();
        System.out.println(string);
        setTextView(string);
        /*String sir = bundle.getString("sir");
        String name = bundle.getString("name");
        String from = bundle.getString("from");
        String to = bundle.getString("to");
        String dateDeparture = bundle.getString("dateDeparture");
        String dateDestination = bundle.getString("dateDestination");
        TextView tvPurchase = container.findViewById(R.id.tv_purchase);
        tvPurchase.setText(sir + name + ", your travel from " + from + " to " + to + " have been purchased." + "\n\n" +
                "Departure date: " + dateDeparture + "\n" + "Arrival date: " + dateDestination);*/
    }

    public void setTextView(String text){
        mTextView.setText(text);
    }

}