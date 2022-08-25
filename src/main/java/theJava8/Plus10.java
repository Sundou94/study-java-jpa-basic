package theJava8;

import java.util.function.Function;

/**
 * Function < 받는 Type, return Type >  자바에서 기본적으로 제공하는 함수형 인터페이스 입니다
 */
public class Plus10 implements Function<Integer, Integer> {
    @Override
    public Integer apply(Integer integer) {
        return integer + 10;
    }
}
