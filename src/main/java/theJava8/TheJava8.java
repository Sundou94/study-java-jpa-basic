package theJava8;

public class TheJava8 {
    //psvm : 메인 메소드 단축키
    public static void main(String[] args) {
        /**
         * 자바8 이전에는 어떻게 인터페이스를 구현 했는가?
         * 익명 내부 클래스라고 부르는 걸 만들어서 사용했다.
         */
//        RunSomething runSomething = new RunSomething() {
//            @Override
//            public void doIt() {
//                System.out.println("hi");
//            }
//        };
        /**
         * 그러나 자바 8 부터는 다음과 같이 람다 표현으로 사용이 가능하다.
         * 람다 표현식을 사용한다면 코드를 많이 줄여서 사용이 가능하다!
         * 특수한 형태의 오브젝트라고 볼 수도 있다.
         */
        RunSomething runSomething = () -> {
            System.out.println("hi");
            System.out.println("hello");
        };

        runSomething.doIt();
    }
}
