package com.jakir.permissions;

import android.Manifest;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;

import com.jakir.permissions.R;

import java.util.HashMap;
import java.util.Map;

public class MyPermissions {
    private static final HashMap<String, String> permissionNameMap = new HashMap<>();
    private static final Map<String, Integer> permissionIconMap = new HashMap<>();
    public static String[] AllPermissions = getAllPermissions();
    public static String[] MediaStoragePermissions = getMediaStoragePermissions();
    public static String getStoragePermissionNameFromApiImage = getMediaStoragePermissionNameFromApiImage();
    public static String getStoragePermissionNameFromApiAudio = getMediaStoragePermissionNameFromApiAudio();
    public static String ContactsPermission = Manifest.permission.READ_CONTACTS;
    public static String CameraPermission = Manifest.permission.CAMERA;
    public static String LocationPermission = Manifest.permission.ACCESS_FINE_LOCATION;
    public static String CalLogPermission = Manifest.permission.READ_CALL_LOG;
    public static String PhonePermission = Manifest.permission.READ_PHONE_STATE;
    public static String SmsPermission = Manifest.permission.READ_SMS;
    public static String RecordAudioPermission = Manifest.permission.RECORD_AUDIO;
    public static String NotificationPermission = Manifest.permission.POST_NOTIFICATIONS;
    public static String SEND_SMS = Manifest.permission.SEND_SMS;
    public static String READ_SMS = Manifest.permission.READ_SMS;
    public static String RECEIVE_SMS = Manifest.permission.RECEIVE_SMS;
    public static String READ_CALL_LOG = Manifest.permission.READ_CALL_LOG;
    public static String PROCESS_OUTGOING_CALLS = Manifest.permission.PROCESS_OUTGOING_CALLS;
    public static String CALL_PHONE = Manifest.permission.CALL_PHONE;
    public static String READ_CONTACTS = Manifest.permission.READ_CONTACTS;
    public static String WRITE_CONTACTS = Manifest.permission.WRITE_CONTACTS;
    public static String READ_PHONE_STATE = Manifest.permission.READ_PHONE_STATE;
    public static String CAMERA = Manifest.permission.CAMERA;
    public static String ACCESS_COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    public static String ACCESS_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    public static String RECORD_AUDIO = Manifest.permission.RECORD_AUDIO;
    public static String WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    public static String READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;
    public static String READ_MEDIA_AUDIO = Manifest.permission.READ_MEDIA_AUDIO;
    public static String READ_MEDIA_IMAGES = Manifest.permission.READ_MEDIA_IMAGES;
    public static String READ_MEDIA_VIDEO = Manifest.permission.READ_MEDIA_VIDEO;
    public static String POST_NOTIFICATIONS = Manifest.permission.POST_NOTIFICATIONS;

    static {
        permissionNameMap.put(Manifest.permission.SEND_SMS, "SMS");
        permissionNameMap.put(Manifest.permission.READ_SMS, "SMS");
        permissionNameMap.put(Manifest.permission.RECEIVE_SMS, "SMS");
        permissionNameMap.put(Manifest.permission.READ_CALL_LOG, "Call Logs");
        permissionNameMap.put(Manifest.permission.PROCESS_OUTGOING_CALLS, "Call Logs");
        permissionNameMap.put(Manifest.permission.CALL_PHONE, "Call Logs");
        permissionNameMap.put(Manifest.permission.READ_CONTACTS, "Contacts");
        permissionNameMap.put(Manifest.permission.WRITE_CONTACTS, "Contacts");
        permissionNameMap.put(Manifest.permission.READ_PHONE_STATE, "Phone");
        permissionNameMap.put(Manifest.permission.CAMERA, "Camera");
        permissionNameMap.put(Manifest.permission.ACCESS_COARSE_LOCATION, "Location");
        permissionNameMap.put(Manifest.permission.ACCESS_FINE_LOCATION, "Location");
        permissionNameMap.put(Manifest.permission.RECORD_AUDIO, "Microphone");
        permissionNameMap.put(Manifest.permission.WRITE_EXTERNAL_STORAGE, "Storage");
        permissionNameMap.put(Manifest.permission.READ_EXTERNAL_STORAGE, "Storage");
        permissionNameMap.put(Manifest.permission.POST_NOTIFICATIONS, "Notifications");
        permissionNameMap.put(Manifest.permission.READ_MEDIA_AUDIO, "Music & Audio");
        permissionNameMap.put(Manifest.permission.READ_MEDIA_IMAGES, "Photos & Videos");
        permissionNameMap.put(Manifest.permission.READ_MEDIA_VIDEO, "Photos & Videos");
    }

