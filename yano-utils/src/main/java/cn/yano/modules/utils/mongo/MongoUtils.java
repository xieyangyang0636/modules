package cn.yano.modules.utils.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.commons.lang.StringUtils;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xieyangyang0636 on 2020/1/19.
 */

public class MongoUtils {
    private String ip;
    private int port;
    private String dbName;
    private String collectionName;
    private MongoDatabase mongoDatabase;
    private MongoClient mongoClient;
    private String password;
    private String userName;

    public MongoUtils(String ip, String port, String dbName, String collectionName) {
        this.ip = ip;
        this.port = Integer.parseInt(port);
        this.dbName = dbName;
        this.collectionName = collectionName;
    }

    public MongoUtils(String ip, String port, String dbName, String collectionName, String userName, String password) {

        this.ip = ip;
        this.port = Integer.parseInt(port);
        this.dbName = dbName;
        this.collectionName = collectionName;
        this.password = password;
        this.userName = userName;
    }

    public void initial() throws Exception {
        List<ServerAddress> adds = new ArrayList<>();
        List<MongoCredential> credentials = new ArrayList<>();
        for (String aIp : this.ip.split(",")) {
            ServerAddress as = new ServerAddress(aIp, port);
            adds.add(as);
        }

        if (StringUtils.isBlank(this.password) || StringUtils.isBlank(this.userName)) {
            mongoClient = new MongoClient(adds);
        } else {
            //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
            MongoCredential mongoCredential = MongoCredential.createScramSha1Credential(this.userName, "admin", password.toCharArray());
            credentials.add(mongoCredential);
            //通过连接认证获取MongoDB连接
            mongoClient = new MongoClient(adds, credentials);
        }
        mongoDatabase = mongoClient.getDatabase(dbName);

    }

    public MongoCollection<Document> getCollection(String collectionName) {
        return mongoDatabase.getCollection(collectionName);
    }

    public void delMongoDoc(String collection) {
        //此处传参为临时表的collectionName
        if (getMongoDocNum(collection) > 0) {
            //此处this.collectionName 为业务表的 collectionName
            MongoCollection<Document> table = this.getCollection(this.collectionName);
            Document document = new Document();
            document.put("i_type", 2);
            //如果临时表中有数据，则删除业务表中i_type=2的记录
            table.deleteMany(document);
        }
    }

    public long getMongoDocNum(String collection) {
        MongoCollection<Document> table = this.getCollection(collection);
        return table.count();
    }

}