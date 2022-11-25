package com.github.catvod.spider;

import android.content.Context;

import com.github.catvod.crawler.Spider;
import com.eclipsesource.v8.V8;

import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.utils.Misc;
import com.github.catvod.utils.okhttp.OkHttpUtil;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JS extends Spider {
    public void init(Context context) {
        super.init(context);
    }
    public String homeContent(boolean filter) {
        V8 v8 =V8.createV8Runtime();
        Object result = v8.executeScript("var json = '{\"class\":[{\"type_id\"：\"dianying\",\"type_name\": \"电影\"},{\"type_id\"：\"lianxuju\",\"type_name\": \"连续剧\"}]}'\n;json;");
        v8.close();
        return result.toString();
    }



}

