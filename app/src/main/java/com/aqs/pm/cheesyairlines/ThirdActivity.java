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
        String surname = bundle.getString("surname");
        String from = bundle.getString("from");
        String to = bundle.getString("to");
        String pet = bundle.getString("pet");

        TextView tvReceipt = findViewById(R.id.tvReceiptBody);
        tvReceipt.setText(pet);

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