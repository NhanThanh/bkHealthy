package com.ttcnpm.bk_healthy.views;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.ttcnpm.bk_healthy.R;
import com.ttcnpm.bk_healthy.model.thanduoi;
import com.ttcnpm.bk_healthy.model.thantren;

/**
 * Created by Huynh Hong Hien on 4/25/2017.
 */

public class thantrenListActivity extends WelcomeActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_has_bottom);
        LinearLayout body_layout = (LinearLayout) findViewById(R.id.body_layout);
        getLayoutInflater().inflate(R.layout.activity_bodyweight, body_layout);
        ((TextView) findViewById(R.id.header)).setText("Thân trên");
        super.handleOnClickForFooter();
        WelcomeActivity.activity = this;

        ((ImageView) findViewById(R.id.logo)).setImageResource(R.drawable.than_tren);

        ListView lists = (ListView) findViewById(R.id.list);
        ArrayAdapter<thantren> listAdapter = new ArrayAdapter<thantren>(this,
                android.R.layout.simple_list_item_1,
                thantren.thantrens);
        lists.setAdapter(listAdapter);
        lists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intent = new Intent(thantrenListActivity.this, thanduoiActivity.class);
                intent.putExtra(thanduoiActivity.EXTRA_THANDUOINO, (int) id);
                startActivity(intent);
            }
        });
    }

}
