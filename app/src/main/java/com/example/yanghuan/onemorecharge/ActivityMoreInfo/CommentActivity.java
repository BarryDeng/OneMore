package com.example.yanghuan.onemorecharge.ActivityMoreInfo;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.yanghuan.onemorecharge.Main.Card;
import com.example.yanghuan.onemorecharge.Main.CardAdapter;
import com.example.yanghuan.onemorecharge.R;
import com.twotoasters.jazzylistview.effects.TiltEffect;
import com.twotoasters.jazzylistview.recyclerview.JazzyRecyclerViewScrollListener;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanghuan on 2016/7/14.
 */
public class CommentActivity extends AppCompatActivity
        implements View.OnClickListener{
    private List<CommentCard> data = new ArrayList<CommentCard>();
    private RecyclerView mRView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.see_comment);

        mRView = (RecyclerView)findViewById(R.id.comment);
        mRView.setLayoutManager(new LinearLayoutManager(this));
        JazzyRecyclerViewScrollListener listener = new JazzyRecyclerViewScrollListener();
        mRView.setOnScrollListener(listener);
        listener.setTransitionEffect(new TiltEffect());

        AsyncTask<List<CommentCard>, Integer, List<Drawable>> task = new AsyncTask<List<CommentCard>, Integer, List<Drawable>>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(List<Drawable> data) {
                mRView.setAdapter(new CommentCardAdapter(data, CommentActivity.this));
            }

            @Override
            protected List<Drawable> doInBackground(List<CommentCard>... lists) {
                List<Drawable> imageList = new ArrayList<>();
                for(int i=0;i<10;i++){
                    CommentCard card = new CommentCard("some", "2016", "good", CommentActivity.this);
                    String url = card.getURL();
                    try {
                        URL mUrl=new URL(url);
                        Drawable mDrawable=Drawable.createFromStream(mUrl.openStream(), "src");
                        imageList.add(mDrawable);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return imageList;
            }
        };
        task.execute(data);

        ImageView back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
            onBackPressed();
             finish();
    }

}
