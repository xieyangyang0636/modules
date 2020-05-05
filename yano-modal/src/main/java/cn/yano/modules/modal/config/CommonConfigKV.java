package cn.yano.modules.modal.config;

/**
 * 通用配置 键值对
 * Created by xieyangyang0636 on 2020/1/19.
 */
public class CommonConfigKV {

    /**
     * 通用配置命名空间
     */
    public final static String APP_NAMESPACE = "application";
    public final static String HBASE_NAME = "hbase";
    public final static String MYSQL_NAME = "mysql";
    public final static String REDIS_NAME = "redis";
    public final static String MONGO_NAME = "mongo";
    public final static String HIVE_NAME = "hive";
    public final static String ELASTIC_NAME = "elastic";
    public final static String KAFKA_PRODUCER_NAME = "kafka-producer";
    public final static String KAFKA_CONSUMER_NAME = "kafka-consumer";
    public final static String HTTP_NAME = "http";
    public final static String HDFS_NAME = "hdfs";

    /**
     * hbase zookeeper host
     */
    public final static String HBASE_ZK_CONNECT_KEY = "hbase.zkConnect";
    public final static String HBASE_ZK_CONNECT_VALUE = "";

    /**
     * hbase zookeeper 端口
     */
    public final static String HBASE_ZK_PORT_KEY = "hbase.zkPort";
    public final static int HBASE_ZK_PORT_VALUE = 2181;

    /**
     * hbase 命名空间
     */
    public final static String HBASE_NAMESPACE_KEY = "hbase.namespace";
    public final static String HBASE_NAMESPACE_VALUE = "rcmd";

    /**
     * hbase 连接池大小
     */
    public final static String HBASE_POOL_SIZE_KEY = "hbase.poolSize";
    public final static int HBASE_POOL_SIZE_VALUE = 10;

    /**
     * hbase kerberos principal
     */
    public final static String HBASE_KERBEROS_PRINCIPAL_KEY = "hbase.kerberos.principal";
    public final static String HBASE_KERBEROS_PRINCIPAL_VALUE = "";

    /**
     * hbase kerberos keytab路径
     */
    public final static String HBASE_KERBEROS_KEYTAB_PATH_KEY = "hbase.kerberos.keytabPath";
    public final static String HBASE_KERBEROS_KEYTAB_PATH_VALUE = "";

    /**
     * hbase kerberos krb5路径
     */
    public final static String HBASE_KERBEROS_KRB5_PATH_KEY = "hbase.kerberos.krb5Path";
    public final static String HBASE_KERBEROS_KRB5_PATH_VALUE = "";

    /**
     * mysql 驱动类
     */
    public final static String MYSQL_DRIVER_CLASS_KEY = "mysql.driverClassName";
    public final static String MYSQL_DRIVER_CLASS_VALUE = "com.mysql.jdbc.Driver";

    /**
     * mysql jdbc url
     */
    public final static String MYSQL_URL_KEY = "mysql.url";
    public final static String MYSQL_URL_VALUE = "";

    /**
     * mysql 用户名
     */
    public final static String MYSQL_USERNAME_KEY = "mysql.username";
    public final static String MYSQL_USERNAME_VALUE = "root";

    /**
     * mysql 密码（加密）
     */
    public final static String MYSQL_PASSWORD_KEY = "mysql.password";
    public final static String MYSQL_PASSWORD_VALUE = "";

    /**
     * mysql 校验SQL
     */
    public final static String MYSQL_VALID_QUERY_KEY = "mysql.validationQuery";
    public final static String MYSQL_VALID_QUERY_VALUE = "select 1 from dual";

    /**
     * mysql 最大活跃连接数
     */
    public final static String MYSQL_MAX_ACTIVE_KEY = "mysql.maxActive";
    public final static int MYSQL_MAX_ACTIVE_VALUE = 100;

    /**
     * mysql 最小空闲连接数
     */
    public final static String MYSQL_MIN_IDLE_KEY = "mysql.minIdle";
    public final static int MYSQL_MIN_IDLE_VALUE = 10;

    /**
     * mysql 连接池初始化连接大小
     */
    public final static String MYSQL_INIT_SIZE_KEY = "mysql.initialSize";
    public final static int MYSQL_INIT_SIZE_VALUE = 10;

    /**
     * mysql 空闲连接是否测试
     */
    public final static String MYSQL_TEST_WHILE_IDLE_KEY = "mysql.testWhileIdle";
    public final static boolean MYSQL_TEST_WHILE_IDLE_VALUE = true;

    /**
     * mysql 连接池空闲连接的有效时间
     */
    public final static String MYSQL_TIME_BETWEEN_EVICT_KEY = "mysql.timeBetweenEvictionRunsMillis";
    public final static int MYSQL_TIME_BETWEEN_EVICT_VALUE = 1800;

