package com.ttcnpm.bk_healthy.views;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ttcnpm.bk_healthy.R;
import com.ttcnpm.bk_healthy.helper.AlertView;
import com.ttcnpm.bk_healthy.helper.MyCustomProgressDialog;
import com.ttcnpm.bk_healthy.model.Users;

import org.json.JSONObject;

public class RegisterActivity extends WelcomeActivity {

    private EditText user_name;
    private EditText first_name;
    private EditText last_name;
    private EditText password;
    private EditText confirmation_password;
    private String username_text;
    private String first_name_text;
    private String last_name_text;
    private String password_text;
    private String password_confirm_text;

    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_no_bottom);
        LinearLayout body_layout = (LinearLayout) findViewById(R.id.body_layout);
        getLayoutInflater().inflate(R.layout.activity_register, body_layout);
        ((TextView) findViewById(R.id.header)).setText("Sign up");

        user_name = (EditText) findViewById (R.id.user_name);
        first_name = (EditText) findViewById (R.id.first_name);
        last_name = (EditText) findViewById (R.id.last_name);
        password = (EditText) findViewById (R.id.password);
        confirmation_password = (EditText) findViewById (R.id.password_confirmation);

        findViewById(R.id.submit_button).setOnClickListener(registerProcess);
    }


    public View.OnClickListener registerProcess = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            username_text = user_name.getText().toString().trim();
            first_name_text = first_name.getText().toString().trim();
            last_name_text = last_name.getText().toString().trim();
            password_text = password.getText().toString();
            password_confirm_text = confirmation_password.getText().toString();

            if (username_text.length() < 1) {
                (new AlertView()).createNativeAlert("Please fill up Username", RegisterActivity.this);
                return;
            }

            if (first_name_text.length() < 1) {
                (new AlertView()).createNativeAlert("Please fill up First Name", RegisterActivity.this);
                return;
            }

            if (last_name_text.length() < 1) {
                (new AlertView()).createNativeAlert("Please fill up Last Name", RegisterActivity.this);
                return;
            }

            if (password_text.length() < 1) {
                (new AlertView()).createNativeAlert("Please fill up Password", RegisterActivity.this);
                return;
            }

            if (password_text.length() < 5) {
                (new AlertView()).createNativeAlert("Password must have more than 4 characters", RegisterActivity.this);
                return;
            }

            if (password_confirm_text.length() < 1) {
                (new AlertView()).createNativeAlert("Please fill up Confirmation Password", RegisterActivity.this);
                return;
            }

            if (!password_text.equals(password_confirm_text)) {
                (new AlertView()).createNativeAlert("Please check your Confirmation Password", RegisterActivity.this);
                return;
            }

            new checkRegister().execute();
        }
    };

    public class checkRegister extends AsyncTask<Void, Void, JSONObject> {
        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            dialog = new MyCustomProgressDialog(RegisterActivity.this, R.style.MyCustomProgressDialog);
            dialog.show();
        }

        @Override
        protected JSONObject doInBackground(Void... params) {
            JSONObject jsonObj = new JSONObject();

            try {
                jsonObj.put("user_id", (new Users(RegisterActivity.this).getAllUsers().length()+1));
                jsonObj.put("user_name", username_text);
                jsonObj.put("password", password_text);
                jsonObj.put("first_name", first_name_text);
                jsonObj.put("last_name", last_name_text);
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
                    Users new_user = new Users(RegisterActivity.this, result);
                    if(new_user.getUserByKey(result.getString("user_name"), "user_name") != null){
                        (new AlertView()).createNativeAlert("Username is existed", RegisterActivity.this);
                        dialog.dismiss();
                        return;
                    }

                    if (new_user.saveUser()){
                        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                        builder.setMessage("Register Successfully");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Intent intent = new Intent(WelcomeActivity.activity, LoginActivity.class);
                                startActivity(intent);
                            }
                        });
                        builder.show();
                    }else{
                        (new AlertView()).createNativeAlert("Unsuccessfully", RegisterActivity.this);
                    }
                    dialog.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
