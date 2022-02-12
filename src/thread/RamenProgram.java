package thread;

import java.util.Scanner;

/**
 * 본 코드는 유튜브 '얄팍한 코딩사전'의 '프로세스는 뭐고 스레드는 뭔가요?' 영상에 나오는 코드입니다.
 * 스레드의 동작 원리를 이해 해보고자 영상 속의 코드를 직접 구현해 보았습니다.
 */
public class RamenProgram {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("끓일 라면의 갯수를 지정해주세요!");
        try {
            // in.nextInt()의 ramenCount를 가지는 RamenCook 객체를 하나 생성 (편의상 이 객체를 라면객체A라고 하겠음)
            RamenCook ramenCook = new RamenCook(in.nextInt());
            in.close();

            // 라면객체A를 조작하는 4개의 스레드를 생성
            // 각각의 스레드 이름은 A, B, C, D로 부여된다.
            // 이후 각각의 스레드는 라면객체A 내의 리소스를 공유하며 run()에 기술된 작업내용을 실시함.
            new Thread(ramenCook, "A").start();
            new Thread(ramenCook, "B").start();
            new Thread(ramenCook, "C").start();
            new Thread(ramenCook, "D").start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// 특정 객체를 멀티스레드로 구현하는 방법은 크게 두가지이다.
// 첫 번째, Thread 클래스를 상속해 구현하는 방법 / 두 번째, Runnable 인터페이스를 구현해 구현하는 방법
// 특정 객체를 멀티스레드로 구현한다는 뜻은 이 객체는 한 개 이상의 스레드에 의해 조작될 수 있도록 한다는 것이다.
// 스레드가 수행해야 하는 수행 내용은 run 메소드 내에 기술이 된다.
// 객체의 리소스와 리소스를 조작하기 위한 메소드를 run 메소드 내에서 적절히 사용하면 된다. (run은 스레드가 사용하는 main 메소드와 유사하다고 보면 될듯하다)
// 그렇다면 main 메소드는 프로세스가 조작하는 메소드?
class RamenCook implements Runnable {

    private int ramenCount;
    private final String[] burners = {"_", "_", "_", "_"};

    public RamenCook(int ramenCount) {
        this.ramenCount = ramenCount;
    }

    @Override
    public void run() {
        while (ramenCount > 0) {

            // synchronized(동기화)를 사용하면 한 개의 자원에 대해 단 하나의 스레드만 접근 가능하다.
            // 두개 이상의 스레드가 하나의 자원을 건드리는 것을 막도록 하는 것 같다.
            // java에서 synchronized를 사용하는 방법은 두 가지. 이 경우처럼 블록 내에서 사용하는 방법과 메소드에 synchronized를 붙이는 방법
            // 매개변수 this는 lock을 걸고자 하는 RamenCook 객체를 의미한다.
            // 스레드가 synchronized를 만나면 "이제부터 RamenCook 객체 건들지 마!" 이게 되는듯
            synchronized (this) {
                ramenCount--;
                System.out.println(
                        Thread.currentThread().getName()
                        + ": " + ramenCount + "개 남음");
            }
            
            for (int i = 0; i < burners.length; i++) {
                if (!burners[i].equals("_")) continue;
                
                // if burners[i] equals "_" -> 아래 코드 진행
                synchronized (this) {
                    burners[i] = Thread.currentThread().getName();
                    System.out.println(
                            "               "
                            + Thread.currentThread().getName()
                            + ": [" + (i + 1) + "]번 버너 ON");
                    showBurners();
                }

                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                synchronized (this) {
                    burners[i] = "_";
                    System.out.println(
                            "                               "
                            + Thread.currentThread().getName()
                            + ": [" + (i + 1) + "]번 버너 OFF");
                    showBurners();
                }
                break;
            }

            try {
                Thread.sleep(Math.round(1000 * Math.random()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void showBurners() {
        String stringToPrint = "                                                        ";
        for (int i = 0; i < burners.length; i++) {
            stringToPrint += (" " + burners[i]);
        }
        System.out.println(stringToPrint);
    }
}