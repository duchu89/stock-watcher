package com.stockwatcher.mduszewski.stockwatcher.ui.splash;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.animation.AnimationUtils;

import com.stockwatcher.mduszewski.stockwatcher.R;
import com.stockwatcher.mduszewski.stockwatcher.databinding.ActivitySplashBinding;
import com.stockwatcher.mduszewski.stockwatcher.ui.BaseActivity;
import com.stockwatcher.mduszewski.stockwatcher.ui.main.MainActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;

/**
 * Created by mduszewski on 23.07.2017.
 */

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySplashBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        binding.splashImage.startAnimation(AnimationUtils.loadAnimation(this, R.anim.heartbeat));

        Completable.timer(5, TimeUnit.SECONDS)
                .subscribe(this::startMainActivity);
    }

    private void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
