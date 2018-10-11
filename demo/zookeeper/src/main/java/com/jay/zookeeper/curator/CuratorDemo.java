package com.jay.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;

public class CuratorDemo {

    public static void main(String[] args) {
        CuratorFramework curator = CuratorUtils.getInstance();
        System.out.println("heh");

        add(curator);
    }

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

    }

    public static void get(CuratorFramework curator) {

    }
}
