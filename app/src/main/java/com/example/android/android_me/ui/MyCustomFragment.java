package com.example.android.android_me.ui;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Smartec on 3/25/2018.
 */

@SuppressLint("NewApi")
public class MyCustomFragment extends Fragment {


    public static final String LISTIMAGE = "list_image";
    public static final String INDEXNUMBER = "index_number";
    private List<Integer> listImage;
    private int indexNumber;

    public void setListImage(List<Integer> listImage) {
        this.listImage = listImage;
    }

    public void setIndexNumber(int indexNumber) {
        this.indexNumber = indexNumber;
    }

    public MyCustomFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            listImage = savedInstanceState.getIntegerArrayList(LISTIMAGE);
            indexNumber = savedInstanceState.getInt(INDEXNUMBER);
        }
        View rootView = inflater.inflate(R.layout.fragment_part, container, false);
        final ImageView imageView = (ImageView) rootView.findViewById(R.id.fragment_part_id);
        imageView.setImageResource(listImage.get(indexNumber));
        if (listImage != null) {
            imageView.setImageResource(listImage.get(indexNumber));
        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (indexNumber < listImage.size() - 1) {
                    indexNumber++;
                } else {
                    indexNumber = 0;
                }
                imageView.setImageResource(listImage.get(indexNumber));
            }
        });
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putIntegerArrayList(LISTIMAGE, (ArrayList<Integer>) listImage);
        outState.putInt(INDEXNUMBER, indexNumber);
    }
}
