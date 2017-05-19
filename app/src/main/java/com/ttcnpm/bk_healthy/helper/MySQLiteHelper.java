package com.ttcnpm.bk_healthy.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ttcnpm.bk_healthy.database.TblFoods;
import com.ttcnpm.bk_healthy.database.TblUsers;

import org.json.JSONArray;
import org.json.JSONObject;

public class MySQLiteHelper extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "db";
 	private static final int DATABASE_VERSION = 1;
	private SQLiteDatabase db;

	public MySQLiteHelper(Context context) {
	    super(context, DATABASE_NAME, null, DATABASE_VERSION);
	  }

  	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(TblUsers.TABLE_CREATE);
		database.execSQL(TblFoods.TABLE_CREATE);
	}

  	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	    onCreate(db);
	  }

	public boolean postParams(String table, ContentValues params){
		db = getWritableDatabase();
		db.beginTransaction();
		try {
			db.insertOrThrow(table, null, params);
			db.setTransactionSuccessful();
		} catch (Exception e) {
			return false;
		} finally {
			db.endTransaction();
			db.close();
			return true;
		}
	}

	public boolean updateParams(String table, ContentValues params, String field){
		db = getWritableDatabase();
		db.beginTransaction();
		try {
			db.update(table, params, field + "= ?", new String[]{params.getAsString(field)});
			db.setTransactionSuccessful();
		} catch (Exception e) {
			return false;
		} finally {
			db.endTransaction();
			db.close();
			return true;
		}
	}

	public boolean deleteParams(String table, ContentValues params, String field){
		db = getWritableDatabase();
		db.beginTransaction();
		try {
			db.delete(table, field + "= ?", new String[]{params.getAsString(field)});
			db.setTransactionSuccessful();
		} catch (Exception e) {
			return false;
		} finally {
			db.endTransaction();
			db.close();
			return true;
		}
	}

	public boolean deleteByUserIdAndType(String table, String user_id, String field, String type_value, String type_field){
		db = getWritableDatabase();
		db.beginTransaction();
		try {
			db.delete(table, field + "= ? and " + type_field + " = ? ", new String[]{user_id, type_value});
			db.setTransactionSuccessful();
		} catch (Exception e) {
			return false;
		} finally {
			db.endTransaction();
			db.close();
			return true;
		}
	}


	public boolean deleteByUserId(String table, String user_id, String field){
		db = getWritableDatabase();
		db.beginTransaction();
		try {
			db.delete(table, field + "= ?", new String[]{user_id});
			db.setTransactionSuccessful();
		} catch (Exception e) {
			return false;
		} finally {
			db.endTransaction();
			db.close();
			return true;
		}
	}

	public boolean deleteAllParams(String table){
		db = getWritableDatabase();
		db.beginTransaction();
		try {
			db.execSQL("delete from " + table);
			db.setTransactionSuccessful();
		} catch (Exception e) {
			return false;
		} finally {
			db.endTransaction();
			db.close();
			return true;
		}
	}

	public JSONArray selectByKey(String table, String field, String value){
		db = getWritableDatabase();
		Cursor c = null;
		db.beginTransaction();
		try {
			c = db.rawQuery("SELECT * FROM " +table+ " WHERE "+field+"=?", new String[] {value});
			db.setTransactionSuccessful();
		} catch (Exception e) {
			return null;
		} finally {
			db.endTransaction();
			return cur2Json(c);
		}
	}

	public JSONArray selectAll(String table){
		db = getWritableDatabase();
		Cursor c = null;
		db.beginTransaction();
		try {
			c = db.rawQuery("SELECT * FROM " +table, null);
			db.setTransactionSuccessful();
		} catch (Exception e) {
			return null;
		} finally {
			db.endTransaction();
			return cur2Json(c);
		}
	}

	public JSONArray selectAllWithLimitAndConditionsAndOrder(String table, int start, int limit, String condition, String order){
		db = getWritableDatabase();
		Cursor c = null;
		db.beginTransaction();
		try {
			c = db.rawQuery("SELECT * FROM " + table + condition + " ORDER BY " + order + " Limit "+start+", "+limit, null);
			db.setTransactionSuccessful();
		} catch (Exception e) {
			return null;
		} finally {
			db.endTransaction();
			return cur2Json(c);
		}
	}

	public JSONArray selectParamsWithLimitAndOrder(String table, int start, int limit){
		db = getWritableDatabase();
		Cursor c = null;
		db.beginTransaction();
		try {
			c = db.rawQuery("SELECT * FROM " + table + " ORDER BY created_at DESC Limit "+start+", "+limit, null);
			db.setTransactionSuccessful();
		} catch (Exception e) {
			return null;
		} finally {
			db.endTransaction();
			return cur2Json(c);
		}
	}

	public JSONArray selectParamsWithLimitAndOrderByUpdated(String table, int start, int limit){
		db = getWritableDatabase();
		Cursor c = null;
		db.beginTransaction();
		try {
			c = db.rawQuery("SELECT * FROM " + table + " ORDER BY updated_at DESC Limit "+start+", "+limit, null);
			db.setTransactionSuccessful();
		} catch (Exception e) {
			return null;
		} finally {
			db.endTransaction();
			return cur2Json(c);
		}
	}

	public JSONArray selectParamsWithLimitAndConditionsAndOrder(String table, int start, int limit, String condition){
		db = getWritableDatabase();
		Cursor c = null;
		db.beginTransaction();
		try {
			c = db.rawQuery("SELECT * FROM " + table + condition + " ORDER BY created_at DESC Limit "+start+", "+limit, null);
			db.setTransactionSuccessful();
		} catch (Exception e) {
			return null;
		} finally {
			db.endTransaction();
			return cur2Json(c);
		}
	}

	public JSONArray selectParamsWithLimitAndConditionsAndOrderForChatOnly(String table, int start, int limit, String condition){
		db = getWritableDatabase();
		Cursor c = null;
		db.beginTransaction();
		try {
			c = db.rawQuery("SELECT * FROM " + table + condition + " ORDER BY updated_at DESC Limit "+start+", "+limit, null);
			db.setTransactionSuccessful();
		} catch (Exception e) {
			return null;
		} finally {
			db.endTransaction();
			return cur2Json(c);
		}
	}

	public JSONArray selectParamsWithLimitAndConditions(String table, int start, int limit, String condition){
		db = getWritableDatabase();
		Cursor c = null;
		db.beginTransaction();
		try {
			c = db.rawQuery("SELECT * FROM " + table + condition + " Limit "+start+", "+limit, null);
			db.setTransactionSuccessful();
		} catch (Exception e) {
			return null;
		} finally {
			db.endTransaction();
			return cur2Json(c);
		}
	}

	public JSONArray cur2Json(Cursor cursor) {
		JSONArray resultSet = new JSONArray();
		if (cursor.moveToFirst()) {
			do {
				JSONObject rowObject = new JSONObject();
				int totalColumn = cursor.getColumnCount();

				for (int i = 0; i < totalColumn; i++) {
					if (cursor.getColumnName(i) != null) {
						try {
							rowObject.put(cursor.getColumnName(i),
									cursor.getString(i));
						} catch (Exception e) {
						}
					}
				}
				resultSet.put(rowObject);
			} while (cursor.moveToNext());
		}
		cursor.close();
		db.close();
		return resultSet;
	}

	public JSONObject cur2JsonWithKey(Cursor cursor) {
		try{
			JSONObject resultSet = new JSONObject();
			if (cursor.moveToFirst()) {
				do {
					JSONObject rowObject = new JSONObject();
					int totalColumn = cursor.getColumnCount();

					for (int i = 0; i < totalColumn; i++) {
						if (cursor.getColumnName(i) != null) {
							try {
								rowObject.put(cursor.getColumnName(i),
										cursor.getString(i));
							} catch (Exception e) {
							}
						}
					}
					resultSet.put(cursor.getString(cursor.getColumnIndex(TblUsers.USER_ID)),rowObject);
				} while (cursor.moveToNext());
			}
			cursor.close();
			db.close();
			return resultSet;
		}catch (Exception e){
			return null;
		}
	}

	public JSONObject selectUsersByIds(String table, String field, String value){
		db = getWritableDatabase();
		Cursor c = null;
		db.beginTransaction();
		try {
			c = db.rawQuery("SELECT * FROM " +table+ " WHERE "+field+" IN ("+value+")", null);
			db.setTransactionSuccessful();
		} catch (Exception e) {
			return null;
		} finally {
			db.endTransaction();
			return cur2JsonWithKey(c);
		}
	}
}
