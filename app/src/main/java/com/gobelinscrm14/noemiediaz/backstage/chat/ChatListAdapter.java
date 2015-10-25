package com.gobelinscrm14.noemiediaz.backstage.chat;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.Query;
import com.gobelinscrm14.noemiediaz.backstage.R;

public class ChatListAdapter extends FirebaseListAdapter<Chat> {

    private String mPseudo;
    private int mColor;
    private int otherColor;

    public ChatListAdapter(Query ref, Activity activity, int layout, String mPseudo, int Color) {
        super(ref, Chat.class, layout, activity);
        this.mPseudo = mPseudo;
        this.mColor = Color;
    }


    @Override
    protected void populateView(View v, Chat model) {
        // Map a Chat object to an entry in our listview
        String author = model.getAuthor();
        TextView authorText = (TextView) v.findViewById(R.id.author);
        authorText.setText(author + ": ");
        // If the message was sent by this user, color it differently
        if (author != null && author.equals(mPseudo)) {
            authorText.setTextColor(mColor);
        } else {
            authorText.setTextColor(Color.MAGENTA);
        }
        ((TextView) v.findViewById(R.id.message)).setText(model.getMessage());

    }
}
