package com.ttcnpm.bk_healthy.views;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ttcnpm.bk_healthy.R;
import com.ttcnpm.bk_healthy.helper.AlertView;
import com.ttcnpm.bk_healthy.helper.MyCustomProgressDialog;

import org.json.JSONObject;

public class LoginActivity extends WelcomeActivity {

    private TextView user_name;
    private TextView password;
    private String user_name_text;
    private String password_text;
    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_no_bottom);
        LinearLayout body_layout = (LinearLayout) findViewById(R.id.body_layout);
        getLayoutInflater().inflate(R.layout.activity_login, body_layout);
        ((TextView) findViewById(R.id.header)).setText("Sign in");
        WelcomeActivity.activity = this;
        user_name = (TextView) findViewById(R.id.user_name);
        password = (TextView) findViewById(R.id.password);

        ((Button) findViewById(R.id.sign_in_button)).setOnClickListener(loginProcess);
    }

    public View.OnClickListener loginProcess = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            user_name_text = user_name.getText().toString().trim();
            password_text = password.getText().toString().trim();

            if (user_name_text.length() < 1) {
                (new AlertView()).createNativeAlert("Please fill up Username", LoginActivity.this);
                return;
            }

            if (password_text.length() < 1) {
                (new AlertView()).createNativeAlert("Please fill up Password", LoginActivity.this);
                return;
            }

            new checkLogin().execute();
        }
    };

    public class checkLogin extends AsyncTask<Void, Void, JSONObject> {
        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            dialog = new MyCustomProgressDialog(LoginActivity.this, R.style.MyCustomProgressDialog);
            dialog.show();
        }

        @Override
        protected JSONObject doInBackground(Void... params) {
            JSONObject jsonObj = null;

            try {
                jsonObj = WelcomeActivity.user.getUserByKey(user_name_text, "user_name");
                if (jsonObj != null){
                    jsonObj.put("password_invalid", "false");
                }
                if (!jsonObj.getString("password").equals(password_text)){
                    jsonObj.put("password_invalid", "true");
                }
            } catch(Throwable t) {
                t.printStackTrace();
            }
            return jsonObj;
        }

        @Override
        protected void onPostExecute(JSONObject result) {
            super.onPostExecute(result);
            if (dialog != null && dialog.isShowing()) {
                try {
                    if (result == null){
                        (new AlertView()).createNativeAlert("User name invalid", LoginActivity.this);
                    }
                    else if(result.getString("password_invalid").equals("true")){
                        (new AlertView()).createNativeAlert("Password invalid", LoginActivity.this);
                    }else{
                        WelcomeActivity.current_user = result;
                        Intent intent = new Intent(WelcomeActivity.activity, HomeActivity.class);
                        startActivity(intent);
                    }

                    dialog.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

