package com.example.administrator.chat.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.chat.R;
import com.example.administrator.chat.adapter.AdapterUserItem;
import com.example.administrator.chat.utils.UserItemMsg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatsFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private AdapterUserItem adapterUserItem;
    private Context context;
    private List<UserItemMsg> userItemMsgList = new ArrayList<>();

    public static ChatsFragment newInstance(){
        return new ChatsFragment();
    }

    public ChatsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_chats, container, false);
        initViews();
        return view;
    }

    private void initViews() {
        context = getContext();
        recyclerView = (RecyclerView) view.findViewById(R.id.chats_recycler_view);

        ItemTouchHelper.Callback callback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP|ItemTouchHelper.DOWN,ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                int fromPosition = viewHolder.getAdapterPosition();
                int toPosition = target.getAdapterPosition();
                if (fromPosition < toPosition){
                    for (int i = fromPosition; i < toPosition; i++){
                        Collections.swap(userItemMsgList,i,i+1);
                    }
                } else {
                    for (int i = fromPosition; i > toPosition; i--){
                        Collections.swap(userItemMsgList,i,i-1);
                    }
                }
                adapterUserItem.notifyItemMoved(fromPosition,toPosition);
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                userItemMsgList.remove(position);
                adapterUserItem.notifyItemRemoved(position);
            }
        };

        loadData();

        adapterUserItem = new AdapterUserItem(context,userItemMsgList);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapterUserItem);
    }

    private void loadData() {
        for (int i = 0; i < 20; i++){
            UserItemMsg userItemMsg = new UserItemMsg();
            userItemMsg.setIconId(R.drawable.avastertony);
            userItemMsg.setUserName("tsz");
            userItemMsg.setSign("消灭人类暴政，世界属于三体");
            userItemMsgList.add(userItemMsg);
        }
    }

}
