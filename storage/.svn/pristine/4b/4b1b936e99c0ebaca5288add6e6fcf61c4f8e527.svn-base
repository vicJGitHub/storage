package com.hywa.bigdata.storage.common;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;
import com.hywa.bigdata.storage.entity.HouseBigEntrepotEntity;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.*;

public class HttpClientUtil {
    /**
     * @param url    :url
     * @param params :参数
     * @return 返回的字符串
     * @Description 处理http请求的post方法
     */
	public static String post(String url, Hashtable<String, String> params) {
        CloseableHttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = "";
        try {
            httpClient = HttpClients.createDefault();
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(4000).setConnectTimeout(4000).build();
            httpPost = new HttpPost(url);
            httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
            httpPost.setConfig(requestConfig);
            List<NameValuePair> ps = new ArrayList<NameValuePair>();
            for (String pKey : params.keySet()) {
                ps.add(new BasicNameValuePair(pKey, params.get(pKey)));
            }
            System.out.println("json:"+ps);
            StringEntity se = new StringEntity(JsonUtils.objectToJson(ps));
           // UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(ps, "utf-8");
            //urlEncodedFormEntity.setContentType("text/json");
            se.setContentType("text/json");
            httpPost.setEntity(se);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();

            result = EntityUtils.toString(httpEntity, "utf-8");

        } catch (ClientProtocolException e) {
            result = "";
        } catch (IOException e) {
            result = "";
        } finally {
            try {
                if (httpPost != null) {
                    httpPost.releaseConnection();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                result = "";
            }
        }
        return result;
    }

    /**
     * @param url    :url
     * @param params :参数
     * @return 返回的字符串
     * @Description 处理http请求的get方法
     */
    public static String get(String url, Hashtable<String, String> params) {
        CloseableHttpClient httpClient = null;
        HttpGet httpGet = null;

        String result = "";
        try {
            httpClient = HttpClients.createDefault();
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(4000).setConnectTimeout(4000).build();
            String ps = "";
            for (String pKey : params.keySet()) {
                if (!"".equals(ps)) {
                    ps = ps + "&";
                }
                // 处理特殊字符，%替换成%25，空格替换为%20，#替换为%23
                String pValue = params.get(pKey).replace("%", "%25")
                        .replace(" ", "%20").replace("#", "%23")/*.replace("\"", "%22")
                        .replace(":", "%3A").replace(",", "%2C").replace("[", "%5B")
                        .replace("]", "%5D").replace("{", "%7B").replace("}", "%7D").replace("/", "%2F")*/;
                ps += pKey + "=" + pValue;
            }
           // ps = URLEncoder.encode(ps, "UTF-8");
            if (!"".equals(ps)&&!url.contains("?")) {
                url = url + "?" + ps;
            }
            /*if(!"".equals(ps)&&url.contains("?")) {
            	url=url+"&"+ps;
            }*/
            //url = url.replaceAll("/",  "%2F");
            httpGet = new HttpGet(url);
            httpGet.setConfig(requestConfig);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity httpEntity = response.getEntity();
            result = EntityUtils.toString(httpEntity, "utf-8");
        } catch (ClientProtocolException e) {
            result = "";
        } catch (IOException e) {
            result = "";
        } catch (Exception e) {
        	System.out.println(ExceptionUtil.getStackTrace(e));
            result = "";
        } finally {
            try {
                if (httpGet != null) {
                    httpGet.releaseConnection();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                result = "";
            }
        }
        return result;
    }

    /**
     * @param url    :url
     * @param params :参数
     * @return 返回的字符串
     * @Description 处理https请求的post方法
     */
    public static String postSSL(String url, Hashtable<String, String> params) {
        CloseableHttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = "";
        try {
            httpClient = (CloseableHttpClient) wrapClient();
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(4000).setConnectTimeout(4000).build();
            httpPost = new HttpPost(url);
            httpPost.setConfig(requestConfig);
            List<NameValuePair> ps = new ArrayList<NameValuePair>();
            for (String pKey : params.keySet()) {
                ps.add(new BasicNameValuePair(pKey, params.get(pKey)));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(ps, "utf-8"));
            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();

            result = EntityUtils.toString(httpEntity, "utf-8");

        } catch (ClientProtocolException e) {
            result = "";
        } catch (IOException e) {
            result = "";
        } finally {
            try {
                if (httpPost != null) {
                    httpPost.releaseConnection();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                result = "";
            }
        }
        return result;
    }

    /**
     * @param url    :url
     * @param params :参数
     * @return 返回的字符串
     * @Description 处理https请求的get方法
     */
    public static String getSSL(String url, Hashtable<String, String> params) {
        CloseableHttpClient httpClient = null;
        HttpGet httpGet = null;

        String result = "";
        try {
            httpClient = (CloseableHttpClient) wrapClient();
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(4000).setConnectTimeout(4000).build();
            String ps = "";
            for (String pKey : params.keySet()) {
                if (!"".equals(ps)) {
                    ps = ps + "&";
                }
                // 处理特殊字符，%替换成%25，空格替换为%20，#替换为%23
                String pValue = params.get(pKey).replace("%", "%25")
                        .replace(" ", "%20").replace("#", "%23");
                ps += pKey + "=" + pValue;
            }
            if (!"".equals(ps)) {
                url = url + "?" + ps;
            }
            httpGet = new HttpGet(url);
            httpGet.setConfig(requestConfig);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity httpEntity = response.getEntity();
            result = EntityUtils.toString(httpEntity, "utf-8");
        } catch (ClientProtocolException e) {
            result = "";
        } catch (IOException e) {
            result = "";
        } catch (Exception e) {
            result = "";
        } finally {
            try {
                if (httpGet != null) {
                    httpGet.releaseConnection();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                result = "";
            }
        }
        return result;
    }


    /**
     * @return HttpClient
     * @Description 创建一个不进行正式验证的请求客户端对象 不用导入SSL证书
     */
    public static HttpClient wrapClient() {
        try {
            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(X509Certificate[] arg0,
                                               String arg1) throws CertificateException {
                }

                public void checkServerTrusted(X509Certificate[] arg0,
                                               String arg1) throws CertificateException {
                }
            };
            ctx.init(null, new TrustManager[]{tm}, null);
            SSLConnectionSocketFactory ssf = new SSLConnectionSocketFactory(
                    ctx, NoopHostnameVerifier.INSTANCE);
            CloseableHttpClient httpclient = HttpClients.custom()
                    .setSSLSocketFactory(ssf).build();
            return httpclient;
        } catch (Exception e) {
            return HttpClients.createDefault();
        }
    }

    /**
     * @param params :字符串的入参
     * @param files  :大数据的入参
     * @return HttpClient
     * @Description 创建一个HTTPEntity对象
     */
    public static HttpEntity makeMultipartEntity(List<NameValuePair> params,
                                                 Map<String, File> files) {

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE); // 如果有SocketTimeoutException等情况，可修改这个枚举
        if (params != null && params.size() > 0) {
            for (NameValuePair p : params) {
                builder.addTextBody(p.getName(), p.getValue(),
                        ContentType.TEXT_PLAIN.withCharset("UTF-8"));
            }
        }

        if (files != null && files.size() > 0) {
            Set<Map.Entry<String, File>> entries = files.entrySet();
            for (Map.Entry<String, File> entry : entries) {
                builder.addPart(entry.getKey(), new FileBody(entry.getValue()));
            }
        }

        return builder.build();

    }
    
    public static String lzhPost(String url,HouseBigEntrepotEntity houseBigEntrepot){
    	CloseableHttpClient httpclient=HttpClients.createDefault();
		HttpPost request=new HttpPost(url);
		request.setHeader("User-Agent","Koala Admin");
		request.setHeader("Content-Type","application/json");
		JSONObject json =new JSONObject();
		json.put("no", houseBigEntrepot.getNo());
		json.put("items", houseBigEntrepot.getItems());
		json.put("inputDate",  houseBigEntrepot.getInputDate());
		json.put("outInType", houseBigEntrepot.getOutInType());
		json.put("updateUser", houseBigEntrepot.getUpdateUser());
		request.setEntity(new StringEntity(json.toString(),"UTF-8"));
		HttpClientContext context=HttpClientContext.create();
		CloseableHttpResponse responese=null;
		try {
			responese = httpclient.execute(request,context);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			return EntityUtils.toString(responese.getEntity(),"UTF-8");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
    }

}