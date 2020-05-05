package cn.yano.modules.modal.config;

import cn.yano.modules.modal.exception.ConfigException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by xieyangyang0636 on 2020/1/19.
 */
public class AbstractConfig {
    private static final Logger log = LoggerFactory.getLogger(AbstractConfig.class);
    private final Map<String, Object> configs;
    private final Map<ServiceType, Set<String>> configKeys;

    public AbstractConfig() {
        this.configs = new HashMap();
        this.configKeys = new HashMap();
    }

    protected void addConfig(Map<String, Object> subConfig) {
        configs.putAll(subConfig);
    }

    public Map<String, Object> getConfig() {
        Map<String, Object> copyConfigs = new HashMap();
        copyConfigs.putAll(configs);
        return copyConfigs;
    }

    public boolean containsKey(String key) {
        return configs.containsKey(key);
    }

    public void setConfig(String key, Object value) {
        configs.put(key, value);
    }

    protected void addConfigKeys(ServiceType type, Set<String> keys) {
        configKeys.put(type, keys);
    }

    protected Map<String, Object> getConfigByType(ServiceType type) {
        Map<String, Object> conf = new HashMap();
        Set<String> keys = configKeys.get(type);
        for (String k : configs.keySet()) {
            if (keys.contains(k)) {
                conf.put(k, configs.get(k));
            }
        }
        return conf;
    }

    public int getInt(String key) {
        Object parsedVal = parseType(key, Type.INT);
        return ((Integer) parsedVal).intValue();
    }

    public long getLong(String key) {
        Object parsedVal = parseType(key, Type.LONG);
        return ((Long) parsedVal).longValue();
    }

    public double getDouble(String key) {
        Object parsedVal = parseType(key, Type.DOUBLE);
        return ((Double) parsedVal).doubleValue();
    }

    public List<String> getList(String key) {
        Object parsedVal = parseType(key, Type.LIST);
        return (List) parsedVal;
    }

    public boolean getBoolean(String key) {
        Object parsedVal = parseType(key, Type.BOOLEAN);
        return ((Boolean) parsedVal).booleanValue();
    }


    public String getString(String key) {
        Object parsedVal = parseType(key, Type.STRING);
        return (String) parsedVal;
    }


    public Class<?> getClass(String key) {
        Object parsedVal = parseType(key, Type.LONG);
        return (Class) parsedVal;
    }

    private Object parseType(String name, Type type) {
        if (configs.containsKey(name)) {
            Object val = configs.get(name);
            try {
                String e;
                if (val instanceof String) {
                    e = ((String) val).trim();
                } else {
                    e = String.valueOf(val);
                }
                switch (type) {
                    case BOOLEAN:
                        if (val instanceof String) {
                            if (e.equalsIgnoreCase("true")) {
                                return Boolean.valueOf(true);
                            } else {
                                if (e.equalsIgnoreCase("false")) {
                                    return Boolean.valueOf(false);
                                }

                                throw new ConfigException(name, val, "Expected value to be either true or false");
                            }
                        } else {
                            if (val instanceof Boolean) {
                                return val;
                            }

                            throw new ConfigException(name, val, "Expected value to be either true or false");
                        }
                    case STRING:
                        if (val instanceof String) {
                            return e;
                        }

                        throw new ConfigException(name, val, "Expected value to be a string, but it was a " + val.getClass().getName());
                    case INT:
                        if (val instanceof Integer) {
                            return (Integer) val;
                        } else {
                            if (val instanceof String) {
                                return Integer.valueOf(Integer.parseInt(e));
                            }

                            throw new ConfigException(name, val, "Expected value to be an number.");
                        }
                    case LONG:
                        if (val instanceof Integer) {
                            return Long.valueOf(((Integer) val).longValue());
                        } else if (val instanceof Long) {
                            return (Long) val;
                        } else {
                            if (val instanceof String) {
                                return Long.valueOf(Long.parseLong(e));
                            }

                            throw new ConfigException(name, val, "Expected value to be an number.");
                        }
                    case DOUBLE:
                        if (val instanceof Number) {
                            return Double.valueOf(((Number) val).doubleValue());
                        } else {
                            if (val instanceof String) {
                                return Double.valueOf(Double.parseDouble(e));
                            }

                            throw new ConfigException(name, val, "Expected value to be an number.");
                        }
                    case LIST:
                        if (val instanceof List) {
                            return (List) val;
                        } else {
                            if (val instanceof String) {
                                if (e.isEmpty()) {
                                    return Collections.EMPTY_LIST;
                                } else {
                                    return Arrays.asList(e.split(","));
                                }
                            }

                            throw new ConfigException(name, val, "Expected a comma separated list.");
                        }
                    case CLASS:
                        if (val instanceof Class) {
                            return (Class) val;
                        } else {
                            if (val instanceof String) {
                                return Class.forName(e);
                            }

                            throw new ConfigException(name, val, "Expected a Class instance or class name.");
                        }
                    default:
                        throw new IllegalStateException("Unknown type.");
                }
            } catch (NumberFormatException var5) {
                throw new ConfigException(name, val, "Not a number of type " + type);
            } catch (ClassNotFoundException var6) {
                throw new ConfigException(name, val, "Class " + val + " could not be found.");
            }
        } else {
            throw new ConfigException("unsupport config key={}", name);
        }
    }

    protected void loadConfigFromFile(String propsFile) throws ConfigException {
        Properties props = new Properties();
        if (propsFile == null) {
            return;
        } else {
            try {
                FileInputStream e = new FileInputStream(propsFile);
                props.load(e);
                for (Object key : props.keySet()) {
                    configs.put(String.valueOf(key), props.get(key));
                }
            } catch (IOException ex) {
                log.error("failed to load the config,{}", ex.getMessage());
                throw new ConfigException("Couldn\'t load properties from " + propsFile, ex);
            }
        }
    }


    private static enum Type {
        BOOLEAN,
        STRING,
        INT,
        LONG,
        DOUBLE,
        LIST,
        CLASS;

        private Type() {
        }
    }

    protected static enum ServiceType {
        KAFKA,
        HDFS,
        ELASTIC,
        HBASE;

        private ServiceType() {
        }
    }

}