    /**
     * redis 密码
     */
    public final static String REDIS_PASSWORD_KEY = "redis.password";
    public final static String REDIS_PASSWORD_VALUE = "";

    /**
     * redis master
     */
    public final static String REDIS_MASTER_KEY = "redis.master";
    public final static String REDIS_MASTER_VALUE = "hs-master";

    /**
     * redis 集群hosts and port
     */
    public final static String REDIS_CLUSTER_NODES_KEY = "redis.clusterNodes";
    public final static String REDIS_CLUSTER_NODES_VALUE = "";

    /**
     * redis 最大连接数
     */
    public final static String REDIS_MAX_TOTAL_KEY = "redis.maxTotal";
    public final static int REDIS_MAX_TOTAL_VALUE = 200;

    /**
     * redis 最大空闲连接数
     */
    public final static String REDIS_MAX_IDLE_KEY = "redis.maxIdle";
    public final static int REDIS_MAX_IDLE_VALUE = 100;

    /**
     * redis 最小空闲连接数
     */
    public final static String REDIS_MIN_IDLE_KEY = "redis.minIdle";
    public final static int REDIS_MIN_IDLE_VALUE = 10;

    /**
     * redis 最大等待时间
     */
    public final static String REDIS_MAX_WAIT_MILLIS_KEY = "redis.maxWaitMillis";
    public final static int REDIS_MAX_WAIT_MILLIS_VALUE = 3000;

    /**
     * redis 连接超时时间
     */
    public final static String REDIS_CONNECT_TIMEOUT_KEY = "redis.connectionTimeout";
    public final static int REDIS_CONNECT_TIMEOUT_VALUE = 1000;

    /**
     * redis 读超时时间
     */
    public final static String REDIS_SO_TIMEOUT_KEY = "redis.soTimeout";
    public final static int REDIS_SO_TIMEOUT_VALUE = 1000;

    /**
     * redis 最多重试次数
     */
    public final static String REDIS_MAX_ATTEMPTS_KEY = "redis.maxAttempts";
    public final static int REDIS_MAX_ATTEMPTS_VALUE = 3;

    /**
     * mongo host
     */
    public final static String MONGO_HOST_KEY = "mongo.host";
    public final static String MONGO_HOST_VALUE = "";

    /**
     * mongo 端口
     */
    public final static String MONGO_PORT_KEY = "mongo.port";
    public final static int MONGO_PORT_VALUE = 27017;

    /**
     * mongo 用户名
     */
    public final static String MONGO_USERNAME_KEY = "mongo.username";
    public final static String MONGO_USERNAME_VALUE = "";

    /**
     * mongo 密码
     */
    public final static String MONGO_PASSWORD_KEY = "mongo.password";
    public final static String MONGO_PASSWORD_VALUE = "";

    /**
     * mongo databases
     */
    public final static String MONGO_DATABASE_KEY = "mongo.database";
    public final static String MONGO_DATABASE_VALUE = "rcmd";

    /**
     * mongo 连接池大小
     */
    public final static String MONGO_POOL_SIZE_KEY = "mongo.poolSize";
    public final static int MONGO_POOL_SIZE_VALUE = 10;

    /**
     * hive 驱动类
     */
    public final static String HIVE_DRIVER_CLASS_KEY = "hive.driverClassName";
    public final static String HIVE_DRIVER_CLASS_VALUE = "org.apache.hive.jdbc.HiveDriver";

    /**
     * hive jdbc url
     */
    public final static String HIVE_URL_KEY = "hive.url";
    public final static String HIVE_URL_VALUE = "";

    /**
     * hive 用户名
     */
    public final static String HIVE_USERNAME_KEY = "hive.username";
    public final static String HIVE_USERNAME_VALUE = "";

    /**
     * hive 密码
     */
    public final static String HIVE_PASSWORD_KEY = "hive.password";
    public final static String HIVE_PASSWORD_VALUE = "";

    /**
     * hive database
     */
    public final static String HIVE_DATABASE_KEY = "hive.database";
    public final static String HIVE_DATABASE_VALUE = "rcmd";

    /**
     * hive kerberos principal
     */
    public final static String HIVE_KERBEROS_PRINCIPAL_KEY = "hive.kerberos.principal";
    public final static String HIVE_KERBEROS_PRINCIPAL_VALUE = "";

    /**
     * hive 秘钥路径
     */
    public final static String HIVE_KERBEROS_KEYTAB_PATH_KEY = "hive.kerberos.keytabPath";
    public final static String HIVE_KERBEROS_KEYTAB_PATH_VALUE = "";

