package theJava8;

//함수형 인터페이스로 쓰고 싶다는 어노테이션
@FunctionalInterface
public interface RunSomething {

    /**
     * 항수형 메소드
     * 추상메소드가 딱 한개만 있는 메소드 함수형 메소드 이다
     */
    void doIt(); //추상 메소드

    /**
     * static 메소드나 default 메소드는 상관 없다. 자바8 에서 추가됨ㅎ
     * */
    static void printName() {
        System.out.println("도우");
    }

}
