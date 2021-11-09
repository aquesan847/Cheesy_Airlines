package com.aqs.pm.cheesyairlines;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {


    TextView tvDepartureDate;
    TextView tvDestinationeDate;

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
        tvDepartureDate = findViewById(R.id.et_date_departure);
        tvDepartureDate.setOnClickListener(this);

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
        switch (view.getId()){
            case R.id.btBuy:
                CallAlertDialog alert = new CallAlertDialog();
                alert.showDialog(MainActivity.this);
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
        }
    }

    private class MyUndoListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            System.out.println("Error retrying");
        }
    }
}