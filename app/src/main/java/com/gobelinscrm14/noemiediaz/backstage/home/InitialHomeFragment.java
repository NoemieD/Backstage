package com.gobelinscrm14.noemiediaz.backstage.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gobelinscrm14.noemiediaz.backstage.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InitialHomeFragment extends Fragment {


    public InitialHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_initial_home, container, false);
    }


}
