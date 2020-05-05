package cn.yano.modules.modal.config;

/**
 * 系统通用配置
 * Created by xieyangyang0636 on 2020/1/19.
 */
public class CommonConfig extends CommonConfigKV {

    private final static String SYSTEM = "MATCH.";

    /**
     * 通用配置命名空间
     */
    public final static String RS_COMMON_NAMESPACE = SYSTEM + "rs-common";
    public final static String TAG_SERVICE_NAMESPACE = SYSTEM + "tag-service";
    public final static String TAGID_SERVICE_NAMESPACE = SYSTEM + "tagid-service";
    public final static String RS_CONSOLE_NAMESPACE = SYSTEM + "rs-console";
    public final static String KG_SERVICE_NAMESPACE = SYSTEM + "kg-service";
    public final static String JSTORM_BEHAVIOR_KAFKA_NAMESPACE = SYSTEM + "jstorm-behavior-kafka";
    public final static String JSTORM_NEWS_KAFKA_NAMESPACE = SYSTEM + "jstorm-news-kafka";
    public final static String JSTORM_TASK_NAMESPACE = SYSTEM + "jstorm-task";
    public final static String HBASE_NAMESPACE = SYSTEM + HBASE_NAME;
    public final static String MYSQL_NAMESPACE = SYSTEM + MYSQL_NAME;
    public final static String REDIS_NAMESPACE = SYSTEM + REDIS_NAME;
    public final static String MONGO_NAMESPACE = SYSTEM + MONGO_NAME;
    public final static String HIVE_NAMESPACE = SYSTEM + HIVE_NAME;
    public final static String ELASTIC_NAMESPACE = SYSTEM + ELASTIC_NAME;
    public final static String KAFKA_PRODUCER_NAMESPACE = SYSTEM + KAFKA_PRODUCER_NAME;
    public final static String KAFKA_CONSUMER_NAMESPACE = SYSTEM + KAFKA_CONSUMER_NAME;
    public final static String HTTP_NAMESPACE = SYSTEM + HTTP_NAME;
    public final static String HDFS_NAMESPACE = SYSTEM + HDFS_NAME;

    /**
     * 标签服务地址
     */
    public final static String TAG_SERVICE_URL_KEY = "tag.service.url";
    public final static String TAG_SERVICE_URL_VALUE = "";

    /**
     * 标签服务连接超时时间
     */
    public final static String TAG_SERVICE_CONNECT_TIMEOUT_KEY = "tag.service.connectionTimeout";
    public final static int TAG_SERVICE_CONNECT_TIMEOUT_VALUE = 30000;

    /**
     * 标签服务读超时时间
     */
    public final static String TAG_SERVICE_READ_TIMEOUT_KEY = "tag.service.readTimeout";
    public final static int TAG_SERVICE_READ_TIMEOUT_VALUE = 120000;

    /**
     * 标签服务appkey
     */
    public final static String TAG_SERVICE_APPKEY_KEY = "tag.service.appkey";
    public final static String TAG_SERVICE_APPKEY_VALUE = "cd597e5f-0eb0-4fbf-8559-4b5a03caa212";

    /**
     * 标签ID服务地址
     */
    public final static String TAGID_SERVICE_URL_KEY = "tagid.service.url";
    public final static String TAGID_SERVICE_URL_VALUE = "";

    /**
     * 标签ID批量服务地址
     */
    public final static String TAGID_SERVICE_BATCH_URL_KEY = "tagid.service.batch.url";
    public final static String TAGID_SERVICE_BATCH_URL_VALUE = "";

    /**
     * 标签ID服务连接超时时间
     */
    public final static String TAGID_SERVICE_CONNECT_TIMEOUT_KEY = "tagid.service.connectionTimeout";
    public final static int TAGID_SERVICE_CONNECT_TIMEOUT_VALUE = 30000;

