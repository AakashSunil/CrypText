/**
 *
 * Decryption of last text message received on the device
 */

package com.example.aakash.androidproject;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Decipher extends AppCompatActivity {

    EditText et,et1;
    Button btn,btn1;
    String msgData="";

    /**
     *
     * On starting this stage.....retrieve the last message before hand
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decipher);
        Cursor cursor = getContentResolver().query(Uri.parse("content://sms/inbox"), new String[] {"body"}, null ,null, "date desc limit 1"); //if you change the 1 to 2 you´ll get the last 2 sms...
        cursor.moveToFirst();

        do{

            for(int idx=0;idx<cursor.getColumnCount();idx++)
            {
                msgData += cursor.getString(idx);

            }
        }while(cursor.moveToNext());

        et = findViewById(R.id.Edit1);
        et1 = findViewById(R.id.Edit2);
        et.setText(msgData);
        btn = findViewById(R.id.Button);
        btn1 = findViewById(R.id.Button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CaesarDecrypt(v);
            }
        });
    }

    /**
     * Decryption
     * @param v
     */
    public void CaesarDecrypt(View v)
    {
        char arr[];
        String plainText =new String(msgData);
        plainText = plainText.toLowerCase();
        int length = plainText.length();
        int i,j,k;
        int[] c = new int[100];
        int[] cl = new int[100];
        char[] e = new char[length];
        char[] cipherText;
        for (i = 0; i < plainText.length(); i++ ) {
            c[i] = plainText.charAt(i) + 97;
            if (c[i] == 129)
                cl[i] = 129;
            else if(c[i]==188)
                cl[i]=188;
            else {
                if ((c[i] + 3) > 122)
                    cl[i] = (c[i] + 3 - 122) % 26;
                else
                    cl[i] = (c[i] + 3) % 26;
                e[i] = (char) (cl[i] + 97);
            }
            if(cl[i]==129)
                e[i]=' ';
            if(cl[i]==188)
                e[i]='\n';
        }
        et1.setText(e,0,length);
    }
}
