package callByValueReference;

public class SwapTestPrimitive {

    public static void main(String[] args) {
        int a = 1;
        int b = 2;

        swap(a, b);

        System.out.println("메소드 외부");
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

    private static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("메소드 내부");
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

}
