package com.github.catvod.demo;

import android.app.Activity;
import android.os.Bundle;


import com.github.catvod.spider.HOME;
import com.github.catvod.spider.LiteApple;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Thread(new Runnable() {
            @Override
            public void run() {
                HOME source = new HOME();
                //LiteApple source = new LiteApple();
                source.init(MainActivity.this, "https://vipmv.co/xgapp.php/v1/");
               // source.init(MainActivity.this);
                String homeContent_json  = source.homeContent(true);
                String categoryContent_json = source.categoryContent("少儿/","",true,null);
               // source.detailContent(categoryContent_json.)
                //类型json
                System.out.println("=======homeContent_json--->："+homeContent_json);
                //一个类型下面的所有video，json
                System.out.println("=======homeVideoContent_json--->："+categoryContent_json);

            }
        }).start();
    }
}