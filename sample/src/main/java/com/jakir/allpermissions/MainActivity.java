package com.jakir.allpermissions;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import static com.jakir.permissions.MyPermissionsCheckRequest.All_Permission_Request_Code;
import static com.jakir.permissions.MyPermissionsCheckRequest.calllog_allow_code;
import static com.jakir.permissions.MyPermissionsCheckRequest.camera_allow_code;
import static com.jakir.permissions.MyPermissionsCheckRequest.contacts_allow_code;
import static com.jakir.permissions.MyPermissionsCheckRequest.filestorage_allow_code;
import static com.jakir.permissions.MyPermissionsCheckRequest.location_allow_code;
import static com.jakir.permissions.MyPermissionsCheckRequest.mediastorage_allow_code;
import static com.jakir.permissions.MyPermissionsCheckRequest.microphone_allow_code;
import static com.jakir.permissions.MyPermissionsCheckRequest.notification_allow_code;
import static com.jakir.permissions.MyPermissionsCheckRequest.phone_allow_code;
import static com.jakir.permissions.MyPermissionsCheckRequest.sms_allow_code;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jakir.permissions.MyPermissionsCheckRequest;
import com.jakir.permissions.dialogs.File_Permission_Dialog;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "PermissionsActivity";
    Button btn_grant_all, microphone_allow, sms_allow, phone_allow, calllog_allow, location_allow, camera_allow, contacts_allow, mediaStorage_allow, notification_allow, fileStorage_allow;
    LinearLayout microphone_linear, sms_linear, phone_linear, calllog_linear, location_linear, camera_linear, contacts_linear, storage_linear, notification_linear, files_linear;
    RelativeLayout notification_sec_rltv, files_sec_rltv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.container), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

            microphone_allow = findViewById(R.id.microphone_allow);
            sms_allow = findViewById(R.id.sms_allow);
            phone_allow = findViewById(R.id.phone_allow);
            calllog_allow = findViewById(R.id.calllog_allow);
            location_allow = findViewById(R.id.location_allow);
            camera_allow = findViewById(R.id.camera_allow);
            contacts_allow = findViewById(R.id.contacts_allow);
            mediaStorage_allow = findViewById(R.id.mediastorage_allow);
            notification_allow = findViewById(R.id.notification_allow);
            fileStorage_allow = findViewById(R.id.filestorage_allow);
            btn_grant_all = findViewById(R.id.btn_grant_all);

            microphone_linear = findViewById(R.id.microphone_linear);
            sms_linear = findViewById(R.id.sms_linear);
            phone_linear = findViewById(R.id.phone_linear);
            calllog_linear = findViewById(R.id.calllog_linear);
            location_linear = findViewById(R.id.location_linear);
            camera_linear = findViewById(R.id.camera_linear);
            contacts_linear = findViewById(R.id.contacts_linear);
            storage_linear = findViewById(R.id.storage_linear);
            notification_linear = findViewById(R.id.notification_linear);
            files_linear = findViewById(R.id.files_linear);

            notification_sec_rltv = findViewById(R.id.notification_sec_rltv);
            files_sec_rltv = findViewById(R.id.files_sec_rltv);

            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
                notification_sec_rltv.setVisibility(View.GONE);
            } else {
                notification_sec_rltv.setVisibility(View.VISIBLE);
            }

            microphone_linear.setOnClickListener(v -> {
                microphone_allow.performClick();
            });
            sms_linear.setOnClickListener(v -> {
                sms_allow.performClick();
            });
            phone_linear.setOnClickListener(v -> {
                phone_allow.performClick();
            });
            calllog_linear.setOnClickListener(v -> {
                calllog_allow.performClick();
            });
            location_linear.setOnClickListener(v -> {
                location_allow.performClick();
            });
            camera_linear.setOnClickListener(v -> {
                camera_allow.performClick();
            });
            contacts_linear.setOnClickListener(v -> {
                contacts_allow.performClick();
            });
            storage_linear.setOnClickListener(v -> {
                mediaStorage_allow.performClick();
            });
            notification_linear.setOnClickListener(v -> {
                notification_allow.performClick();
            });
            files_linear.setOnClickListener(v -> {
                fileStorage_allow.performClick();
            });

            microphone_allow.setOnClickListener(v -> {
                microphone_allow_permission();
            });
            sms_allow.setOnClickListener(v -> {
                sms_allow_permission();
            });
            phone_allow.setOnClickListener(v -> {
                phone_allow_permission();
            });
            calllog_allow.setOnClickListener(v -> {
                calllog_allow_permission();
            });
            location_allow.setOnClickListener(v -> {
                location_allow_permission();
            });
            camera_allow.setOnClickListener(v -> {
                camera_allow_permission();
            });
            contacts_allow.setOnClickListener(v -> {
                contacts_allow_permission();
            });
            mediaStorage_allow.setOnClickListener(v -> {
                mediaStorage_allow_permission();
            });
            notification_allow.setOnClickListener(v -> {
                notification_allow_permission();
            });
            fileStorage_allow.setOnClickListener(v -> {
                fileStorage_allow_permission();
            });

            btn_grant_all.setOnClickListener(v -> {
                btn_grant_all_permission();
            });
        }


        private void btn_grant_all_permission() {
            // Request runtime permissions
            MyPermissionsCheckRequest.requestAllPermission(this);
        }

        private void fileStorage_allow_permission() {
            if (!MyPermissionsCheckRequest.checkFileStoragePermission(this)) {
                MyPermissionsCheckRequest.requestFileStoragePermission(this);
            } else {
                changeButtonOption(fileStorage_allow);
            }
        }

        private void mediaStorage_allow_permission() {
            if (!MyPermissionsCheckRequest.checkMediaStoragePermission(this)) {
                MyPermissionsCheckRequest.requestMediaStoragePermission(this);
//            MyPermissionsCheckRequest.showPermissionDialog_RequestMultiplePermission(this, MyPermissions.MediaStoragePermissions, mediastorage_allow_code);
            } else {
                changeButtonOption(mediaStorage_allow);
            }
        }

        private void contacts_allow_permission() {
            if (!MyPermissionsCheckRequest.checkContactsPermission(this)) {
                MyPermissionsCheckRequest.requestContactsPermission(this);
//            MyPermissionsCheckRequest.showPermissionDialog_RequestPermission(this, MyPermissions.ContactsPermission, contacts_allow_code);
            } else {
                changeButtonOption(contacts_allow);
            }
        }

        private void camera_allow_permission() {
            if (!MyPermissionsCheckRequest.checkCameraPermission(this)) {
                MyPermissionsCheckRequest.requestCameraPermission(this);
//            MyPermissionsCheckRequest.showPermissionDialog_RequestPermission(this, MyPermissions.CameraPermission, camera_allow_code);
            } else {
                changeButtonOption(camera_allow);
            }
        }

        private void location_allow_permission() {
            if (!MyPermissionsCheckRequest.checkLocationPermission(this)) {
                MyPermissionsCheckRequest.requestLocationPermission(MainActivity.this);
//            MyPermissionsCheckRequest.showPermissionDialog_RequestPermission(this, MyPermissions.LocationPermission, location_allow_code);
            } else {
                changeButtonOption(location_allow);
            }

        }

        private void calllog_allow_permission() {
            if (!MyPermissionsCheckRequest.checkCallLogPermission(this)) {
                MyPermissionsCheckRequest.requestCallLogPermission(this);
//            MyPermissionsCheckRequest.showPermissionDialog_RequestPermission(this, MyPermissions.CalLogPermission, calllog_allow_code);
            } else {
                changeButtonOption(calllog_allow);
            }

        }

        private void phone_allow_permission() {
            if (!MyPermissionsCheckRequest.checkPhonePermission(this)) {
                MyPermissionsCheckRequest.requestPhonePermission(this);
//            MyPermissionsCheckRequest.showPermissionDialog_RequestPermission(this, MyPermissions.PhonePermission, phone_allow_code);
            } else {
                changeButtonOption(phone_allow);
            }

        }

        private void sms_allow_permission() {
            if (!MyPermissionsCheckRequest.checkSmsPermission(this)) {
                MyPermissionsCheckRequest.requestSmsPermission(this);
//            MyPermissionsCheckRequest.showPermissionDialog_RequestPermission(this, MyPermissions.SmsPermission, sms_allow_code);
            } else {
                changeButtonOption(sms_allow);
            }

        }

        private void microphone_allow_permission() {
            if (!MyPermissionsCheckRequest.checkMicrophonePermission(this)) {
                MyPermissionsCheckRequest.requestMicrophonePermission(this);
//            MyPermissionsCheckRequest.showPermissionDialog_RequestPermission(this, MyPermissions.RecordAudioPermission, microphone_allow_code);
            } else {
                changeButtonOption(microphone_allow);
            }
        }

        private void notification_allow_permission() {
            if (!MyPermissionsCheckRequest.checkNotificationPermission(this)) {
                MyPermissionsCheckRequest.requestNotificationPermission(this);
//            MyPermissionsCheckRequest.showPermissionDialog_RequestPermission(this, MyPermissions.NotificationPermission, notification_allow_code);
            } else {
                changeButtonOption(notification_allow);
            }

        }


        @Override
        protected void onRestart() {
            super.onRestart();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                if (Environment.isExternalStorageManager()) {
                    fileStorage_allow.setTextColor(Color.WHITE);
                    fileStorage_allow.setText("Allowed");
                    fileStorage_allow.setBackgroundResource(R.drawable.bg_allowed_button);
                } else {
                    fileStorage_allow.setTextColor(Color.BLACK);
                    fileStorage_allow.setText("Allow");
                    fileStorage_allow.setBackgroundResource(R.drawable.bg_allow_button);

//                showPermissionDialog();
                }
            }
        }

        @Override
        protected void onStart() {
            super.onStart();
//        checkPermissions();
        }

        private void showPermissionDialog() {
            new File_Permission_Dialog(this).show();
        }


        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            checkPermissions();

