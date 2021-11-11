package com.aqs.pm.cheesyairlines;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {


    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        bundle = getIntent().getBundleExtra("bundle");

        String sir = bundle.getString("sir");
        String name = bundle.getString("name");
        String from = bundle.getString("from");
        String to = bundle.getString("to");
        String dateDeparture = bundle.getString("dateDeparture");
        String dateDestination = bundle.getString("dateDestination");
        TextView tvPurchase = findViewById(R.id.tv_purchase);
        tvPurchase.setText(sir + name + ", your travel from " + from + " to " + to + " have been purchased." + "\n\n" +
                "Departure date: " + dateDeparture + "\n" + "Arrival date: " + dateDestination);

        Button btBack = findViewById(R.id.btBack);
        btBack.setOnClickListener(this);

        Button btNext = findViewById(R.id.btNext);
        btNext.setOnClickListener(this);

        TextView tvPrice = findViewById(R.id.tvPrice);
        int price = createSeed(from+to);
        tvPrice.setText("Price:\n"+String.valueOf(price)+"€");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btBack:
                finish();
                break;
            case R.id.btNext:
                Context context = view.getContext();
                Intent intent = new Intent(context, ThirdActivity.class);
                intent.putExtra("bundle", bundle);
                context.startActivity(intent);
                break;
        }
    }

    private int createSeed (String seedText) {
        int seedPrice = 0;
        seedText = seedText.toLowerCase(Locale.ROOT);
        for (int i = 0; i < seedText.length(); i++) {
            seedPrice += seedText.getBytes(StandardCharsets.UTF_8)[i];
            if (seedPrice > 1000) {
                return 999;
            }
            if (seedPrice < 0){
                return 0;
            }
        }

        return seedPrice;
    }
}