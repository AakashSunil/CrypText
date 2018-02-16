/**
 *
 * Application to Encrypt the text messages.
 *
 * Inclusion of Deciphering of the text by retrieving the last messages automatically from the messages application of the device
 * In the updation stage.....updation includes involvement of different ciphers to do the main idea of the activity
 *
 * Created by Aakash Sunil
 *
*/
package com.example.aakash.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * First Interface of the Application
 */
public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.Button000);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next(v);
            }
        });
    }

    /**
     *
     * Options Menu to select the Encrypt or Decrypt of Text
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        EditText opt1 = findViewById(R.id.edit);
        switch(item.getItemId())
        {
            case R.id.Option1:
                opt1.setText("Caesar - Encrypt");
                return true;
            case R.id.Option2:
                opt1.setText("Caesar - Decrypt");
                return true;
/*            case R.id.Option3:
                opt1.setText("PlayFair - Encrypt");
                return true;
            case R.id.Option4:
                opt1.setText("PlayFair - Decrypt");
                return true;*/
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     *
     * Intent to move to next stage of Application
     *
     * @param v
     */
    public void next(View v)
    {
        EditText opt1 = findViewById(R.id.edit);
        String ch = opt1.getText().toString();
        if(ch.equals("Caesar - Encrypt"))
        {
            Intent intent = new Intent(this,Generate_Cipher.class);
            startActivity(intent);
        }
        if(ch.equals("Caesar - Decrypt"))
        {
            Intent intent = new Intent(this,Decipher.class);
            startActivity(intent);
        }
        if(ch.equals("PlayFair - Encrypt"))
        {
            Intent intent = new Intent(this,PlayFairIntermediateCipher.class);
            startActivity(intent);
        }
        if(ch.equals("PlayFair - Decrypt"))
        {
            Intent intent = new Intent(this,PlayFairIntermediateDecipher.class);
            startActivity(intent);
        }
    }
}
