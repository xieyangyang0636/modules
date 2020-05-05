package cn.yano.modules.utils.es;

import cn.yano.modules.modal.config.AbstractConfig;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xieyangyang0636 on 2020/1/19.
 */
public class ElasticConnectorSinkConfig extends AbstractConfig {
    //elasticsearch nodes
    public static final String  ELASTIC_NODES_CONFIG="es.nodes";
    private static final String ELASTIC_NODES_DEFAULT="localhost:9300";
    //cluster name
    public static final String  CLUSTER_NAME_CONFIG="cluster.name";
    private static final String CLUSTER_NAME_DEFAULT="networkcountly";
    //indice
    public static final String  ELASTIC_INDICE_CONFIG="es.indice";
    //client.transport.sniff
    public static final String CLIENT_TRANS_SNIFF_CONIFG ="client.transport.sniff";
    private static final boolean CLIENT_TRANS_SNIFF_DEFAULT =false;
    //The time to wait for a ping response from a node
    public static final String CLIENT_TRANS_PING_TIMEOUT_CONFIG ="client.transport.ping_timeout";
    private static final String CLIENT_TRANS_PING_TIMEOUT_DEFAULT ="5s";
    //How often to sample / ping the nodes listed and connected
    public static final String CLIENT_TRANS_NODES_SAMPLER_INTERVAL_CONFIG ="client.transport.nodes_sampler_interval";
    private static final String CLIENT_TRANS_NODES_SAMPLER_INTERVAL_DEFAULT ="5s";
    //client connection max pool size
    public static final String CLIENT_CONN_MAX_TOTAL_CONFIG="client.conn.max.total";
    private static final int  CLIENT_CONN_MAX_TOTOL_DEFAULT=10;
    //client connection min idele size
    public static final String CLIENT_CONN_MIN_IDLE_CONFIG="client.conn.min.idle";
    private static final int  CLIENT_CONN_MIN_IDLE_DEFAULT=0;
    //client write buffer size
    public static final String CLIENT_WRITE_BUFFER_SIZE_CONFIG="client.write.bufferSize";
    private static final long CLIENT_WRITE_BUFFER_SIZE_DEFAULT=2000L;
    //table that doesnot index
    public  static final String INDEX_INTERCEPT_TABLES_CONFIG="indice.intercept.tables";
    public  static final String INDEX_INTERCEPT_TABLES_DEFAULT="";
    private  static final  Map<String,Object> defConfig;
    private static final Set<String> configKeys;

    static{
        defConfig=new HashMap<>();
        defConfig.put(ELASTIC_NODES_CONFIG,ELASTIC_NODES_DEFAULT);
        defConfig.put(CLUSTER_NAME_CONFIG,CLUSTER_NAME_DEFAULT);
        defConfig.put(CLIENT_TRANS_SNIFF_CONIFG, CLIENT_TRANS_SNIFF_DEFAULT);
        defConfig.put(CLIENT_TRANS_PING_TIMEOUT_CONFIG, CLIENT_TRANS_PING_TIMEOUT_DEFAULT);
        defConfig.put(CLIENT_TRANS_NODES_SAMPLER_INTERVAL_CONFIG, CLIENT_TRANS_NODES_SAMPLER_INTERVAL_DEFAULT);

        defConfig.put(CLIENT_CONN_MAX_TOTAL_CONFIG,CLIENT_CONN_MAX_TOTOL_DEFAULT);
        defConfig.put(CLIENT_CONN_MIN_IDLE_CONFIG,CLIENT_CONN_MIN_IDLE_DEFAULT);
        defConfig.put(ELASTIC_INDICE_CONFIG,CLUSTER_NAME_DEFAULT);
        defConfig.put(CLIENT_WRITE_BUFFER_SIZE_CONFIG,CLIENT_WRITE_BUFFER_SIZE_DEFAULT);
        defConfig.put(INDEX_INTERCEPT_TABLES_CONFIG,INDEX_INTERCEPT_TABLES_DEFAULT);
        configKeys=new HashSet<>();
        configKeys.addAll(defConfig.keySet());
    }

    public ElasticConnectorSinkConfig(String configFile) {
        super();
        addConfig(defConfig);
        loadConfigFromFile(configFile);
        addConfigKeys(ServiceType.ELASTIC,configKeys);
    }
    public ElasticConnectorSinkConfig(Map<String,Object> config){
        super();
        addConfig(defConfig);
        addConfig(config);
        addConfigKeys(ServiceType.ELASTIC,configKeys);
    }
    public Map<String,Object> getConf(){
        return super.getConfigByType(ServiceType.ELASTIC);
    }
}
