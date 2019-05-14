package com.neuedu.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONObject;

/**
 * 
 * 发送https请求
 *
 */
public class CommonUtil {
	
	/**
     * 发送https请求
     * 
     * @param requestUrl 请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param outputStr 提交的数据
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
    public static JSONObject httpsRequest(String requestUrl, String requestMethod) {
        JSONObject jsonObject = null;
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = { new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(ssf);
            
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            conn.setRequestMethod(requestMethod);         

            // 从输入流读取返回内容
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            
            System.out.println("返回信息："+buffer);

            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            conn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (ConnectException ce) {
        	
        	System.out.println(ce.toString());
        	
            //log.error("连接超时：{}", ce);
        } catch (Exception e) {
            //log.error("https请求异常：{}", e);
        	System.out.println(e.toString());
        }
        return jsonObject;
    }
    
    public static void main(String[] args) {
    	
    	//根据code得到accesstoken, openid
    	JSONObject o = httpsRequest("https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx0156cb18976c3f90&secret=1bcb2d21ce527777ca4593bf452f48dc&code=071ZFuGj05fLQn1GszGj00fuGj0ZFuGa&grant_type=authorization_code","GET");		
		
		String access_token = o.getString("access_token");
		String openid = o.getString("openid");
		
		//根据accesstoken, openid得到用户信息
		String url = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
		url = url.replace("ACCESS_TOKEN", access_token);
		url = url.replace("OPENID", openid);
		
		System.out.println(url);
		
		JSONObject o2 = httpsRequest(url,"GET");
		System.out.println("昵称是："+o2.getString("nickname"));
		System.out.println("姓名是："+o2.getString("sex"));
		System.out.println("头像是："+o2.getString("headimgurl"));
		
	}

}
