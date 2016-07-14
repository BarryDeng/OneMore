package com.example.yanghuan.onemorecharge.ActivityMoreInfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yanghuan.onemorecharge.R;

/**
 * Created by yanghuan on 2016/7/13.
 */

public class ActivityMoreInfo extends Activity implements View.OnClickListener{

    TextView charge_view;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.list_item_activitymore_info);
        ImageButton back_button = (ImageButton) findViewById(R.id.back);
        back_button.setOnClickListener(this);

        ImageView praise_button = (ImageView) findViewById(R.id.praise_view);
        ImageView add_button = (ImageView) findViewById(R.id.join_view);
        ImageView comment = (ImageView) findViewById(R.id.comment_view);

        praise_button.setOnClickListener(this);
        add_button.setOnClickListener(this);
        comment.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                onBackPressed();
                break;
            case R.id.praise_view:
                /*
                仅仅用来展示
                 */
                charge_view = (TextView) findViewById(R.id.user_activity_more_priase_number);
                int data = Integer.parseInt(getResources().getString(R.string.user_activity_more_praise_number));
                ++data;
                charge_view.setText(String.valueOf(data));
                break;
            case R.id.join_view:
                charge_view = (TextView) findViewById(R.id.user_activity_more_join_number);
                int data2 = Integer.parseInt(getResources().getString(R.string.user_activity_more_praise_number));
                ++data2;
                charge_view.setText(String.valueOf(data2));
                break;
            case R.id.comment_view:
                Intent intent = new Intent(ActivityMoreInfo.this, CommentActivity.class);
                startActivity(intent);
            default:
        }
    }
}
