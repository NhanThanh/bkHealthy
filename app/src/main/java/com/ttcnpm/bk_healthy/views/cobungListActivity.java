package com.ttcnpm.bk_healthy.views;

/**
 * Created by Huynh Hong Hien on 4/25/2017.
 */

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
import com.ttcnpm.bk_healthy.model.cobung;

public class cobungListActivity extends WelcomeActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_has_bottom);
        LinearLayout body_layout = (LinearLayout) findViewById(R.id.body_layout);
        getLayoutInflater().inflate(R.layout.activity_bodyweight, body_layout);
        ((TextView) findViewById(R.id.header)).setText("Cơ Bụng");
        super.handleOnClickForFooter();
        WelcomeActivity.activity = this;

        ((ImageView) findViewById(R.id.logo)).setImageResource(R.drawable.co_bung);

        ListView listDrinks = (ListView) findViewById(R.id.list);
        ArrayAdapter<cobung> listAdapter = new ArrayAdapter<cobung>(this,
                android.R.layout.simple_list_item_1,
                cobung.cobungs);
        listDrinks.setAdapter(listAdapter);
        listDrinks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intent = new Intent(cobungListActivity.this, cobungActivity.class);
                intent.putExtra(cobungActivity.EXTRA_COBUNGNO, (int) id);
                startActivity(intent);
            }
        });
    }
}
