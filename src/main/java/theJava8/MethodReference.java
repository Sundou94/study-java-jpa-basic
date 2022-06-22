package theJava8;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodReference {
    public static void main(String[] args) {
        // Function<T, R>
        Function<Integer, String> intToString = (i) -> "number";

        /*
        static method 참조
         */
        // UnaryOperator<T&R>
        // :: method Reference 라는 뜻
        // hi 가 static method 라서 이렇게 바로 사용가능
        UnaryOperator<String> hi = Greeting::hi;

        /*
        instance method 참조
         */
        // public 으로 선언한 instance method 같은 경우는 instance 선언 후 사용 하면 됨
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;

        /*
        임의 객체 instance method 참조
         */
        // Supplier<R>
        Supplier<Greeting> newGreeting = Greeting::new;
        Greeting greeting1 = newGreeting.get();

        /*
        생성자 참조
         */
        // greetingFunction, greetingSupplier 다른 생성자를 본다.
        Function<String, Greeting> greetingFunction = Greeting::new;
        Supplier<Greeting> greetingSupplier = Greeting::new;

        Greeting douseon = greetingFunction.apply("soo");
        System.out.println(douseon.getName());
    }
}