    static {
        permissionIconMap.put("SMS", R.drawable.permission_dialog_sms);
        permissionIconMap.put("Call Logs", R.drawable.permission_dialog_cal);
        permissionIconMap.put("Contacts", R.drawable.permission_dialog_on);
        permissionIconMap.put("Phone", R.drawable.permission_dialog_phn);
        permissionIconMap.put("Camera", R.drawable.permission_dialog_cam);
        permissionIconMap.put("Location", R.drawable.permission_dialog_loc);
        permissionIconMap.put("Microphone", R.drawable.permission_dialog_mic);
        permissionIconMap.put("Storage", R.drawable.permission_dialog_img);
        permissionIconMap.put("Notifications", R.drawable.permission_dialog_not);
        permissionIconMap.put("Music & Audio", R.drawable.permission_dialog_mus);
        permissionIconMap.put("Photos & Videos", R.drawable.permission_dialog_img);
    }

    public static void main(String[] args) {
        getPermissionName(Manifest.permission.SEND_SMS);
        getPermissionName(Manifest.permission.READ_SMS);
        getPermissionName(Manifest.permission.RECEIVE_SMS);
        getPermissionName(Manifest.permission.READ_CALL_LOG);
        getPermissionName(Manifest.permission.PROCESS_OUTGOING_CALLS);
        getPermissionName(Manifest.permission.CALL_PHONE);
        getPermissionName(Manifest.permission.READ_CONTACTS);
        getPermissionName(Manifest.permission.WRITE_CONTACTS);
        getPermissionName(Manifest.permission.READ_PHONE_STATE);
        getPermissionName(Manifest.permission.CAMERA);
        getPermissionName(Manifest.permission.ACCESS_COARSE_LOCATION);
        getPermissionName(Manifest.permission.ACCESS_FINE_LOCATION);
        getPermissionName(Manifest.permission.RECORD_AUDIO);
        getPermissionName(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        getPermissionName(Manifest.permission.READ_EXTERNAL_STORAGE);
        getPermissionName(Manifest.permission.POST_NOTIFICATIONS);
        getPermissionName(Manifest.permission.READ_MEDIA_AUDIO);
        getPermissionName(Manifest.permission.READ_MEDIA_IMAGES);
        getPermissionName(Manifest.permission.READ_MEDIA_VIDEO);
    }

    private static String[] getAllPermissions() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            String[] PermissionsOLd = {Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS, Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_CALL_LOG, Manifest.permission.PROCESS_OUTGOING_CALLS, Manifest.permission.CALL_PHONE, Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.CAMERA, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
            return PermissionsOLd;
        } else {
            return new String[]{Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS, Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_CALL_LOG, Manifest.permission.PROCESS_OUTGOING_CALLS, Manifest.permission.CALL_PHONE, Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.CAMERA, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.RECORD_AUDIO, Manifest.permission.POST_NOTIFICATIONS, Manifest.permission.READ_MEDIA_AUDIO, Manifest.permission.READ_MEDIA_IMAGES, Manifest.permission.READ_MEDIA_VIDEO};
        }
    }

    private static String[] getMediaStoragePermissions() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            return new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        } else {
            return new String[]{Manifest.permission.READ_MEDIA_AUDIO, Manifest.permission.READ_MEDIA_IMAGES, Manifest.permission.READ_MEDIA_VIDEO};
        }
    }

    public static String getMediaStoragePermissionNameFromApiImage() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            return Manifest.permission.READ_EXTERNAL_STORAGE;
        } else {
            return Manifest.permission.READ_MEDIA_IMAGES;
        }
    }

    public static String getMediaStoragePermissionNameFromApiAudio() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            return Manifest.permission.READ_EXTERNAL_STORAGE;
        } else {
            return Manifest.permission.READ_MEDIA_AUDIO;
        }
    }


    public static String getPermissionName(String permissionName) {
        String readableName = permissionNameMap.get(permissionName);
        if (readableName != null) {
            return readableName;
        } else {
            return "Unknown";
        }
    }

    public static Drawable getPermissionIcon(Context context, String permissionName) {
        Integer drawableId = permissionIconMap.getOrDefault(permissionName, R.drawable.permission_dialog_img);
        return context.getResources().getDrawable(drawableId, context.getTheme());
    }
}

