package com.example.aakash.androidproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PlayFair_Decipher extends AppCompatActivity {

    EditText et,et1;
    Button btn,btn1;
    String key,letter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_fair__decipher);
        et = findViewById(R.id.Edit1);
        et1 = findViewById(R.id.Edit2);
        btn = findViewById(R.id.Button);
        btn1 = findViewById(R.id.Button1);
        Bundle b = new Bundle();
        key = b.getString("Key");
        letter = b.getString("letter");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PlayFairDecrypt(v);
            }
        });
    }
    public void PlayFairDecrypt(View v)
    {

    }
}
