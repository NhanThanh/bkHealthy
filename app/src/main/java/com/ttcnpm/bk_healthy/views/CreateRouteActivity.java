package com.ttcnpm.bk_healthy.views;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ttcnpm.bk_healthy.R;
import com.ttcnpm.bk_healthy.database.RunningContract;
import com.ttcnpm.bk_healthy.helper.RunningDbHelper;

/**
 * Created by anh on 5/5/17.
 */

public class CreateRouteActivity extends Activity {

    private EditText startPoint = null;
    private EditText endingPoint = null;
    private EditText timeToComplete = null;
    private EditText runningDate = null;
    private Button confirmBtn = null;

    private String startPoint_text = null;
    private String endingPoint_text = null;
    private String timeComplete_text = null;
    private String runningDate_text = null;


    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_route);


        startPoint = (EditText) findViewById(R.id.startpoint_edittext);
        endingPoint = (EditText) findViewById(R.id.endingpoint_edittext);
        timeToComplete = (EditText) findViewById(R.id.runningtime_edittext);
        runningDate = (EditText) findViewById(R.id.runningdate_edittext);
        confirmBtn = (Button) findViewById(R.id.confirmroute_button);

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startPoint_text = startPoint.getText().toString().trim();
                endingPoint_text = endingPoint.getText().toString().trim();
                timeComplete_text = timeToComplete.getText().toString().trim();
                runningDate_text = runningDate.getText().toString().trim();
//                JSONObject jsonObject = new JSONObject();
//
//                try {
//                    jsonObject.put("StartPoint", startPoint.getText().toString());
//                    jsonObject.put("EndingPoint", endingPoint.getText().toString());
//                    jsonObject.put("TimeComplete", timeToComplete.getText().toString());
//                    jsonObject.put("Date", runningDate.getText().toString());
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
                //Log.d("json", jsonObject.toString());
                //Toast.makeText(CreateRouteActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                // Gets the data repository in write mode
                RunningDbHelper mDbHelper = new RunningDbHelper(CreateRouteActivity.this);
                SQLiteDatabase db = mDbHelper.getWritableDatabase();

// Create a new map of values, where column names are the keys
                ContentValues values = new ContentValues();
                values.put(RunningContract.RunningEntry.COLUMN_NAME_1, startPoint_text);
                values.put(RunningContract.RunningEntry.COLUMN_NAME_2, endingPoint_text);
                values.put(RunningContract.RunningEntry.COLUMN_NAME_3, timeComplete_text);
                values.put(RunningContract.RunningEntry.COLUMN_NAME_4, runningDate_text);

// Insert the new row, returning the primary key value of the new row
                long newRowId = db.insert(RunningContract.RunningEntry.TABLE_NAME, null, values);
            }

        });


    }

}
