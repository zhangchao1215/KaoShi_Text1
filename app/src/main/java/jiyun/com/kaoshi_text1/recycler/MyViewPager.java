package jiyun.com.kaoshi_text1.recycler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jiyun.com.kaoshi_text1.R;

/**
 * Created by Administrator on 2017/5/15.
 */

public class MyViewPager extends Activity {
    @BindView(R.id.MyViewPager)
    ViewPager MyViewPager;
    @BindView(R.id.MyText_number)
    TextView MyTextNumber;
    private List<View> viewList;
    private ViewPagerAdapter adapter;
    private ArrayList<List<String>> listExtra;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        ButterKnife.bind(this);
        init();
        initData();
        viewpager();
    }

    private void init() {
        Intent intent = getIntent();
        listExtra = (ArrayList<List<String>>) intent.getSerializableExtra("image");
        pos = intent.getIntExtra("postion", 0);
        viewList = new ArrayList<>();
        adapter = new ViewPagerAdapter(viewList);
        MyViewPager.setAdapter(adapter);
        MyViewPager.setCurrentItem(pos);
    }

    private void initData() {

        for (int i = 0; i < listExtra.size(); i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.activity_viewpage_image, null);
            ImageView image = (ImageView) view.findViewById(R.id.ViewPager_Item);

            Glide.with(this).load(listExtra.get(i).get(pos)).into(image);
            viewList.add(view);


            Log.d("MyViewPager", "listExtra.size():" + listExtra.size());
        }
    }
private void viewpager(){
    MyViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
          if(position%listExtra.size() == 0){
              MyTextNumber.setText(listExtra.size()+"/"+"1");
          }if(position%listExtra.size() == 1){
                MyTextNumber.setText(listExtra.size()+"/"+"2");
            }if(position%listExtra.size() == 2) {
                MyTextNumber.setText(listExtra.size()+"/"+"3");
            }if(position%listExtra.size() == 3){
                MyTextNumber.setText(listExtra.size()+"/"+"4");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    });

}

}

