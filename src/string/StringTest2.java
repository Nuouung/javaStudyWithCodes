package string;

public class StringTest2 {

    public static void main(String[] args) {
        String a = "1234";
        System.out.println(a.hashCode()); // 1509442
        a = "12345";
        System.out.println(a.hashCode()); // 46792755
        // String은 불변객체 -> 변수값을 바꾸면 객체가 새로 생성된다!

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("1234");
        System.out.println(stringBuffer.hashCode()); // 1239731077
        stringBuffer.append("5");
        System.out.println(stringBuffer.hashCode()); // 1239731077

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1234");
        System.out.println(stringBuilder.hashCode()); // 557041912
        stringBuilder.append("5");
        System.out.println(stringBuilder.hashCode()); // 557041912
        // 반면 StringBuilder와 StringBuffer은 불변객체가 아니기에 참조값이 새로 생성되지 않는다!
    }
}
