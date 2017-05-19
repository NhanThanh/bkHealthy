package com.ttcnpm.bk_healthy.views;

/**
 * Created by Huynh Hong Hien on 4/25/2017.
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ttcnpm.bk_healthy.R;
import com.ttcnpm.bk_healthy.model.thantren;

public class thantrenActivity extends WelcomeActivity{
    public static final String EXTRA_THANTRENNO = "thantrenNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_has_bottom);
        LinearLayout body_layout = (LinearLayout) findViewById(R.id.body_layout);
        getLayoutInflater().inflate(R.layout.activity_description_bodyweight, body_layout);
        ((TextView) findViewById(R.id.header)).setText("Thân trên");
        super.handleOnClickForFooter();
        WelcomeActivity.activity = this;

        int thantrenNo = (Integer)getIntent().getExtras().get(EXTRA_THANTRENNO);
        thantren thantrens = thantren.thantrens[thantrenNo];

        ImageView photo = (ImageView)findViewById(R.id.photo);
        photo.setImageResource(thantrens.getImageResourceId());
        photo.setContentDescription(thantrens.getName());

        TextView name = (TextView)findViewById(R.id.name);
        name.setText(thantrens.getName());

        TextView description = (TextView)findViewById(R.id.description);
        description.setText(thantrens.getDescription());
    }
}
