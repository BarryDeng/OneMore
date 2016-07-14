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
        // holder.title_name.setText("");
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
        ImageView person_album = null;
        ImageView tag_photo = null;
        TextView user_name = null;
        TextView title_name = null;
        TextView tag_name = null;

        MyViewHolder(View view) {
            super(view);
            header = (RoundeImageView)view.findViewById(R.id.header);
            person_album = (ImageView)view.findViewById(R.id.person_album);
            user_name = (TextView)view.findViewById(R.id.user_name);
            tag_photo = (ImageView) view.findViewById(R.id.tag_photo);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, ActivityMoreInfo.class));
                }
            });
        }
    }

}
