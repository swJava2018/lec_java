package counter;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CounterWithReentrantReadWriteLock implements Counter{
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    int count;

    public int getCount() {
        return count;
    }

    public void increase() {
        try {
            lock.writeLock().lock();
            count++;
        } finally {
            lock.writeLock().unlock();
        }
    }
}
