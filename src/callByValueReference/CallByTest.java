package callByValueReference;

public class CallByTest {

    static CallByTest callByTest = new CallByTest();

    public static void main(String[] args) {
        int primitiveType = 3;

        // 메소드 내에서 원시형 데이터를 변경했음
        callByTest.primitiveTypeTest(primitiveType);

        System.out.println(primitiveType); // 3
        // java는 원시형 변수의 경우 call by value로 호출 (인자를 복사해서 복사된 새로운 값을 사용)

        int[] referenceType = new int[1];
        referenceType[0] = 3;

        // 메소드 내에서 참조형 데이터를 변경했음
        callByTest.referenceTypeTest(referenceType);
        System.out.println(referenceType[0]); // 5
        // java는 참조형 변수를 call by reference로 동작시키므로 포인터에 의해 가리키고 있는 원래의 변수가 변화됨
    }

    public void primitiveTypeTest(int target) {
        target = 5; // 파라미터로 온 원시형 인자를 변경
    }

    public void referenceTypeTest(int[] target) {
        target[0] = 5; // 파라미터로 온 참조형 인자를 변경
    }

}
