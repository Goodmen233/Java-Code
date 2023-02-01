package cas;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

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
}
