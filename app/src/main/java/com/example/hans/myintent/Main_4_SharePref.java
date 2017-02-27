package com.example.hans.myintent;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main_4_SharePref extends Activity { /// extends AppCompatActivity {


    EditText usernameInput;
    EditText passwordInput;
    Button button_Save;
    Button button_Display;
    TextView textView_Main4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_4);


        usernameInput = (EditText) findViewById(R.id.id_textIn_username);
        passwordInput = (EditText) findViewById(R.id.id_textIn_password);
        textView_Main4 = (TextView) findViewById(R.id.idtexview_main4);

    }

    public void onClicksaveInfo(View view) {
        ;

        SharedPreferences sharedPref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("username", usernameInput.getText().toString());
        editor.putString("password", passwordInput.getText().toString());
        editor.apply();

        Toast.makeText(this, "save", Toast.LENGTH_LONG).show();
    }


   public void onClick_DisplayInfo(View view) {

        SharedPreferences sharedPref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);

        String name = sharedPref.getString("username", "");
        String pw = sharedPref.getString("password", "");


        Toast.makeText(this, "   display ", Toast.LENGTH_LONG).show();
        Toast.makeText(this, "   display " + pw, Toast.LENGTH_LONG).show();
        textView_Main4.setText(name + " " + pw);
    }


}
