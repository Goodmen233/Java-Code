package volatilefeature;

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
}
