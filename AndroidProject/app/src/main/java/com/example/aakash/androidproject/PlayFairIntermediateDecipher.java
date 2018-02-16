package com.example.aakash.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class PlayFairIntermediateDecipher extends AppCompatActivity {

    Button btn;
    EditText et;
    RadioGroup rg;
    RadioButton rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_fair_intermediate_decipher);
        btn=findViewById(R.id.Button000);
        et=findViewById(R.id.edit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next(v);
            }
        });
    }
    public void next(View v)
    {
        Intent intent = new Intent(PlayFairIntermediateDecipher.this,PlayFair_Decipher.class);

        //Retrieving fromEditText
        String key = et.getText().toString();
        int selected;

        //Finding RadioGroup
        rg = findViewById(R.id.Radio);

        //Getting Selected Radio Button Value
        selected = rg.getCheckedRadioButtonId();
        rb = findViewById(selected);
        String choice = (String)rb.getText();

        //Bundle Intent for multiple data transfer
        Bundle b = new Bundle();
        b.putString("Key",key);
        b.putString("letter",choice);
        intent.putExtras(b);
        startActivity(intent);

    }
}
