package thread;

/**
 * 예제 출처
 * https://link2me.tistory.com/1732
 */
public class SynchronizedPractice {

    public static void main(String[] args) {
        LetsGetSynchronized letsGetSynchronized = new LetsGetSynchronized();

        // 스레드 4개 실행
        new Thread(letsGetSynchronized).start();
        new Thread(letsGetSynchronized).start();
        new Thread(letsGetSynchronized).start();
        new Thread(letsGetSynchronized).start();

        synchronized (letsGetSynchronized) {
            System.out.println("기다린다");
            try {
                letsGetSynchronized.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("최종 결과 : " + letsGetSynchronized.total);
        }
    }
    
}

class LetsGetSynchronized implements Runnable {
    
    int total = 0;

    @Override
    public void run() {

        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println(i + "를 더한다. - " + Thread.currentThread().getName());
                total += i;
                
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            notify(); // 위 작업이 모두 끝나면 다른 스레드를 실행 대기 상태로 만듬.
        }

    }
}
