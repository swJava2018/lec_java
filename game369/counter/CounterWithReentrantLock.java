package counter;

import java.util.concurrent.locks.ReentrantLock;

// ReentrantLock 사용해서 동시성 제어하지 않고 카운팅
public class CounterWithReentrantLock implements Counter{
    ReentrantLock lock = new ReentrantLock();
    int count;

    public int getCount() {
        return count;
    }

    public void increase() {
        try {
            lock.lock();
            count++;
        } finally {
            lock.unlock();
        }
    }
}
