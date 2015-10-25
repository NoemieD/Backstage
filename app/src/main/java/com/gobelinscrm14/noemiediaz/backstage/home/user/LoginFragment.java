package com.gobelinscrm14.noemiediaz.backstage.home.user;


import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gobelinscrm14.noemiediaz.backstage.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private LoginListener mListener;
    @Bind(R.id.loginEmail) TextView mLoginEmail;
    @Bind(R.id.loginButton) TextView mLoginbutton;
    @Bind(R.id.loginPassword) TextView mLoginPassword;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //context -> activity
        try{
            mListener = (LoginListener) context;
        } catch (ClassCastException exception){
            throw new ClassCastException(context.toString()
                    + "must implement LoginFragment.LoginListener");
        }
    }

    public interface LoginListener{
        void onLoginClicked(CharSequence loginEmail, CharSequence loginPassword);
    }

    @OnClick(R.id.loginButton)
    public void onClick(View v){
        mLoginbutton.setEnabled(false);
        mListener.onLoginClicked(mLoginEmail.getText(), mLoginPassword.getText());
    }


}