    /**
     * 标签ID服务读超时时间
     */
    public final static String TAGID_SERVICE_READ_TIMEOUT_KEY = "tagid.service.readTimeout";
    public final static int TAGID_SERVICE_READ_TIMEOUT_VALUE = 120000;

    /**
     * 标签ID服务appkey
     */
    public final static String TAGID_SERVICE_APPKEY_KEY = "tagid.service.appkey";
    public final static String TAGID_SERVICE_APPKEY_VALUE = "gildata";

    /**
     * 管理端zookeeper监听服务地址
     */
    public final static String CONSOLE_SERVERS_KEY = "rs.console.servers";
    public final static String CONSOLE_SERVERS_VALUE = "";

    /**
     * 管理端zookeeper监听服务超时时间
     */
    public final static String CONSOLE_TIMEOUT_KEY = "rs.console.timeout";
    public final static int CONSOLE_TIMEOUT_VALUE = 10000;

    /**
     * 管理端zookeeper监听服务路径
     */
    public final static String CONSOLE_PATH_KEY = "rs.console.path";
    public final static String CONSOLE_PATH_VALUE = "/rcmd/config";

    /**
     * 管理端zookeeper监听服务标识
     */
    public final static String CONSOLE_SYSTEM_KEY = "rs.console.system";
    public final static String CONSOLE_SYSTEM_VALUE = "console-server";

    /**
     * 图谱服务地址
     */
    public final static String KG_SERVICE_URL_KEY = "kg.service.url";
    public final static String KG_SERVICE_URL_VALUE = "";

    /**
     * 图谱服务读超时时间
     */
    public final static String KG_SERVICE_READ_TIMEOUT_KEY = "kg.service.readTimeout";
    public final static int KG_SERVICE_READ_TIMEOUT_VALUE = 1200000;

    /**
     * kg.service.connectionTimeout
     */
    public final static String KG_SERVICE_CONNECT_TIMEOUT_KEY = "kg.service.connectionTimeout";
    public final static int KG_SERVICE_CONNECT_TIMEOUT_VALUE = 1200000;

    /**
     * 图谱entity标识
     */
    public final static String KG_ENTITY_KEY = "kg.entity";
    public final static String KG_ENTITY_VALUE = "kg_entity_11517441";

    /**
     * 图谱数据标识
     */
    public final static String KG_SOURCE_KEY = "kg.source";
    public final static String KG_SOURCE_VALUE = "QYTP-mysql";

    /**
     * 资讯ID补位长度
     */
    public final static String RS_ID_FIX_LENGTH_KEY = "rs.idFixLength";
    public final static int RS_ID_FIX_LENGTH_VALUE = 25;

    /**
     * 图片上传服务地址
     */
    public final static String RS_IMG_UPLOAD_URL_KEY = "rs.imgUploadUrl";
    public final static String RS_IMG_UPLOAD_URL_VALUE = "";

    /**
     * 标签展示数量
     */
    public final static String RS_TAG_SIZE_KEY = "rs.defaultTagSize";
    public final static int RS_TAG_SIZE_VALUE = 5;

    /**
     * 题图Url前缀
     */
    public final static String RS_IMG_URL_PREFIX_KEY = "rs.defaultImgUrlPrefix";
    public final static String RS_IMG_URL_PREFIX_VALUE = "http://r.hsubas.com/images/";

    /**
     * 题图Url后缀
     */
    public final static String RS_IMG_URL_SUFFIX_KEY = "rs.defaultImgUrlSuffix";
    public final static String RS_IMG_URL_SUFFIX_VALUE = "_thumb";

    /**
     * redis热点标签前缀
     */
    public final static String RS_CACHE_HOT_TAGS_KEY = "rs.cache.hotTags";
    public final static String RS_CACHE_HOT_TAGS_VALUE = "RCMD/HOT/TAGS";

    /**
     * redis热点资讯前缀
     */
    public final static String RS_CACHE_HOT_NEWS_PREFIX_KEY = "rs.cache.hotNewsPrefix";
    public final static String RS_CACHE_HOT_NEWS_PREFIX_VALUE = "RCMD/NEWS/HOT/";

