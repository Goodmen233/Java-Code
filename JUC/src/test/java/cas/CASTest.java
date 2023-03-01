package cas;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CASTest {

    /**
     * compareAndSet
     */
    @Test
    public void testCompareAndSet() {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        boolean b = atomicInteger.compareAndSet(5, 2019);

        Assert.assertEquals(2019, atomicInteger.get());
        Assert.assertEquals(b, Boolean.TRUE);
    }

    /**
     * 原子引用
     */
    @Test
    public void testAtomicReference() {
        User z3 = new User("z3", 21);
        User l4 = new User("l4", 14);

        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(z3);
        System.out.println(atomicReference.compareAndSet(z3, l4) + " 现在的值：" + atomicReference.get());
        System.out.println(atomicReference.compareAndSet(z3, l4) + " 现在的值：" + atomicReference.get());
    }

    /**
     * ABA问题
     */
    @Test
    public void testABA() {
        AtomicReference<Integer> atomicReference = new AtomicReference<>(100);

        new Thread(() -> {
           atomicReference.compareAndSet(100, 101);
           atomicReference.compareAndSet(101, 100);
        }, "t1").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100, 2019));
            Assert.assertEquals(new Integer(2019), atomicReference.get());
        }, "t2").start();

        // 解决junit不支持多线程。
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //
    }

    /**
     * 解决ABA问题，时间戳原子引用解决
     */
    @Test
    public void testFixABA() {
        AtomicStampedReference<Integer> ref = new AtomicStampedReference<>(100, 1);

        new Thread(() -> {
            int stamp = ref.getStamp();
            try {
                // 等待让t2线程获得同一stamp
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ref.compareAndSet(100, 101, stamp, stamp + 1);
            stamp = ref.getStamp();
            ref.compareAndSet(101, 100, stamp, stamp + 1);
        }, "t1").start();

        new Thread(() -> {
            int stamp = ref.getStamp();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ref.compareAndSet(100, 2019, stamp, stamp + 1);
            System.out.println("最新版本号：" + ref.getStamp() + ", 最后结果值：" + ref.getReference());
        }, "t2").start();

        // 解决junit不支持多线程。
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //
    }
}