/*        if (requestCode == READ_EXTERNAL_STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                goMainDirectoryActivity();
                Toast.makeText(this, "Storage permission accepted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Storage permission denied", Toast.LENGTH_SHORT).show();
            }
        }*/


            if (requestCode == All_Permission_Request_Code) {

            } else if (requestCode == mediastorage_allow_code) {
                changeButtonOption(mediaStorage_allow);
            } else if (requestCode == filestorage_allow_code) {
                changeButtonOption(fileStorage_allow);
            } else if (requestCode == microphone_allow_code) {
                changeButtonOption(microphone_allow);
            } else if (requestCode == sms_allow_code) {
                changeButtonOption(sms_allow);
            } else if (requestCode == calllog_allow_code) {
                changeButtonOption(calllog_allow);
            } else if (requestCode == location_allow_code) {
                changeButtonOption(location_allow);
            } else if (requestCode == camera_allow_code) {
                changeButtonOption(camera_allow);
            } else if (requestCode == contacts_allow_code) {
                changeButtonOption(contacts_allow);
            } else if (requestCode == phone_allow_code) {
                changeButtonOption(phone_allow);
            } else if (requestCode == notification_allow_code) {
                changeButtonOption(notification_allow);
            }


        }

        private void changeButtonOption(Button buttonId) {
            buttonId.setTextColor(Color.WHITE);
            buttonId.setText("Allowed");
            buttonId.setBackgroundResource(R.drawable.bg_allowed_button);
        }

        private void checkPermissions() {
            boolean allPermissionsGranted = true;

            if (MyPermissionsCheckRequest.checkMediaStoragePermission(this)) {
                mediaStorage_allow.setTextColor(Color.WHITE);
                mediaStorage_allow.setText("Allowed");
                mediaStorage_allow.setBackgroundResource(R.drawable.bg_allowed_button);
            } else {
                mediaStorage_allow.setTextColor(Color.BLACK);
                mediaStorage_allow.setText("Allow");
                mediaStorage_allow.setBackgroundResource(R.drawable.bg_allow_button);
                allPermissionsGranted = false;
            }
            if (MyPermissionsCheckRequest.checkFileStoragePermission(this)) {
                fileStorage_allow.setTextColor(Color.WHITE);
                fileStorage_allow.setText("Allowed");
                fileStorage_allow.setBackgroundResource(R.drawable.bg_allowed_button);
            } else {
                fileStorage_allow.setTextColor(Color.BLACK);
                fileStorage_allow.setText("Allow");
                fileStorage_allow.setBackgroundResource(R.drawable.bg_allow_button);
                allPermissionsGranted = false;
            }
            if (MyPermissionsCheckRequest.checkContactsPermission(this)) {
                contacts_allow.setTextColor(Color.WHITE);
                contacts_allow.setText("Allowed");
                contacts_allow.setBackgroundResource(R.drawable.bg_allowed_button);
            } else {
                contacts_allow.setTextColor(Color.BLACK);
                contacts_allow.setText("Allow");
                contacts_allow.setBackgroundResource(R.drawable.bg_allow_button);
                allPermissionsGranted = false;
            }
            if (MyPermissionsCheckRequest.checkCameraPermission(this)) {
                camera_allow.setTextColor(Color.WHITE);
                camera_allow.setText("Allowed");
                camera_allow.setBackgroundResource(R.drawable.bg_allowed_button);
            } else {
                camera_allow.setTextColor(Color.BLACK);
                camera_allow.setText("Allow");
                camera_allow.setBackgroundResource(R.drawable.bg_allow_button);
                allPermissionsGranted = false;
            }
            if (MyPermissionsCheckRequest.checkLocationPermission(this)) {
                location_allow.setTextColor(Color.WHITE);
                location_allow.setText("Allowed");
                location_allow.setBackgroundResource(R.drawable.bg_allowed_button);
            } else {
                location_allow.setTextColor(Color.BLACK);
                location_allow.setText("Allow");
                location_allow.setBackgroundResource(R.drawable.bg_allow_button);
                allPermissionsGranted = false;
            }
            if (MyPermissionsCheckRequest.checkCallLogPermission(this)) {
                calllog_allow.setTextColor(Color.WHITE);
                calllog_allow.setText("Allowed");
                calllog_allow.setBackgroundResource(R.drawable.bg_allowed_button);
            } else {
                calllog_allow.setTextColor(Color.BLACK);
                calllog_allow.setText("Allow");
                calllog_allow.setBackgroundResource(R.drawable.bg_allow_button);
                allPermissionsGranted = false;
            }
            if (MyPermissionsCheckRequest.checkPhonePermission(this)) {
                phone_allow.setTextColor(Color.WHITE);
                phone_allow.setText("Allowed");
                phone_allow.setBackgroundResource(R.drawable.bg_allowed_button);
            } else {
                phone_allow.setTextColor(Color.BLACK);
                phone_allow.setText("Allow");
                phone_allow.setBackgroundResource(R.drawable.bg_allow_button);
                allPermissionsGranted = false;
            }
            if (MyPermissionsCheckRequest.checkSmsPermission(this)) {
                sms_allow.setTextColor(Color.WHITE);
                sms_allow.setText("Allowed");
                sms_allow.setBackgroundResource(R.drawable.bg_allowed_button);
            } else {
                sms_allow.setTextColor(Color.BLACK);
                sms_allow.setText("Allow");
                sms_allow.setBackgroundResource(R.drawable.bg_allow_button);
                allPermissionsGranted = false;
            }
            if (MyPermissionsCheckRequest.checkMicrophonePermission(this)) {
                microphone_allow.setTextColor(Color.WHITE);
                microphone_allow.setText("Allowed");
                microphone_allow.setBackgroundResource(R.drawable.bg_allowed_button);
            } else {
                microphone_allow.setTextColor(Color.BLACK);
                microphone_allow.setText("Allow");
                microphone_allow.setBackgroundResource(R.drawable.bg_allow_button);
                allPermissionsGranted = false;
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                if (MyPermissionsCheckRequest.checkNotificationPermission(this)) {
                    notification_allow.setTextColor(Color.WHITE);
                    notification_allow.setText("Allowed");
                    notification_allow.setBackgroundResource(R.drawable.bg_allowed_button);
                } else {
                    notification_allow.setTextColor(Color.BLACK);
                    notification_allow.setText("Allow");
                    notification_allow.setBackgroundResource(R.drawable.bg_allow_button);
                    allPermissionsGranted = false;
                }
            }

            if (allPermissionsGranted) {
                // Permissions granted, continue with your app logic
                Toast.makeText(this, "All permission are Allowed", Toast.LENGTH_SHORT).show();
            }
        }

    }