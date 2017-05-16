package jiyun.com.kaoshi_text1;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/5/15.
 */

public  class  ImageBean implements Serializable{

    private List<List<String>> images;

    public List<List<String>> getImages() {
        return images;
    }

    public void setImages(List<List<String>> images) {
        this.images = images;
    }
}