    /**
     * redis热点搜索前缀
     */
    public final static String RS_CACHE_HOT_SERCH_PREFIX_KEY = "rs.cache.hotSearchPrefix";
    public final static String RS_CACHE_HOT_SERCH_PREFIX_VALUE = "RCMD/SEARCH/HOT/";

    /**
     * redis相似资讯前缀
     */
    public final static String RS_CACHE_RELATE_NEWS_PREFIX_KEY = "rs.cache.relateNewsPrefix";
    public final static String RS_CACHE_RELATE_NEWS_PREFIX_VALUE = "RCMD/SIM/NEWSID/";

    /**
     * 相似度资讯最大数量
     */
    public final static String RS_CACHE_RELATE_NEWS_MAX_NUM_KEY = "rs.cache.relateNewsMaxNum";
    public final static int RS_CACHE_RELATE_NEWS_MAX_NUM_VALUE = 200;

    /**
     * redis用户推荐批次前缀
     */
    public final static String RS_CACHE_RECOMMEND_BATCH_PREFIX_KEY = "rs.cache.userRecommendBatchPrefix";
    public final static String RS_CACHE_RECOMMEND_BATCH_PREFIX_VALUE = "RCMD/BATCH/USERID/";

    /**
     * redis股票code映射name前缀
     */
    public final static String RS_CACHE_STOCK_CTN_PREFIX_KEY = "rs.cache.stockCtnPrefix";
    public final static String RS_CACHE_STOCK_CTN_PREFIX_VALUE = "RCMD/SECURITY/CODE/";

    /**
     * redis股票name映射code前缀
     */
    public final static String RS_CACHE_STOCK_NTC_PREFIX_KEY = "rs.cache.stockNtcPrefix";
    public final static String RS_CACHE_STOCK_NTC_PREFIX_VALUE = "RCMD/SECURITY/NAME/";

    /**
     * 第三方数据前缀
     */
    public final static String RS_CACHE_MODULE_PREFIX_KEY = "rs.cache.modulePrefix";
    public final static String RS_CACHE_MODULE_PREFIX_VALUE = "";

    /**
     * 推荐系统默认资讯时效性（小时）
     */
    public final static String RS_DEFAULT_EXPIRY_TIME_KEY = "rs.defaultExpiryTime";
    public final static int RS_DEFAULT_EXPIRY_TIME_VALUE = 72;

    /**
     * 推荐系统资讯源 资讯时效性（小时）
     */
    public final static String RS_EXPIRY_TIME_KEY = "rs.expiryTime";
    public final static String RS_EXPIRY_TIME_VALUE = "";

    /**
     * 推荐系统资讯黑白名单配置
     */
    public final static String RS_NEWS_RESTRICTIONS_KEY = "rs.news.restrictions";
    public final static String RS_NEWS_RESTRICTIONS_VALUE = "";

    /**
     * 不喜欢媒体时间（天）
     */
    public final static String RS_DISLIKE_MEDIA_TIME_KEY = "rs.defaultDisLikeMediaTime";
    public final static int RS_DISLIKE_MEDIA_TIME_VALUE = 3;

    /**
     * 相似度资讯redis生存时间（秒）
     */
    public final static String RS_SIM_NEWS_TTL_KEY = "rs.defaultSimNewsTTL";
    public final static int RS_SIM_NEWS_TTL_VALUE = 2592000;

    /**
     * 规则推荐各个栏目的推荐阈值
     */
    public final static String RS_CATEGORY_WEIGHT_THRESHOLD_KEY = "rs.categoryWeightThreshold";
    public final static String RS_CATEGORY_WEIGHT_THRESHOLD_VALUE = "1:-0.6|2:-0.6|3:-0.6|4:-0.6|5:-0.6|6:-0.6";

