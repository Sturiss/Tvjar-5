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


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

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
                jsonObject.put("vod_id", curl+links.get(i).attr("href"));
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
            JSONObject result3 = new JSONObject();
            JSONObject info = new JSONObject();

            JSONArray list_info = new JSONArray();

            ArrayList<String> surls = new ArrayList<String>();
            String durl =ids.get(0);


            String deta_html = OkHttpUtil.string(durl, null);
            Document suon_doc = Jsoup.parse(deta_html,"UTF-8");
            Elements links3 = suon_doc.getElementsByTag("a");

            String play_from = "";
            for (int i = 1; i < links3.size(); i++) {
            if (i == links3.size() - 1) {
                play_from = play_from + links3.get(i).text().split("/")[0];
            } else {
                play_from = play_from + links3.get(i).text().split("/")[0] + "$$$";
            }
            String surl = durl + links3.get(i).attr("href");
            String ddeta_html  = OkHttpUtil.string(surl, null);
            Document res3_doc = Jsoup.parse(ddeta_html, "UTF-8");
            Elements links4 = res3_doc.getElementsByTag("a");

            String c = "";
            for (int j = 1; j < links4.size(); j++) {
                String a = "";
                String b = "";
                a = links4.get(j).text() + "$";
                if (j == links4.size() - 1) {
                    b = surl + links4.get(j).attr("href");
                } else {
                    b = surl + links4.get(j).attr("href") + "#";

                }

                c = c + a + b;

            }
            surls.add(c);

        }
        String d = "";
        for (int k = 0; k < surls.size(); k++) {
            if (k == surls.size() - 1) {
                d = d + surls.get(k);
            } else {
                d = d + surls.get(k) + "$$$";

            }
        }

        info.put("vod_id", ids.get(0));
        info.put("vod_name", ids.get(1));

        info.put("vod_play_from", play_from);
        info.put("vod_play_url", d);
        list_info.put(info);
        result3.put("list", list_info);


        JSONObject cc = JSONObject.parseObject("{
	\"list\": [{
		\"vod_id\": \"1902\",
		\"vod_name\": \"海岸村恰恰恰\",
		\"vod_pic\": \"https:\/\/pic.imgdb.cn\/item\/61463fd12ab3f51d91a0f44d.jpg\",
		\"type_name\": \"剧情\",
		\"vod_year\": \"2021\",
		\"vod_area\": \"韩国\",
		\"vod_remarks\": \"更新至第8集\",
		\"vod_actor\": \"申敏儿,金宣虎,李相二,孔敏晶,徐尚沅,禹美华,朴艺荣,李世亨,边胜泰,金贤佑,金英玉\",
		\"vod_director\": \"柳济元\",
		\"vod_content\": \"海岸村恰恰恰剧情:　　韩剧海岸村恰恰恰 갯마을 차차차改编自2004年的电影《我的百事通男友洪班长》，海岸村恰恰恰 갯마을 차차차讲述来自大都市的牙医（申敏儿 饰）到充满人情味的海岸村开设牙医诊所，那里住着一位各方面都\",
		\"vod_play_from\": \"qiepian$$$yun3edu\", 
		\"vod_play_url\": \"第1集$1902-1-1#第2集$1902-1-2#第3集$1902-1-3#第4集$1902-1-4#第5集$1902-1-5#第6集$1902-1-6#第7集$1902-1-7#第8集$1902-1-8$$$第1集$1902-2-1#第2集$1902-2-2#第3集$1902-2-3#第4集$1902-2-4#第5集$1902-2-5#第6集$1902-2-6#第7集$1902-2-7#第8集$1902-2-8\" 	}]}");
            //return result3.toString();
            return cc.toString();
        }catch(Exception e){
            SpiderDebug.log(e);
        }


        return "";
    }
}

