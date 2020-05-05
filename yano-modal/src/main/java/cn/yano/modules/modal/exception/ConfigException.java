package cn.yano.modules.modal.exception;

/**
 * Created by xieyangyang0636 on 2020/1/19.
 */
public class ConfigException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ConfigException(String message) {
        super(message);
    }

    public ConfigException(String name, Object value) {
        this(name, value, (String)null);
    }

    public ConfigException(String name, Object value, String message) {
        super("Invalid value " + value + " for configuration " + name + (message == null?"":": " + message));
    }
}
