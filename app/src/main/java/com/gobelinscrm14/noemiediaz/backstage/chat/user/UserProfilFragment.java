package com.gobelinscrm14.noemiediaz.backstage.chat.user;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.util.Log;

import com.gobelinscrm14.noemiediaz.backstage.Authentification;
import com.gobelinscrm14.noemiediaz.backstage.R;
import com.gobelinscrm14.noemiediaz.backstage.User;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserProfilFragment extends Fragment {

    private static final String TAG = "userProfilFragment";

    @Bind(R.id.userPseudo) TextView mUserPseudo;
    @Bind(R.id.userEmail) TextView mUserMail;


    public UserProfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_profil, container, false);
        ButterKnife.bind(this, view);

        Log.d(TAG, "CREATE");

        TextView pseudoDisplay = (TextView) view.findViewById(R.id.userPseudo);
        TextView emailDisplay = (TextView) view.findViewById(R.id.userEmail);

        User user = Authentification.getInstance().getUser();

        pseudoDisplay.setText(user.getPseudo());
        emailDisplay.setText(user.getEmail());
        return view;
    }


}
