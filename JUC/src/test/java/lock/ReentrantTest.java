package lock;

import org.junit.Test;

public class ReentrantTest {

    /**
     * 验证synchronized是一个可重入锁
     * 验证ReentrantLock...
     */
    @Test
    public void reentrantTest() {
        Phone phone = new Phone();

        for (int i = 0; i < 20; i++) {
            new Thread(phone::sendSMS, "" + i).start();
        }
    }

}
