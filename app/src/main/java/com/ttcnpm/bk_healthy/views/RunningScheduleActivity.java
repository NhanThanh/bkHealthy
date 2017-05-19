package com.ttcnpm.bk_healthy.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.ttcnpm.bk_healthy.R;

public class RunningScheduleActivity extends WelcomeActivity implements View.OnClickListener {

    private Button createBtn = null;
    private Button viewBtn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running_schedule);

        //final String[] items = new String[] {"1", "2222", "333"};
        //ArrayAdapter<String> stringList = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);

        createBtn = (Button) findViewById(R.id.create_btn);
        viewBtn = (Button) findViewById(R.id.view_btn);

        createBtn.setOnClickListener(this);
        viewBtn.setOnClickListener(this);


//        ListView listView = (ListView) findViewById(R.id.runningListView);
//        listView.setAdapter(stringList);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(RunningScheduleActivity.this, items[position], Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.create_btn:
                Intent createRoute = new Intent(RunningScheduleActivity.this, CreateRouteActivity.class);
                startActivity(createRoute);
                break;
            case R.id.view_btn:
                break;
        }
    }
}
