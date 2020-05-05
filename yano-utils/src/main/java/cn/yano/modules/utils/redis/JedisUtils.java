package cn.yano.modules.utils.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * Jedis工具类
 * Created by xieyangyang0636 on 2020/1/19.
 **/
public class JedisUtils {

    /**
     * 获取 HostAndPort对象
     *
     * @param hostAndPort hostAndPort
     * @return HostAndPort对象
     */
    public static Set<HostAndPort> getHostAndPortSet(String hostAndPort) {
        Set<HostAndPort> nodeSet = new HashSet<>();
        String[] list = hostAndPort.split(",");
        for (String str : list) {
            String[] hp = str.split(":");
            nodeSet.add(new HostAndPort(hp[0], Integer.valueOf(hp[1])));
        }
        return nodeSet;
    }

    /**
     * 获取JedisCluster
     *
     * @param clusterNodes 连接信息
     * @param password     密码
     * @return JedisCluster
     * @throws Exception
     */
    public static JedisCluster getJedisCluster(String clusterNodes,
                                               String password) throws Exception {
        Set<HostAndPort> nodeSet = getHostAndPortSet(clusterNodes);
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(200);
        poolConfig.setMaxIdle(100);
        poolConfig.setMinIdle(10);
        poolConfig.setMaxWaitMillis(5000);
        poolConfig.setTestOnBorrow(false);
        poolConfig.setTestOnReturn(false);
        return new JedisCluster(nodeSet, 5000, 5000, 3, password, poolConfig);
    }

    /**
     * 获取JedisCluster
     *
     * @param clusterNodes      连接信息
     * @param password          密码
     * @param maxTotal          最大连接数
     * @param maxIdle           最大空闲数
     * @param minIdle           最小空闲数
     * @param maxWaitMillis     最大等待时间
     * @param connectionTimeout 连接超时数据
     * @param soTimeout         读超时时间
     * @param maxAttempts       最大尝试次数
     * @return JedisCluster
     * @throws Exception
     */
    public static JedisCluster getJedisCluster(String clusterNodes,
                                               String password,
                                               int maxTotal,
                                               int maxIdle,
                                               int minIdle,
                                               int maxWaitMillis,
                                               int connectionTimeout,
                                               int soTimeout,
                                               int maxAttempts) throws Exception {
        Set<HostAndPort> nodeSet = getHostAndPortSet(clusterNodes);
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(maxTotal);
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMinIdle(minIdle);
        poolConfig.setMaxWaitMillis(maxWaitMillis);
        poolConfig.setTestOnBorrow(false);
        poolConfig.setTestOnReturn(false);
        return new JedisCluster(nodeSet, connectionTimeout, soTimeout, maxAttempts, password, poolConfig);
    }

    /**
     * 获取JedisCluster
     *
     * @param clusterNodes 连接信息
     * @return JedisCluster
     * @throws Exception
     */
    public static JedisCluster getJedisCluster(String clusterNodes) throws Exception {
        Set<HostAndPort> nodeSet = getHostAndPortSet(clusterNodes);
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(200);
        poolConfig.setMaxIdle(100);
        poolConfig.setMinIdle(10);
        poolConfig.setMaxWaitMillis(5000);
        poolConfig.setTestOnBorrow(false);
        poolConfig.setTestOnReturn(false);
        return new JedisCluster(nodeSet, 5000, 5000, 3, poolConfig);
    }

    /**
     * 获取JedisCluster
     *
     * @param clusterNodes      连接信息
     * @param maxTotal          最大连接数
     * @param maxIdle           最大空闲数
     * @param minIdle           最小空闲数
     * @param maxWaitMillis     最大等待时间
     * @param connectionTimeout 连接超时数据
     * @param soTimeout         读超时时间
     * @param maxAttempts       最大尝试次数
     * @return JedisCluster
     * @throws Exception
     */
    public static JedisCluster getJedisCluster(String clusterNodes,
                                               int maxTotal,
                                               int maxIdle,
                                               int minIdle,
                                               int maxWaitMillis,
                                               int connectionTimeout,
                                               int soTimeout,
                                               int maxAttempts) throws Exception {
        Set<HostAndPort> nodeSet = getHostAndPortSet(clusterNodes);
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(maxTotal);
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMinIdle(minIdle);
        poolConfig.setMaxWaitMillis(maxWaitMillis);
        poolConfig.setTestOnBorrow(false);
        poolConfig.setTestOnReturn(false);
        return new JedisCluster(nodeSet, connectionTimeout, soTimeout, maxAttempts, poolConfig);
    }

}
