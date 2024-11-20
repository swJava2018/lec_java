package counter;

import java.util.concurrent.Semaphore;

// Semaphore
// 제한된 리소스에 대해 접근을 제어할 때 사용됩니다.
public class CounterWithSemaphore implements Counter{
    Semaphore lock = new Semaphore(1); // 최대 1개의 스레드 접근 허용
    int count;

    public int getCount() {
        return count;
    }

    public void increase() {
        try {
            lock.acquire();
            count++;
        } catch(InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.release();
        }
    }
}
