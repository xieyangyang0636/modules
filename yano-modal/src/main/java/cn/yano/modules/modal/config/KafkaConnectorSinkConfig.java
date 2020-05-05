package cn.yano.modules.modal.config;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xieyangyang0636 on 2020/1/19.
 */
public class KafkaConnectorSinkConfig extends AbstractConfig {
    //bootstrap servers
    public static final String BOOTSTRAP_SERVERS_CONFIG = "bootstrap.servers";
    private static final String BOOTSTRAP_SERVERS_DEFAULT = "localhost:9092";
    //group id
    public static final String GROUP_ID_CONIFG = "group.id";
    private static final String GROUP_ID_DEFAULT = "test";
    //whether to auto commit the offset of consumer message,default false;
    public static final String ENABLE_AUTO_COMMIT_CONFIG = "enable.auto.commit";
    private static final String ENABLE_AUTO_COMMIT_DEFAULT = "false";
    //time interval to auto.commit,it only works when enable.auto.commit=true;
    public static final String AUTO_COMMIT_INTERVAL_MS_CONFIG = "auto.commit.interval.ms";
    private static final String AUTO_COMMIT_INTERVAL_MS_DEFAULT = "1000";
    //session Duration in milliseconds
    public static final String SESSION_TIMEOUT_MS_CONFIG = "session.timeout.ms";
    private static final String SESSION_TIMEOUT_MS_DEFAULT = "30000";

    public static final String REQUEST_TIMEOUT_MS_CONFIG = "request.timeout.ms";
    private static final String REQUEST_TIMEOUT_MS_DEFAULT = "50000";
    //for producer
    //message type for compression
    public static final String COMPRESSION_TYPE_CONFIG = "message.compression.type";
    private static final String COMPRESSION_TYPE_DEFAULT = "snappy";
    //fetch.message.max.bytes
    public static final String FETCH_MESSAGE_MAX_BYTES_CONFIG = "fetch.message.max.bytes";
    public static final String FETCH_MESSAGE_MAX_BYTES_DEFAULT = "1024*1024";
    //producer retries
    public static final String PRODUCER_RETRIES_CONFIG = "retries";
    private static final String PRODUCER_RETRIES_DEFAULT = "3";
    //batchSize of messages to producer to broker
    public static final String LINGER_TIME_CONFIG = "linger.ms";
    private static final String LINGER_TIME_DEFAULT = "50";
    //linger timeInterval to produce message
    public static final String BATCH_SIZE_CONFIG = "batch.size";
    private static final String BATCH_SIZE_DEFAULT = "32768";
    //acks
    public static final String MESSAGE_ACKS_CONFIG = "acks";
    private static final String MESSAGE_ACKS_DEFAULT = "1";
    //key and value serializer
    public static final String KEY_SERIALIZER_CONFIG = "key.serializer";
    private static final String KEY_SERIALIZER_DEFAULT = "org.apache.kafka.common.serialization.StringSerializer";
    public static final String VALUE_SERIALIZER_CONFIG = "value.serializer";
    private static final String VALUE_SERIALIZER_DEFAULT = "org.apache.kafka.common.serialization.ByteArraySerializer";
    //memory used for buffering the messages
    public static final String BUFFER_MEMORY_CONFIG = "buffer.memory";
    private static final String BUFFER_MEMORY_DEFAULT = "36555246";
    //auto.offset.reset
    public static final String AUTO_OFFSET_RESET_CONFIG = "auto.offset.reset";

    //for consumer
    //key and value desrializer
    public static final String KEY_DESERIALIZER_CONFIG = "key.deserializer";
    private static final String KEY_DESERIALIZER_DEFAULT =
            "org.apache.kafka.common.serialization.StringDeserializer";
    public static final String VALUE_DESERIALIZER_CONFIG = "value.deserializer";
    private static final String VALUE_DESERIALIZER_DEFAULT =
            "org.apache.kafka.common.serialization.StringDeserializer";
    //min message batchSize to commit
    public static final String MIN_BATCH_SIZE_CONFIG = "fetch.min.bytes";
    private static final long MIN_BATCH_SIZE_DEFAULT = 262144;
    public static final String SUBSCRIBE_TOPIC_CONFIG = "kafka.topic";
    private static final String SUBSCRIBE_TOPIC_DEFAULT = "test";

