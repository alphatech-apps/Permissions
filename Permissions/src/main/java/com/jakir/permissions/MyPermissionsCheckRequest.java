package com.jakir.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.jakir.permissions.dialogs.File_Permission_Dialog;
import com.jakir.permissions.dialogs.Notification_settings_Dialog;
import com.jakir.permissions.extraclass.Key;
import com.jakir.permissions.extraclass.Pref;
import com.jakir.permissions.permissions.dialogs.Allow_Permission_Dialog;


public class MyPermissionsCheckRequest {
    public static final int All_Permission_Request_Code = 10001, microphone_allow_code = 1111, sms_allow_code = 2222, phone_allow_code = 3333, calllog_allow_code = 4444, location_allow_code = 5555, camera_allow_code = 6666, contacts_allow_code = 7777, mediastorage_allow_code = 8888, filestorage_allow_code = 8008, notification_allow_code = 9999;

    public static void requestAllPermission(Activity activity) { //if call it from Activity = "this" , Fragment = "getActivity"
//        ActivityCompat.requestPermissions(activity, MyPermissions.AllPermissions, All_Permission_Request_Code);
        showPermissionDialog_RequestMultiplePermission(activity, MyPermissions.AllPermissions, All_Permission_Request_Code);
    }


    public static boolean checkMediaStoragePermission0(Context context) {
        boolean isMediaStoragePermissionGranted = true;
        if (ContextCompat.checkSelfPermission(context, MyPermissions.getStoragePermissionNameFromApiImage) != PackageManager.PERMISSION_GRANTED) {
            isMediaStoragePermissionGranted = false;
        } else if (ContextCompat.checkSelfPermission(context, MyPermissions.getStoragePermissionNameFromApiAudio) != PackageManager.PERMISSION_GRANTED) {
            isMediaStoragePermissionGranted = false;
        }
        return isMediaStoragePermissionGranted;
    }

    public static boolean checkMediaStoragePermission(Context context) {
        return ContextCompat.checkSelfPermission(context, MyPermissions.getStoragePermissionNameFromApiImage) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(context, MyPermissions.getStoragePermissionNameFromApiAudio) == PackageManager.PERMISSION_GRANTED;
    }

    public static void requestMediaStoragePermission(Activity activity) {//if call it from Activity = "this" , Fragment = "getActivity"
//        ActivityCompat.requestPermissions(activity, MyPermissions.MediaStoragePermissions, mediastorage_allow_code);
//        checkRationale_RequestPermission(activity, MyPermissions.MediaStoragePermissions, mediastorage_allow_code);
        showPermissionDialog_RequestMultiplePermission(activity, MyPermissions.MediaStoragePermissions, mediastorage_allow_code);
    }

    public static boolean checkFileStoragePermission(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            return Environment.isExternalStorageManager();
        } else {
            return ContextCompat.checkSelfPermission(context, MyPermissions.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
        }
    }

