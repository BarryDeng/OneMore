package com.example.yanghuan.onemorecharge.Main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.yanghuan.onemorecharge.R;

/**
 * Created by yanghuan on 2016/7/13.
 */
public class CreatePersonalActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_activity_layout);
        Button pulish_button = (Button)findViewById(R.id.publish);
        pulish_button.setOnClickListener(this);
    }
    public void onClick(View view) {
        startActivity(new Intent(CreatePersonalActivity.this, Main2Activity.class));
    }
}
