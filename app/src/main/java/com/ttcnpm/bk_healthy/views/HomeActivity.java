package com.ttcnpm.bk_healthy.views;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ttcnpm.bk_healthy.R;
import com.ttcnpm.bk_healthy.adapter.HomeAdapter;
import com.ttcnpm.bk_healthy.database.TblFoods;
import com.ttcnpm.bk_healthy.helper.SuperGridview;
import com.ttcnpm.bk_healthy.model.Foods;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeActivity extends WelcomeActivity {

    private SuperGridview list;
    private HomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_has_bottom);
        LinearLayout body_layout = (LinearLayout) findViewById(R.id.body_layout);
        getLayoutInflater().inflate(R.layout.activity_home, body_layout);
        ((TextView) findViewById(R.id.header)).setText("Home");
        super.handleOnClickForFooter();
        WelcomeActivity.activity = this;
        ArrayList<String> lst = new ArrayList<String>();
        adapter = new HomeAdapter(this, lst);
        list = (SuperGridview) findViewById(R.id.list);
        adapter.data.add("{\"menu_image\": \"1\", \"menu_name\": \"Danh sách thức ăn\"}");
        adapter.data.add("{\"menu_image\": \"2\", \"menu_name\": \"Chế độ ăn\"}");
        adapter.data.add("{\"menu_image\": \"3\", \"menu_name\": \"Hướng dẫn tập gym\"}");
        adapter.data.add("{\"menu_image\": \"4\", \"menu_name\": \"Chạy bộ\"}");
        adapter.data.add("{\"menu_image\": \"5\", \"menu_name\": \"Lên lịch chạy\"}");


        list.setAdapter(adapter);
        list.setEnabled(false);
        createListFood();
    }

    public void createListFood(){
        JSONObject food1 = new JSONObject();
        JSONObject food2 = new JSONObject();
        try {
            food1.put(TblFoods.FOOD_ID, "1");
            food1.put(TblFoods.NAME, "Thịt bò");
            food1.put(TblFoods.FOOD_TYPE, "meat");
            food1.put(TblFoods.DESCRIPTION, "Thịt bò, chủ yếu bao gồm protein.\n" +
                    "\n" +
                    "Hàm lượng protein trong thịt nạc, thịt bò chế biến khoảng 26-27%.\n" +
                    "\n" +
                    "Protein động vật thường có chất lượng cao,có chứa tất cả 8 axit amin thiết yếu cần thiết cho sự tăng trưởng và duy trì cơ thể chúng ta.\n" +
                    "\n" +
                    "Các khối protein, các axit amin, là rất quan trọng từ góc độ sức khỏe. Thành phần của chúng trong các protein rất khác nhau, tùy thuộc vào nguồn dinh dưỡng.\n" +
                    "\n" +
                    "Thịt là một trong những nguồn thực phẩm hoàn thiện nhất của protein, các axit amin gần như giống hệt với các cơ bắp của chúng ta.");
            food1.put(TblFoods.CALORIES, "278");

            food2.put(TblFoods.FOOD_ID, "2");
            food2.put(TblFoods.NAME, "Thịt heo");
            food2.put(TblFoods.FOOD_TYPE, "meat");
            food2.put(TblFoods.DESCRIPTION, "Giống như tất cả các loại thịt khác, thịt lợn là chủ yếu được tạo thành từ protein.\n" +
                    "\n" +
                    "Hàm lượng protein trong thịt lợn chín là khoảng 26% trọng lượng tươi.\n" +
                    "\n" +
                    "Tính theo trọng lượng khô, hàm lượng protein trong thịt lợn nạc có thể cao tới 89%, làm cho nó một trong những nguồn thực phẩm giàu protein.\n" +
                    "\n" +
                    "Nó chứa tất cả các axit amin thiết yếu cần thiết cho sự tăng trưởng và duy trì cơ thể chúng ta. Trong thực tế, thịt là một trong những nguồn thực phẩm hoàn thiện nhất của protein.");
            food2.put(TblFoods.CALORIES, "198");

            new Foods(WelcomeActivity.activity, food1).saveFoods();
            new Foods(WelcomeActivity.activity, food2).saveFoods();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
