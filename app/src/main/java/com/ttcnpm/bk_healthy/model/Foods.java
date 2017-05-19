package com.ttcnpm.bk_healthy.model;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.ttcnpm.bk_healthy.database.TblFoods;
import com.ttcnpm.bk_healthy.database.TblUsers;
import com.ttcnpm.bk_healthy.helper.MySQLiteHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Foods{
    private MySQLiteHelper db;
    public ContentValues food;
    public Context context;

    public Foods(Context context){
        db = new MySQLiteHelper(context);
        food = new ContentValues();
        food.put(TblFoods.FOOD_ID, "");
        food.put(TblFoods.NAME, "");
        food.put(TblFoods.FOOD_TYPE, "");
        food.put(TblFoods.CALORIES, "");
        food.put(TblFoods.DESCRIPTION, "");
    };

    public Foods(Context context, JSONObject params){
        try{
            db = new MySQLiteHelper(context);
            food = new ContentValues();
            food.put(TblFoods.FOOD_ID, params.getString(TblFoods.FOOD_ID));
            food.put(TblFoods.NAME, params.getString(TblFoods.NAME));
            food.put(TblFoods.FOOD_TYPE, params.getString(TblFoods.FOOD_TYPE));
            food.put(TblFoods.CALORIES, params.getString(TblFoods.CALORIES));
            food.put(TblFoods.DESCRIPTION, params.getString(TblFoods.DESCRIPTION));
        }catch (Exception e){

        }
    };

    public boolean saveFoods(){
        if(db.selectByKey(TblFoods.TABLE_NAME, TblFoods.FOOD_ID, food.getAsString(TblFoods.FOOD_ID)).length() > 0){
            return db.updateParams(TblFoods.TABLE_NAME, food, TblFoods.FOOD_ID);
        }else{
            return db.postParams(TblFoods.TABLE_NAME, food);
        }
    }

    public boolean deleteFoods(){
        return db.deleteParams(TblFoods.TABLE_NAME, food, TblFoods.FOOD_ID);
    }

    public boolean deleteAllFoods(){
        return db.deleteAllParams(TblFoods.TABLE_NAME);
    }

    public JSONObject getFoodById(String id) throws JSONException {
        JSONArray foods = db.selectByKey(TblFoods.TABLE_NAME, TblFoods.FOOD_ID, id);
        if(foods.length() > 0){
            return foods.getJSONObject(0);
        }
        return null;
    }

    public JSONArray getFoodByKey(String key, String field_name) throws JSONException {
        JSONArray foods = db.selectByKey(TblFoods.TABLE_NAME, field_name, key);
        return foods;
    }

    public JSONObject getFoodsByIds(String ids){
        return db.selectUsersByIds(TblFoods.TABLE_NAME, TblFoods.FOOD_ID, ids);
    }

    public JSONArray getAllFoods(){
        return db.selectAll(TblFoods.FOOD_ID);
    }
}
