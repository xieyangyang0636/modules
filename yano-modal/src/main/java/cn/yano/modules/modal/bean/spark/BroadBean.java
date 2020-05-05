package cn.yano.modules.modal.bean.spark;

/**
 * Spark共享变量泛型类
 * Created by xieyangyang0636 on 2020/1/19.
 */
public class BroadBean<T> {

    /**
     * Spark共享变量
     */
    private T broadcast;

    public T getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(T broadcast) {
        this.broadcast = broadcast;
    }
}
