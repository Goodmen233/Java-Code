package volatilefeature;

import java.util.concurrent.atomic.AtomicInteger;

public class Data {

    public volatile int num;

    public void add1() {
        this.num++;
    }

    public void addTo60() {
        this.num = 60;
    }

    public synchronized void synAdd1() {
        this.num++;
    }

    public AtomicInteger number = new AtomicInteger();

    public void addAtomic1() {
        this.number.getAndIncrement();
    }
}
