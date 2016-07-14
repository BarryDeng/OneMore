package com.example.yanghuan.onemorecharge.ActivityMoreInfo;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yanghuan.onemorecharge.R;
import com.example.yanghuan.onemorecharge.RoundeImageView;

import java.util.List;

/**
 * Created by yanghuan on 2016/7/14.
 */
public class CommentCardAdapter extends RecyclerView.Adapter<CommentCardAdapter.MyViewHolder>{

        private List<Drawable> data;
        private final Context context;
        private final LayoutInflater mInflater;

        public CommentCardAdapter(List<Drawable> data, Context context) {
            this.data = data;
            this.context = context;
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(mInflater.inflate(R.layout.see_comment_card, parent, false));
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
       /*     holder.person_album.setImageDrawable(data.get(position));*/
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
            ImageView tag_photo = null;
            TextView user_name = null;
            TextView comment = null;
            TextView praise_number = null;
            TextView time_date = null;

            MyViewHolder(View view) {
                super(view);
                header = (RoundeImageView)view.findViewById(R.id.com_head);
                user_name = (TextView)view.findViewById(R.id.com_name);
                tag_photo = (ImageView) view.findViewById(R.id.tag_photo);
                comment = (TextView) view.findViewById(R.id.comment_return);
                praise_number = (TextView)view.findViewById(R.id.priase_number);
                time_date = (TextView) view.findViewById(R.id.com_time);
            }
        }

}
