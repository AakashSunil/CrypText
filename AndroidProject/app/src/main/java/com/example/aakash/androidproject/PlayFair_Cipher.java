package com.example.aakash.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PlayFair_Cipher extends AppCompatActivity {

    EditText et,et1;
    Button btn,btn1;
    String key,letter;
    char a[];
    char matrix[][];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_fair__cipher);
        btn = findViewById(R.id.Button);
        btn1 = findViewById(R.id.Button1);
        et = findViewById(R.id.Edit1);
        et1 = findViewById(R.id.Edit2);
        Bundle b = new Bundle();
        key = b.getString("Key");
        letter = b.getString("letter");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                playfair(v);
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        sendSMS(v);
                    }
                });
            }
        });
    }
    public void playfair(View v)
    {
        String plain = et.getText().toString();
    }

    public void sendSMS(View v)
    {
        String cipher = et1.getText().toString();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.putExtra("sms_body", cipher);
        intent.setType("vnd.android-dir/mms-sms");
        startActivity(intent);
    }
}