    public static final String COMMIT_TIMEINTERVAL_CONFIG = "kafka.commit.timeinterval";
    private static final long COMMIT_TIMEINTERVAL_DEFAULT = 5000L;

    public static final String MAX_PARTITION_FETCH_BYTES_CONFIG = "max.partition.fetch.bytes";
    private static final int MAX_PARTITION_FETCH_BYTES_DEFAULT = 1048576;

    private static final Map<String, Object> defConfig;
    private static final Set<String> configKeys;

    static {
        defConfig = new HashMap();
        defConfig.put(BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS_DEFAULT);
        defConfig.put(GROUP_ID_CONIFG, GROUP_ID_DEFAULT);
        defConfig.put(ENABLE_AUTO_COMMIT_CONFIG, ENABLE_AUTO_COMMIT_DEFAULT);
        defConfig.put(AUTO_COMMIT_INTERVAL_MS_CONFIG, AUTO_COMMIT_INTERVAL_MS_DEFAULT);
        defConfig.put(SESSION_TIMEOUT_MS_CONFIG, SESSION_TIMEOUT_MS_DEFAULT);
        defConfig.put(KEY_DESERIALIZER_CONFIG, KEY_DESERIALIZER_DEFAULT);
        defConfig.put(VALUE_DESERIALIZER_CONFIG, VALUE_DESERIALIZER_DEFAULT);
        defConfig.put(MIN_BATCH_SIZE_CONFIG, MIN_BATCH_SIZE_DEFAULT);
        defConfig.put(SUBSCRIBE_TOPIC_CONFIG, SUBSCRIBE_TOPIC_DEFAULT);
        defConfig.put(REQUEST_TIMEOUT_MS_CONFIG, REQUEST_TIMEOUT_MS_DEFAULT);
        defConfig.put(COMMIT_TIMEINTERVAL_CONFIG, COMMIT_TIMEINTERVAL_DEFAULT);
        defConfig.put(MAX_PARTITION_FETCH_BYTES_CONFIG, MAX_PARTITION_FETCH_BYTES_DEFAULT);
        //for producer
        defConfig.put(COMPRESSION_TYPE_CONFIG, COMPRESSION_TYPE_DEFAULT);
        defConfig.put(PRODUCER_RETRIES_CONFIG, PRODUCER_RETRIES_DEFAULT);
        defConfig.put(LINGER_TIME_CONFIG, LINGER_TIME_DEFAULT);
        defConfig.put(BATCH_SIZE_CONFIG, BATCH_SIZE_DEFAULT);
        defConfig.put(MESSAGE_ACKS_CONFIG, MESSAGE_ACKS_DEFAULT);
        defConfig.put(KEY_SERIALIZER_CONFIG, KEY_SERIALIZER_DEFAULT);
        defConfig.put(VALUE_SERIALIZER_CONFIG, VALUE_SERIALIZER_DEFAULT);
        defConfig.put(BUFFER_MEMORY_CONFIG, BUFFER_MEMORY_DEFAULT);

        configKeys = new HashSet();
        configKeys.addAll(defConfig.keySet());
    }

    public KafkaConnectorSinkConfig(String configFile) {
        super();
        addConfig(defConfig);
        loadConfigFromFile(configFile);
    }

    public KafkaConnectorSinkConfig(Map<String, Object> config) {
        super();
        addConfig(defConfig);
        addConfig(config);
    }

    public Map<String, Object> getConf() {
        return super.getConfigByType(ServiceType.KAFKA);
    }
}
