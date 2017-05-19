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
import com.ttcnpm.bk_healthy.model.cobung;

public class cobungActivity extends WelcomeActivity {
    public static final String EXTRA_COBUNGNO = "cobungNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_has_bottom);
        LinearLayout body_layout = (LinearLayout) findViewById(R.id.body_layout);
        getLayoutInflater().inflate(R.layout.activity_description_bodyweight, body_layout);
        ((TextView) findViewById(R.id.header)).setText("Cơ Bụng");
        super.handleOnClickForFooter();
        WelcomeActivity.activity = this;

        //Get the drink from the intent
        int cobungNo = (Integer)getIntent().getExtras().get(EXTRA_COBUNGNO);
        cobung cobungs = cobung.cobungs[cobungNo];

        //Populate the drink image
        ImageView photo = (ImageView)findViewById(R.id.photo);
        photo.setImageResource(cobungs.getImageResourceId());
        photo.setContentDescription(cobungs.getName());

        //Populate the drink name
        TextView name = (TextView)findViewById(R.id.name);
        name.setText(cobungs.getName());

        //Populate the drink description
        TextView description = (TextView)findViewById(R.id.description);
        description.setText(cobungs.getDescription());
    }
}
