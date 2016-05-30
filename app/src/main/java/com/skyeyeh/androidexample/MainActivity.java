package com.skyeyeh.androidexample;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

/**
 * 繼承自 Activity 類別.
 */
public class MainActivity extends AppCompatActivity {

    private ListView itemList;
    private TextView showAppName;
    private static final String[] DATA = new String[]{"骷髏兵", "萬箭齊發", "加農砲", "野豬騎士"};
    private ArrayAdapter<String> adapter;

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

        // 讀取在畫面配置檔已經設定好名稱的元件.
        processViews();

        // 綁定事件.
        processControllers();

        // 為 ListView 元件設定三筆資料. 增加「final」關鍵字，讓巢狀類別中的程式碼使用.
        int layoutId = android.R.layout.simple_list_item_1;
        adapter = new ArrayAdapter<>(this, layoutId, DATA);
        if (itemList != null) {
            itemList.setAdapter(adapter);
        }
    }

    /**
     * 讀取在畫面配置檔已經設定好名稱的元件.
     */
    private void processViews() {
        itemList = (ListView) findViewById(R.id.item_list);
        showAppName = (TextView) findViewById(R.id.show_app_name);
    }

    /**
     * 綁定事件.
     */
    private void processControllers() {
        // 建立選單項目點擊監聽物件
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            /**
             * 建立選單項目點擊監聽物件.
             * @param parent 使用者操作的 ListView 物件
             * @param view 使用者選擇的項目
             * @param position 使用者選擇的項目編號，第一個是0
             * @param id id
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, DATA[position], Toast.LENGTH_LONG).show();
            }
        };
        // 註冊選單項目點擊監聽物件.
        itemList.setOnItemClickListener(itemClickListener);

        AdapterView.OnItemLongClickListener itemLongClickListener = new AdapterView.OnItemLongClickListener() {
            /**
             * 建立選單項目長按監聽物件.
             * @param parent 使用者操作的 ListView 物件
             * @param view 使用者選擇的項目
             * @param position 使用者選擇的項目編號，第一個是0
             * @param id id
             */
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "A long time ago, " + DATA[position], Toast.LENGTH_LONG).show();
                return false;
            }
        };
        // 註冊選單項目長按監聽物件.
        itemList.setOnItemLongClickListener(itemLongClickListener);


        // 建立點擊監聽物件.
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 建立對話框.
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.app_name).setMessage(R.string.about).show();
            }
        };
        // 註冊點擊監聽物件.
        if (showAppName != null) {
            showAppName.setOnClickListener(clickListener);
        }

        // 建立長按監聽物件.
        View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // 建立對話框.
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.app_name).setMessage(R.string.long_about).show();
                return false;
            }
        };
        // 註冊長按監聽物件.
        showAppName.setOnLongClickListener(longClickListener);
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
     * 使用者選擇所有的選單項目都會呼叫這個方法.
     *
     * @param item MenuItem
     */
    public void clickMenuItem(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.search_item:
                break;
            case R.id.add_item:
                break;
            case R.id.revert_item:
                break;
            case R.id.delete_item:
                break;
        }

        // 測試用.
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("MenuItem Test").setMessage(item.getTitle()).setIcon(item.getIcon()).show();
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
