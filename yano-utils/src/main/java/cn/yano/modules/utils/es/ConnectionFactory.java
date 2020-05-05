
package cn.yano.modules.utils.es;

import org.apache.commons.pool2.PooledObjectFactory;

import java.io.IOException;
import java.io.Serializable;


public interface ConnectionFactory<T> extends PooledObjectFactory<T>, Serializable {

	/**
	 * <p>Title: createConnection</p>
	 * <p>Description: 创建连接</p>
	 *
	 * @return T 连接
	 * @throws IOException 存在IOException的可能
	 */
	T createConnection() throws IOException;
}
