package callByValueReference;

public class SwapTestReference {

    public static void main(String[] args) {
        String a = "1";
        String b = "2";

        swap(a, b);

        System.out.println("메소드 외부");

        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

    private static void swap(String a, String b) {
        String temp = a;
        a = b;
        b = temp;

        System.out.println("메소드 내부");

        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

}
