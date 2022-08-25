package theJava8;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

/**
 * 자바 8부터 새로 나온 메소드 들을 설명합니다.
 */
public class NewMethodInJava8 {

    public static void main(String[] args) {
        List<String> name = new ArrayList<>();

        name.add("Dou");
        name.add("Soo");
        name.add("Seon");
        name.add("Park");

        /*
        Iterable
         */

        //1. forEach
        System.out.println("\n1.forEach");
        name.forEach(System.out::println);


        //2.spliterator : iterator 와 비슷 하지만, 분리가 가능하다. (순회 기능)
        System.out.println("\n2.spliterator");

        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit(); //뒤에 trySplit 을 하게 되면 앞에 변수도 반으로 나뉜다. 신기,,해

        while (spliterator.tryAdvance(System.out::println));
        System.out.println("==========================");
        while (spliterator1.tryAdvance(System.out::println));

        //3. removeIf
        System.out.println("\n3.removeIf");

        name.removeIf(datum -> datum.startsWith("P")); // "p" 로 시작하는걸 지운다.
        name.forEach(System.out::println);

        /*
        Collection : 주로 정렬할때 사용한다
         */

        //1. sort
        System.out.println("\n1. sort");

        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed()); // 역순으로 String 으로 정렬!

        name.forEach(System.out::println);
    }

}