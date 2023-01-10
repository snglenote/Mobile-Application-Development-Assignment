package com.PAMA.personalassistantmanagementapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sendMessage extends AppCompatActivity {

    Button btn_send;
    EditText et_contact, et_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        btn_send = (Button)findViewById(R.id.btn_send);
        et_contact = (EditText)findViewById(R.id.et_contact);
        et_message = (EditText)findViewById(R.id.et_message);

        PermissionToConnect();

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = et_contact.getText().toString();
                String message = et_message.getText().toString();

                try{
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(number, null, message, null, null);
                    Toast.makeText(sendMessage.this, "Sent", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(sendMessage.this, "Sending Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void PermissionToConnect(){
        if(ContextCompat.checkSelfPermission(sendMessage.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(sendMessage.this, Manifest.permission.SEND_SMS)){
                ActivityCompat.requestPermissions(sendMessage.this, new String[]{Manifest.permission.SEND_SMS}, 1);
            }else{
                ActivityCompat.requestPermissions(sendMessage.this, new String[]{Manifest.permission.SEND_SMS}, 1);
            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (ContextCompat.checkSelfPermission(sendMessage.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Access", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}