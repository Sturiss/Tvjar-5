package com.github.catvod.spider;

import android.content.Context;
import android.text.TextUtils;

import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.utils.okhttp.OkHttpUtil;

import org.json.JSONArray;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.select.Elements;


import java.util.regex.Pattern;

/**
 * Demo for spider
 * <p>
 * Author: CatVod
 */
public class HOME extends Spider {

    private static final String siteUrl = "http://192.168.1.1:8888";
    private static final String siteHost = "192.168.1.1:8888";

    @Override
    public void init(Context context) {
        super.init(context);
    }

    public String homeContent(boolean filter) {
        try {
            JSONObject result = new JSONObject();
            JSONArray classes = new JSONArray();
            String fenlei_html = OkHttpUtil.string(siteUrl, null);
            Document fenlei_doc = Jsoup.parse(fenlei_html, "UTF-8");
            Elements links = fenlei_doc.getElementsByTag("a");
            for (int i=1;i<links.size();i++) {
                JSONObject jsonObject = new JSONObject();
                // 获取超链接路径
                jsonObject.put("type_id", links.get(i).attr("href"));
                // 获取文本信息
                jsonObject.put("type_name", links.get(i).text().split("/")[0]);
                classes.put(jsonObject);


                result.put("class",classes);
            }

          // System.out.println("=============："+classes);
            return result.toString();
        }catch(Exception e){
            SpiderDebug.log(e);
        }



        return "";
        }



}
