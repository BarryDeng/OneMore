package com.example.yanghuan.onemorecharge.Personal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import com.example.yanghuan.onemorecharge.R;
/**
 * Created by yanghuan on 2016/7/13.
 */
public class PersonalActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.personal_layout);

        Button edit_button = (Button)findViewById(R.id.change_personnal_message);
        edit_button.setOnClickListener(this);

        ImageButton return_button = (ImageButton) findViewById(R.id.return_button);
        return_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.change_personnal_message:
                startActivity(new Intent(PersonalActivity.this, ChangeUsersInfo.class));
                break;
            case R.id.return_button:
                super.onBackPressed();
                break;
            default:

        }
    }
}
