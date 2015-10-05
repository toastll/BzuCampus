package cn.edu.bzu.bzucampus.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.edu.bzu.bzucampus.R;


/**
 * Created by monster on 2015/9/13.
 */
public class LifeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_lifenews,container,false);
        return view;
    }
}
