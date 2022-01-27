package erii.erii.common;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname test
 * @Description TODO
 * @Date 2022/1/2 18:14
 * @Created by Administrator
 */
public class test {
    public static void main(String[] args) {
        get();
    }
    private static void get() {



        // 创建 HttpClient 客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 创建 HttpGet 请求
        HttpGet httpGet = new HttpGet("http://121.40.83.129:6610/api/projects/1");
        // 设置长连接
        httpGet.setHeader("Connection", "keep-alive");
        // 设置代理（模拟浏览器版本）
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
        // 设置 Cookie
        //httpGet.setHeader("Cookie", "JSESSIONID: node01cr3tndrfgydi1m43w8ktmf5fj22.node0");


        //设置用户验证
        String username = "erii";
        String password = "erii123456";

        //String authHeader = new sun.misc.BASE64Encoder().encode((username + ":" + password).getBytes());
        String authHeader = DatatypeConverter.printBase64Binary((username + ":" + password).getBytes());
        httpGet.setHeader("Authorization", "Basic "+authHeader);



        CloseableHttpResponse httpResponse = null;
        try {
            // 请求并获得响应结果
            httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            // 输出请求结果
            System.out.println("================================================");
            System.out.println(EntityUtils.toString(httpEntity));
            System.out.println("================================================");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 无论如何必须关闭连接
        finally {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
