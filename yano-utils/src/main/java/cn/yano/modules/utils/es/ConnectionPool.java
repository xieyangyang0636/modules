
package cn.yano.modules.utils.es;

import java.io.Serializable;

public interface ConnectionPool<T> extends Serializable {

	/**
	 * <p>Title: getConnection</p>
	 * <p>Description: 获取连接</p>
	 *
	 * @return 连接
	 */
	 T getConnection();
	
	/**
	 * <p>Title: returnConnection</p>
	 * <p>Description: 返回连接</p>
	 *
	 * @param conn 连接
	 */
	void returnConnection(T conn);
	
	/**
	 * <p>Title: invalidateConnection</p>
	 * <p>Description: 废弃连接</p>
	 *
	 * @param conn 连接
	 */
	 void invalidateConnection(T conn);
}
