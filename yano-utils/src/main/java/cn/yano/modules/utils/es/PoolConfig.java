
package cn.yano.modules.utils.es;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import java.io.Serializable;


public class PoolConfig extends GenericObjectPoolConfig implements Serializable {
	/** max totoal connection */
	private static final int MAX_TOTAL_DEFAULT=10;
	/**min idle connection 	 */
	private static final int MIN_IDLE_DEFAULT=0;

	/** serialVersionUID */
	private static final long serialVersionUID = -2414567557372345057L;

	/** DEFAULT_TEST_WHILE_IDLE */
	public static final boolean DEFAULT_TEST_WHILE_IDLE = true;
	
	/** DEFAULT_MIN_EVICTABLE_IDLE_TIME_MILLIS */
	public static final long  DEFAULT_MIN_EVICTABLE_IDLE_TIME_MILLIS = 60000;
	
	/** DEFAULT_TIME_BETWEEN_EVICTION_RUNS_MILLIS */
	public static final long  DEFAULT_TIME_BETWEEN_EVICTION_RUNS_MILLIS = 30000;
	
	/** DEFAULT_NUM_TESTS_PER_EVICTION_RUN */
	public static final int  DEFAULT_NUM_TESTS_PER_EVICTION_RUN = -1;

	/**
	 * <p>Title: PoolConfig</p>
	 * <p>Description: 默认构造方法</p>
	 */
	public PoolConfig() {
		this(MAX_TOTAL_DEFAULT,MIN_IDLE_DEFAULT,DEFAULT_TEST_WHILE_IDLE,
				DEFAULT_MIN_EVICTABLE_IDLE_TIME_MILLIS,DEFAULT_TIME_BETWEEN_EVICTION_RUNS_MILLIS,
				DEFAULT_NUM_TESTS_PER_EVICTION_RUN	);
	}
	public PoolConfig(int maxTotalSize,int minIdle){
		this(maxTotalSize,minIdle,true,120000L,60000L,-1);
	}
	private PoolConfig(int maxTotal,int minIdle,boolean isTestWhileIdle,long minEvictTimeMills,
					   long evictTimeIntervalToRun,int numEvictToRun){
		super();
		setMaxTotal(maxTotal);
		setMinIdle(minIdle);
		setTestWhileIdle(isTestWhileIdle);
		setMinEvictableIdleTimeMillis(minEvictTimeMills);
		setTimeBetweenEvictionRunsMillis(evictTimeIntervalToRun);
		setNumTestsPerEvictionRun(numEvictToRun);
	}
}
