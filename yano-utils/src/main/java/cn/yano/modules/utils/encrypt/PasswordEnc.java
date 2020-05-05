package cn.yano.modules.utils.encrypt;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

/**
 * Password 加密类
 * Created by xieyangyang0636 on 2020/1/19.
 */
public class PasswordEnc {

    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            if (args[0].equals("report")) {
                if (args.length == 2) {
                    AESUtils aesUtils = new AESUtils();
                    System.out.println("=========password===========");
                    System.out.println(aesUtils.encrypt(args[1]));
                    System.out.println("==========end==========");
                } else if (args.length == 3) {
                    AESUtils aesUtils = new AESUtils(args[1]);
                    System.out.println("=========password===========");
                    System.out.println(aesUtils.encrypt(args[2]));
                    System.out.println("==========end==========");
                }
            } else if (args[0].equals("other")) {
                if (args.length == 2) {
                    PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
                    SimpleStringPBEConfig config = new SimpleStringPBEConfig();
                    config.setPassword("hsstr.COM");
                    config.setAlgorithm("PBEWithMD5AndDES");
                    config.setKeyObtentionIterations("1000");
                    config.setPoolSize("1");
                    config.setProviderName("SunJCE");
                    config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
                    config.setStringOutputType("base64");
                    encryptor.setConfig(config);
                    String key = encryptor.encrypt(args[1]);
                    System.out.println("=========password===========");
                    System.out.println(key);
                    System.out.println("==========end==========");
                } else if (args.length == 3) {
                    PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
                    SimpleStringPBEConfig config = new SimpleStringPBEConfig();
                    config.setPassword(args[1]);
                    config.setAlgorithm("PBEWithMD5AndDES");
                    config.setKeyObtentionIterations("1000");
                    config.setPoolSize("1");
                    config.setProviderName("SunJCE");
                    config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
                    config.setStringOutputType("base64");
                    encryptor.setConfig(config);
                    String key = encryptor.encrypt(args[2]);
                    System.out.println("=========password===========");
                    System.out.println(key);
                    System.out.println("==========end==========");
                }
            }
        } else {
            System.out.println("param is nor correct!please read the READMEFILE!");
        }

    }
}
