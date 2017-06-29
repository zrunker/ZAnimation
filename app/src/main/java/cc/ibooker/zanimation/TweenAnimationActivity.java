package cc.ibooker.zanimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Tween Animation 变换动画/补间动画/View Animation
 * Created by 邹峰立 on 2017/6/19.
 */
public class TweenAnimationActivity extends AppCompatActivity {
    private ImageView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);

        img = (ImageView) findViewById(R.id.img);
    }

    // 渐变透明度动画
    public void onAlpha(View view) {
//        AlphaAnimation alphaAnim = new AlphaAnimation(1.0f, 0.0f);
//        alphaAnim.setDuration(1000);
//        alphaAnim.setFillAfter(true);
//        alphaAnim.setStartOffset(1000);
//        alphaAnim.setInterpolator(this, android.R.anim.decelerate_interpolator);

        Animation alphaAnim = AnimationUtils.loadAnimation(this, R.anim.alpha);

        img.startAnimation(alphaAnim);
    }

    // 尺寸伸缩动画效果
    public void onScale(View view) {
//        ScaleAnimation scaleAnim = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 0.5f, 0.5f);
//        scaleAnim.setDuration(1000);
//        scaleAnim.setFillAfter(true);
//        scaleAnim.setStartOffset(1000);
//        scaleAnim.setInterpolator(this, android.R.anim.decelerate_interpolator);

        Animation scaleAnim = AnimationUtils.loadAnimation(this, R.anim.scale);

        img.startAnimation(scaleAnim);
    }

    //  位置移动动画效果
    public void onTranslate(View view) {
//        TranslateAnimation translateAnim = new TranslateAnimation(0.0f, 100.0f, 0.0f, 100.0f);
//        translateAnim.setDuration(1000);
//        translateAnim.setFillAfter(true);
//        translateAnim.setStartOffset(1000);
//        translateAnim.setInterpolator(this, android.R.anim.decelerate_interpolator);

        Animation translateAnim = AnimationUtils.loadAnimation(this, R.anim.translate);

        img.startAnimation(translateAnim);
    }

    // 画面旋转动画效果
    public void onRotate(View view) {
//        RotateAnimation rotateAnim = new RotateAnimation(0.0f, 180.0f, 0.5f, 0.5f);
//        rotateAnim.setDuration(1000);
//        rotateAnim.setFillAfter(true);
//        rotateAnim.setStartOffset(1000);
//        rotateAnim.setInterpolator(this, android.R.anim.decelerate_interpolator);

        Animation rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate);

        img.startAnimation(rotateAnim);
    }

    // 组合动画
    public void onSet(View view) {
        // 方法一
//        AnimationSet animationSet = new AnimationSet(true);
//        animationSet.setInterpolator(this, android.R.anim.decelerate_interpolator);
//        animationSet.setFillAfter(true);
//
//        RotateAnimation rotateAnim = new RotateAnimation(0.0f, 180.0f, 0.5f, 0.5f);
//        rotateAnim.setDuration(1000);
//        rotateAnim.setStartOffset(1000);
//
//        TranslateAnimation translateAnim = new TranslateAnimation(0.0f, 100.0f, 0.0f, 100.0f);
//        translateAnim.setDuration(1000);
//        translateAnim.setStartOffset(2000);
//
//        animationSet.addAnimation(rotateAnim);
//        animationSet.addAnimation(translateAnim);

//        img.startAnimation(animationSet);

        // 方法二
//        RotateAnimation rotateAnim = new RotateAnimation(0.0f, 180.0f, 0.5f, 0.5f);
//        rotateAnim.setDuration(1000);
//        rotateAnim.setFillAfter(true);
//        rotateAnim.setStartOffset(1000);
//        rotateAnim.setInterpolator(this, android.R.anim.decelerate_interpolator);
//        rotateAnim.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                TranslateAnimation translateAnim = new TranslateAnimation(0.0f, 100.0f, 0.0f, 100.0f);
//                translateAnim.setDuration(1000);
//                translateAnim.setFillAfter(true);
//                translateAnim.setStartOffset(1000);
//                translateAnim.setInterpolator(TweenAnimationActivity.this, android.R.anim.decelerate_interpolator);
//                img.startAnimation(translateAnim);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//        img.startAnimation(rotateAnim);

        // 方法三
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.set);
        img.startAnimation(animation);
    }
}
