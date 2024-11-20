import counter.Counter0;
import counter.CounterWithAtomic;
import counter.CounterWithReentrantLock;
import counter.CounterWithReentrantReadWriteLock;
import counter.CounterWithSemaphore;
import counter.CounterWithStampedLock;
import counter.CounterWithSyncBlock;
import counter.CounterWithSyncMethod;
import scenario.Scenario;

/**
 * 369 게임
 *
 * 1단계 : 주어진 요구사항에 맞게 369 게임 구현
 * 2단계 : 오답률에 따른 게임 종료 및 사용자 등 몇 가지 심화 기능과 클래스 추가
 * 3단계 : 지역별 다른 규칙의 369 게임을 위해 추상화 및 다형성 적용
 * 4단계 : 다양한 지역 동시 게임 진행을 위한 동시성 적용
 *
 * 요구사항
 * - 각 플레이어는 독립확율로 매 순서마다 오답율에 의거하여 답을 얘기 / 오답을 얘기하는 경우 게임 종료
 * - 오답 CASE) 박수쳐야할 때 숫자를 얘기한다거나, 잘못된 숫자를 얘기하는 경우
 * - 사용자(Player)는 오답율을 갖는다.
 *
 * 기본 369 게임 요구사항
 * - number 에 3,6,9가 포함되면 "clap", 아니면 입력받은 숫자를 String으로 리턴지역별 다른 규칙의 369 게임
 * - 서울지역에서는 박수를 한번만 치지만, 부산 지역에서는 3,6,9가 나온숫자만큼 박수를 쳐야한다.
 * - 부산 do369(33) => "clapclap", 서울 do369(33) => "clap"
 *
 * 요구사항
 * - 서울지역, 부산지역, … 여러 지역에서 다른 룰로 게임이 동시에 진행될수 있도록 한다.
 */

// 메모 :
//  락
//  - Atomic, ReentrantLock, ReentrantReadWriteLock, Semaphore, StampedLock, SyncBlock, SyncMethod
//  리소스 제어 or 대기 제어
//  - Semaphore, CountDownLatch, CyclicBarrier
//  Concurrent Collections : 동시성을 고려하여 설계된 컬렉션을 사용하면 명시적으로 락을 관리할 필요 없이 스레드 안전한 작업이 가능합니다.
//  - (Key-Value 기반의 Map) ConcurrentHashMap
//  - (Queue) ConcurrentLinkedQueue, BlockingQueue
//  - (읽기 작업이 많은) CopyOnWriteArrayList, ConcurrentHashMap
//  - (정렬된) ConcurrentSkipListMap, ConcurrentSkipListSet
public class Main {
    public static void main(String[] args) {
        Scenario[] sceneList = new Scenario[]{
            new Scenario(new Counter0()),
            new Scenario(new CounterWithAtomic()),
            new Scenario(new CounterWithReentrantLock()),
            new Scenario(new CounterWithReentrantReadWriteLock()),
            new Scenario(new CounterWithSemaphore()),
            new Scenario(new CounterWithStampedLock()),
            new Scenario(new CounterWithSyncBlock()),
            new Scenario(new CounterWithSyncMethod()),
            new Scenario(new Counter0()),
        };

        for (Scenario scene : sceneList) {
            scene.run();
        }

        //실행 결과:
        //모든 game의 박수 횟수: 147567(shared), 148368(expected), 불일치
        //모든 game의 박수 횟수: 16117(shared), 16117(expected), 일치
        //모든 game의 박수 횟수: 14346(shared), 14346(expected), 일치
        //모든 game의 박수 횟수: 105600(shared), 105600(expected), 일치
        //모든 game의 박수 횟수: 19046(shared), 19046(expected), 일치
        //모든 game의 박수 횟수: 39689(shared), 39689(expected), 일치
        //모든 game의 박수 횟수: 58929(shared), 58929(expected), 일치
        //모든 game의 박수 횟수: 78696(shared), 78696(expected), 일치
        //모든 game의 박수 횟수: 99145(shared), 99200(expected), 불일치
    }
}