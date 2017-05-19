package com.ttcnpm.bk_healthy.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ttcnpm.bk_healthy.R;
import com.ttcnpm.bk_healthy.helper.CircularImageView;
import com.ttcnpm.bk_healthy.views.ListFoodActivity;
import com.ttcnpm.bk_healthy.views.CheDoAnActivity;
import com.ttcnpm.bk_healthy.views.MapsActivity;
import com.ttcnpm.bk_healthy.views.RunningScheduleActivity;
import com.ttcnpm.bk_healthy.views.WelcomeActivity;
import com.ttcnpm.bk_healthy.views.bodyweightmainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeAdapter extends BaseAdapter {
    private static LayoutInflater inflater = null;
    public Context context;
    public ArrayList<String> data;

    public HomeAdapter(Context context, ArrayList<String> data) {
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
            vi = inflater.inflate(R.layout.row_home, null);
        }
        try {
            JSONObject json_data = new JSONObject(data.get(position));
            if(json_data.getString("menu_image").equals("1")){
                ((CircularImageView) vi.findViewById(R.id.menu_image)).setImageResource(R.drawable.list_foot);
            }else if(json_data.getString("menu_image").equals("2")){
                ((CircularImageView) vi.findViewById(R.id.menu_image)).setImageResource(R.drawable.che_do_an);
            }else if(json_data.getString("menu_image").equals("3")){
                ((CircularImageView) vi.findViewById(R.id.menu_image)).setImageResource(R.drawable.nguoi_tap_gym);
            }else if(json_data.getString("menu_image").equals("4")){
                ((CircularImageView) vi.findViewById(R.id.menu_image)).setImageResource(R.drawable.chaybo);
            }
            else if(json_data.getString("menu_image").equals("5")){
                ((CircularImageView) vi.findViewById(R.id.menu_image)).setImageResource(R.drawable.running_calendar);
            }
            ((TextView)vi.findViewById(R.id.menu_name)).setText(json_data.getString("menu_name"));
            vi.setOnClickListener(clickMenu(json_data.getString("menu_image")));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return vi;
    }


    public View.OnClickListener clickMenu(final String menu_id){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                switch (menu_id) {
                    case "1":
                        intent = new Intent(WelcomeActivity.activity, ListFoodActivity.class);
                        WelcomeActivity.activity.startActivity(intent);
                        break;
                    case "2":
                        intent = new Intent(WelcomeActivity.activity, CheDoAnActivity.class);
                        WelcomeActivity.activity.startActivity(intent);
                        break;
                    case "3":
                        intent = new Intent(WelcomeActivity.activity, bodyweightmainActivity.class);
                        WelcomeActivity.activity.startActivity(intent);
                        break;
                    case "4":
                        intent = new Intent(WelcomeActivity.activity, MapsActivity.class);
                        WelcomeActivity.activity.startActivity(intent);
                        break;
                    case "5":
                        intent = new Intent(WelcomeActivity.activity, RunningScheduleActivity.class);
                        WelcomeActivity.activity.startActivity(intent);
                        break;
                }
            }
        };
    }
}
