package volatilefeature;

public class Singleton {
    private static Singleton singleton = null;
    /**
     * 不加volatile，正确性99.9%
     */
    private static volatile Singleton singletonDCL = null;

    private Singleton() {
        System.out.println(Thread.currentThread().getName() + " 正在构造一个Singleton实例");
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public static synchronized Singleton getSynInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    /**
     * DCL因为有指令重排，还是不能达到百分百效果，需要加volatile
     *
     * @return
     */
    public static Singleton getDCLInstance() {
        if (singletonDCL == null) {
            synchronized (Singleton.class) {
                if (singletonDCL == null) {
                    singletonDCL = new Singleton();
                }
            }
        }
        return singletonDCL;
    }
}
