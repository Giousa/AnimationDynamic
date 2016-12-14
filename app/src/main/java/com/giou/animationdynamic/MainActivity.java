package com.giou.animationdynamic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.btn_alpha)
    Button mBtnAlpha;
    @InjectView(R.id.btn_scale)
    Button mBtnScale;
    @InjectView(R.id.btn_translate)
    Button mBtnTranslate;
    @InjectView(R.id.btn_rotate)
    Button mBtnRotate;
    @InjectView(R.id.btn_set)
    Button mBtnSet;
    @InjectView(R.id.tv_test)
    TextView mTvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.btn_alpha, R.id.btn_scale, R.id.btn_translate, R.id.btn_rotate, R.id.btn_set})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_alpha:
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f,0.0f);
                alphaAnimation.setDuration(3000);
                alphaAnimation.setRepeatCount(3);
                alphaAnimation.setRepeatMode(Animation.RESTART);
                mTvTest.startAnimation(alphaAnimation);
                break;

            case R.id.btn_scale:
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.5f,2.0f,0.5f,2.0f,0.5f,1.0f);
                scaleAnimation.setDuration(3000);
                scaleAnimation.setRepeatCount(3);
                scaleAnimation.setRepeatMode(Animation.RESTART);
                mTvTest.startAnimation(scaleAnimation);
                break;

            case R.id.btn_translate:
                TranslateAnimation translateAnimation = new TranslateAnimation(0,180.0f,0,0);
                translateAnimation.setDuration(3000);
                translateAnimation.setRepeatCount(3);
                translateAnimation.setRepeatMode(Animation.RESTART);
                translateAnimation.setInterpolator(new BounceInterpolator());
                mTvTest.startAnimation(translateAnimation);
                break;

            case R.id.btn_rotate:
                RotateAnimation rotateAnimation = new RotateAnimation(0,270.0f,0.5f,0.5f);
                rotateAnimation.setDuration(3000);
                rotateAnimation.setRepeatCount(2);
                rotateAnimation.setRepeatMode(Animation.RESTART);
                rotateAnimation.setInterpolator(new BounceInterpolator());
                rotateAnimation.setFillAfter(true);
                mTvTest.startAnimation(rotateAnimation);
                break;

            case R.id.btn_set:
                AlphaAnimation alpha = new AlphaAnimation(1.0f,0.0f);
                ScaleAnimation scale = new ScaleAnimation(0.5f,2.0f,0.5f,2.0f,0.5f,1.0f);
                TranslateAnimation translate = new TranslateAnimation(0,180.0f,0,0);
                RotateAnimation rotate = new RotateAnimation(0,270.0f,0.5f,0.5f);

                AnimationSet animationSet = new AnimationSet(true);
                animationSet.addAnimation(alpha);
                animationSet.addAnimation(scale);
                animationSet.addAnimation(translate);
                animationSet.addAnimation(rotate);

                animationSet.setDuration(3000);
                animationSet.setRepeatCount(2);
                animationSet.setRepeatMode(Animation.RESTART);

                mTvTest.startAnimation(animationSet);

                break;
        }
    }
}
