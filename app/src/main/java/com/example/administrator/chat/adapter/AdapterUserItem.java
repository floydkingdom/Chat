package com.example.administrator.chat.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.chat.R;
import com.example.administrator.chat.utils.UserItemMsg;

import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */

public class AdapterUserItem extends RecyclerView.Adapter<AdapterUserItem.BaseViewHolder> {

    private Context context;
    private List<UserItemMsg> userItemMsgList;

    public AdapterUserItem(Context context, List<UserItemMsg> userItemMsgList) {
        this.context = context;
        this.userItemMsgList = userItemMsgList;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new BaseViewHolder(v);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.userIcon.setImageResource(userItemMsgList.get(position).getIconId());
        holder.userName.setText(userItemMsgList.get(position).getUserName());
        holder.sign.setText(userItemMsgList.get(position).getSign());
    }

    @Override
    public int getItemCount() {
        return userItemMsgList.size();
    }

    class BaseViewHolder extends RecyclerView.ViewHolder{

        private ImageView userIcon;
        private TextView userName;
        private TextView sign;

        public BaseViewHolder(final View itemView) {
            super(itemView);
            userIcon = (ImageView) itemView.findViewById(R.id.iv_item_user_icon);
            userName = (TextView) itemView.findViewById(R.id.tv_item_username);
            sign = (TextView) itemView.findViewById(R.id.tv_item_sign);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,userName.getText().toString(),Toast.LENGTH_SHORT).show();
                }
            });


        }
    }
}
