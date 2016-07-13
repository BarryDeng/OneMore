package com.example.yanghuan.onemorecharge.Main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import com.example.yanghuan.onemorecharge.R;
/**
 * Created by yanghuan on 2016/7/13.
 */
public class CardAdapter extends BaseAdapter {
/*
    private static final String TAG = "LoaderAdapter";
    private boolean mBusy = false;

    public void setFlagBusy(boolean busy){
        this.mBusy = busy;
    }*/

  /*  private ImageLoader mImageLoader;
    private int Count;
    private String[] urlArrays;*/
    private List<Card> data;
    private Context context;
    private LayoutInflater mInflater;

    public CardAdapter(List<Card> data, Context context) {
        this.data = data;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView = mInflater.inflate(R.layout.list_item_card, null);

            holder = new ViewHolder();
            holder.praise = (ImageView) convertView.findViewById(R.id.praise);
            holder.comment = (ImageView)convertView.findViewById(R.id.comment);
            holder.concern = (ImageView) convertView.findViewById(R.id.concern);
            holder.join = (ImageView) convertView.findViewById(R.id.join);
            holder.header = (com.example.yanghuan.onemorecharge.RoundeImageView) convertView.findViewById(R.id.header);
            holder.album = (com.example.yanghuan.onemorecharge.RoundeImageView) convertView.findViewById(R.id.person_album);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    public static class ViewHolder{
        ImageView praise;
        ImageView comment;
        ImageView concern;
        ImageView join;
        com.example.yanghuan.onemorecharge.RoundeImageView header;
        com.example.yanghuan.onemorecharge.RoundeImageView album;
    }
}
