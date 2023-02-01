package volatilefeature;

import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class VolatileTest {

    /**
     * 验证volatile的保证可见性
     */
    @Test
    public void testVisibility() {
        Data data = new Data();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " go");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.addTo60();
            System.out.println(Thread.currentThread().getName() + " update success");
        }, "AAA").start();

        while(Objects.equals(data.num, 0)) {

        }
        System.out.println(Thread.currentThread().getName() + " over");
    }

    /**
     * 测试volatile的不保证原子性
     */
    @Test
    public void testNoAtomic() {
        Data data = new Data();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    data.add1();
                }
            }, "" + i).start();
        }

        while(Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println("结果大概不是20000：" + data.num);
    }

    /**
     * 测试volatile的不保证原子性，synchronized解决
     */
    @Test
    public void testSynFixNoAtomic() {
        Data data = new Data();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    data.synAdd1();
                }
            }, "" + i).start();
        }

        while(Thread.activeCount() > 2) {
            Thread.yield();
        }

        Assert.assertEquals(20000, data.num);
        System.out.println("结果必须是20000：" + data.num);
    }

    /**
     * 测试volatile的不保证原子性，atomic解决
     */
    @Test
    public void testAtomicFixNoAtomic() {
        Data data = new Data();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    data.addAtomic1();
                }
            }, "" + i).start();
        }

        while(Thread.activeCount() > 2) {
            Thread.yield();
        }

        Assert.assertEquals(20000, data.number.get());
        System.out.println("结果必须是20000：" + data.number.get());
    }

    /**
     * 测试单机版 单例模式 单线程访问
     */
    @Test
    public void testSingletonNormal() {
        System.out.println(Singleton.getInstance() == Singleton.getInstance());
        System.out.println(Singleton.getInstance() == Singleton.getInstance());
        System.out.println(Singleton.getInstance() == Singleton.getInstance());
    }

    /**
     * 测试单机版 单例模式 多线程访问
     */
    @Test
    public void testConcurrentSingleton() {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    Singleton.getInstance();
                }
            }, "" + i).start();
        }
    }

    /**
     * 测试单机版 单例模式 多线程访问 synchronized解决问题
     */
    @Test
    public void testConcurrentSynSingleton() {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    Singleton.getSynInstance();
                }
            }, "" + i).start();
        }
    }

    /**
     * 测试双重校验锁解决并发单例模式
     */
    @Test
    public void testDCLSingleton() {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    Singleton.getDCLInstance();
                }
            }, "" + i).start();
        }
    }
}
