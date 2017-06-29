package cc.ibooker.zanimation;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * 逐帧动画
 * Created by 邹峰立 on 2017/6/20.
 */
public class FrameAnimationActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);

        imageView = (ImageView) findViewById(R.id.imageView);

        // Java代码实现逐帧动画
        AnimationDrawable anim = new AnimationDrawable();
        for (int i = 1; i <= 12; i++) {
            int id;
            if (i < 10)
                id = getResources().getIdentifier("loading_0" + i, "drawable", getPackageName());
            else
                id = getResources().getIdentifier("loading_" + i, "drawable", getPackageName());
            Drawable drawable = getResources().getDrawable(id);
            anim.addFrame(drawable, 100);
        }
        anim.setOneShot(false);
        imageView.setImageDrawable(anim);
        anim.start();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        // XML实现逐帧动画
//        imageView.setImageResource(R.drawable.loading);
//        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
//        animationDrawable.start();
    }
}
