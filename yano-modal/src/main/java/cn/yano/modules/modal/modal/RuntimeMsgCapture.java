package cn.yano.modules.modal.modal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * runtime消息捕获类
 * Created by xieyangyang0636 on 2020/1/19.
 */
public class RuntimeMsgCapture extends Thread {
    InputStream is;
    String type;

    public RuntimeMsgCapture(InputStream is, String type) {
        this.is = is;
        this.type = type;
    }

    /**
     * 捕获消息，输出到当前进程的Console
     */
    public void run() {
        try {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                if (type.equals("Error")) {
                    System.out.println(line);
                } else {
                    System.out.println(line);
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
