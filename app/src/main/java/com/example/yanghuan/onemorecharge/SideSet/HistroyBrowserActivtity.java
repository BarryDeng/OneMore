package com.example.yanghuan.onemorecharge.SideSet;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.yanghuan.onemorecharge.R;
/**
 * Created by yanghuan on 2016/7/13.
 */
public class HistroyBrowserActivtity extends Activity{
    private String[] data = { "您好", "参加我们的活动吗？", "Orange", "Watermelon",
            "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango","Mango" ,"Mango" ,"Mango"  };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_layout);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                HistroyBrowserActivtity.this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.history_listview);
        listView.setAdapter(adapter);
    }
}
