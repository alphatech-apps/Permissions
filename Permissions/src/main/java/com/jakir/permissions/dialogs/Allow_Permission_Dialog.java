package com.jakir.permissions.permissions.dialogs;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import com.jakir.permissions.R;


public class Allow_Permission_Dialog extends Dialog {

//    Activity activity;
    public Allow_Permission_Dialog(Context context) {
        super(context);
//        this.activity= activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().getAttributes().windowAnimations = R.style.DialogAnimation_fade_in_zoom; //dialog animation
        setContentView(R.layout.permission_allow_dialog);

        getWindow().setBackgroundDrawableResource(android.R.color.transparent);

     }


}
