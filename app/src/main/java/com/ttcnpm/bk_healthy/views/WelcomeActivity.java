package com.ttcnpm.bk_healthy.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.ttcnpm.bk_healthy.R;
import com.ttcnpm.bk_healthy.model.Users;

import org.json.JSONObject;

public class WelcomeActivity extends Activity{
    public Button login;
    public Button register;
    public static JSONObject current_user = null;
    public static Activity activity = null;
    public static Users user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activity = this;
        user = new Users(WelcomeActivity.this);
        setContentView(R.layout.layout_main_no_bottom);
        LinearLayout body_layout = (LinearLayout) findViewById(R.id.body_layout);
        getLayoutInflater().inflate(R.layout.activity_welcome, body_layout);

        login = (Button) findViewById(R.id.btn_login);
        register = (Button) findViewById(R.id.btn_register);

        login.setOnClickListener(onClick);
        register.setOnClickListener(onClick);
    }

    public View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_login:
                    intent = new Intent(WelcomeActivity.activity, LoginActivity.class);
                    startActivity(intent);
                    break;

                case R.id.btn_register:
                    intent = new Intent(WelcomeActivity.activity, RegisterActivity.class);
                    startActivity(intent);
                    break;
                default:
                    break;
            }
        }
    };

    public void handleOnClickForFooter() {
        findViewById(R.id.footer_home).setOnClickListener(onClickFooter);
    }

    public View.OnClickListener onClickFooter = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()) {
                case R.id.footer_home:
                    intent = new Intent(WelcomeActivity.activity, HomeActivity.class);
                    startActivity(intent);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public void onBackPressed() {
        Intent intent = null;
        switch (WelcomeActivity.activity.getClass().getSimpleName()) {
            case "LoginActivity":
            case "RegisterActivity":
                intent = new Intent(WelcomeActivity.activity, WelcomeActivity.class);
                startActivity(intent);
                break;
            default:
                super.onBackPressed();
        }
    }
}
