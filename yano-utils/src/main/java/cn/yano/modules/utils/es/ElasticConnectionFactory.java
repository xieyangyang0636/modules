package cn.yano.modules.utils.es;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;

/**
 * Created by xieyangyang0636 on 2020/1/19.
 */
public class ElasticConnectionFactory implements ConnectionFactory<TransportClient> {
    private Logger LOGGER = LoggerFactory.getLogger(ElasticConnectionFactory.class);
    private String clusterName;
    private boolean clientTransportSniff;
    private String clientPingTimeout;
    private String clientNodesSamplerInterval;
    private Settings settings;
    private String nodes;

    public ElasticConnectionFactory(String clusterName, String nodes) {
        this(clusterName, nodes, false, "5s", "5s");
    }

    public ElasticConnectionFactory(ElasticConnectorSinkConfig config) {
        this.nodes = config.getString(ElasticConnectorSinkConfig.ELASTIC_NODES_CONFIG);
        this.clusterName = config.getString(ElasticConnectorSinkConfig.CLUSTER_NAME_CONFIG);
        this.clientTransportSniff = config.getBoolean(ElasticConnectorSinkConfig.CLIENT_TRANS_SNIFF_CONIFG);
        this.clientNodesSamplerInterval = config.getString(
                ElasticConnectorSinkConfig.CLIENT_TRANS_NODES_SAMPLER_INTERVAL_CONFIG);
        this.clientPingTimeout = config.getString(ElasticConnectorSinkConfig.CLIENT_TRANS_PING_TIMEOUT_CONFIG);
    }

    public ElasticConnectionFactory(String clusterName, String nodes, boolean clientTransportSniff,
                                  String clientPingTimeout, String clientNodesSamplerInterval) {
        this.nodes = nodes;
        this.clusterName = clusterName;
        this.clientTransportSniff = clientTransportSniff;
        this.clientPingTimeout = clientPingTimeout;
        this.clientNodesSamplerInterval = clientNodesSamplerInterval;
    }

    @Override
    public PooledObject<TransportClient> makeObject() throws Exception {
        TransportClient client=createConnection();
        return new DefaultPooledObject<>(client);
    }

    @Override
    public void destroyObject(PooledObject<TransportClient> pool) throws Exception {
        Client client = pool.getObject();
        if(client!=null){
            client.close();
        }

    }

    @Override
    public boolean validateObject(PooledObject<TransportClient> pooledObject) {
        
        return true;
    }

    @Override
    public void activateObject(PooledObject<TransportClient> pool) throws Exception {
        TransportClient client= pool.getObject();
        if(client!=null){
            client.connectedNodes();
        }
    }

    @Override
    public void passivateObject(PooledObject<TransportClient> pooledObject) throws Exception {
    }

    private Settings initSettings() {
        Settings settings = Settings.settingsBuilder()
                .put(ElasticConnectorSinkConfig.CLUSTER_NAME_CONFIG, clusterName)
                .put(ElasticConnectorSinkConfig.CLIENT_TRANS_SNIFF_CONIFG, clientTransportSniff)
                .put(ElasticConnectorSinkConfig.CLIENT_TRANS_PING_TIMEOUT_CONFIG, clientPingTimeout)
                .put(ElasticConnectorSinkConfig.CLIENT_TRANS_NODES_SAMPLER_INTERVAL_CONFIG,
                        clientNodesSamplerInterval)
                .build();
        return settings;
    }

    @Override
    public TransportClient createConnection() throws IOException {
        if (settings == null) {
            synchronized (this) {
                settings = initSettings();
            }
        }
        LOGGER.debug("establish connection to elasticsearch");
        TransportClient client = TransportClient.builder().settings(settings).build();
        Preconditions.checkNotNull(nodes, "es nodes cannot be null");
        for (String node : nodes.split(",")) {
            String host = StringUtils.substringBefore(node, ":");
            String port = StringUtils.substringAfter(node, ":");
            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), Integer.valueOf(port)));
        }
        return client;
    }
}
