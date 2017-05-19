package com.ttcnpm.bk_healthy.helper;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import com.ttcnpm.bk_healthy.R;

public class MyCustomProgressDialog extends ProgressDialog {
    private AnimationDrawable animation;

    public static ProgressDialog ctor(Context context) {
        MyCustomProgressDialog dialog = new MyCustomProgressDialog(context);
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
        return dialog;
    }

    public MyCustomProgressDialog(Context context) {
        super(context);
    }

    public MyCustomProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_progress_dialog);
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }
}
