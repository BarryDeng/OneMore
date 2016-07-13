package com.example.yanghuan.onemorecharge.Main;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.yanghuan.onemorecharge.ActivityMoreInfo.AcitivityMoreInfo;
import com.example.yanghuan.onemorecharge.SideSet.HistroyBrowserActivtity;
import  com.example.yanghuan.onemorecharge.SideSet.InformationActivity;
import  com.example.yanghuan.onemorecharge.Personal.PersonalActivity;
import  com.example.yanghuan.onemorecharge.R;
import  com.example.yanghuan.onemorecharge.SideSet.SetActivity;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener,
        AdapterView.OnItemClickListener {

    private List<Card> data = new ArrayList<Card>();
    //test string

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main2);

        initData();
        ListView mListView = (ListView)findViewById(R.id.main_listview);
        CardAdapter mAdapter = new CardAdapter(data, this);
        mListView.setAdapter(mAdapter);
        mListView.setFocusable(true);
        mListView.setFocusableInTouchMode(true);
        mListView.setOnItemClickListener(this);

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

    private void initData() {
        for(int i=0;i<10;i++){
            Card card = new Card("some", "2016", "good");
            data.add(card);
        }
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

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.


        int id = item.getItemId();

        if (id == R.id.nav_board_game) {
            // Handle the camera action
        } else if (id == R.id.nav_dining) {

        } else if (id == R.id.nav_history) {
            startActivity(new Intent(Main2Activity.this, HistroyBrowserActivtity.class));
        }  else if (id == R.id.nav_message) {
            startActivity(new Intent(Main2Activity.this, InformationActivity.class));
        } else if (id == R.id.nav_movie) {

        }else if (id == R.id.nav_set) {
            startActivity(new Intent(Main2Activity.this, SetActivity.class));
        }else if (id == R.id.nav_sport) {

        }else if (id == R.id.nav_travel) {

        }else if (id == R.id.nav_view) {

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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Log.d("Main2Activity", String.valueOf(view.getId()));
        Log.d("Main2Activity", String.valueOf(R.id.header));
        switch (position){
            case 0:
                startActivity(new Intent(Main2Activity.this, AcitivityMoreInfo.class));
                break;
            default:
        }
    }

}
