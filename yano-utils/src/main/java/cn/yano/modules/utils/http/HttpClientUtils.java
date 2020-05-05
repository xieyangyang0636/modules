package cn.yano.modules.utils.http;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by xieyangyang0636 on 2020/1/19.
 */
public class HttpClientUtils {

    private volatile static HttpClientUtils httpClientUtils;

    private RequestConfig config;
    private RequestConfig.Builder builder;
    private PoolingHttpClientConnectionManager httpClientConnectionManager;
    private HttpClientBuilder httpClientBuilder;

    /**
     * DCL 获取单例
     * @param httpConfig
     * @return
     */
    public static HttpClientUtils getInstance(HttpClientConfig httpConfig) {
        if (httpClientUtils == null) {
            synchronized (HttpClientUtils.class) {
                if (httpClientUtils == null) {
                    httpClientUtils = new HttpClientUtils(httpConfig);
                }
            }
        }
        return httpClientUtils;
    }

    private HttpClientUtils(HttpClientConfig httpConfig) {
        initHttpClientConnectionManager(httpConfig.getMaxTotal(), httpConfig.getDefaultMaxPerRoute());
        initBuilder(httpConfig.getConnectTimeout(), httpConfig.getConnectionRequestTimeout(), httpConfig.getSocketTimeout(), httpConfig.isStaleConnectionCheckEnabled());
        initRequestConfig(this.builder);
        initHttpClientBuilder(this.httpClientConnectionManager);

        new IdleConnectionEvictor(this.httpClientConnectionManager);
    }

    /**
     * 实例化一个连接池管理器，设置最大连接数、并发连接数
     * @return
     */
    private void initHttpClientConnectionManager(int maxTotal, int defaultMaxPerRoute){
        PoolingHttpClientConnectionManager httpClientConnectionManager = new PoolingHttpClientConnectionManager();
        //最大连接数
        httpClientConnectionManager.setMaxTotal(maxTotal);
        //并发数
        httpClientConnectionManager.setDefaultMaxPerRoute(defaultMaxPerRoute);
        httpClientConnectionManager.setDefaultConnectionConfig(
                ConnectionConfig.custom().setCharset(Charset.forName("UTF-8")).build());
        this.httpClientConnectionManager = httpClientConnectionManager;
    }

    /**
     * 实例化连接池，设置连接池管理器。
     * 这里需要以参数形式注入上面实例化的连接池管理器
     * @param httpClientConnectionManager
     * @return
     */
    private void initHttpClientBuilder(PoolingHttpClientConnectionManager httpClientConnectionManager){
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        httpClientBuilder.setConnectionManager(httpClientConnectionManager);
        httpClientBuilder.setDefaultRequestConfig(this.config);
        this.httpClientBuilder = httpClientBuilder;
    }

    /**
     * Builder是RequestConfig的一个内部类
     * 通过RequestConfig的custom方法来获取到一个Builder对象
     * 设置builder的连接信息
     * 这里还可以设置proxy，cookieSpec等属性。有需要的话可以在此设置
     * @return
     */
    private void initBuilder(int connectTimeout, int connectionRequestTimeout, int socketTimeout, boolean staleConnectionCheckEnabled) {
        RequestConfig.Builder builder = RequestConfig.custom();
        this.builder = builder.setConnectTimeout(connectTimeout)
                .setConnectionRequestTimeout(connectionRequestTimeout)
                .setSocketTimeout(socketTimeout)
                .setStaleConnectionCheckEnabled(staleConnectionCheckEnabled);
    }

    /**
     * 使用builder构建一个RequestConfig对象
     * @param builder
     * @return
     */
    private void initRequestConfig(RequestConfig.Builder builder){
        this.config = builder.build();
    }

    /**
     * 通过连接池获取httpClient
     * @return
     */
    private CloseableHttpClient getCloseableHttpClient(){
        return this.httpClientBuilder.build();
    }


    /**
     * 不带参数的get请求，如果状态码为200，则返回body，如果不为200，则返回null
     *
     * @param url
     * @return
     * @throws Exception
     */
    public HttpResponseEntity doGet(String url) throws IOException {
        // 声明 http get 请求
        HttpGet httpGet = new HttpGet(url);

        return getHttpResponse(httpGet);
    }

    /**
     * 带参数的get请求，如果状态码为200，则返回body，如果不为200，则返回null
     *
     * @param url
     * @return
     * @throws Exception
     */
    public HttpResponseEntity doGet(String url, Map<String, Object> params) throws IOException, URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(url);

        if (params != null) {
            // 遍历map,拼接请求参数
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                uriBuilder.setParameter(entry.getKey(), entry.getValue().toString());
            }
        }

        return this.doGet(uriBuilder.toString());
    }

    /**
     * 带参数的get请求，允许自定义请求头
     * @param url 地址
     * @param params 参数
     * @param headers 请求头
     * @return
     * @throws IOException
     * @throws URISyntaxException
     */
    public HttpResponseEntity doGet(String url, Map<String, Object> params, Map<String, String> headers) throws IOException, URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(url);

        if (params != null) {
            // 遍历map,拼接请求参数
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                uriBuilder.setParameter(entry.getKey(), entry.getValue().toString());
            }
        }

        // 声明 http get 请求
        HttpGet httpGet = new HttpGet(uriBuilder.toString());

        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpGet.setHeader(entry.getKey(), entry.getValue());
            }
        }

        return getHttpResponse(httpGet);
    }

    /**
     * 带参数的post请求
     *
     * @param url
     * @param params
     * @return
     * @throws Exception
     */
    public HttpResponseEntity doPost(String url, Map<String, Object> params) throws IOException {
        return this.doPost(url, null, params, null);
    }

    /**
     * 原生body
     * @param url
     * @param body
     * @return
     * @throws Exception
     */
    public HttpResponseEntity doPost(String url, String body) throws IOException {
        return this.doPost(url, null, null, body);
    }

    /**
     * post请求
     *
     * @param url
     * @param params
     * @return
     * @throws Exception
     */
    public HttpResponseEntity doPost(String url, Map<String, String> headers, Map<String, Object> params, String body) throws IOException {
        // 声明httpPost请求
        HttpPost httpPost = new HttpPost(url);

        // 判断map是否为空，不为空则进行遍历，封装from表单对象
        if (params != null) {
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                list.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
            }
            // 构造from表单对象
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list, "UTF-8");

            // 把表单放到post里
            httpPost.setEntity(urlEncodedFormEntity);
        }

        // raw body
        if (body != null) {
            httpPost.setEntity(new StringEntity(body, "UTF-8"));
        }

        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpPost.setHeader(entry.getKey(), entry.getValue());
            }
        }

        return getHttpResponse(httpPost);
    }

    /**
     * 不带参数post请求
     *
     * @param url
     * @return
     * @throws Exception
     */
    public HttpResponseEntity doPost(String url) throws IOException {
        return this.doPost(url, null, null, null);
    }

    private HttpResponseEntity getHttpResponse(HttpUriRequest httpRequest) throws IOException {
        // 发起请求
        CloseableHttpResponse response = getCloseableHttpClient().execute(httpRequest);
        return getResponseEntity(response);
    }

    private HttpResponseEntity getResponseEntity(HttpResponse response) throws IOException {
        int code = response.getStatusLine().getStatusCode();
        String entity = EntityUtils.toString(response.getEntity(), "UTF-8");
        return HttpResponseEntity.build(code, entity);
    }
}
