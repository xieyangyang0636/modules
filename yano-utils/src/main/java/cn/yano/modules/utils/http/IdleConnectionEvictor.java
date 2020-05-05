package cn.yano.modules.utils.http;

import org.apache.http.conn.HttpClientConnectionManager;

/**
 * @author zhaomw28361
 *
 */
public class IdleConnectionEvictor extends Thread {

    private HttpClientConnectionManager connMgr;

    private volatile boolean shutdown;

    public IdleConnectionEvictor(HttpClientConnectionManager connMgr) {
        super();
        this.connMgr = connMgr;
        super.start();
    }

    @Override
    public void run() {
        try {
            while (!shutdown) {
                synchronized (this) {
                    wait(5000);
                    // 关闭失效的连接
                    connMgr.closeExpiredConnections();
                }
            }
        } catch (InterruptedException ex) {
            // 结束
        }
    }

    /**
     * 关闭清理无效连接的线程
     */
    public void shutdown() {
        shutdown = true;
        synchronized (this) {
            notifyAll();
        }
    }
}
