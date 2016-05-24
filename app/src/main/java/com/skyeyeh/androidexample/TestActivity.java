package com.skyeyeh.androidexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 設定畫面配置資源，指定的參數在「R.layout.」後面是檔案名稱。
        setContentView(R.layout.activity_test);
    }
}
