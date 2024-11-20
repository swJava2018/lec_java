package counter;

// synchronized 키워드로 동시성 제어하면서 카운팅
// 동기화는 increase() 메서드 실행 시 블록 내부 코드만 보호합니다.
// 장점:
//  동기화가 필요한 코드 범위가 작기 때문에 효율적입니다. 동기화 블록 외부에서의 작업에는 락이 걸리지 않습니다.
// 문제점:
//  count 변수가 Integer 타입이므로 불변 객체입니다. 매번 count++를 수행할 때 새로운 Integer 객체가 생성되므로 성능에 약간의 영향을 줄 수 있습니다.
//  다만, Java 의 오토박싱 기능 때문에 기본적으로 동작은 문제없이 수행됩니다.
public class CounterWithSyncBlock implements Counter{
    Integer count = 0;

    public int getCount() {
        return count.intValue();
    }

    public void increase() {
        synchronized(this) {
            count++;
        }
    }
}
