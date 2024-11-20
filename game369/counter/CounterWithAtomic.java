package counter;

import java.util.concurrent.atomic.AtomicInteger;

// 간단한 연산(증가, 감소 등)을 수행할 때 락 대신 사용할 수 있는 클래스입니다.
// 내부적으로 CAS(Compare-And-Swap) 연산을 사용하므로 락 오버헤드가 없습니다.
public class CounterWithAtomic implements Counter {
    AtomicInteger count = new AtomicInteger(0);

    public int getCount() {
        return count.intValue();
    }

    public void increase() {
        count.incrementAndGet();
    }
}
