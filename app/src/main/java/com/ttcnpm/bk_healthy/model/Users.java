package com.ttcnpm.bk_healthy.model;

import android.content.ContentValues;
import android.content.Context;

import com.ttcnpm.bk_healthy.database.TblUsers;
import com.ttcnpm.bk_healthy.helper.MySQLiteHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Users{
    private MySQLiteHelper db;
    public ContentValues user;
    public Context context;

    public Users(Context context){
        db = new MySQLiteHelper(context);
        user = new ContentValues();
        user.put(TblUsers.USER_ID, "");
        user.put(TblUsers.USERNAME, "");
        user.put(TblUsers.FIRST_NAME, "");
        user.put(TblUsers.LAST_NAME, "");
        user.put(TblUsers.PASSWORD, "");
    };

    public Users(Context context, JSONObject params){
        try{
            db = new MySQLiteHelper(context);
            user = new ContentValues();
            user.put(TblUsers.USER_ID, params.getString(TblUsers.USER_ID));
            user.put(TblUsers.USERNAME, params.getString(TblUsers.USERNAME));
            user.put(TblUsers.FIRST_NAME, params.getString(TblUsers.FIRST_NAME));
            user.put(TblUsers.LAST_NAME, params.getString(TblUsers.LAST_NAME));
            user.put(TblUsers.PASSWORD, params.getString(TblUsers.PASSWORD));
        }catch (Exception e){

        }
    };

    public boolean saveUser(){
        if(db.selectByKey(TblUsers.TABLE_NAME, TblUsers.USER_ID, user.getAsString(TblUsers.USER_ID)).length() > 0){
            return db.updateParams(TblUsers.TABLE_NAME, user, TblUsers.USER_ID);
        }else{
            return db.postParams(TblUsers.TABLE_NAME, user);
        }
    }

    public boolean deleteUser(){
        return db.deleteParams(TblUsers.TABLE_NAME, user, TblUsers.USER_ID);
    }

    public boolean deleteAllUsers(){
        return db.deleteAllParams(TblUsers.TABLE_NAME);
    }

    public JSONObject getUserById(String id) throws JSONException {
        JSONArray users = db.selectByKey(TblUsers.TABLE_NAME, TblUsers.USER_ID, id);
        if(users.length() > 0){
            return users.getJSONObject(0);
        }
        return null;
    }

    public JSONObject getUserByKey(String key, String field_name) throws JSONException {
        JSONArray users = db.selectByKey(TblUsers.TABLE_NAME, field_name, key);

        if(users.length() > 0){
            return users.getJSONObject(0);
        }
        return null;
    }

    public JSONObject getUsersByIds(String ids){
        return db.selectUsersByIds(TblUsers.TABLE_NAME, TblUsers.USER_ID, ids);
    }

    public JSONArray getAllUsers(){
        return db.selectAll(TblUsers.TABLE_NAME);
    }
}