    /**
     * 行为标签系数
     */
    public final static String RS_TAG_BEHAVIOR_COE_KEY = "rs.tag.behaviorCoe";
    public final static double RS_TAG_BEHAVIOR_COE_VALUE = 1.5;

    /**
     * 规则标签系数
     */
    public final static String RS_TAG_RULE_COE_KEY = "rs.tag.ruleCoe";
    public final static double RS_TAG_RULE_COE_VALUE = 0.5;

    /**
     * 时间计算权重
     */
    public final static String RS_WEIGHT_TIME_CODE_KEY = "rs.weight.timeCoe";
    public final static double RS_WEIGHT_TIME_CODE_VALUE = 1.0;

    /**
     * 内容计算权重
     */
    public final static String RS_WEIGHT_NEWS_COE_KEY = "rs.weight.newsCoe";
    public final static double RS_WEIGHT_NEWS_COE_VALUE = 0;

    /**
     * 行为计算权重
     */
    public final static String RS_WEIGHT_BEHAVIOR_COE_KEY = "rs.weight.behabiorCoe";
    public final static double RS_WEIGHT_BEHAVIOR_COE_VALUE = 0;

    /**
     * 过滤APPKEY
     */
    public final static String RS_BEHAVIOR_APPKEYS_KEY = "rs.behavior.appkeys";
    public final static String RS_BEHAVIOR_APPKEYS_VALUE = "";

    /**
     * 刷写量阈值
     */
    public final static String RS_DATA_FLUSH_SIZE_KEY = "rs.data.flushSize";
    public final static int RS_DATA_FLUSH_SIZE_VALUE = 1000;

    /**
     * 刷写时间阈值（毫秒）
     */
    public final static String RS_DATA_FLUSH_TIME_KEY = "rs.data.flushTime";
    public final static long RS_DATA_FLUSH_TIME_VALUE = 60000;

    /**
     * 协同过滤输入路径
     */
    public final static String RS_CF_INPUT_KEY = "rs.cf.input";
    public final static String RS_CF_INPUT_VALUE = "/user/hive/warehouse/rcmd.db/rs_users_news_score_result";

    /**
     * 协同过滤输出路径
     */
    public final static String RS_CF_OUTPUT_KEY = "rs.cf.output";
    public final static String RS_CF_OUTPUT_VALUE = "/test/user_cf/out/";

    /**
     * 标签库入库标签数量
     */
    public final static String RS_NEWS_TAG_NUM_KEY = "rs.news.tagNum";
    public final static int RS_NEWS_TAG_NUM_VALUE = 50;

    /**
     * 客户码
     */
    public final static String RS_CUSTOMER_CODE_KEY = "rs.customer.code";
    public final static String RS_CUSTOMER_CODE_VALUE = "";

    /**
     * 理财资讯缓存批次
     */
    public final static String RS_FINANCE_NEWS_CACHE_BATCH_KEY = "rs.financenews.cache.batch";
    public final static int RS_FINANCE_NEWS_CACHE_BATCH_VALUE = 20;

    /**
     * 理财资讯缓存每批次数量
     */
    public final static String RS_FINANCE_NEWS_CACHE_BATCH_SIZE_KEY = "rs.financenews.cache.batchSize";
    public final static int RS_FINANCE_NEWS_CACHE_BATCH_SIZE_VALUE = 10;

    /**
     * 理财资讯redis前缀
     */
    public final static String RS_CACHE_FINANCE_NEWS_PREFIX_KEY = "rs.cache.financeNewsPrefix";
    public final static String RS_CACHE_FINANCE_NEWS_PREFIX_VALUE = "RCMD/FINANCE/NEWS/";

    /**
     * zk HostAndIp
     */
    public final static String JSTORM_KAFKA_ZK_SERVERS_KEY = "zk.servers";
    public final static String JSTORM_KAFKA_ZK_SERVERS_VALUE = "";

