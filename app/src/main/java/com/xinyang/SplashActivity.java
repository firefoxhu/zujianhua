package com.xinyang;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        boolean isFirst = sp.getBoolean("isFirst", true);
        Intent intent = new Intent();
        // 如果是第一次启动，则先进入功能引导页
        if (isFirst) {
            // 修改进入状态
            sp.edit().putBoolean("isFirst",false).commit();
            intent.setClass(SplashActivity.this, IntroMainActivity.class);
            startActivity(intent);
            finish();
        }else {
            mHandler.postDelayed(()->{
                startActivity(new Intent(this,HomeActivity.class));
                finish();
            },3000);
        }
    }
}
