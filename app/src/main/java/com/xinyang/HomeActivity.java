package com.xinyang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.Arrays;

public class HomeActivity extends AppCompatActivity {

    private Banner banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);

        banner = findViewById(R.id.banner);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器
        banner.setImageLoader(new BannerImageLoader());
        //设置图片集合
        banner.setImages(Arrays.asList("https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLke9yyicW4DA7TicbAt7qwI86iaXIn4I9a6j4JicUsFwXRyMVTDdbiabvDrhXrZs4bgF9hFJquIibw3jkA/132",
                "https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLke9yyicW4DA7TicbAt7qwI86iaXIn4I9a6j4JicUsFwXRyMVTDdbiabvDrhXrZs4bgF9hFJquIibw3jkA/132",
                "https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLke9yyicW4DA7TicbAt7qwI86iaXIn4I9a6j4JicUsFwXRyMVTDdbiabvDrhXrZs4bgF9hFJquIibw3jkA/132"));
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Default);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(Arrays.asList("哈哈哈哈","哈哈哈哈二","进行了解多少分了就爱上看见了"));
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();


        banner.setOnBannerListener(position -> {
            Toast.makeText(HomeActivity.this, "点击的下标索引："+ position, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        banner.stopAutoPlay();
    }
}
