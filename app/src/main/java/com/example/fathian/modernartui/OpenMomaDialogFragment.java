package com.example.fathian.modernartui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class OpenMomaDialogFragment extends DialogFragment {

    static private final String URL = "http://www.moma.org";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Chain together various setter methods to set the dialog characteristics
        builder.setTitle(R.string.dialog_title);
        builder.setMessage(R.string.dialog_message);
        // Get the AlertDialog from create()
        builder.setPositiveButton(R.string.visit_moma, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //open MoMA website
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(URL));
                startActivity(intent);
            }
        })
            .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    OpenMomaDialogFragment.this.getDialog().cancel();
                }
            });
        return builder.create();
    }

}
