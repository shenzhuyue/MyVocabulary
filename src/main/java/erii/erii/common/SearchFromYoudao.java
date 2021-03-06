//package erii.erii.common;
//
//import org.apache.http.Header;
//import org.apache.http.HttpEntity;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.util.EntityUtils;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.IOException;
//
//import java.io.*;
//import java.nio.charset.StandardCharsets;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//
//import java.util.*;
//
//
//
//
//
//public class SearchFromYoudao {
//
//    private static Logger logger = LoggerFactory.getLogger(SearchFromYoudao.class);
//
//    private static final String YOUDAO_URL = "https://openapi.youdao.com/api";
//
//    private static final String APP_KEY = "6a5d11394ce6cebc";
//
//    private static final String APP_SECRET = "1aLs38XLmH1KuphQCISWomE3O8qiygy5";
//    //这是请求体（bushi----是请求格式
//
//    public static String mySearch(String q,String from,String to) throws IOException {
//        Map<String,String> params = new HashMap<String,String>();
//        String salt = String.valueOf(System.currentTimeMillis());
//        params.put("from", from);
//        params.put("to", to);
//        params.put("signType", "v3");
//        String curtime = String.valueOf(System.currentTimeMillis() / 1000);
//        params.put("curtime", curtime);
//        String signStr = APP_KEY + truncate(q) + salt + curtime + APP_SECRET;
//        String sign = getDigest(signStr);
//        params.put("appKey", APP_KEY);
//        params.put("q", q);
//        params.put("salt", salt);
//        params.put("sign", sign);
//        /** 处理结果 */
//        return requestForHttp(YOUDAO_URL,params);
//    }
//
//
//    public static String requestForHttp(String url, Map<String,String> params) throws IOException {
//
//        /** 创建HttpClient */
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//
//        /** httpPost */
//        HttpPost httpPost = new HttpPost(url);
//        List<NameValuePair> paramsList = new ArrayList<NameValuePair>();
//        Iterator<Map.Entry<String,String>> it = params.entrySet().iterator();
//        while(it.hasNext()){
//            Map.Entry<String,String> en = it.next();
//            String key = en.getKey();
//            String value = en.getValue();
//            paramsList.add(new BasicNameValuePair(key,value));
//        }
//        httpPost.setEntity(new UrlEncodedFormEntity(paramsList,"UTF-8"));
//        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
//        try{
//            Header[] contentType = httpResponse.getHeaders("Content-Type");
//            logger.info("Content-Type:" + contentType[0].getValue());
//            if("audio/mp3".equals(contentType[0].getValue())){
////                //如果响应是wav
////                HttpEntity httpEntity = httpResponse.getEntity();
////                ByteArrayOutputStream baos = new ByteArrayOutputStream();
////                httpResponse.getEntity().writeTo(baos);
////                byte[] result = baos.toByteArray();
////                EntityUtils.consume(httpEntity);
////                if(result != null){//合成成功
////                    String file = "合成的音频存储路径"+System.currentTimeMillis() + ".mp3";
////                    byte2File(result,file);
////                }
//            }else{
//                /** 响应不是音频流，直接显示结果 */
//                HttpEntity httpEntity = httpResponse.getEntity();
//                String json = EntityUtils.toString(httpEntity,"UTF-8");
//                EntityUtils.consume(httpEntity);
//                logger.info(json);
//                return json;
//            }
//        }finally {
//            try{
//                if(httpResponse!=null){
//                    httpResponse.close();
//                }
//            }catch(IOException e){
//                logger.info("## release resouce error ##" + e);
//            }
//        }
//        return url;
//    }
//
//    /**
//     * 生成加密字段
//     */
//    public static String getDigest(String string) {
//        if (string == null) {
//            return null;
//        }
//        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
//        byte[] btInput = string.getBytes(StandardCharsets.UTF_8);
//        try {
//            MessageDigest mdInst = MessageDigest.getInstance("SHA-256");
//            mdInst.update(btInput);
//            byte[] md = mdInst.digest();
//            int j = md.length;
//            char str[] = new char[j * 2];
//            int k = 0;
//            for (byte byte0 : md) {
//                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
//                str[k++] = hexDigits[byte0 & 0xf];
//            }
//            return new String(str);
//        } catch (NoSuchAlgorithmException e) {
//            return null;
//        }
//    }
//
//    public static String truncate(String q) {
//        if (q == null) {
//            return null;
//        }
//        int len = q.length();
//        String result;
//        return len <= 20 ? q : (q.substring(0, 10) + len + q.substring(len - 10, len));
//    }
//
//
//}
