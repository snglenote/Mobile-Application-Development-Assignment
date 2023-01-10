package com.PAMA.personalassistantmanagementapp;

import com.PAMA.personalassistantmanagementapp.DAO.DBHelper;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import android.database.Cursor;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText email , password;
    Button btnSubmit;
    TextView createAcc;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Boolean e = false, p = false;
        setContentView(R.layout.activity_login);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        email = findViewById(R.id.text_email);
        password = findViewById(R.id.text_pass);
        btnSubmit = findViewById(R.id.btnSubmit_login);
        dbHelper = new DBHelper(this);
        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String emailCheck = email.getText().toString();
                String passCheck = password.getText().toString();
                Cursor  cursor = dbHelper.getData();
                if(cursor.getCount() == 0){
                    Toast.makeText(LoginActivity.this,"No entries Exists",Toast.LENGTH_LONG).show();
                }
                if (loginCheck(cursor, emailCheck, passCheck)) {
                    Intent intent = new Intent(LoginActivity.this, MainMenu.class);
                    intent.putExtra("email", emailCheck);
                    email.setText("");
                    password.setText("");
                    startActivity(intent);
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setCancelable(true);
                    builder.setTitle("Incorrect email or password");
                    builder.setMessage("Please try again");
                    builder.show();
                }
                dbHelper.close();
            }
        });

        createAcc = findViewById(R.id.createAcc);
        createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUp.class);
                startActivity(intent);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent demo = new Intent(LoginActivity.this, MainMenu.class);
                startActivity(demo);
            }
        });
    }
    public static boolean loginCheck(Cursor cursor,String emailCheck,String passCheck) {
        while (cursor.moveToNext()){
            if (cursor.getString(0).equals(emailCheck)) {
                if (cursor.getString(2).equals(passCheck)) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}