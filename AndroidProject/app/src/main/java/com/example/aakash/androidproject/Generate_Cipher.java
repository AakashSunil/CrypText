/**
 *
 * Encryption of text message that can be sent as an SMS
 *
 */

package com.example.aakash.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Generate_Cipher extends AppCompatActivity {

    EditText et,et1;
    Button btn,btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate__cipher);
        btn = findViewById(R.id.Button);
        btn1 = findViewById(R.id.Button1);
        et = findViewById(R.id.Edit1);
        et1 = findViewById(R.id.Edit2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CaesarEncrypt(v);
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        sendSMS(v);
                    }
                });
            }
        });
    }

    /**
     *
     * Encryption
     *
     * @param v
     */
    public void CaesarEncrypt(View v)
    {
        char arr[];
        String plainText = et.getText().toString();
        plainText=plainText.toLowerCase();
        int length = plainText.length();
        int i,j,k;
        int[] c = new int[100];
        int[] cl = new int[100];
        char[] e = new char[length];
        for (i = 0; i < plainText.length(); i++ ) {
            c[i] = plainText.charAt(i) - 97;

                if ((c[i] + 3) > 122)
                    cl[i] = (c[i] + 3 - 122) % 26;
                else
                    cl[i] = (c[i] + 3) % 26;
                e[i] = (char) (cl[i] + 97);
            if(e[i]=='W')
            {
                e[i]=' ';
            }

        }
        et1.setText(e,0,length);

    }

    /**
     * Calling the SMS application Built in the device with the encrypted message
     *
     * @param v
     */
    public void sendSMS(View v)
    {
        String cipher = et1.getText().toString();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.putExtra("sms_body", cipher);
        intent.setType("vnd.android-dir/mms-sms");
        startActivity(intent);
    }
}