package jiyun.com.kaoshi_text1.recycler;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jiyun.com.kaoshi_text1.ImageBean;
import jiyun.com.kaoshi_text1.R;

/**
 * Created by Administrator on 2017/5/15.
 * 在这个类中实现点击事件的接口，完成接口的回调
 *
 */

public class RecycleActivity extends Activity implements MyAdapter.OnitemClickListener {
    @BindView(R.id.MyRecycler)
    RecyclerView MyRecycler;
    private MyAdapter adapter;
    private Context context;
    private List<List<String>> mList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_activity);
        ButterKnife.bind(this);
        context = RecycleActivity.this;
//        adapter.setListener(RecycleActivity.this);
        init();
        Volley();
    }

    private void init() {
        MyRecycler.setHasFixedSize(true);
        MyRecycler.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        adapter = new MyAdapter(mList,context);
        MyRecycler.setAdapter(adapter);
    }

    private void Volley() {
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "http://172.16.42.220:8080/My/shixun.json";
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                ImageBean bean = gson.fromJson(response, ImageBean.class);
                List<List<String>> images = bean.getImages();

                mList.addAll(images);
                Log.d("RecycleActivity", "images:" + images);
                adapter.notifyDataSetChanged();
                Log.d("RecycleActivity", response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(request);

    }

    @Override
    public void onItemClick(int position) {

    }
}
