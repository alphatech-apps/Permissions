package com.jakir.permissions.dialogs;


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Window;
import android.widget.TextView;

import com.jakir.permissions.R;


public class Notification_settings_Dialog extends Dialog {
    Activity activity;

    public Notification_settings_Dialog(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().getAttributes().windowAnimations = R.style.DialogAnimation_fade_in_zoom; //dialog animation
        setContentView(R.layout.permission_notific_set_dialog);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        TextView ok = findViewById(R.id.txt_allow);
        TextView cancel = findViewById(R.id.txt_close);

        ok.setOnClickListener(v -> {
            dismiss();

            Intent intent;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                intent = new Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
                intent.putExtra("android.provider.extra.APP_PACKAGE", activity.getPackageName());
            } else {
                intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                String packageName = activity.getPackageName();
                intent.setData(Uri.parse("package:" + packageName));
            }
            activity.startActivity(intent);

        });

        cancel.setOnClickListener(v -> dismiss());
    }
}
