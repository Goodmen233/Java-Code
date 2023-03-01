package collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

public class SetTest {

    /**
     * 测试并发下Set线程不安全：java.util.ConcurrentModificationException
     *  解决：通ArrayList解决
     *
     */
    @Test
    public void testConcurrentUnSafe() {
        Set<String> list = new HashSet<>();

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
     * 解决并发下Set线程不安全：CopyOnWriteArraySet(底层还是CopyOnWriteArraySet)
     */
    @Test
    public void testFixConcurrentUnSafe3() {
        Set<String> list = new CopyOnWriteArraySet<>();

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
