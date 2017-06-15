package com.example.administrator.chat.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.chat.R;
import com.example.administrator.chat.utils.ImageMsg;

import java.util.List;

/**
 * Created by Administrator on 2017/6/15.
 */

public class AdapterAvatarRecyclerView extends RecyclerView.Adapter<AdapterAvatarRecyclerView.BaseViewHolder> {

    private Context context;
    private List<ImageMsg> imageMsgList;
    private static int selectedImageBackground = 0;
    private List<LinearLayout> imageContainer;
    private Drawable bgImageDrawable;               //image_container 的背景

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public AdapterAvatarRecyclerView(Context context, List<ImageMsg> imageMsgList) {
        this.context = context;
        this.imageMsgList = imageMsgList;
        selectedImageBackground = 0;
        bgImageDrawable = context.getResources().getDrawable(R.drawable.bgimage,null);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.choose_image,parent,false);

        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.imageView.setImageResource(imageMsgList.get(position).getImageId());
        imageContainer.get(selectedImageBackground).setBackground(bgImageDrawable);
    }

    @Override
    public int getItemCount() {
        return imageMsgList == null ? 0 : imageMsgList.size();
    }

    class BaseViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public BaseViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            LinearLayout layout = (LinearLayout) itemView.findViewById(R.id.image_container);
            imageContainer.add(layout);
        }
    }
}
