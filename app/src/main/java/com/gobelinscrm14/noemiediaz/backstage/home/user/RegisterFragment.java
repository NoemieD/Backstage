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
public class RegisterFragment extends Fragment {

    private RegisterListener mListener;

    @Bind(R.id.registerPseudo) TextView mRegisterPseudo;
    @Bind(R.id.registerEmail) TextView mRegisterEmail;
    @Bind(R.id.registerPassword) TextView mRegisterPassword;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //context -> activity
        try{
            mListener = (RegisterListener) context;
        } catch (ClassCastException exception){
            throw new ClassCastException(context.toString()
                    + "must implement LoginFragment.LoginListener");
        }
    }

    public interface RegisterListener{
        void onRegisterClicked(CharSequence registerEmail, CharSequence registerPassword);
    }

    @OnClick(R.id.registerButton)
    public void onClick(View v){
        mListener.onRegisterClicked(mRegisterEmail.getText(), mRegisterPassword.getText());
    }


}
