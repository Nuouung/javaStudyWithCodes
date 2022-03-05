package string;

public class StringTest {

    public static void main(String[] args) {
        String a = "1234";
        String b = "1234";

        System.out.println(a == b); // true

        // String은 "어쩌구저쩌구"인 경우 안의 메세지를 String Constant Pool에 할당
        // 만약 같은 값을 갖는 문자열이 있는 경우 기존 String Constant Pool에서 가져다 쓴다고 함!
    }

}
