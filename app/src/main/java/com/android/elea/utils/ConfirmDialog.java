package com.android.elea.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.DialogFragment;
import android.util.Log;

import com.android.elea.R;
import com.android.elea.activities.MainMenuActivity;
import com.android.elea.activities.SearchResultListActivity;

/**
 * Created by Borja on 22/05/2015.
 */
public class ConfirmDialog extends DialogFragment {


    public static ConfirmDialog newInstance(String title, String text,Integer tagID) {
        ConfirmDialog frag = new ConfirmDialog();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("text", text);
        args.putInt("tagID",tagID);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        try {
            String title = getArguments().getString("title");
            String text = getArguments().getString("text");
            final Integer tagID  = getArguments().getInt("tagID");

            builder.setMessage(text)
                    .setTitle(title)
                    .setPositiveButton(getResources().getString(R.string.common_accept), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {


                            if (tagID.compareTo(NumericConstants.LOGOUT_FRAGMENT_ID)==0) {
                                try {
                                    Log.i("Dialogos", "Confirmacion Logout Aceptada.");
                                    ((MainMenuActivity)CacheManager.getMainMenuActivity()).logout();

                                } catch (Exception e) {
                                    new EleaException(e);
                                }
                            }else if (getActivity() instanceof MainMenuActivity && tagID.compareTo(NumericConstants.EXIT_APP_FRAGMENT_ID)==0) {
                                try {
                                    Log.i("Dialogos", "Confirmacion Salir APP Aceptada.");
                                    ((MainMenuActivity)CacheManager.getMainMenuActivity()).exitApplicationAction();
                                } catch (Exception e) {
                                    new EleaException(e);
                                }
                            }else if (getActivity() instanceof SearchResultListActivity && tagID.compareTo(NumericConstants.DELETE_JOB_CONFIRM_FRAGMENT_ID)==0) {
                                try {
                                    ((SearchResultListActivity)getActivity()).getAdapter().deleteJob();
                                } catch (Exception e) {
                                    new EleaException(e);
                                }
                            }
                        }
                    })
                    .setNegativeButton(getResources().getString(R.string.common_cancel), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Log.i("Dialogos", "Confirmacion Salir APP Cancelada.");
                            dialog.cancel();
                        }
                    });
        } catch (Exception e) {
            new EleaException(e);
        }
        return builder.create();
    }
}