    public static void requestFileStoragePermission(Activity activity) { //if call it from Activity = "this" , Fragment = "getActivity"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            new File_Permission_Dialog(activity).show();
        } else {
//            ActivityCompat.requestPermissions(activity, MyPermissions.MediaStoragePermissions, mediastorage_allow_code);
            showPermissionDialog_RequestMultiplePermission(activity, MyPermissions.MediaStoragePermissions, filestorage_allow_code);
        }
    }


    public static boolean checkContactsPermission(Context context) {
        return ContextCompat.checkSelfPermission(context, MyPermissions.ContactsPermission) == PackageManager.PERMISSION_GRANTED;
    }

    public static void requestContactsPermission(Activity activity) { //if call it from Activity = "this" , Fragment = "getActivity"
//        ActivityCompat.requestPermissions(activity, new String[]{MyPermissions.ContactsPermission}, contacts_allow_code);
//        checkRationale_RequestPermission(activity, MyPermissions.ContactsPermission, contacts_allow_code);
        showPermissionDialog_RequestPermission(activity, MyPermissions.ContactsPermission, contacts_allow_code);
    }


    public static boolean checkCameraPermission(Context context) {
        return ContextCompat.checkSelfPermission(context, MyPermissions.CameraPermission) == PackageManager.PERMISSION_GRANTED;
    }

    public static void requestCameraPermission(Activity activity) { //if call it from Activity = "this" , Fragment = "getActivity"
//        ActivityCompat.requestPermissions(activity, new String[]{MyPermissions.CameraPermission}, camera_allow_code);
//        checkRationale_RequestPermission(activity, MyPermissions.CameraPermission, camera_allow_code);
        showPermissionDialog_RequestPermission(activity, MyPermissions.CameraPermission, camera_allow_code);
    }


    public static boolean checkLocationPermission(Context context) {
        return ContextCompat.checkSelfPermission(context, MyPermissions.LocationPermission) == PackageManager.PERMISSION_GRANTED;
    }

    public static void requestLocationPermission(Activity activity) { //if call it from Activity = "this" , Fragment = "getActivity"
//        ActivityCompat.requestPermissions(activity, new String[]{MyPermissions.LocationPermission}, location_allow_code);
//        checkRationale_RequestPermission(activity, MyPermissions.LocationPermission, location_allow_code);
        showPermissionDialog_RequestPermission(activity, MyPermissions.LocationPermission, location_allow_code);
    }


    public static boolean checkCallLogPermission(Context context) {
        return ContextCompat.checkSelfPermission(context, MyPermissions.CalLogPermission) == PackageManager.PERMISSION_GRANTED;
    }

    public static void requestCallLogPermission(Activity activity) { //if call it from Activity = "this" , Fragment = "getActivity"
//        ActivityCompat.requestPermissions(activity, new String[]{MyPermissions.CalLogPermission}, calllog_allow_code);
//        checkRationale_RequestPermission(activity, MyPermissions.CalLogPermission, calllog_allow_code);
        showPermissionDialog_RequestPermission(activity, MyPermissions.CalLogPermission, calllog_allow_code);
    }


    public static boolean checkPhonePermission(Context context) {
        return ContextCompat.checkSelfPermission(context, MyPermissions.PhonePermission) == PackageManager.PERMISSION_GRANTED;
    }

    public static void requestPhonePermission(Activity activity) { //if call it from Activity = "this" , Fragment = "getActivity"
//        ActivityCompat.requestPermissions(activity, new String[]{MyPermissions.PhonePermission}, phone_allow_code);
//        checkRationale_RequestPermission(activity, MyPermissions.PhonePermission, phone_allow_code);
        showPermissionDialog_RequestPermission(activity, MyPermissions.PhonePermission, phone_allow_code);
    }


    public static boolean checkSmsPermission(Context context) {
        return ContextCompat.checkSelfPermission(context, MyPermissions.SmsPermission) == PackageManager.PERMISSION_GRANTED;
    }

    public static void requestSmsPermission(Activity activity) { //if call it from Activity = "this" , Fragment = "getActivity"
//        ActivityCompat.requestPermissions(activity, new String[]{MyPermissions.SmsPermission}, sms_allow_code);
//        checkRationale_RequestPermission(activity, MyPermissions.SmsPermission, sms_allow_code);
        showPermissionDialog_RequestPermission(activity, MyPermissions.SmsPermission, sms_allow_code);
    }


    public static boolean checkMicrophonePermission(Context context) {
        return ContextCompat.checkSelfPermission(context, MyPermissions.RecordAudioPermission) == PackageManager.PERMISSION_GRANTED;
    }

    public static void requestMicrophonePermission(Activity activity) { //if call it from Activity = "this" , Fragment = "getActivity"
//        ActivityCompat.requestPermissions(activity, new String[]{MyPermissions.RecordAudioPermission}, microphone_allow_code);
//        checkRationale_RequestPermission(activity, MyPermissions.RecordAudioPermission, microphone_allow_code);
        showPermissionDialog_RequestPermission(activity, MyPermissions.RecordAudioPermission, microphone_allow_code);
    }


    public static boolean checkNotificationPermission(Context context) {
        return ContextCompat.checkSelfPermission(context, MyPermissions.NotificationPermission) == PackageManager.PERMISSION_GRANTED;
    }

    public static void requestNotificationPermission(Activity activity) { //if call it from Activity = "this" , Fragment = "getActivity"
//        ActivityCompat.requestPermissions(activity, new String[]{MyPermissions.NotificationPermission}, notification_allow_code);
//        checkRationale_RequestPermission(activity, MyPermissions.NotificationPermission, notification_allow_code);
        showPermissionDialog_RequestPermission(activity, MyPermissions.NotificationPermission, notification_allow_code);
    }


    public static boolean checkSinglePermission(Context context, String permissionName) {
        return ContextCompat.checkSelfPermission(context, permissionName) == PackageManager.PERMISSION_GRANTED;
    }

    public static void requestSinglePermission(Activity activity, String permissionName, int allow_code) { //if call it from Activity = "this" , Fragment = "getActivity"
//        ActivityCompat.requestPermissions(activity, new String[]{permissionName}, allow_code);
//        checkRationale_RequestPermission(activity, permissionName, allow_code);
        showPermissionDialog_RequestPermission(activity, permissionName, allow_code);
    }


    public static boolean checkMultiplePermission(Context context, String[] permissionName) {
        boolean anyPermissionNOFailed = true;
        for (String permission : permissionName) {
            if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                anyPermissionNOFailed = false;
                break;
            }
        }
        return anyPermissionNOFailed;

