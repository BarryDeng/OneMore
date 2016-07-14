package com.example.yanghuan.onemorecharge.Login;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.yanghuan.onemorecharge.Main.Main2Activity;
import com.example.yanghuan.onemorecharge.R;

public class MainActivity extends AppCompatActivity {

    EditText UserNumber;
    EditText UserPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button reg = (Button)findViewById(R.id.btn_login_regist);
        Button login = (Button) findViewById(R.id.btn_login);
        ActivityManager activityManager = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
        Log.d("MEM", Integer.toString(activityManager.getMemoryClass()));
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*if() 判断*/
                startActivity( new Intent(MainActivity.this, Main2Activity.class));
            }
        });
       /* Button button = (Button)findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PersonalActivity.class));
            }
        });*/
        /*CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox.isChecked()){

                }
            }
        });*/  //if is checked, we should save the user's password and number
        /*Button CheckButton_Image = (Button) findViewById(R.id.xinlang_check);
        CheckButton_Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/ //if is checked, we should turn into the third login page
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