    /**
     * hive krb5文件路径
     */
    public final static String HIVE_KERBEROS_KRB5_PATH_KEY = "hive.kerberos.krb5Path";
    public final static String HIVE_KERBEROS_KRB5_PATH_VALUE = "";

    /**
     * elastic 集群hosts and port
     */
    public final static String ES_NODES_KEY = "elastic.nodes";
    public final static String ES_NODES_VALUE = "";

    /**
     * elastic 集群名称
     */
    public final static String ES_CLUSTER_NAME_KEY = "elastic.clusterName";
    public final static String ES_CLUSTER_NAME_VALUE = "networkcountly";

    /**
     * elastic 最大活跃连接数
     */
    public final static String ES_MAX_ACTIVE_KEY = "elastic.maxActive";
    public final static int ES_MAX_ACTIVE_VALUE = 10;

    /**
     * elastic 最小空闲连接数
     */
    public final static String ES_MIN_IDLE_KEY = "elastic.minIdle";
    public final static int ES_MIN_IDLE_VALUE = 4;

    /**
     * elastic 类型名称
     */
    public final static String ES_TYPE_NAME_KEY = "elastic.type";
    public final static String ES_TYPE_NAME_VALUE = "defalut";

    /**
     * elastic 类型名称
     */
    public final static String ES_SCROLL_TIME_KEY = "elastic.scrollTime";
    public final static int ES_SCROLL_TIME_VALUE = 60;

    /**
     * elastic 客户端是否嗅探集群
     */
    public final static String ES_CLIENT_TRANSPORT_SNIFF_KEY = "elastic.clientTransportSniff";
    public final static boolean ES_CLIENT_TRANSPORT_SNIFF_VALUE = true;

    /**
     * elastic 资讯索引别名
     */
    public final static String ES_INDEX_ALIAS_NEWS_KEY = "elastic.newsIndexAlias";
    public final static String ES_INDEX_ALIAS_NEWS_VALUE = "";

    /**
     * elastic 标签索引别名
     */
    public final static String ES_INDEX_ALIAS_TAGS_KEY = "elastic.tagsIndexAlias";
    public final static String ES_INDEX_ALIAS_TAGS_VALUE = "";
    /**
     * elastic 标签索引前缀
     */
    public final static String ES_INDEX_PREFIX_TAGS_KEY = "elastic.tagsIndexPrefix";
    public final static String ES_INDEX_PREFIX_TAGS_VALUE = "";

    /**
     * elastic 旧索引
     */
    public final static String ES_OLD_INDEX_KEY = "elastic.oldIndex";
    public final static String ES_OLD_INDEX_VALUE = "";

    /**
     * kafka 集群broker hosts and port
     */
    public final static String KAFKA_PRODUCE_BROKERS_KEY = "kafka.producer.brokerList";
    public final static String KAFKA_PRODUCE_BROKERS_VALUE = "";

    /**
     * kafka 发送 值序列化类
     */
    public final static String KAFKA_PRODUCE_VALUE_SERIAL_CALSS_KEY = "kafka.producer.valueSerialClass";
    public final static String KAFKA_PRODUCE_VALUE_SERIAL_CALSS_VALUE = "org.apache.kafka.common.serialization.ByteArraySerializer";

    /**
     * kafka 发送 Key序列化类
     */
    public final static String KAFKA_PRODUCE_KEY_SERIAL_CALSS_KEY = "kafka.producer.keySerialClass";
    public final static String KAFKA_PRODUCE_KEY_SERIAL_CALSS_VALUE = "org.apache.kafka.common.serialization.StringSerializer";

    /**
     * kafka 发送 消息确认模式
     */
    public final static String KAFKA_PRODUCE_REQUEST_ACKS_KEY = "kafka.producer.requestAcks";
    public final static int KAFKA_PRODUCE_REQUEST_ACKS_VALUE = 1;

    /**
     * kafka 发送 批处理消息记录数
     */
    public final static String KAFKA_PRODUCE_BATCH_SIZE_KEY = "kafka.producer.batchSize";
    public final static int KAFKA_PRODUCE_BATCH_SIZE_VALUE = 32768;

    /**
     * kafka 发送 延迟毫秒数
     */
    public final static String KAFKA_PRODUCE_LINGER_MS_KEY = "kafka.producer.lingerMs";
    public final static int KAFKA_PRODUCE_LINGER_MS_VALUE = 50;

    /**
     * kafka 发送 本地缓存字节大小
     */
    public final static String KAFKA_PRODUCE_BUFFER_MEM_KEY = "kafka.producer.bufferMemory";
    public final static int KAFKA_PRODUCE_BUFFER_MEM_VALUE = 36555246;

