package ca.bcit.jihyokim.lab08;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class MyAlertDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        String message = getResources().getString(R.string.has_been_setup);
        String cancelText = getResources().getString(R.string.close);

        builder.setMessage(message).setNegativeButton(cancelText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // user cancelled the dialog
            }
        });
        return builder.create();
    }
}
