package com.example.yanghuan.onemorecharge.SideSet;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.example.yanghuan.onemorecharge.R;

/**
 * Created by yanghuan on 2016/7/14.
 */
public class SortOfActivity extends Activity implements View.OnClickListener{

    ImageView sport_click;
    ImageView travel_click;
    ImageView sing_click;
    ImageView eating_click;
    ImageView play_click;
    ImageView movie_click;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstancState){
        super.onCreate(savedInstancState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.sort_of_activity_layout);
        sport_click =  (ImageView) findViewById(R.id.sport);
        travel_click = (ImageView) findViewById(R.id.trvel);
        sing_click = (ImageView) findViewById(R.id.sing);
        eating_click = (ImageView) findViewById(R.id.eating);
        play_click = (ImageView) findViewById(R.id.play);
        movie_click = (ImageView) findViewById(R.id.movie);

        sport_click.setOnClickListener(this);
        travel_click.setOnClickListener(this);
        sing_click.setOnClickListener(this);
        eating_click.setOnClickListener(this);
        play_click.setOnClickListener(this);
        movie_click.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sport:
                intent = new Intent(SortOfActivity.this, ShowSortActivity.class);
                intent.putExtra("sport", R.string.sport);
                startActivity(intent);
                break;
            case R.id.trvel:
                intent = new Intent(SortOfActivity.this, ShowSortActivity.class);
                intent.putExtra("travel", R.string.trvel);
                startActivity(intent);
                break;
            case R.id.sing:
                intent = new Intent(SortOfActivity.this, ShowSortActivity.class);
                intent.putExtra("sing", R.string.sing);
                startActivity(intent);
                break;

            case R.id.eating:
                intent = new Intent(SortOfActivity.this, ShowSortActivity.class);
                intent.putExtra("eating", R.string.eating);
                startActivity(intent);
                break;
            case R.id.play:
                intent = new Intent(SortOfActivity.this, ShowSortActivity.class);
                intent.putExtra("play", R.string.play);
                startActivity(intent);
                break;
            case R.id.movie:
                intent = new Intent(SortOfActivity.this, ShowSortActivity.class);
                intent.putExtra("movie", R.string.movie);
                startActivity(intent);
                break;
            default:

        }
    }
}
