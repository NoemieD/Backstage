package com.gobelinscrm14.noemiediaz.backstage.home;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gobelinscrm14.noemiediaz.backstage.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class InitialHomeFragment extends Fragment {


    private static final String TAG = "initialHomeFragment";

    private InitialHomeListener mListener;

    @Bind(R.id.buttonChoiceRegister) Button buttonRegister;

    public InitialHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_initial_home, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //context -> activity
        try{
            mListener = (InitialHomeListener) context;
        } catch (ClassCastException exception){
            throw new ClassCastException(context.toString()
                    + "must implement LoginFragment.LoginListener");
        }
    }

    public interface InitialHomeListener{
        void onRegisterChoiceClicked();
        void onLoginChoiceClick();
    }

    @OnClick(R.id.buttonChoiceRegister)
    public void onRegisterChoiceClicked(View v){
        mListener.onRegisterChoiceClicked();
    }

    @OnClick(R.id.buttonChoiceLogin)
    public void onLoginChoiceClick(View v){
        mListener.onLoginChoiceClick();
    }


}
