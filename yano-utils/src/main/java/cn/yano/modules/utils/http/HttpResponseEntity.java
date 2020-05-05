package cn.yano.modules.utils.http;

import org.apache.http.HttpStatus;

/**
 * @author zhaomw28361
 *
 */
public class HttpResponseEntity {
    /**
     * http状态
     */
    private int status;
    /**
     * 返回体
     * 统一返回String，由业务决定转成工具类的JSONArray或JSONObject、string、xml文档等
     */
    private String body;

    public static HttpResponseEntity build(int status, String body) {
        return new HttpResponseEntity(status, body);
    }

    public HttpResponseEntity(int status, String body) {
        this.status = status;
        this.body = body;
    }

    public HttpResponseEntity(int status) {
        this.status = status;
    }

    public boolean isSuccess(){
        return this.status == HttpStatus.SC_OK;
    }

    public boolean isSuccessAndValid(){
        return this.status == HttpStatus.SC_OK && this.body != null && !"".equals(this.body);
    }

    public boolean isUnauthorized(){
        return this.status == HttpStatus.SC_UNAUTHORIZED;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
