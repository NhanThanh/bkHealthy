package com.ttcnpm.bk_healthy.views;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ttcnpm.bk_healthy.R;
import com.ttcnpm.bk_healthy.model.thanduoi;

/**
 * Created by Huynh Hong Hien on 4/25/2017.
 */

public class thanduoiActivity extends WelcomeActivity {
    public static final String EXTRA_THANDUOINO = "thanduoiNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_has_bottom);
        LinearLayout body_layout = (LinearLayout) findViewById(R.id.body_layout);
        getLayoutInflater().inflate(R.layout.activity_description_bodyweight, body_layout);
        ((TextView) findViewById(R.id.header)).setText("Thân dưới");
        super.handleOnClickForFooter();
        WelcomeActivity.activity = this;

        //Get the drink from the intent
        int thanduoiNo = (Integer)getIntent().getExtras().get(EXTRA_THANDUOINO);
        thanduoi thanduois = thanduoi.thanduois[thanduoiNo];

        //Populate the drink image
        ImageView photo = (ImageView)findViewById(R.id.photo);
        photo.setImageResource(thanduois.getImageResourceId());
        photo.setContentDescription(thanduois.getName());

        //Populate the drink name
        TextView name = (TextView)findViewById(R.id.name);
        name.setText(thanduois.getName());

        //Populate the drink description
        TextView description = (TextView)findViewById(R.id.description);
        description.setText(thanduois.getDescription());
    }
}
