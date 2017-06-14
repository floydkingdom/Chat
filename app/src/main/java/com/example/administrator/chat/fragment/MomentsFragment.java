package com.example.administrator.chat.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.chat.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MomentsFragment extends Fragment {

    public static MomentsFragment newInstance(){
        return new MomentsFragment();
    }

    public MomentsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.layout_moments, container, false);
    }

}
