package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class jpaMain {

    public static void main(String[] args) {
        //EntityManagerFactory 생성
        //생성하면 자동으로 열리는 건가?
        //어플리케이션 실행단계는 딱 한번만 해준다.
        //Manager Factory 는 DB당 하나만 생성되는 거고
        //Manager 는 요청 한개당 하나씩 만 쓰레드간 공유가 불가능하다.
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        //트렌젝션이 하나 수행될 때마다 entityManager가 꼭 필요하다.
        System.out.println(entityManagerFactory.toString());

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //1. JPA에서는 트렌젝션이 정말 중요하다 getTransaction을 통해 EntityTransaction을 하나 생성한다.
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin(); // 트렌젝션 시작! 원래는 이렇게 짜야하지만..
        // 나중에는 스프링이 다해줌요 ㅎㅎ

        //왜 쿼리가 안나올까
        try{
            Member findMember = entityManager.find(Member.class, 1L); //find pk로 값을 찾아준다.
            System.out.println(findMember.getId());
            System.out.println(findMember.getName());
            tx.commit();
//            System.out.println("?");
        }catch (Exception e) {
            System.out.println(e.getMessage());
            tx.rollback();
        }finally {
            entityManager.close(); // 데이터 커넥션을 물고 있어서 닫아줘야한다.
        }
        //여기서 닫아주네?


        //JPQL 가장 단순한 조회 방법
        // entity manager 도 새로 만들어줘야 하네..
        EntityManager entityManager2 = entityManagerFactory.createEntityManager();
        EntityTransaction tx2 = entityManager2.getTransaction();

        tx2.begin();
        try{
            //JPQL 은 table 을 직접 호출 하는게 아니라, 객체를 호출한다.
            //sql 과의 미묘한 차이
            //객체 이기때문에 mySql, h2, oracle 상관 없이 잘 작동한다.
            //b2b에서 왜 JPQL 을 썼는지 이유를 알겠네..
            //객체지향 쿼리 언어.. 오
            List<Member> result = entityManager2.createQuery("select m from Member as m", Member.class)
                    .getResultList();
            for (Member member : result) {
                System.out.println(member.getId());
                System.out.println(member.getName());
            }
            tx2.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            tx2.rollback();
        }finally {
            entityManager2.close();
        }

        entityManagerFactory.close();
    }


}
