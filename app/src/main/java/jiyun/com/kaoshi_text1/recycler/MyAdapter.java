package jiyun.com.kaoshi_text1.recycler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.Serializable;
import java.util.List;

import jiyun.com.kaoshi_text1.R;

/**
 * Created by Administrator on 2017/5/15.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<List<String>> mList;
    private Context context;
    private OnitemClickListener listener;

    public void setListener(OnitemClickListener listener) {
        this.listener = listener;
    }

    public MyAdapter(List<List<String>> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    //这是找布局
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_griditem, null);
        ViewHolder masonryView = new ViewHolder(view);
//        view.setOnClickListener(this);
        return masonryView;
    }

    /**
     * 找Id,和每个索引
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        List<String> str = mList.get(position);
        holder.image.setImageResource(R.mipmap.ic_launcher);
        holder.mtext.setText(str + "");
        Glide.with(context).load(mList.get(0).get(1)).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.image);
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MyViewPager.class);
                intent.putExtra("image", (Serializable) mList);
                intent.putExtra("postion",position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    /**
     * 内部类，相当于viewhodler,找每个布局中的组件
     * //自定义的ViewHolder，持有每个Item的的所有界面元素
     */
    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView mtext;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.Grid_imageItem);
            mtext = (TextView) itemView.findViewById(R.id.Grid_text);
            int width = ((Activity) image.getContext()).getWindowManager().getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams params = image.getLayoutParams();
            //设置图片的相对于屏幕的宽高比
            params.width = width / 3;
            params.height = (int) (200 + Math.random() * 400);
            image.setLayoutParams(params);
            /**
             * 给每个view设置点击事件，通过接口得到每个的索引
             */
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(getLayoutPosition());
                }
            });
        }
    }

    /**
     * 接口自定义
     */
    public interface OnitemClickListener {
        void onItemClick(int position);

    }

}
