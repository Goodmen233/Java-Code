package lock;

public class Phone {

    public synchronized void sendSMS() {
        System.out.println(Thread.currentThread().getId() + "send SMS");
        sendEmail();
    }

    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getId() + "send email");
    }
}
