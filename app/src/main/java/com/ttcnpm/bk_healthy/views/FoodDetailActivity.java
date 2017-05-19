package com.ttcnpm.bk_healthy.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ttcnpm.bk_healthy.R;
import com.ttcnpm.bk_healthy.database.TblFoods;
import com.ttcnpm.bk_healthy.model.Foods;

import org.json.JSONException;
import org.json.JSONObject;

public class FoodDetailActivity extends WelcomeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_has_bottom);
        LinearLayout body_layout = (LinearLayout) findViewById(R.id.body_layout);
        getLayoutInflater().inflate(R.layout.activity_food_detail, body_layout);
        Intent i = getIntent();
        String header = i.getStringExtra("name");
        String id = i.getStringExtra("id");
        ((TextView) findViewById(R.id.header)).setText(header.toUpperCase());
        super.handleOnClickForFooter();
        JSONObject food = new JSONObject();
        try {
            food = new Foods(WelcomeActivity.activity).getFoodById(id);
            ((TextView) findViewById(R.id.name)).setText(food.getString(TblFoods.NAME));
            ((TextView) findViewById(R.id.desctiption)).setText(food.getString(TblFoods.DESCRIPTION));
            ((TextView) findViewById(R.id.calo)).setText(food.getString(TblFoods.CALORIES));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
