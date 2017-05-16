package jiyun.com.kaoshi_text1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import jiyun.com.kaoshi_text1.recycler.RecycleActivity;

public class LogoActivity extends AppCompatActivity {

    @BindView(R.id.Logo_Image)
    ImageView LogoImage;
    @BindView(R.id.activity_logo)
    RelativeLayout activityLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        ButterKnife.bind(this);
        Animation animation = new RotateAnimation(1f,180f,500f,500f);
        LogoImage.setAnimation(animation);
        animation.setDuration(2000);
        animation.start();
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(LogoActivity.this,RecycleActivity.class);
                startActivity(intent);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
}
