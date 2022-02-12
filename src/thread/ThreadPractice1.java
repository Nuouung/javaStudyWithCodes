package thread;

/**
 * 남궁성의 자바의 정석을 보고 적는 코드
 */
public class ThreadPractice1 {

    public static void main(String[] args) {
        ThreadExample1 te1 = new ThreadExample1();

        // Runnable 인터페이스를 구현한 객체의 스레드를 생성하는 방법
        // 방법 1.
        Thread te2 = new Thread(new ThreadExample2());

        // 방법 2.
//        ThreadExample2 threadExample2 = new ThreadExample2();
//        Thread te2 = new Thread(threadExample2);

        // 방법 3.
//        Runnable runnable = new ThreadExample2();
//        Thread te2 = new Thread(runnable);

        te1.start();
        te2.start();
    }
}

class ThreadExample1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print(this.getName());
        }
    }
}

class ThreadExample2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Thread thread = Thread.currentThread();
            System.out.print(thread.getName());
        }
    }
}