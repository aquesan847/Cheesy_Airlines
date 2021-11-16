package com.aqs.pm.cheesyairlines;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {


    TextView tvDepartureDate, tvDestinationeDate, tvSurname, tvFrom, tvDestination;
    RadioButton rdBtNo, rdBtYes;

    Spinner spinner;

    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView imgFav;
        imgFav = findViewById(R.id.imgFav);
        imgFav.setOnClickListener(this);

        Button btBuy;
        btBuy = findViewById(R.id.btBuy);
        btBuy.setOnClickListener(this);







        ImageButton imgBtBuy;
        imgBtBuy = findViewById(R.id.imgBtBuy);
        imgBtBuy.setOnClickListener(this);

        Switch switchMobility = findViewById(R.id.switch_mobility);
        switchMobility.setOnCheckedChangeListener(this);

        CheckBox cbPet = findViewById(R.id.cbPet);
        cbPet.setOnCheckedChangeListener(this);

        CheckBox cbFirstClass = findViewById(R.id.cbFirstClass);
        cbFirstClass.setOnCheckedChangeListener(this);

        CheckBox cbWindowed = findViewById(R.id.cbWindowedSeat);
        cbWindowed.setOnCheckedChangeListener(this);

        CheckBox cbBreakfast = findViewById(R.id.cbBreakfast);
        cbBreakfast.setOnCheckedChangeListener(this);

        CheckBox cbLunch = findViewById(R.id.cbLunch);
        cbLunch.setOnCheckedChangeListener(this);

        CheckBox cbDinner = findViewById(R.id.cbDinner);
        cbDinner.setOnCheckedChangeListener(this);

        rdBtYes = findViewById(R.id.radioBtYes);
        rdBtYes.setOnCheckedChangeListener(this);

        rdBtNo = findViewById(R.id.radioBtNo);
        rdBtNo.setChecked(true);
        rdBtNo.setOnCheckedChangeListener(this);

        tvDepartureDate = findViewById(R.id.et_date_departure);
        tvDepartureDate.setOnClickListener(this);

        tvSurname = findViewById(R.id.et_surname);
        tvFrom = findViewById(R.id.et_origin);
        tvDestination = findViewById(R.id.et_destiny);

        tvDestinationeDate = findViewById(R.id.et_date_destination);
        tvDestinationeDate.setOnClickListener(this);
    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu, popup.getMenu());
        popup.show();
    }



    @Override
    public void onClick(View view) {
        spinner = findViewById(R.id.spinner);
        switch (view.getId()){
            case R.id.btBuy:
                Configuration config = getResources().getConfiguration();
                System.out.println(config.smallestScreenWidthDp);
                if (config.smallestScreenWidthDp >= 600) {
                    if (!tvSurname.getText().toString().isEmpty() || !tvFrom.getText().toString().isEmpty()
                            ||!tvDestination.getText().toString().isEmpty()) {
                        CallAlertDialog alert = new CallAlertDialog();
                        bundle.putString("dateDeparture", String.valueOf(tvDepartureDate.getText()));
                        bundle.putString("dateDestination", String.valueOf(tvDestinationeDate.getText()));
                        bundle.putString("name", String.valueOf(tvSurname.getText()));
                        bundle.putString("sir", spinner.getSelectedItem().toString());
                        bundle.putString("from", String.valueOf(tvFrom.getText()));
                        bundle.putString("to", String.valueOf(tvDestination.getText()));
                        alert.showDialog(MainActivity.this, bundle);
                    } else {
                        Toast.makeText(this,"Empty fields!" ,Toast.LENGTH_SHORT).show();
                    }

                } else {
                    if (!tvSurname.getText().toString().isEmpty() || !tvFrom.getText().toString().isEmpty()
                            ||!tvDestination.getText().toString().isEmpty()) {
                        CallAlertDialog alert = new CallAlertDialog();
                        bundle.putString("dateDeparture", String.valueOf(tvDepartureDate.getText()));
                        bundle.putString("dateDestination", String.valueOf(tvDestinationeDate.getText()));
                        bundle.putString("name", String.valueOf(tvSurname.getText()));
                        bundle.putString("sir", spinner.getSelectedItem().toString());
                        bundle.putString("from", String.valueOf(tvFrom.getText()));
                        bundle.putString("to", String.valueOf(tvDestination.getText()));
                        alert.showDialog(MainActivity.this, bundle);
                    } else {
                        Toast.makeText(this,"Empty fields!" ,Toast.LENGTH_SHORT).show();
                    }
                }

                break;
            case R.id.imgFav:
                //If you press the heart icon at ActionBar it will display a Toast with a design.
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toast_fav,
                        (ViewGroup) findViewById(R.id.toast_layout_root));
                TextView text = (TextView) layout.findViewById(R.id.text);
                text.setText("Favorite");

                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(layout);
                toast.show();
                break;

            case R.id.imgBtBuy:
                //Snackbar with design. I changed the text color to my cheesy yellow set at colors.xml
                Snackbar snackbarBuyNow = Snackbar.make(view, R.string.buy_now_snack, BaseTransientBottomBar.LENGTH_INDEFINITE);
                snackbarBuyNow.setActionTextColor(getResources().getColor(R.color.cheesy_yellow))
                        .setAction(R.string.buy_now_error, new MyUndoListener());
                snackbarBuyNow.show();
                break;

            case R.id.et_date_departure:
                showDatePickerDialog(R.id.et_date_departure);
                break;

            case R.id.et_date_destination:
                showDatePickerDialog(R.id.et_date_destination);
                break;
        }
    }

    private void showDatePickerDialog(int id) {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                final String selectedDate = day + "-" + (month+1) + "-" + year;
                if (id == R.id.et_date_departure) {
                    tvDepartureDate.setText(selectedDate);
                } else {
                    tvDestinationeDate.setText(selectedDate);
                }
            }
        });

        newFragment.show(getSupportFragmentManager(), "datePicker");

    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

        switch (compoundButton.getId()){
            case R.id.cbPet:
                //If you press the checkbox of "Pet" a toast will be displayed with a paw icon
                if(isChecked) {
                    bundle.putString("pet","Pet");
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.toast_pet,
                            (ViewGroup) findViewById(R.id.toast_layout_root));
                    TextView text = (TextView) layout.findViewById(R.id.text);
                    text.setText("Pet");

                    Toast toast = new Toast(getApplicationContext());
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setView(layout);
                    toast.show();
                }
                break;
            case R.id.cbFirstClass:
                if (isChecked) {
                //If you press the checkbox of "First class" a toast will be displayed with a medal icon
                    bundle.putString("first","First Class");
                    LayoutInflater inflater2 = getLayoutInflater();
                    View layout2 = inflater2.inflate(R.layout.toast_first_class,
                            (ViewGroup) findViewById(R.id.toast_layout_root));
                    TextView text2 = (TextView) layout2.findViewById(R.id.text);
                    text2.setText("First class set");

                    Toast toast2 = new Toast(getApplicationContext());
                    toast2.setDuration(Toast.LENGTH_SHORT);
                    toast2.setView(layout2);
                    toast2.show();
                }
                break;
            case R.id.cbWindowedSeat:
                if (isChecked)
                    bundle.putString("window","Windowed Seat");
                break;
            case R.id.cbBreakfast:
                if (isChecked)
                    bundle.putString("break","Breakfast");
                break;
            case R.id.cbLunch:
                if (isChecked)
                    bundle.putString("lunch","Lunch");
                break;
            case R.id.cbDinner:
                if (isChecked)
                    bundle.putString("dinner","Dinner");
                break;
            case R.id.radioBtYes:
                if (isChecked)
                    bundle.putString("rdyes","Insurance");
                break;
            case R.id.switch_mobility:
                if (isChecked)
                    bundle.putString("mobility", "Reduced Mobility");
                break;

        }
    }

    private class MyUndoListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            System.out.println("Error retrying");
        }
    }
}