package com.aqs.pm.cheesyairlines;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CallAlertDialog extends Activity{

    public void showDialog(Activity activity, Bundle bundle) {
        // Dialog is instantiated with a layout made by us
        Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.layout_alert_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        // We instantiate floatingActionButtons, use them for cancel and continue purposes
        FloatingActionButton floatActionCancel = dialog.findViewById(R.id.cancel);
        // Pressing cancel we close the dialog
        floatActionCancel.setOnClickListener(v -> dialog.cancel());

        FloatingActionButton floatActionBuy = dialog.findViewById(R.id.buy);
        // Pressing buy button we continue to redirect the user
        floatActionBuy.setOnClickListener(v -> {
            Context context = v.getContext();
            Configuration config = v.getResources().getConfiguration();
            Intent intent;
            // We check if the user is using a tablet (or a device with more than 600sw)
            // In true case its redirect to a activity made exclusively for them
            // In false case its redirect to a default activity
            if (config.smallestScreenWidthDp >= 600) {
                intent = new Intent(context, FragmentActivity.class);
            } else {
                intent = new Intent(context, SecondActivity.class);
            }
            // We put the bundle with the data provided
            intent.putExtra("bundle", bundle);
            context.startActivity(intent);
        });
        // We shows dialog at MainActivity
        dialog.show();
    }



}
