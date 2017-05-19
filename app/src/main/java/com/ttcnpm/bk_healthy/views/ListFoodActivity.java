package com.ttcnpm.bk_healthy.views;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ttcnpm.bk_healthy.R;
import com.ttcnpm.bk_healthy.adapter.HomeAdapter;
import com.ttcnpm.bk_healthy.adapter.ListFoodAdapter;
import com.ttcnpm.bk_healthy.helper.SuperGridview;

import java.util.ArrayList;

public class ListFoodActivity extends WelcomeActivity {
    private SuperGridview list;
    private ListFoodAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_has_bottom);
        LinearLayout body_layout = (LinearLayout) findViewById(R.id.body_layout);
        getLayoutInflater().inflate(R.layout.activity_list_food, body_layout);
        ((TextView) findViewById(R.id.header)).setText("Danh sách thức ăn");
        super.handleOnClickForFooter();
        WelcomeActivity.activity = this;
        ArrayList<String> lst = new ArrayList<String>();
        adapter = new ListFoodAdapter(this, lst);
        list = (SuperGridview) findViewById(R.id.list);
        adapter.data.add("{\"menu_image\": \"1\", \"menu_name\": \"Thịt\"}");
        adapter.data.add("{\"menu_image\": \"2\", \"menu_name\": \"Rau củ quả\"}");
        adapter.data.add("{\"menu_image\": \"3\", \"menu_name\": \"Cá\"}");
        adapter.data.add("{\"menu_image\": \"4\", \"menu_name\": \"Đồ uống\"}");

        list.setAdapter(adapter);
        list.setEnabled(false);
    }
}
