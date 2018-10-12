package com.jay.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorEventType;
import org.apache.curator.framework.api.transaction.CuratorMultiTransaction;
import org.apache.curator.framework.api.transaction.CuratorTransactionResult;
import org.apache.curator.framework.api.transaction.OperationType;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.sql.SQLOutput;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executors;

public class CuratorDemo {

    public static void main(String[] args) {
        CuratorFramework curator = CuratorUtils.getInstance();
        System.out.println("heh");

        add(curator);
    }

    //--------------------------增删改查----------------------------
    public static void add(CuratorFramework curator) {
        try {
            String result = curator.create()
                    .creatingParentsIfNeeded()
                    .withMode(CreateMode.PERSISTENT)
                    .forPath("/a/b/c", "a".getBytes());
            System.out.println("add: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(CuratorFramework curator) {
        try {
            curator.delete()
                    .deletingChildrenIfNeeded()
                    .forPath("/a");
            System.out.println("delete: ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update(CuratorFramework curator) {
        try {
            Stat stat = curator.setData().forPath("/a", "111".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void get(CuratorFramework curator) {
        Stat stat = new Stat();
        try {
            byte[] bytes = curator.getData()
                    .storingStatIn(stat)
                    .forPath("/a");
            String s = new String(bytes);
            // s为/a节点的值 状态在stat
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //异步
    public static void asyncAdd(CuratorFramework curator) {
        try {
            String s = curator.create()
                    .creatingParentsIfNeeded()
                    .withMode(CreateMode.PERSISTENT)
                    .inBackground((curatorFramework, curatorEvent) -> {
                        String threadName = Thread.currentThread().getName();
                        int resultCode = curatorEvent.getResultCode();
                        CuratorEventType type = curatorEvent.getType();
                    }, Executors.newFixedThreadPool(1))
                    .forPath("/a", "111".getBytes());

            System.in.read(); //等待异步结果
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //事务
    public static void tranAdd(CuratorFramework curator) {
        try {
            Collection<CuratorTransactionResult> commitCollection = curator.inTransaction()
                    .create().forPath("/a", "111".getBytes()).and()
                    .setData().forPath("/xxx", "222".getBytes()).and()
                    .commit();

            for (CuratorTransactionResult result : commitCollection) {
                String forPath = result.getForPath();
                OperationType type = result.getType();
            }


            CuratorMultiTransaction transaction = curator.transaction();
            List<CuratorTransactionResult> curatorTransactionResults = transaction.forOperations();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
