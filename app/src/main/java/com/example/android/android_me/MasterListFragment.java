package com.example.android.android_me;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;

import com.example.android.android_me.data.AndroidImageAssets;
import com.example.android.android_me.ui.MasterListAdapter;

/**
 * Created by Smartec on 3/26/2018.
 */

public class MasterListFragment extends Fragment {
    public MasterListFragment() {
    }

    onItemClick mCallBack;
    public interface onItemClick{
        void onImageClick(int postion);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       View rootView= inflater.inflate(R.layout.fragment_master_list,container,false);
        GridView gridView= (GridView) rootView.findViewById(R.id.image_grid_view);
        MasterListAdapter adapter= null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            adapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());
        }
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mCallBack.onImageClick(i);
            }
        });
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallBack= (onItemClick) context;
        }
        catch (Exception e){
        }

    }
}
