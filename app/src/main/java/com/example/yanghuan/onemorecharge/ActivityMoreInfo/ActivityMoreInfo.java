package com.example.yanghuan.onemorecharge.ActivityMoreInfo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.yanghuan.onemorecharge.R;

/**
 * Created by yanghuan on 2016/7/13.
 */
public class ActivityMoreInfo extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.list_item_activitymore_info);
        ImageButton back_button = (ImageButton) findViewById(R.id.back);
        back_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                onBackPressed();
                break;
            default:
        }
    }
}
