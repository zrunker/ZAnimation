package cc.ibooker.zanimation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

/**
 * 属性动画-ObjectAnimator（控制属性） ValueAnimator（改变值，不改变属性）
 * Created by 邹峰立 on 2017/6/27.
 */
public class PropertyAnimationActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);

        imageView = (ImageView) findViewById(R.id.imageView);

//        ObjectAnimator.ofFloat(imageView, "rotationX", 0.0F, 360.0F)
//                .setDuration(1000)
//                .start();
//        ObjectAnimator.ofFloat(imageView, "translationX", 0.0F, 150.0F)
//                .setDuration(1000)
//                .start();


//        ValueAnimator valueAnimator = ValueAnimator.ofFloat(150);
//        valueAnimator.setDuration(1000);
//        valueAnimator.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//                // 动画开始
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                // 动画结束
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//              // 动画取消
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//              // 动画重复
//            }
//        });
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                imageView.setTranslationX((Float) animation.getAnimatedValue());
//            }
//        });
//        valueAnimator.setInterpolator(new CycleInterpolator(3));
//        valueAnimator.start();


//        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(imageView, "translationX", 0.0F, 150.0F).setDuration(1000);
//        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(imageView, "translationY", 0.0F, 150.0F).setDuration(1000);
//        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(imageView, "rotationX", 0.0F, 360.0F).setDuration(1000);
//        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.setDuration(3 * 1000);
//        // 随机设置
//        animatorSet.play(objectAnimator1)
//                .with(objectAnimator2)
//                .after(objectAnimator3);
//        // 一起播放
//        animatorSet.playTogether(objectAnimator1, objectAnimator2, objectAnimator3);
//        // 顺序播放
//        animatorSet.playSequentially(objectAnimator1, objectAnimator2, objectAnimator3);
//        animatorSet.start();


//        // 同时进行
//        // 在X轴缩放从原始比例1f,缩小到最小0f,再放大到原始比例1f
//        PropertyValuesHolder pvhScaleX = PropertyValuesHolder.ofFloat("scaleX", 1f, 0f, 1f);
//        // 在Y轴缩放从原始比例1f,缩小到最小0f,再放大到原始比例1f
//        PropertyValuesHolder pvhScaleY = PropertyValuesHolder.ofFloat("scaleY", 1f, 0f, 1f);
//        // 将PropertyValuesHolder交付给ObjectAnimator进行构建
//        ObjectAnimator customAnim = ObjectAnimator.ofPropertyValuesHolder(imageView, pvhScaleX, pvhScaleY);
//        // 设置执行时间(4000ms)
//        customAnim.setDuration(4000);
//        // 开始动画
//        customAnim.start();


//        // 设置在动画开始时,旋转角度为0度
//        Keyframe kf0 = Keyframe.ofFloat(0f, 0f);
//        // 设置在动画执行50%时,旋转角度为360度
//        Keyframe kf1 = Keyframe.ofFloat(.5f, 360f);
//        // 设置在动画结束时,旋转角度为0度
//        Keyframe kf2 = Keyframe.ofFloat(1f, 0f);
//        // 使用PropertyValuesHolder进行属性名称和值集合的封装
//        PropertyValuesHolder pvhRotation = PropertyValuesHolder.ofKeyframe("rotation", kf0, kf1, kf2);
//        // 通过ObjectAnimator进行执行
//        ObjectAnimator.ofPropertyValuesHolder(imageView, pvhRotation)
//                // 设置执行时间(1000ms)
//                .setDuration(1000)
//                // 开始动画
//                .start();


        // 加载xml属性动画
//        Animator anim = AnimatorInflater.loadAnimator(this, R.anim.animator);
//        anim.setTarget(imageView);
//        anim.start();


        // 类型估值 - 抛物线示例
        TypeEvaluator<PointF> typeEvaluator = new TypeEvaluator<PointF>() {
            @Override
            public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
                float time = fraction * 3;
                // x方向200px/s ，y方向0.5 * 200 * t * t
                PointF point = new PointF();
                point.x = 120 * time;
                point.y = 0.5f * 200 * time * time;
                return point;
            }
        };
        ValueAnimator valueAnimator = ValueAnimator.ofObject(typeEvaluator, new PointF(0, 0));
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setDuration(3000);
        valueAnimator.start();

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF point = (PointF) animation.getAnimatedValue();
                imageView.setX(point.x);
                imageView.setY(point.y);
            }
        });
    }
}
