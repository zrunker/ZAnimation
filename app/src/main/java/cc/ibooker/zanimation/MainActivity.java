package cc.ibooker.zanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 跳转Tween Animation界面
    public void onTween(View view) {
        Intent intent = new Intent(this, TweenAnimationActivity.class);
        startActivity(intent);
    }

    // 跳转Frame Animation界面
    public void onFrame(View view) {
        Intent intent = new Intent(this, FrameAnimationActivity.class);
        startActivity(intent);
    }

    // 跳转Property Animation界面
    public void onProperty(View view) {
        Intent intent = new Intent(this, PropertyAnimationActivity.class);
        startActivity(intent);
    }

    // 跳转Layout Animation界面
    public void onLayout(View view) {
        Intent intent = new Intent(this, LayoutAnimationActivity.class);
        startActivity(intent);
    }
}