    /**
     * zk 根路径
     */
    public final static String JSTORM_KAFKA_ZK_ROOT_KEY = "zk.root";
    public final static String JSTORM_KAFKA_ZK_ROOT_VALUE = "/";

    /**
     * 消费Topic
     */
    public final static String JSTORM_KAFKA_CONSUME_TOPIC_KEY = "consume.topic";
    public final static String JSTORM_KAFKA_CONSUME_TOPIC_VALUE = "ni_newsinfo";

    /**
     * jstorm任务名
     */
    public final static String JSTORM_TASK_ZK_ID_KEY = "zk.id";
    public final static String JSTORM_TASK_ZK_ID_VALUE = "";

    /**
     * jstorm任务是否集群模式
     */
    public final static String JSTORM_TASK_CLUSTER_MODE_KEY = "run.mode.cluster";
    public final static boolean JSTORM_TASK_CLUSTER_MODE_VALUE = true;

    /**
     * kafka spout是否单线程
     */
    public final static String JSTORM_TASK_SPOUT_SINGLE_THREAD_KEY = "spout.single.thread";
    public final static boolean JSTORM_TASK_SPOUT_SINGLE_THREAD_VALUE = true;

    /**
     * kafka spout是否从头消费
     */
    public final static String JSTORM_TASK_SPOUT_FROM_BEGAINNING_KEY = "spout.from.beginning";
    public final static boolean JSTORM_TASK_SPOUT_FROM_BEGAINNING_VALUE = false;

    /**
     * bolt任务并行度
     */
    public final static String JSTORM_TASK_PARALLEL_SIZE_KEY = "vt.bolt.parallel.size";
    public final static int JSTORM_TASK_PARALLEL_SIZE_VALUE = 1;

    /**
     * topology的workers数量
     */
    public final static String JSTORM_TASK_WORK_NUMS_KEY = "work.nums";
    public final static int JSTORM_TASK_WORK_NUMS_VALUE = 1;

    /**
     * 置顶等级
     */
    public final static String RS_CONSOLE_STICK_LEVEL_KEY = "rs.stick.level";
    public final static String RS_CONSOLE_STICK_LEVEL_VALUE = "";

    /**
     * 备份接口开关
     */
    public final static String RS_BACKUP_INTERFACE_SWITCH_KEY = "rs.backup.interface.switch";
    public final static boolean RS_BACKUP_INTERFACE_SWITCH_VALUE = false;

    /**
     * 备份接口标识文件
     */
    public final static String RS_BACKUP_INTERFACE_FILE_FLAG_KEY = "rs.backup.interface.file.flag";
    public final static String RS_BACKUP_INTERFACE_FILE_FLAG_VALUE = "file/flag";

    /**
     * MAP<ID,NEWS>
     */
    public final static String RS_BACKUP_INTERFACE_FILE_NEWSMAP_KEY = "rs.backup.interface.file.newsMap";
    public final static String RS_BACKUP_INTERFACE_FILE_NEWSMAP_VALUE = "file/newsMap";

    /**
     * LIST<DOC>
     */
    public final static String RS_BACKUP_INTERFACE_FILE_NEWSLIST_KEY = "rs.backup.interface.file.newsList";
    public final static String RS_BACKUP_INTERFACE_FILE_NEWSLIST_VALUE = "file/newsList";

    /**
     * MAP<ID,ID_LIST>
     */
    public final static String RS_BACKUP_INTERFACE_FILE_SIMMAP_KEY = "rs.backup.interface.file.simMap";
    public final static String RS_BACKUP_INTERFACE_FILE_SIMMAP_VALUE = "file/simMap";

    /**
     * MAP<TAG,ID_LIST>
     */
    public final static String RS_BACKUP_INTERFACE_FILE_TAGMAP_KEY = "rs.backup.interface.file.tagMap";
    public final static String RS_BACKUP_INTERFACE_FILE_TAGMAP_VALUE = "file/tagMap";

}
