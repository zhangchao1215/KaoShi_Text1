package jiyun.com.kaoshi_text1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Administrator on 2017/5/15.
 */

public class DemoAdapter extends BaseAdapter {
    private List<String> mList;
    private Context context;
    public DemoAdapter(Context context, List<String> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodler hodler;
        if(convertView == null){
            hodler = new ViewHodler();
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_griditem,null);
            hodler.image = (ImageView) convertView.findViewById(R.id.Grid_imageItem);
            convertView.setTag(hodler);
        }else{
            hodler = (ViewHodler) convertView.getTag();
        }

        String str= mList.get(position);
        Glide.with(context).load(str).into(hodler.image);
        return convertView;
    }

    class ViewHodler{
        private ImageView image;

    }
}
