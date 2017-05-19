package com.ttcnpm.bk_healthy.adapter;

import android.content.Context;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ttcnpm.bk_healthy.R;
import com.ttcnpm.bk_healthy.database.TblFoods;
import com.ttcnpm.bk_healthy.views.FoodDetailActivity;
import com.ttcnpm.bk_healthy.views.WelcomeActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;

import static android.provider.CalendarContract.CalendarCache.URI;

public class FoodAdapter extends BaseAdapter {

    public Context context;
    public ArrayList<String> data;
    private static LayoutInflater inflater = null;

    public FoodAdapter(Context context, ArrayList<String> data) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi = convertView;
        if (vi == null) {
            vi = inflater.inflate(R.layout.row_food, null);
        }

        try {
            JSONObject food =  new JSONObject(data.get(position));

            ImageView imageView = (ImageView) vi.findViewById(R.id.food_img);
            if (food.getString(TblFoods.FOOD_ID).equals("1")){
                imageView.setImageResource(R.drawable.meat_1);
            }else{
                imageView.setImageResource(R.drawable.meat_2);
            }
            ((TextView) vi.findViewById(R.id.name)).setText(food.getString(TblFoods.NAME));
            vi.findViewById(R.id.row_food).setOnClickListener(clickRow(position));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return vi;
    }

    public View.OnClickListener clickRow(final int position){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject food = null;
                try {
                    food = new JSONObject(data.get(position));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(WelcomeActivity.activity, FoodDetailActivity.class);
                try {
                    intent.putExtra("name", food.getString(TblFoods.NAME));
                    intent.putExtra("id", food.getString(TblFoods.FOOD_ID));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                WelcomeActivity.activity.startActivity(intent);
            }
        };
    }
}