//        return ContextCompat.checkSelfPermission(context, Arrays.toString(permissionName)) == PackageManager.PERMISSION_GRANTED;
    }

    public static void requestMultiplePermission(Activity activity, String[] permissionName, int allow_code) { //if call it from Activity = "this" , Fragment = "getActivity"
//        ActivityCompat.requestPermissions(activity, permissionName, allow_code);
        checkRationale_RequestMultiplePermission(activity, permissionName, allow_code);
    }


    public static void showPermissionDialog_RequestPermission(Context context, String permissionName, int allow_code) {
        Allow_Permission_Dialog allowPermissionDialog = new Allow_Permission_Dialog(context);
        allowPermissionDialog.show();

        TextView tittle = allowPermissionDialog.findViewById(R.id.txt_tittle);
        TextView ok = allowPermissionDialog.findViewById(R.id.txt_allow);
        TextView cancel = allowPermissionDialog.findViewById(R.id.txt_close);
        ImageView icon = allowPermissionDialog.findViewById(R.id.imageView2);

        String pDisplayName = MyPermissions.getPermissionName(permissionName);
        Drawable pIcon = MyPermissions.getPermissionIcon(context, pDisplayName);

        // Set the formatted text to your TextView
        tittle.setText(Html.fromHtml("Please <b>Allow</b> <b>" + pDisplayName + "</b> permission required by <b>" + context.getString(R.string.app_name) + "</b> to work properly."));
        icon.setImageDrawable(pIcon);

        ok.setOnClickListener(v -> {
            allowPermissionDialog.dismiss();
            if (Pref.getState(permissionName, context)) {
                checkRationale_RequestPermission((Activity) context, permissionName, allow_code);
            } else {
                Pref.setState(true, permissionName, context);
                ActivityCompat.requestPermissions((Activity) context, new String[]{permissionName}, allow_code);
            }
        });

        cancel.setOnClickListener(v -> {
            allowPermissionDialog.dismiss();
        });
    }

    public static void showPermissionDialog_RequestMultiplePermission(Context context, String[] permissionName, int allow_code) {
        Allow_Permission_Dialog allowPermissionDialog = new Allow_Permission_Dialog(context);
        allowPermissionDialog.show();

        TextView tittle = allowPermissionDialog.findViewById(R.id.txt_tittle);
        TextView ok = allowPermissionDialog.findViewById(R.id.txt_allow);
        TextView cancel = allowPermissionDialog.findViewById(R.id.txt_close);

        // Set the formatted text to your TextView
        tittle.setText(Html.fromHtml("Please <b>Allow</b> ALl Permissions required by <b>" + context.getString(R.string.app_name) + "</b> to work properly."));

        ok.setOnClickListener(v -> {
            allowPermissionDialog.dismiss();
            if (Pref.getState(Key.multiple_permission_rationale, context)) {
                checkRationale_RequestMultiplePermission((Activity) context, permissionName, allow_code);
            } else {
                Pref.setState(true, Key.multiple_permission_rationale, context);
                ActivityCompat.requestPermissions((Activity) context, permissionName, allow_code);
            }
        });

        cancel.setOnClickListener(v -> {
            allowPermissionDialog.dismiss();
        });
    }

    private static void checkRationale_RequestPermission(Activity activity, String permissionName, int allow_code) {
        if (!ActivityCompat.shouldShowRequestPermissionRationale(activity, permissionName)) {
            LayoutInflater layoutInflater;
            if (!permissionName.equals(MyPermissions.NotificationPermission)) { // first check permission is Notification or not
                BottomSheetDialog dialog;
                View view = activity.getLayoutInflater().inflate(R.layout.bottomsheet_permission_settings, null);
                dialog = new BottomSheetDialog(activity, R.style.AppBottomSheetDialogTheme); // Style here
                dialog.setContentView(view);
                dialog.show();
                TextView allow_settings = dialog.findViewById(R.id.allow_settings);
                allow_settings.setOnClickListener(view1 -> {
                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri = Uri.fromParts("package", activity.getPackageName(), null);
                    intent.setData(uri);
                    activity.startActivity(intent);
                });
                ActivityCompat.requestPermissions(activity, new String[]{permissionName}, allow_code);
            } else { // permission is notification so go direct notification settings
                new Notification_settings_Dialog(activity).show();
            }
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{permissionName}, allow_code);
        }
    }

    private static void checkRationale_RequestMultiplePermission(Activity activity, String[] permissions, int allow_code) {
        boolean rtnl = false;
        for (String permission : permissions) {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
                rtnl = true;
                break;
            }
        }
        if (rtnl) {
            BottomSheetDialog dialog;
            View view = activity.getLayoutInflater().inflate(R.layout.bottomsheet_permission_settings, null);
            dialog = new BottomSheetDialog(activity, R.style.AppBottomSheetDialogTheme); // Style here
            dialog.setContentView(view);
            dialog.show();
            TextView allow_settings = dialog.findViewById(R.id.allow_settings);
            allow_settings.setOnClickListener(view1 -> {
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", activity.getPackageName(), null);
                intent.setData(uri);
                activity.startActivity(intent);
            });
        }
        ActivityCompat.requestPermissions(activity, permissions, allow_code);
    }

}
