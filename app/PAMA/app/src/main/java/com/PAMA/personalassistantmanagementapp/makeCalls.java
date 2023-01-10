package com.PAMA.personalassistantmanagementapp;

import android.os.Bundle;
import android.widget.EditText;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class makeCalls extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    public static final int MULTIPLE_PERMISSIONS  = 101;

    EditText number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_calls);
        number =(EditText)findViewById(R.id.mobnum);

        //asl for runtime permission
        checkPermissions();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MULTIPLE_PERMISSIONS:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    //Call on Button click
    public void dialCall(View view){
        String num = number.getText().toString();
        if(num!=null && !num.equals("")){
            String noToDial = "tel:"+num;
            Uri number = Uri.parse(noToDial);
            Intent callIntent = new Intent(Intent.ACTION_CALL, number);
            if(checkPermissions()){
                startActivity(callIntent);
            }
        }
        else{
            Toast.makeText(this,"Please enter number",Toast.LENGTH_SHORT).show();
        }

    }

    // For runtime Permission
    private  boolean checkPermissions() {
        int result;
        String[] permissions= new String[]{
                Manifest.permission.CALL_PHONE};

        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String p:permissions) {
            result = ContextCompat.checkSelfPermission(this,p);
            if (result != PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG,"Ask Permissions : "+p);
                listPermissionsNeeded.add(p);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]),MULTIPLE_PERMISSIONS );
            return false;
        }
        return true;
    }
}