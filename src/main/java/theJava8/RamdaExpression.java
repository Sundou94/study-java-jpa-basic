package theJava8;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class RamdaExpression {

    /**
     * 람다 표현식을 연습합니다.
     * @param args
     */
    public static void main(String[] args) {
    /*
    람다 표현식
    (인자) -> 바디
    (인자 리스트) -> {바디}
     */

    /*
    BinaryOperator : 같은 type 의 param 2개와 같은 type 의 return 값을 가질때 사용한다
     */
        //BinaryOperator<Integer> sum = (a, b)  -> a + b ;
        BinaryOperator<Integer> sum = Integer::sum;

        RamdaExpression ramdaExpression = new RamdaExpression();
        ramdaExpression.run();
    }

    private void run() {
        /*
        변수 캡쳐
        익명 클래스, 로컬 클래스에서 사용하는 변수 캡쳐와는 조금 다르다.
        익명 클래스나 로컬클래스에서는 쉐도잉 되지만
        람다에서는 가려지지 않는다.

        람다는 run 이라는 메소드랑 같은 위치다.

        *참고 - Consumer : return void
         */

        final int baseNumber = 10;

        // 로컬 클래스
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 11; // 'final' 이지만 스콥이 안쪽이기 때문에 가린다.
                System.out.println(baseNumber); // 11
            }
        }

        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber); // 얘도 밖 스콥의 baseNumber 를 보지 않는다
            }
        };

        // 람다
        IntConsumer printInt = (i) -> System.out.println(i + baseNumber); // run 과 같은 스콥이다

        printInt.accept(10);
    }

}
