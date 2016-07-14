package com.example.yanghuan.onemorecharge.Personal;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.yanghuan.onemorecharge.R;

public class ParticipatePlans extends AppCompatActivity {

    private String[] data = { "黄山", "三国杀", "星巴克", "足球赛", "周杰伦演唱会" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participate_plans);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                ParticipatePlans.this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.par_activity);
        listView.setAdapter(adapter);
    }

}
