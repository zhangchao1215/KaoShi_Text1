package jiyun.com.kaoshi_text1;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.LinearLayout;

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

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.Main_Gridview)
    GridView MainGridview;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    private Context context;
    private List<ImageBean> mList = new ArrayList<>();
    private List<String> listname = new ArrayList<>();
    private DemoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        context = MainActivity.this;
        init();
        volley();
    }

    private void init() {
        for (int i = 0; i < 5; i++) {
            listname.add(R.mipmap.ic_launcher+"");

        }

    }

    private void volley() {
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "http://172.16.42.13:8080/shixun.json";
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                ImageBean bean = gson.fromJson(response, ImageBean.class);
                listname.add(bean.getImages().get(0).get(0));
                listname.add(bean.getImages().get(1).get(1));
                listname.add(bean.getImages().get(2).get(2));
                listname.add(bean.getImages().get(3).get(3));
                listname.add(bean.getImages().get(1).get(0));
                listname.add(bean.getImages().get(2).get(1));
                listname.add(bean.getImages().get(3).get(2));
                listname.add(bean.getImages().get(1).get(3));
                adapter = new DemoAdapter(context, listname);
                MainGridview.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(stringRequest);
    }


}
