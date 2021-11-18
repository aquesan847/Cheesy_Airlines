package com.aqs.pm.cheesyairlines;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FragmentActivity extends AppCompatActivity {

    Bundle bundle;
    String sir,name,from,to,dateDeparture,dateDestination;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fragment);

        initialize();
        System.out.println((sir + name + ", your travel from " + from + " to " + to + " have been purchased." + "\n\n" +
                "Departure date: " + dateDeparture + "\n" + "Arrival date: " + dateDestination));

    }

    private void initialize() {
        bundle = getIntent().getBundleExtra("bundle");
        String sir = bundle.getString("sir");
        String name = bundle.getString("name");
        String from = bundle.getString("from");
        String to = bundle.getString("to");
        String dateDeparture = bundle.getString("dateDeparture");
        String dateDestination = bundle.getString("dateDestination");
    }


    public String getStringPurchase() {
        initialize();
        String string = sir + name + ", your travel from " + from + " to " + to + " have been purchased." + "\n\n" +
                "Departure date: " + dateDeparture + "\n" + "Arrival date: " + dateDestination;
        System.out.println(string);
        return string;
    }}