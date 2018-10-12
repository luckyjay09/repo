package com.jay.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;

import java.util.Calendar;

public class CuratorEventDemo {

    /**
     * 三种watcher监听节点事件
     * NodeCache 监听一个节点的CUD数据
     * PathChildCache 监听一个路径下子节点的CUD数据
     * TreeChche 前两者的结合
     */

    public static void main(String[] args) {

    }

    public void watch1(CuratorFramework curator) {
        try {
            NodeCache cache = new NodeCache(curator, "/a", false); //3 缓存数据是否压缩
            cache.start();

            cache.getListenable().addListener(() ->
                    System.out.println("1: " + cache.getCurrentData().getData()));

            //事件
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void watch2(CuratorFramework curator) {
        try {
            PathChildrenCache cache = new PathChildrenCache(curator, "/a", false); //3 缓存数据是否压缩
            cache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
            //PathChildrenCache.StartMode.BUILD_INITIAL_CACHE
            //PathChildrenCache.StartMode.NORMAL
            //PathChildrenCache.StartMode.POST_INITIALIZED_EVENT

            cache.getListenable().addListener((curatorFramework, pathChildrenCacheEvent) -> {
                switch (pathChildrenCacheEvent.getType()) {
                    case CHILD_ADDED:
                        System.out.println("CHILD_ADDED");
                        break;
                    case CHILD_REMOVED:
                        System.out.println("CHILD_REMOVED");
                        break;
                    case CHILD_UPDATED:
                        System.out.println("CHILD_UPDATED");
                        break;
                    default:
                        break;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void watch3(CuratorFramework curator) {

    }
}
