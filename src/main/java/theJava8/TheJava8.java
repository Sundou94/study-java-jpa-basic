package theJava8;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class TheJava8 {
    /*
    psvm : 메인 메소드 만들기 단축키
     */
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
        System.out.println(returnInt.doIt(2));
        System.out.println(returnInt.doIt(2));
        System.out.println(returnInt.doIt(2));
        /*
        pure function 을 달성하기 위해서는 함수 밖에있는 값을 참조하거나 변경하려고 하면 안된다.
         */


        /*
        2. 자바에서 기본적으로 제공하는 함수형 인터페이스들
         */
        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(1));

        /*
        apply : 기본적인 함수 (t) 를 받아서 (r)을 리턴한다.
        물론 따로 함수를 만들어서 인스턴스 생성 후 사용해도 되지만 다음과 같이 람다식으로도 표현이 가능하다
         */
        Function<Integer, Integer> plus11 = (i) -> i + 11;
        Function<Integer, Integer> multiply2 = (i) -> i * 2;
        System.out.println(plus11.apply(1));

        /*
        2.compose(1) : 함수 조합을 위해 쓴다.
         */
        Function<Integer, Integer> multiply2AndPlus11 = plus11.compose(multiply2);
        System.out.println(multiply2AndPlus11.apply(2)); //15

        /*
        1.andThen(2) : 뒤에 붙인다 순차적으로
         */
        System.out.println(plus10.andThen(multiply2).apply(2)); //24

        /*
        ByFunction : 입력 값이 두개 ,
        Consumer : return 이 없음 void,
        Supplier : param 없이 return 만 한다.
        Predicate : 인자 값을 하나 받아서 true, false 를 리턴 해줍니다.
         */

        Predicate<Integer> isEven = (i) -> i%2 == 0;
        System.out.println(isEven.test(5));

        /*
        UnaryOperator : Function 이랑 같은데 param 과 return 이 동일 할 때
        Function을 상속받음
         */

    }
}
