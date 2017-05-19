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

/**
 * Created by Huynh Hong Hien on 4/25/2017.
 */

public class thanduoiListActivity extends WelcomeActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_has_bottom);
        LinearLayout body_layout = (LinearLayout) findViewById(R.id.body_layout);
        getLayoutInflater().inflate(R.layout.activity_bodyweight, body_layout);
        ((TextView) findViewById(R.id.header)).setText("Thân dưới");
        super.handleOnClickForFooter();
        WelcomeActivity.activity = this;

        ((ImageView) findViewById(R.id.logo)).setImageResource(R.drawable.than_duoi);

        ListView lists = (ListView) findViewById(R.id.list);
        ArrayAdapter<thanduoi> listAdapter = new ArrayAdapter<thanduoi>(this,
                android.R.layout.simple_list_item_1,
                thanduoi.thanduois);
        lists.setAdapter(listAdapter);
        lists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intent = new Intent(thanduoiListActivity.this, thanduoiActivity.class);
                intent.putExtra(thanduoiActivity.EXTRA_THANDUOINO, (int) id);
                startActivity(intent);
            }
        });
    }
}
