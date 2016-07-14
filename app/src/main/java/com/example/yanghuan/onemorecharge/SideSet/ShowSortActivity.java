package com.example.yanghuan.onemorecharge.SideSet;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yanghuan.onemorecharge.ActivityMoreInfo.AcitivityMoreInfo;
import com.example.yanghuan.onemorecharge.Main.Card;
import com.example.yanghuan.onemorecharge.Main.CardAdapter;
import com.example.yanghuan.onemorecharge.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by yanghuan on 2016/7/14.
 */
public class ShowSortActivity extends Activity implements View.OnClickListener/*, AdapterView.OnItemClickListener*/{

    ImageButton return_button;
    private List<Card> data = new ArrayList<Card>();
    ImageView album;
    TextView title;
    int [] mList;

    @Override
    protected void onCreate(Bundle savedInstancState) {
        super.onCreate(savedInstancState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.show_sort_activity);
        album = (ImageView) findViewById(R.id.cover);
        title = (TextView) findViewById(R.id.diff_title);
        Intent intent = getIntent();//取出Sort中的id值，进行替换
        ImageButton return_button = (ImageButton)findViewById(R.id.return_button);
        return_button.setOnClickListener(this);

        /*initData();
        ListView mListView = (ListView)findViewById(R.id.main_listview);
        CardAdapter mAdapter = new CardAdapter(data, this);
        mListView.setAdapter(mAdapter);
        mListView.setFocusable(true);
        mListView.setFocusableInTouchMode(true);
        mListView.setOnItemClickListener(this);*/

        /*
        现在开始判断上一个活动传入的值是什么,动态更改主页图片，达到重用目的
         */

        mList = new int[2];

        if(intent.getIntExtra("data", 1) == R.string.trvel){
            mList[0] = R.string.trvel;
            mList[1] = R.drawable.travel;
            new ShowAsyncTask().execute();
        }else if(intent.getIntExtra("data",1) == R.string.play){
            mList[0] = R.string.play;
            mList[1] = R.drawable.play;
            new ShowAsyncTask().execute();
        }else if(intent.getIntExtra("data", 1) == R.string.sport){
            mList[0] = R.string.sport;
            mList[1] = R.drawable.sport;
            new ShowAsyncTask().execute();
        }else if(intent.getIntExtra("data", 1) == R.string.eating){
            mList[0] = R.string.eating;
            mList[1] = R.drawable.eating;
            new ShowAsyncTask().execute();
        }else if(intent.getIntExtra("data", 1) == R.string.sing){
            mList[0] = R.string.sing;
            mList[1] = R.drawable.sing;
            new ShowAsyncTask().execute();
        }else if(intent.getIntExtra("data", 1) == R.string.movie){
            mList[0] = R.string.movie;
            mList[1] = R.drawable.movie;
            new ShowAsyncTask().execute();
        }
    }

    @Override
    public void onClick(View view) {
        onBackPressed();
        finish();
    }

    /*private void initData() {
        for(int i=0;i<10;i++){
            Card card = new Card("some", "2016", "good");
            data.add(card);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Log.d("Main2Activity", String.valueOf(view.getId()));
        Log.d("Main2Activity", String.valueOf(R.id.header));
        switch (position){
            case 0:
                startActivity(new Intent(ShowSortActivity.this, AcitivityMoreInfo.class));
                break;
            default:
        }
    }*/

    class ShowAsyncTask extends AsyncTask<Void, Integer, Boolean> {

        private  int text_url;
        private  int image_url;
        public ShowAsyncTask(){
            text_url = mList[0];
            image_url = mList[1];
        }

        @Override
        protected Boolean doInBackground(Void... arrayLists) {
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            album.setBackgroundResource(image_url);
            title.setText(text_url);
        }
    }
}
