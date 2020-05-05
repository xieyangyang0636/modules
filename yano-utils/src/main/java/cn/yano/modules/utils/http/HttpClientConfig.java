package cn.yano.modules.utils.http;

/**
 * Created by xieyangyang0636 on 2020/1/19.
 */
public class HttpClientConfig {
    /**
     * 最大连接数
     */
    private Integer maxTotal;

    /**
     * 并发数
     */
    private Integer defaultMaxPerRoute;

    /**
     * 创建连接的最长时间
     */
    private Integer connectTimeout;

    /**
     * 从连接池中获取到连接的最长时间
     */
    private Integer connectionRequestTimeout;

    /**
     * 数据传输的最长时间
     */
    private Integer socketTimeout;

    /**
     * 提交请求前测试连接是否可用
     */
    private boolean staleConnectionCheckEnabled;

    public HttpClientConfig(Integer maxTotal, Integer defaultMaxPerRoute, Integer connectTimeout,
                            Integer connectionRequestTimeout, Integer socketTimeout, boolean staleConnectionCheckEnabled) {
        this.maxTotal = maxTotal;
        this.defaultMaxPerRoute = defaultMaxPerRoute;
        this.connectTimeout = connectTimeout;
        this.connectionRequestTimeout = connectionRequestTimeout;
        this.socketTimeout = socketTimeout;
        this.staleConnectionCheckEnabled = staleConnectionCheckEnabled;
    }

    public HttpClientConfig() {
    }

    public Integer getMaxTotal() {
        return maxTotal;
    }

    public Integer getDefaultMaxPerRoute() {
        return defaultMaxPerRoute;
    }

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    public Integer getConnectionRequestTimeout() {
        return connectionRequestTimeout;
    }

    public Integer getSocketTimeout() {
        return socketTimeout;
    }

    public boolean isStaleConnectionCheckEnabled() {
        return staleConnectionCheckEnabled;
    }
}