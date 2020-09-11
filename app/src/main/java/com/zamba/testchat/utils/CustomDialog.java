package com.zamba.testchat.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import android.text.Html;
import android.view.Window;
import android.widget.ProgressBar;

import com.zamba.testchat.R;

public class CustomDialog extends ProgressDialog {

    public CustomDialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setIndeterminate(true);

        String meeage = context.getResources().getString(R.string.dailog_message);

        // setMessage("Please wait...");
        setMessage(Html.fromHtml(meeage));

        //  setContentView(R.layout.custom_dialog);

        Drawable drawable = new ProgressBar(context).getIndeterminateDrawable().mutate();
        drawable.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimary),
                PorterDuff.Mode.SRC_IN);
        setIndeterminateDrawable(drawable);

    }
}