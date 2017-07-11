package com.milabobo.android.sample.view.canvas;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.milabobo.android.sample.R;

/**
 * Created by yu.tian on 7/11/17.
 * Email mailto:tianyu1@le.com
 */

public class PagerFragment extends Fragment {
    @LayoutRes int practiceLayoutRes;
    static final String LAYOUT_RES = "layout_res";

    public static PagerFragment newInstance(@LayoutRes int resId) {
        PagerFragment fragment = new PagerFragment();
        Bundle args = new Bundle();
        args.putInt(LAYOUT_RES, resId);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.practice_simple, container, false);
        inflater.inflate(practiceLayoutRes, (ViewGroup) view);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            practiceLayoutRes = args.getInt(LAYOUT_RES);
        }
    }


}
