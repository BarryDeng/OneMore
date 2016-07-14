package com.example.yanghuan.onemorecharge.Main;


import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;
import com.example.yanghuan.onemorecharge.ActivityMoreInfo.*;
import  com.example.yanghuan.onemorecharge.SideSet.InformationActivity;
import  com.example.yanghuan.onemorecharge.Personal.PersonalActivity;
import  com.example.yanghuan.onemorecharge.R;
import  com.example.yanghuan.onemorecharge.SideSet.SetActivity;
import com.twotoasters.jazzylistview.effects.TiltEffect;
import com.twotoasters.jazzylistview.recyclerview.JazzyRecyclerViewScrollListener;
import com.example.yanghuan.onemorecharge.SideSet.ShowSortActivity;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener
         {

    private List<Card> data = new ArrayList<Card>();
    //test string
    private RecyclerView mRView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main2);

        //initData();
        mRView = (RecyclerView)findViewById(R.id.main_recycler_view);
        mRView.setLayoutManager(new LinearLayoutManager(this));
        JazzyRecyclerViewScrollListener listener = new JazzyRecyclerViewScrollListener();
        mRView.setOnScrollListener(listener);
        listener.setTransitionEffect(new TiltEffect());
        int spacingInPixel = getResources().getDimensionPixelSize(R.dimen.space);
        mRView.addItemDecoration(new SpaceItemDecoration(spacingInPixel));

        AsyncTask<List<Card>, Integer, List<Drawable>> task = new AsyncTask<List<Card>, Integer, List<Drawable>>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(List<Drawable> data) {
                mRView.setAdapter(new CardAdapter(data, Main2Activity.this));
            }

            @Override
            protected List<Drawable> doInBackground(List<Card>... lists) {
                List<Drawable> imageList = new ArrayList<>();
                for(int i=0;i<10;i++){
                    Card card = new Card("some", "2016", "good", Main2Activity.this);
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

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        监听测菜单头像点击行为
         */
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View navHeaderView = navigationView.inflateHeaderView(R.layout.nav_header_main2);
        ImageView headIv = (ImageView) navHeaderView.findViewById(R.id.head_view);
        headIv.setOnClickListener(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        ImageView addActivity = (ImageView) findViewById(R.id.addActivity);
        addActivity.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.string.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Intent intent;

        int id = item.getItemId();
        if (id == R.id.nav_board_game) {
            // Handle the camera action
            intent = new Intent(Main2Activity.this, ShowSortActivity.class);
            intent.putExtra("data", R.string.play);
            startActivity(intent);
        } else if (id == R.id.nav_dining) {
            intent = new Intent(Main2Activity.this, ShowSortActivity.class);
            intent.putExtra("data", R.string.eating);
            startActivity(intent);
        } else if (id == R.id.nav_message) {
            startActivity(new Intent(Main2Activity.this, InformationActivity.class));
        } else if (id == R.id.nav_movie) {
            intent = new Intent(Main2Activity.this, ShowSortActivity.class);
            intent.putExtra("data", R.string.movie);
            startActivity(intent);
        }else if (id == R.id.nav_set) {
            startActivity(new Intent(Main2Activity.this, SetActivity.class));
        }else if (id == R.id.nav_sport) {
            intent = new Intent(Main2Activity.this, ShowSortActivity.class);
            intent.putExtra("data", R.string.sport);
            startActivity(intent);
        }else if (id == R.id.nav_travel) {
            intent = new Intent(Main2Activity.this, ShowSortActivity.class);
            intent.putExtra("data", R.string.trvel);
            startActivity(intent);
        }else if (id == R.id.nav_sing) {
            intent = new Intent(Main2Activity.this, ShowSortActivity.class);
            intent.putExtra("data", R.string.sing);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.head_view:
                startActivity(new Intent(Main2Activity.this, PersonalActivity.class));
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.addActivity:
                startActivity(new Intent(Main2Activity.this, CreatePersonalActivity.class));
                break;
            default:
        }
    }

    public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public SpaceItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            if (parent.getChildPosition(view) != 0) {
                outRect.top = space;
            }
        }
    }
}
