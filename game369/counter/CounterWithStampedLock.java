package counter;

import java.util.concurrent.locks.StampedLock;

// StampedLock
// Java 8에서 추가된 동기화 도구로, ReentrantReadWriteLock과 유사하지만 더 나은 성능을 제공합니다.
// 낙관적 읽기를 지원하며, 쓰기 락을 효율적으로 관리할 수 있습니다.
public class CounterWithStampedLock implements Counter{
    StampedLock lock = new StampedLock();
    int count;

    public int getCount() {
        return count;
    }

    public void increase() {
        long stamp = lock.writeLock();
        try {
            count++;
        } finally {
            lock.unlockWrite(stamp);
        }
    }
}
