package com.github.catvod.spider;

import android.content.Context;

import com.github.catvod.crawler.Spider;


/**
 * Demo for spider
 * <p>
 * Author: CatVod
 */
public class cs extends Spider {
    @Override
    public void init(Context context) {
        super.init(context);
    }

    public String homeContent(boolean filter) {


        return "{\"class\":[{\"type_id\":\"1\",\"type_name\":\"电影\"},{\"type_id\":\"2\",\"type_name\":\"连续剧\"},{\"type_id\":\"3\",\"type_name\":\"综艺\"},{\"type_id\":\"4\",\"type_name\":\"动漫\"}]}";


    }
}