    /**
     * kafka 发送 消息压缩类型
     */
    public final static String KAFKA_PRODUCE_COMPRESS_TYPE_KEY = "kafka.producer.compressionType";
    public final static String KAFKA_PRODUCE_COMPRESS_TYPE_VALUE = "snappy";

    /**
     * kafka 集群broker hosts and port
     */
    public final static String KAFKA_CONSUME_BROKERS_KEY = "kafka.consumer.brokerList";
    public final static String KAFKA_CONSUME_BROKERS_VALUE = "";

    /**
     * kafka 消费 组id
     */
    public final static String KAFKA_CONSUME_GROUP_ID_KEY = "kafka.consumer.groupId";
    public final static String KAFKA_CONSUME_GROUP_ID_VALUE = "rcmd";

    /**
     * kafka 消费 每次最小字节数
     */
    public final static String KAFKA_CONSUME_FETCH_MIN_BYTES_KEY = "kafka.consumer.fetchMinBytes";
    public final static int KAFKA_CONSUME_FETCH_MIN_BYTES_VALUE = 102400;

    /**
     * kafka 消费 每分区最大字节数
     */
    public final static String KAFKA_CONSUME_MAX_PARTITION_FETCH_BYTES_KEY = "kafka.consumer.maxPartitionFetchBytes";
    public final static int KAFKA_CONSUME_MAX_PARTITION_FETCH_BYTES_VALUE = 2048000;

    /**
     * kafka 消费 值反序列化类
     */
    public final static String KAFKA_CONSUME_VALUE_DE_SERIAL_CALSS_KEY = "kafka.consumer.valueDeSerialClass";
    public final static String KAFKA_CONSUME_VALUE_DE_SERIAL_CALSS_VALUE = "org.apache.kafka.common.serialization.ByteArrayDeserializer";

    /**
     * kafka 消费 Key反序列化类
     */
    public final static String KAFKA_CONSUME_KEY_DE_SERIAL_CALSS_KEY = "kafka.consumer.keyDeSerialClass";
    public final static String KAFKA_CONSUME_KEY_DE_SERIAL_CALSS_VALUE = "org.apache.kafka.common.serialization.StringDeserializer";

    /**
     * kafka 默认偏移量模式
     */
    public final static String KAFKA_CONSUME_AUTO_OFFSET_RESET_KEY = "kafka.consumer.autoOffsetReset";
    public final static String KAFKA_CONSUME_AUTO_OFFSET_RESET_VALUE = "earliest";

    /**
     * 最大连接数
     */
    public static final String HTTP_MAX_TOTAL_KEY = "http.maxTotal";
    public static final int HTTP_MAX_TOTAL_VALUE = 100;

    /**
     * 并发数
     */
    public static final String HTTP_DEFAULT_MAX_PER_ROUTE_KEY = "http.defaultMaxPerRoute";
    public static final int HTTP_DEFAULT_MAX_PER_ROUTE_VALUE = 20;

    /**
     * 创建连接的最长时间
     */
    public static final String HTTP_CONNECT_TIMEOUT_KEY = "http.connectTimeout";
    public static final int HTTP_CONNECT_TIMEOUT_VALUE = 1000;

    /**
     * 从连接池中获取到连接的最长时间
     */
    public static final String HTTP_CONNECTION_REQUEST_TIMEOUT_KEY = "http.connectionRequestTimeout";
    public static final int HTTP_CONNECTION_REQUEST_TIMEOUT_VALUE = 500;

    /**
     * 数据传输的最长时间
     */
    public static final String HTTP_SOCKET_TIMEOUT_KEY = "http.socketTimeout";
    public static final int HTTP_SOCKET_TIMEOUT_VALUE = 10000;

    /**
     * 提交请求前测试连接是否可用
     */
    public static final String HTTP_STALE_CONNECTION_CHECK_ENABLED_KEY = "http.staleConnectionCheckEnabled";
    public static final boolean HTTP_STALE_CONNECTION_CHECK_ENABLED_VALUE = true;

    /**
     * hdfs 用户名
     */
    public final static String HDFS_KERBEROS_PRINCIPAL_KEY = "hdfs.kerberos.principal";
    public final static String HDFS_KERBEROS_PRINCIPAL_VALUE = "";

    /**
     * hdfs 秘钥路径
     */
    public final static String HDFS_KERBEROS_KEYTAB_PATH_KEY = "hdfs.kerberos.keytabPath";
    public final static String HDFS_KERBEROS_KEYTAB_PATH_VALUE = "";

    /**
     * hdfs krb5文件路径
     */
    public final static String HDFS_KERBEROS_KRB5_PATH_KEY = "hdfs.kerberos.krb5Path";
    public final static String HDFS_KERBEROS_KRB5_PATH_VALUE = "";

}
