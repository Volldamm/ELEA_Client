package com.android.elea.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.DialogFragment;

import com.android.elea.activities.MainMenuActivity;
import com.android.elea.activities.SearchResultListActivity;
import com.android.elea.activities.login.RegisterActivity;

/**
 * Created by Borja on 22/05/2015.
 */
public class MessageDialog extends DialogFragment {


    private String title,text;

    public static MessageDialog newInstance(String title, String text,Integer tagID) {
        MessageDialog frag = new MessageDialog();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("text", text);
        args.putInt("tagID", tagID);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        String title = getArguments().getString("title");
        String text = getArguments().getString("text");
        final Integer tagID  = getArguments().getInt("tagID");

        builder.setMessage(text)
                .setTitle(title)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (getActivity() instanceof SearchResultListActivity && tagID.compareTo(NumericConstants.NO_RESULTS_FRAGMENT_ID)==0) {
                            try {
                                ((SearchResultListActivity)getActivity()).goToMainMenu();
                            } catch (Exception e) {
                                new EleaException(e);
                            }
                        }else if (getActivity() instanceof RegisterActivity && tagID.compareTo(NumericConstants.REGISTER_OK_FRAGMENT_ID)==0) {
                            try {
                                ((RegisterActivity)getActivity()).goToLogin();
                            } catch (Exception e) {
                                new EleaException(e);
                            }
                        }
                    }
                });

        return builder.create();
    }
}