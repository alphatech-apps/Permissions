package com.jakir.permissions.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.Window;
import android.widget.TextView;

import com.jakir.permissions.R;


public class File_Permission_Dialog extends Dialog {
    Activity activity;

    public File_Permission_Dialog(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().getAttributes().windowAnimations = R.style.DialogAnimation_fade_in_zoom; //dialog animation
        setContentView(R.layout.permission_allow_file_dialog);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        TextView ok = findViewById(R.id.txt_allow);
        TextView cancel = findViewById(R.id.txt_close);

        ok.setOnClickListener(v -> {
            dismiss();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                if (!Environment.isExternalStorageManager()) {
                    try {
                        Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                        intent.addCategory("android.intent.category.DEFAULT");
                        intent.setData(Uri.parse(String.format("package:%s", activity.getApplicationContext().getPackageName())));
                        activity.startActivityIfNeeded(intent, 101);
                    } catch (Exception exception) {
                        Intent intent = new Intent();
                        intent.setAction(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                        activity.startActivityIfNeeded(intent, 101);
                    }
                }
            }
        });

        cancel.setOnClickListener(v -> dismiss());
    }
}
