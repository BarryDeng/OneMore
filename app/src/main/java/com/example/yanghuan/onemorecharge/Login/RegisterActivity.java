package com.example.yanghuan.onemorecharge.Login;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yanghuan.onemorecharge.R;

/**
 * Created by BarryGates on 2016/7/8.
 */

public class RegisterActivity extends AppCompatActivity {

    EditText first_password;
    EditText  check_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        Button CheckRegister = (Button) findViewById(R.id.check);
        first_password = (EditText) findViewById(R.id.UserPassword);
        check_password = (EditText)findViewById(R.id.check_password);
        CheckRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(first_password.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "输入密码为空,请重新输入", Toast.LENGTH_SHORT).show();
                else if(first_password.getText().toString().equals(check_password.getText().toString()))
                    startActivity( new Intent(RegisterActivity.this, MainActivity.class));
                else
                    Toast.makeText(getApplicationContext(), "密码不一致,请重新输入", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
