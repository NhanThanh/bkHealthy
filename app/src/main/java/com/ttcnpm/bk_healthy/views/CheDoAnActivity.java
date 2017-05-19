package com.ttcnpm.bk_healthy.views;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ttcnpm.bk_healthy.R;
import com.ttcnpm.bk_healthy.adapter.CheDoAnAdapter;
import com.ttcnpm.bk_healthy.adapter.ListFoodAdapter;
import com.ttcnpm.bk_healthy.helper.SuperGridview;

import java.util.ArrayList;

public class CheDoAnActivity extends WelcomeActivity {

    private SuperGridview list;
    private CheDoAnAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_has_bottom);
        LinearLayout body_layout = (LinearLayout) findViewById(R.id.body_layout);
        getLayoutInflater().inflate(R.layout.activity_che_do_an, body_layout);
        ((TextView) findViewById(R.id.header)).setText("Chế độ ăn");
        super.handleOnClickForFooter();


        ArrayList<String> lst = new ArrayList<String>();
        adapter = new CheDoAnAdapter(this, lst);
        list = (SuperGridview) findViewById(R.id.list);
        adapter.data.add("{\"menu_image\": \"1\", \"menu_name\": \"Người già\"}");
        adapter.data.add("{\"menu_image\": \"2\", \"menu_name\": \"Trẻ em\"}");
        adapter.data.add("{\"menu_image\": \"3\", \"menu_name\": \"Người bệnh\"}");
        adapter.data.add("{\"menu_image\": \"4\", \"menu_name\": \"Người tập gym\"}");
        adapter.data.add("{\"menu_image\": \"5\", \"menu_name\": \"Người ăn kiêng\"}");
        adapter.data.add("{\"menu_image\": \"6\", \"menu_name\": \"Người tăng cân\"}");

        list.setAdapter(adapter);
        list.setEnabled(false);
    }
}
