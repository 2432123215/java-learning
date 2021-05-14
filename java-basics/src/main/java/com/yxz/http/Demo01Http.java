package com.yxz.http;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @ClassName: Demo01Http
 * @Description: http请求
 * @Author: yangxiangzhong
 * @Date 2021/4/21
 * @Version 1.0
 **/
public class Demo01Http {
    public static void main(String[] args) {
        String url = "http://10.3.152.3:32152/dorado/api/v1/wgjEdor/cusQueryPolicy";
        String s = "{\n" +
                "    \"head\": {\n" +
                "        \"tid\": \"1614516048215695263\",\n" +
                "        \"aid\": \"app\",\n" +
                "        \"zone\": \"UTC+8\",\n" +
                "        \"time\": \"Sun Feb 28 20:40:48 GMT+08:00 2021\",\n" +
                "        \"asyn\": \"N\",\n" +
                "        \"sign\": \"\"\n" +
                "    },\n" +
                "    \"body\": {\n" +
                "        \"customerNo\": \"0001156008\"\n" +
                "    }\n" +
                "}";
//        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject1 = JSONObject.parseObject(s);
        String s1 = null;
        s1 = httpPost(url, jsonObject1);
        System.out.println(s1);
        System.out.println("你好啊");
    }

    /**
     * JSONObject jsonParam = new JSONObject();
     * jsonParam.put("name", "admin");
     * jsonParam.put("pass", "123456");
     *
     * @param url
     * @param jsonParam
     * @return
     * @throws IOException
     */
    public static String httpPost(String url, JSONObject jsonParam) {
        String str="";
        try {
            int i = 1 / 0;
            //(1) 创建HttpClient对象。
            CloseableHttpClient httpClient = HttpClients.createDefault();
            //(2)创建请求方法的实例，并指定请求URL。如果需要发送GET请求，创建HttpGet对象；
            // 如果需要发送POST请求，创建HttpPost对象。
            HttpPost post = new HttpPost(url);
            //(3) 如果需要发送请求参数，可调用HttpGet同的setParams(HetpParams params)方法来添加请求参数；
            // 对于HttpPost对象而言，可调用setEntity(HttpEntity entity)方法来设置请求参数。
            StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            post.setEntity(entity);
            //(4) 调用HttpClient对象的execute(HttpUriRequest request)发送请求，该方法返回一个HttpResponse。
            CloseableHttpResponse response = httpClient.execute(post);
            //(5) 调用HttpResponse的getAllHeaders()、getHeaders(String name)等方法可获取服务器的响应头；
            // 调用HttpResponse的getEntity()方法可获取HttpEntity对象，该对象包装了服务器的响应内容。
            // 程序可通过该对象获取服务器的响应内容。
            HttpEntity news = response.getEntity();
            str = EntityUtils.toString(news, "utf-8");
            //(6) 释放连接。无论执行方法是否成功，都必须释放连接
            httpClient.close();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }



}
