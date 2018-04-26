package hook;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Start {

    private static final ReentrantLock LOCK = new ReentrantLock();
    private static final Condition STOP = LOCK.newCondition();

    public static void main(String[] args) {
        addHook();
        try {
            LOCK.lock();
            STOP.await();
        } catch (InterruptedException e) {
        } finally {
            LOCK.unlock();
        }
    }

    public static void addHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        try {
            LOCK.lock();
            STOP.signal();
        } finally {
            LOCK.unlock();
        }
            System.out.println("hook");
        }, "StartMain-shutdown-hook"));
    }
}
