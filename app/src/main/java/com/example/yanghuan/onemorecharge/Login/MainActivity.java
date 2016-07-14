package com.example.yanghuan.onemorecharge.Login;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.ActivityManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yanghuan.onemorecharge.Main.Main2Activity;
import com.example.yanghuan.onemorecharge.R;

public class MainActivity extends AppCompatActivity {

    EditText UserNumber;
    EditText UserPassword;
    private LinearLayout splash;
    private LinearLayout login;

    private static final int STOPSPLASH = 0;
    // time in milliseconds
    private static final long SPLASHTIME = 1000;

    private Handler splashHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case STOPSPLASH:
                    SystemClock.sleep(1000);
                    splash.setVisibility(View.GONE);
                    login.setVisibility(View.VISIBLE);
                    break;
            }
            super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        splash = (LinearLayout) findViewById(R.id.splashscreen);
        login = (LinearLayout)findViewById(R.id.loginscreen);
        login.setVisibility(View.INVISIBLE);

        Message msg = new Message();
        msg.what = STOPSPLASH;
        splashHandler.sendMessageDelayed(msg, SPLASHTIME);

        Button reg = (Button)findViewById(R.id.btn_login_regist);
        Button login = (Button) findViewById(R.id.btn_login);
//        ActivityManager activityManager = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
//        Log.d("MEM", Integer.toString(activityManager.getMemoryClass()));
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
