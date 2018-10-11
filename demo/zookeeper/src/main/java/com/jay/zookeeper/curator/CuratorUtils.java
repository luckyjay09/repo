package com.jay.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryNTimes;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.retry.RetryUntilElapsed;

public class CuratorUtils {

    public static final String CONNECT_STRING =
            "192.168.0.104:2181, 192.168.0.104:2182,192.168.0.104:2183";
    public static final int SESSION_TIMEOUR = 5000;
    public static final int CONNECTION_TIMEOUR = 5000;
    private static CuratorFramework sCuratorFrameworkj;

    //创建会话的两种方法
    public static CuratorFramework getInstance() {
        sCuratorFrameworkj = CuratorFrameworkFactory.builder()
                .connectString(CONNECT_STRING)
                .sessionTimeoutMs(SESSION_TIMEOUR)
                .connectionTimeoutMs(CONNECTION_TIMEOUR)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                /*
                连接的重试策略
                ExponentialBackoffRetry(间隔时间，重试次数)
                RetryNTimes(最大重试次数)
                RetryOneTime() 重试一次
                RetryUntilElapsed() 一直重试知道规定时间
                */
//                .namespace("/curator") //命名空间  该会话连接下的所有操作都是在该节点下的
                .build();
        sCuratorFrameworkj.start();
        System.out.println("CuratorFramework start");
        return sCuratorFrameworkj;
    }

    public static CuratorFramework getInstance1() {
       sCuratorFrameworkj = CuratorFrameworkFactory.newClient(CONNECT_STRING,
                SESSION_TIMEOUR,
                CONNECTION_TIMEOUR,
                new ExponentialBackoffRetry(1000, 3));
        sCuratorFrameworkj.start();
        System.out.println("CuratorFramework start1");
        return sCuratorFrameworkj;
    }
}
