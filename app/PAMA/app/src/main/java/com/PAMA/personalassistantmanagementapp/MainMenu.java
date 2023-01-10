package com.PAMA.personalassistantmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // TextView
        TextView MainMenuTextView = (TextView) findViewById(R.id.MainMenuTextView);
        TextView callTextView = (TextView) findViewById(R.id.callTextView);
        TextView searchTextView = (TextView) findViewById(R.id.searchTextView);
        TextView emailTextView = (TextView) findViewById(R.id.emailTextView);
        TextView settingsTextView = (TextView) findViewById(R.id.settingsTextView);
        TextView musicTextView = (TextView) findViewById(R.id.musicTextView);
        TextView videoTextView = (TextView) findViewById(R.id.videoTextView);
        TextView smsTextView = (TextView) findViewById(R.id.smsTextView);
        TextView cameraTextView = (TextView) findViewById(R.id.cameraTextView);

        // ImageViews
        /*
        * We will be adding onClickListeners on the imageViews
        **/
        ImageView callLogImageView = (ImageView) findViewById(R.id.callLogImageView);
        ImageView searchImageView = (ImageView) findViewById(R.id.searchImageView);
        ImageView settingsImageView = (ImageView) findViewById(R.id.settingsImageView);
        ImageView emailImageView = (ImageView) findViewById(R.id.emailImageView);
        ImageView musicImageView = (ImageView) findViewById(R.id.musicImageView);
        ImageView videoImageView = (ImageView) findViewById(R.id.videoImageView);
        ImageView cameraImageView = (ImageView) findViewById(R.id.cameraImageView);
        ImageView smsImageView = (ImageView) findViewById(R.id.smsImageView);
        ImageView helpImageView = (ImageView) findViewById(R.id.helpImageView);


        // helpImageView
        helpImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainMenu.this, "Help Here", Toast.LENGTH_SHORT).show();
                Intent helpIntent = new Intent(MainMenu.this, helpActivity.class);
                startActivity(helpIntent);
            }
        });

        // SMS
        smsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainMenu.this, "Message", Toast.LENGTH_SHORT).show();
                Intent smsSendIntent = new Intent(MainMenu.this, sendMessage.class);
                startActivity(smsSendIntent);
            }
        });

        // Search
        searchImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainMenu.this, "WebSearch", Toast.LENGTH_SHORT).show();
                Intent webSearchIntent = new Intent(MainMenu.this, webSearch.class);
                startActivity(webSearchIntent);
            }
        });

        // Music
        musicImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainMenu.this, "Music", Toast.LENGTH_SHORT).show();
                Intent musicIntent = new Intent(MainMenu.this, MusicActivity.class);
                startActivity(musicIntent);
            }
        });

        // Settings
        settingsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainMenu.this, "Settings", Toast.LENGTH_SHORT).show();
                Intent settingsIntent = new Intent(MainMenu.this, SettingsActivity.class);
                startActivity(settingsIntent);
            }
        });

        // Calls
        callLogImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainMenu.this, "Make Call", Toast.LENGTH_SHORT).show();
                Intent callsIntent = new Intent(MainMenu.this, makeCalls.class);
                startActivity(callsIntent);
            }
        });

        // Email
        emailImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainMenu.this, "Send Email", Toast.LENGTH_SHORT).show();
                Intent intentEmail = new Intent(MainMenu.this, SendEmail.class);
                startActivity(intentEmail);
            }
        });

        // Camera for pictures
        cameraImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainMenu.this, "Take Picture", Toast.LENGTH_SHORT).show();
                Intent intentCamera = new Intent(MainMenu.this, Camera.class);
                startActivity(intentCamera);
            }
        });
    }
}