package com.ttcnpm.bk_healthy.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ttcnpm.bk_healthy.R;
import com.ttcnpm.bk_healthy.adapter.FoodAdapter;
import com.ttcnpm.bk_healthy.database.TblFoods;
import com.ttcnpm.bk_healthy.helper.SuperGridview;
import com.ttcnpm.bk_healthy.helper.SuperListview;
import com.ttcnpm.bk_healthy.model.Foods;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FoodActivity extends  WelcomeActivity  {
    private SuperGridview mList;
    private FoodAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_has_bottom);
        LinearLayout body_layout = (LinearLayout) findViewById(R.id.body_layout);
        getLayoutInflater().inflate(R.layout.activity_food, body_layout);
        super.handleOnClickForFooter();
        WelcomeActivity.activity = this;
        Intent i = getIntent();
        String food_type = i.getStringExtra("food_type");
        if (food_type.equals("meats")){
            ((TextView) findViewById(R.id.header)).setText("Thịt");
        }else if (food_type.equals("vegestable")){
            ((TextView) findViewById(R.id.header)).setText("Rau củ quả");
        }else if (food_type.equals("fish")){
            ((TextView) findViewById(R.id.header)).setText("Cá");
        }else if (food_type.equals("drink")){
            ((TextView) findViewById(R.id.header)).setText("Đồ uống");
        }
        ArrayList<String> lst = new ArrayList<String>();
        mAdapter = new FoodAdapter(this, lst);
        try {
            getDataSelect(food_type);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mList = (SuperGridview) findViewById(R.id.list);
        mList.setAdapter(mAdapter);
        mList.setEnabled(false);

        if(mAdapter.getCount() <= 0){
            ((TextView) findViewById(R.id.list_view_empty_message)).setText("There are no data.");
            findViewById(R.id.list_view_empty_message).setVisibility(View.VISIBLE);
        }
    }

    public void getDataSelect(String type) throws JSONException {
        Foods foods = new Foods(WelcomeActivity.activity);
        JSONArray arr_foods = foods.getFoodByKey(type, TblFoods.FOOD_TYPE);
        mAdapter.data.clear();

        for (int i = 0; i < arr_foods.length(); i++) {
            JSONObject food = arr_foods.getJSONObject(i);
            mAdapter.data.add(food.toString());
        }
        mAdapter.notifyDataSetChanged();
    }

}
