package com.skyeyeh.androidexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * 繼承自 Activity 類別.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * 覆寫 Activity 類別的 onCreate 方法.
     *
     * @param savedInstanceState 如果 Activity 關閉後重新初始化，則會包含他上次的資料；否則為空.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 一定要加入呼叫父類別 onCreate 方法的敘述.
        super.onCreate(savedInstanceState);

        // 指定這個元件使用的畫面配置資源.
        setContentView(R.layout.activity_main);

        // 為 ListView 元件設定三筆資料.
        String[] data = {"骷髏兵", "萬箭齊發", "加農砲", "野豬騎士"};
        int layoutId = android.R.layout.simple_list_item_1;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, layoutId, data);
        ListView itemList = (ListView) findViewById(R.id.item_list);
        itemList.setAdapter(adapter);
    }

    /**
     * 加入載入選單資源的方法.
     *
     * @param menu 選單.
     * @return 回傳 true 則顯示選單；否則則不顯示.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * 點選觸發的事件.
     *
     * @param view View
     */
    public void aboutApp(View view) {
        // 顯示訊息框(Context：通常指定為 this；String | int：設定顯示在訊息框裡面的訊息或文字資源；int：設定訊息框停留在畫面的時間).
        Toast.makeText(this, R.string.app_name, Toast.LENGTH_LONG).show();
    }
}
