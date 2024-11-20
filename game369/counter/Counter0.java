package counter;

// 동시성 제어하지 않고 카운팅
public class Counter0 implements Counter{
    int count;

    public int getCount() {
        return count;
    }

    public void increase() {
        count++;
    }
}
