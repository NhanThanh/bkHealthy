package com.ttcnpm.bk_healthy.views;
/**
 * Created by Huynh Hong Hien on 4/25/2017.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.ttcnpm.bk_healthy.R;

import java.util.ArrayList;
import java.util.Arrays;

public class bodyweightmainActivity extends WelcomeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_has_bottom);
        LinearLayout body_layout = (LinearLayout) findViewById(R.id.body_layout);
        getLayoutInflater().inflate(R.layout.activity_main_bodyweight, body_layout);
        ((TextView) findViewById(R.id.header)).setText("Body Weight");
        super.handleOnClickForFooter();
        WelcomeActivity.activity = this;

        findViewById(R.id.btn_cobung).setOnClickListener(OnClick);
        findViewById(R.id.btn_than_tren).setOnClickListener(OnClick);
        findViewById(R.id.btn_than_duoi).setOnClickListener(OnClick);
    }

    public View.OnClickListener OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;
          switch (v.getId()){
              case R.id.btn_cobung:
                  intent = new Intent(WelcomeActivity.activity, cobungListActivity.class);
                  startActivity(intent);
                  break;
              case R.id.btn_than_tren:
                  intent = new Intent(WelcomeActivity.activity, thantrenListActivity.class);
                  startActivity(intent);
                  break;
              case R.id.btn_than_duoi:
                  intent = new Intent(WelcomeActivity.activity, thanduoiListActivity.class);
                  startActivity(intent);
                  break;
          }
        }
    };
}

