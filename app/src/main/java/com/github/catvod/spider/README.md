QQ.java
����

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
//����QQ��
public class QQ extends Spider {
  protected JSONObject dn;
  protected JSONObject q = new JSONObject();
//���巽��
 private String q(String str, String str2){}
//��д
public String categoryContent(String str, String str2, boolean z, HashMap<String, String> hashMap){}
//��д
 public String detailContent(List<String> list){}
//���巽��
//protected HashMap<String, String> getHeaders(String str){}
//��д
 public String homeContent(boolean z){}
//��д
  public String homeVideoContent() {}
//��д
public void init(Context context){}
//δ֪
public String join(@NonNull CharSequence charSequence, @NonNull Iterable iterable) {}
//��д
public String playerContent(String str, String str2, List<String> list){}
//��д
}

LiteApple.java


//����
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


public class LiteApple extends Spider{
 private static final String siteUrl = "http://ht.grelighting.cn/api.php";
//���ͷ
 private HashMap<String, String> getHeaders(String url, String data){}
 private String fakeDevice = null;
 private String tokenKey = null;
public void init(Context context, String extend){}
//���token
void getTokenKey() 
//��д
 public String homeContent(boolean filter){}
//��д
 public String homeVideoContent(){}
//��д
 public String categoryContent(String tid, String pg, boolean filter, HashMap<String, String> extend){}
//��д
  public String detailContent(List<String> ids) {}

//��д
public String playerContent(String flag, String id, List<String> vipFlags){}
//��д
public String searchContent(String key, boolean quick){}
//�Զ���
protected String decryptResponse(String src){}
//�Զ���

byte[] a(String str){}
byte[] b(byte[] bArr, String str) {}
String randomString(int length) {}
String randomMACAddress() {}
String fakeDid(){}
String md5(String str){}



}
