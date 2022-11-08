## QQ.java
//导包
```
import android.content.Context;
import android.net.Uri;
import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.utils.okhttp.OkHttpUtil;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import rxhttp.wrapper.annotations.NonNull;
```

### 定义QQ类
```
public class QQ extends Spider {
  protected JSONObject dn;
  protected JSONObject q = new JSONObject();
//定义方法
 private String q(String str, String str2){}
//重写
public String categoryContent(String str, String str2, boolean z, HashMap<String, String> hashMap){}
//重新
 public String detailContent(List<String> list){}
//获得头数据
protected HashMap<String, String> getHeaders(String str){}
//重写
 public String homeContent(boolean z){}
//重写
  public String homeVideoContent() {}
//重写
public void init(Context context){}
//未知
public String join(@NonNull CharSequence charSequence, @NonNull Iterable iterable) {}
//重写
public String playerContent(String str, String str2, List<String> list){}
}
```
## LiteApple.java


```
//导包
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;

import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.utils.Misc;
import com.github.catvod.utils.okhttp.OKCallBack;
import com.github.catvod.utils.okhttp.OkHttpUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

import okhttp3.Call;
```

### 定义LiteApple类
```
public class LiteApple extends Spider{
 private static final String siteUrl = "http://ht.grelighting.cn/api.php";
 //获得头数据
 private HashMap<String, String> getHeaders(String url, String data){}
 private String fakeDevice = null;
 private String tokenKey = null;
public void init(Context context, String extend){}
//获得token
void getTokenKey()
//重写
 public String homeContent(boolean filter){}
//重写
 public String homeVideoContent(){}
//重写
 public String categoryContent(String tid, String pg, boolean filter, HashMap<String, String> extend){}
//重写
  public String detailContent(List<String> ids) {}
//重写

public String playerContent(String flag, String id, List<String> vipFlags){}
//重写
public String searchContent(String key, boolean quick){}
//自定义
protected String decryptResponse(String src){}
//自定义

byte[] a(String str){}
byte[] b(byte[] bArr, String str) {}
String randomString(int length) {}
String randomMACAddress() {}
String fakeDid(){}
String md5(String str){}
```



}
