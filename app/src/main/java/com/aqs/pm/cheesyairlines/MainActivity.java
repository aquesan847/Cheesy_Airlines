package com.aqs.pm.cheesyairlines;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

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
                FragmentManager fragmentManager = getSupportFragmentManager();
                CallAlertDialog dialogBuy = new CallAlertDialog();
                dialogBuy.show(fragmentManager, "Dialog Alert");
                break;
            case R.id.imgFav:
                //Toast.makeText(this, "Favorite", Toast.LENGTH_SHORT).show();
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

            /*case R.id.cbFirstClass:
                LayoutInflater inflater2 = getLayoutInflater();
                View layout2 = inflater2.inflate(R.layout.toast_fav,
                        (ViewGroup) findViewById(R.id.toast_layout_root));
                TextView text2 = (TextView) layout2.findViewById(R.id.text);
                text2.setText("First class set");

                Toast toast2 = new Toast(getApplicationContext());
                toast2.setDuration(Toast.LENGTH_SHORT);
                toast2.setView(layout2);
                toast2.show();
                    break;

            case R.id.cbPet:
                LayoutInflater inflater3 = getLayoutInflater();
                View layout3 = inflater3.inflate(R.layout.toast_fav,
                        (ViewGroup) findViewById(R.id.toast_layout_root));
                TextView text3 = (TextView) layout3.findViewById(R.id.text);
                text3.setText("Pet set");

                Toast toast3 = new Toast(getApplicationContext());
                toast3.setDuration(Toast.LENGTH_SHORT);
                toast3.setView(layout3);
                toast3.show();
                break;*/

            case R.id.imgBtBuy:
                Snackbar snackbarBuyNow = Snackbar.make(view, R.string.buy_now_snack, BaseTransientBottomBar.LENGTH_INDEFINITE);
                snackbarBuyNow.setAction(R.string.buy_now_error, new MyUndoListener());
                snackbarBuyNow.show();
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        switch (compoundButton.getId()){
            case R.id.switch_mobility:
                System.out.println("Switch");
                break;
            case R.id.cbPet:
                System.out.println("Pet");
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