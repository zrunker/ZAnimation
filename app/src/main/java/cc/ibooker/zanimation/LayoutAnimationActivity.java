package cc.ibooker.zanimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * 布局动画 LayoutAnimation
 * Created by 邹峰立 on 2017/6/28.
 */
public class LayoutAnimationActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_animation);

        listView = (ListView) findViewById(R.id.listview);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list.add("IBook布局动画" + i);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        // 布局动画控制器
        LayoutAnimationController animationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.move_in));
        animationController.setOrder(LayoutAnimationController.ORDER_RANDOM);
        listView.setLayoutAnimation(animationController);
        listView.startLayoutAnimation();

    }
}
