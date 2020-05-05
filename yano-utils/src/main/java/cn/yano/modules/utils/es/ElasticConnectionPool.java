package cn.yano.modules.utils.es;

import org.elasticsearch.client.transport.TransportClient;

/**
 * Created by xieyangyang0636 on 2020/1/19.
 */
public class ElasticConnectionPool extends PoolBase<TransportClient>
        implements ConnectionPool<TransportClient> {

    public ElasticConnectionPool(String nodes,String clusterName){
        this(nodes,clusterName,10,2);
    }

    public ElasticConnectionPool(String nodes,String clusterName,int maxTotal,int minIdle){
        super(new PoolConfig(maxTotal,minIdle),new ElasticConnectionFactory(clusterName,nodes));
    }
    public ElasticConnectionPool(PoolConfig poolConfig,String nodes,String clusterName){
        super(poolConfig,new ElasticConnectionFactory(clusterName,nodes));
    }
    public ElasticConnectionPool( ElasticConnectorSinkConfig config){
        super(new PoolConfig(config.getInt(ElasticConnectorSinkConfig.CLIENT_CONN_MAX_TOTAL_CONFIG),
                        config.getInt(ElasticConnectorSinkConfig.CLIENT_CONN_MIN_IDLE_CONFIG)),
                new ElasticConnectionFactory(config));
    }


    @Override
    public TransportClient getConnection() {
        return super.getResource();
    }

    @Override
    public void returnConnection(TransportClient conn) {
        super.returnResource(conn);

    }

    @Override
    public void invalidateConnection(TransportClient conn) {
       super.invalidateResource(conn);
    }
}
