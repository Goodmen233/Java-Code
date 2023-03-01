package collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class ArrayListTest {

    /**
     * 测试并发下ArrayList线程不安全：java.util.ConcurrentModificationException
     */
    @Test
    public void testConcurrentUnSafe() {
        List<String> list = new ArrayList<>();

        try {
            for (int i = 0; i < 30; i++) {
                new Thread(() -> {
                    list.add(UUID.randomUUID().toString().substring(0, 8));
                    System.out.println(list);
                }, "t" + i).start();
            }
        } catch (Exception e) {
            Assert.assertEquals(Boolean.TRUE, e instanceof ConcurrentModificationException);
        }

        // 解决junit不支持多线程。
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //
    }

    /**
     * 解决并发下ArrayList线程不安全：Vector(synchronized)
     */
    @Test
    public void testFixConcurrentUnSafe1() {
        List<String> list = new Vector<>();

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, "t" + i).start();
        }

        // 解决junit不支持多线程。
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //
    }

    /**
     * 解决并发下ArrayList线程不安全：Collections.synchronized
     */
    @Test
    public void testFixConcurrentUnSafe2() {
        List<String> list = Collections.synchronizedList(new ArrayList<>());

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, "t" + i).start();
        }

        // 解决junit不支持多线程。
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //
    }

    /**
     * 解决并发下ArrayList线程不安全：CopyOnWriteArrayList
     */
    @Test
    public void testFixConcurrentUnSafe3() {
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, "t" + i).start();
        }

        // 解决junit不支持多线程。
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //
    }
}
