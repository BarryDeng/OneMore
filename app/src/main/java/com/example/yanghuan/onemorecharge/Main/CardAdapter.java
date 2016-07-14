package com.example.yanghuan.onemorecharge.Main;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.example.yanghuan.onemorecharge.ActivityMoreInfo.ActivityMoreInfo;
import com.example.yanghuan.onemorecharge.R;
import com.example.yanghuan.onemorecharge.RoundeImageView;

/**
 * Created by yanghuan on 2016/7/13.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.MyViewHolder>  {

    private List<Drawable> data;
    private final Context context;
    private final LayoutInflater mInflater;

    public CardAdapter(List<Drawable> data, Context context) {
        this.data = data;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(mInflater.inflate(R.layout.list_item_card, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.person_album.setImageDrawable(data.get(position));
        //holder.header.setImageResource(R.drawable.touxiang);
        //holder.person_album.setImageResource(R.drawable.background);
        //holder.imageView4.setImageResource();
        //holder.praise.setImageResource(R.drawable.praise_empty);
        //holder.comment.setImageResource(R.drawable.connent);
        //holder.join.setImageResource(R.drawable.add);
        //holder.user_male.setImageResource(R.drawable.female);
        holder.user_name.setText("lala");
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        RoundeImageView header = null;
        RoundeImageView person_album = null;
        ImageView imageView4 = null;
        ImageView praise = null;
        ImageView concern = null;
        ImageView comment = null;
        ImageView join = null;
        ImageView user_male = null;
        TextView user_name = null;

        MyViewHolder(View view) {
            super(view);
            header = (RoundeImageView)view.findViewById(R.id.header);
            person_album = (RoundeImageView)view.findViewById(R.id.person_album);
            imageView4 = (ImageView)view.findViewById(R.id.imageView4);
            praise = (ImageView)view.findViewById(R.id.praise);
            concern = (ImageView)view.findViewById(R.id.concern);
            comment = (ImageView)view.findViewById(R.id.comment);
            join = (ImageView)view.findViewById(R.id.join);
            user_male = (ImageView)view.findViewById(R.id.user_male);
            user_name = (TextView)view.findViewById(R.id.user_name);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, ActivityMoreInfo.class));
                }
            });
        }
    }

}
