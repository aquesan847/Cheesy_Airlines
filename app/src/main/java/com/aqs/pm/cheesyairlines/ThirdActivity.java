package com.aqs.pm.cheesyairlines;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        bundle = getIntent().getBundleExtra("bundle");

        String sir = bundle.getString("sir");
        String name = bundle.getString("name");
        String from = bundle.getString("from");
        String to = bundle.getString("to");


        String first = bundle.getString("first");
        String pet = bundle.getString("pet");
        String window = bundle.getString("window");
        String breakfast = bundle.getString("break");
        String lunch = bundle.getString("lunch");
        String dinner = bundle.getString("dinner");
        String rbYes = bundle.getString("rdyes");
        String mobility = bundle.getString("mobility");

        if (first == null) {
            first = "";
        }

        if (pet == null) {
            pet = "";
        }

        if (window == null) {
            window = "";
        }

        if (breakfast == null) {
            breakfast = "";
        }

        if (lunch == null) {
            lunch = "";
        }

        if (dinner == null) {
            dinner = "";
        }

        if (rbYes == null) {
            rbYes = "";
        }

        if (mobility == null) {
            mobility = "";
        }

        TextView tvReceipt = findViewById(R.id.tvReceiptBody);
        tvReceipt.setText(first + "\n" +
                            pet + "\n" +
                            window + "\n" +
                            breakfast + "\n" +
                            lunch + "\n" +
                            dinner + "\n" +
                            rbYes + "\n" +
                            mobility);


        String dateDeparture = bundle.getString("dateDeparture");
        String dateDestination = bundle.getString("dateDestination");

        TextView tvDates = findViewById(R.id.tvDates);
        tvDates.setText("Departure date: " + dateDeparture + "\n" + "Arrival date: " + dateDestination);

        TextView tvThanks = findViewById(R.id.tvThanks);
        tvThanks.setText("Thanks " + sir + name + " for your purchase!");

        TextView tvFlightDeparture = findViewById(R.id.tvFlightDeparture);
        tvFlightDeparture.setText(from);

        TextView tvFlightDestination = findViewById(R.id.tvFlightDestination);
        tvFlightDestination.setText(to);


        Button btFinal = findViewById(R.id.btFinal);
        btFinal.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        view.getContext().startActivity(intent);
    }
}