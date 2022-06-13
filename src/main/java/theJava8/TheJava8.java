package theJava8;

public class TheJava8 {
    //psvm : 메인 메소드 단축키
    public static void main(String[] args) {
        /*
         * 자바8 이전에는 어떻게 인터페이스를 구현 했는가?
         * 익명 내부 클래스라고 부르는 걸 만들어서 사용했다.
         */
//        RunSomething runSomething = new RunSomething() {
//            @Override
//            public void doIt() {
//                System.out.println("hi");
//            }
//        };
        /*
         * 그러나 자바 8 부터는 다음과 같이 람다 표현으로 사용이 가능하다.
         * 람다 표현식을 사용한다면 코드를 많이 줄여서 사용이 가능하다!
         * 특수한 형태의 오브젝트라고 볼 수도 있다.
         */
        RunSomething runSomething = () -> {
            System.out.println("hi");
            System.out.println("hello");
        };

        /*
         * 고차함수 : 함수가 함수를 파라미터로 사용 하는 것..
         * 당연히 가능하다. 자바에서 함수는 그냥 오브젝트의 한 형태이기 때문에
         */
        runSomething.doIt();


        /*
         * 함수형 프로그래밍의 '맹점'은
         * 입력받은 값이 동일할경우 항상 같은 결과를 보장해야한다는 것이다.
         * 이걸 보장해주지 않는 경우, 여지, 가능성이 있다면
         * 함수형 프로그래밍이라고 할 수 없다.
         * -> 상태값을 참조하는 경우, 외부의 값을 변경하려는 경우
         */
        ReturnInt returnInt = (num) -> {
            return num + 10;
        };

        System.out.println(returnInt.doIt(1));
        System.out.println(returnInt.doIt(1));
        System.out.println(returnInt.doIt(1));
    }
}
