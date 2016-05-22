package com.skyeyeh.androidexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

/**
 * 繼承自 Activity 類別。
 */
public class MainActivity extends AppCompatActivity {
    /**
     * 覆寫 Activity 類別的 onCreate 方法。
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 一定要加入呼叫父類別 onCreate 方法的敘述
        super.onCreate(savedInstanceState);

        // 指定這個元件使用的畫面配置資源
        setContentView(R.layout.activity_main);
    }

    /**
     * 加入載入選單資源的方法。
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
//        return super.onCreateOptionsMenu(menu);
    }
}
