package counter;

// synchronized 키워드로 동시성 제어하면서 카운팅
// 동기화 방식:
//  increase() 메서드 자체에 synchronized 키워드를 사용하여 메서드 전체에 대해 락을 걸었습니다.
//  메서드를 호출할 때마다 해당 객체에 대해 락이 걸리며, 다른 스레드는 해당 메서드를 호출할 수 없습니다.
// 장점:
//  구현이 더 간단하며, synchronized 메서드를 사용하면 락 대상이 명확합니다. 유지보수 측면에서 직관적입니다.
// 문제점:
//  메서드 전체가 동기화되므로 필요 이상으로 락을 잡을 수 있습니다. 즉, 동기화가 필요한 코드 범위가 넓어질 수 있습니다.
//  비록 현재 코드에서 increase() 메서드가 짧지만, 메서드가 더 복잡해지면 성능 저하가 발생할 수 있습니다.
public class CounterWithSyncMethod implements Counter{
    int count = 0;

    public int getCount() {
        return count;
    }

    public synchronized void increase() {
        count++;
    }
}
