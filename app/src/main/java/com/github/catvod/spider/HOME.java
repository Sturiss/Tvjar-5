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


import java.util.HashMap;
import java.util.List;
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

    public String categoryContent(String tid, String pg, boolean filter, HashMap<String, String> extend) {
        try {
            JSONObject result = new JSONObject();
            JSONArray list = new JSONArray();
            result.put("page", 1);
            result.put("pagecount", 1);
            String curl = siteUrl + "/" + tid;
            String con_html = OkHttpUtil.string(curl, null);
            Document con_doc = Jsoup.parse(con_html, "UTF-8");
            Elements links = con_doc.getElementsByTag("a");
            result.put("limit",links.size()-1);
            result.put("total",links.size()-1);
            for (int i = 1; i < links.size(); i++) {
                JSONObject jsonObject = new JSONObject();
                // 获取超链接路径
                jsonObject.put("vod_id", tid+"/"+links.get(i).attr("href"));
                // 获取文本信息
                jsonObject.put("vod_name", links.get(i).text().split("/")[0]);
                list.put(jsonObject);
                result.put("list", list);
            }

            return result.toString();
        }catch(Exception e){
            SpiderDebug.log(e);
        }
        return "";
    }


    public String detailContent(List<String> ids) {
        try {
            JSONObject result = new JSONObject();
            JSONArray list = new JSONArray();
            String durl = siteUrl + "/" + ids.get(0);
            String don_html = OkHttpUtil.string(durl, null);
            Document don_doc = Jsoup.parse(don_html, "UTF-8");
            Elements links = don_doc.getElementsByTag("a");
            JSONObject info = new JSONObject();
            info.put("vod_id",ids.get(0));
            info.put("vod_name",ids.get(1));
            info.put("vod_pic","");
            String play_from = "";
            for (int i = 1; i < links.size(); i++) {
                if(i==links.size()-1){
                    play_from=play_from+links.get(i).text().split("/")[0];
                }else {
                    play_from=play_from+links.get(i).text().split("/")[0]+"$$$";
                }

                 }
            info.put("vod_play_from",play_from);
            list.put(info);
            result.put("list",list);
            return result.toString();
        }catch(Exception e){
            SpiderDebug.log(e);
        }


        return "";
    }
}

