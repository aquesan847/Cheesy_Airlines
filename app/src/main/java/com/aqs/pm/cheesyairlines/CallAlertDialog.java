package com.aqs.pm.cheesyairlines;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.app.AlertDialog;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CallAlertDialog extends Activity{

    public void showDialog(Activity activity, Bundle bundle) {
        Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.layout_alert_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        FloatingActionButton floatActionCancel = dialog.findViewById(R.id.cancel);
        floatActionCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        FloatingActionButton floatActionBuy = dialog.findViewById(R.id.buy);
        floatActionBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Configuration config = v.getResources().getConfiguration();
                if (config.smallestScreenWidthDp >= 600) {
                    Intent intent = new Intent(context, FragmentActivity.class);
                    intent.putExtra("bundle", bundle);
                    context.startActivity(intent);
                } else {
                    Intent intent = new Intent(context, SecondActivity.class);
                    intent.putExtra("bundle", bundle);
                    context.startActivity(intent);
                }
            }
        });

        dialog.show();
    }



}
