package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class jpaMain {

    public static void main(String[] args) {
        //EntityManagerFactory 생성
        //생성하면 자동으로 열리는 건가?
        //어플리케이션 실행단계는 딱 한번만 해준다.
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        //트렌젝션이 하나 수행될 때마다 entityManager가 꼭 필요하다.
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //1. JPA에서는 트렌젝션이 정말 중요하다 getTransaction을 통해 EntityTransaction을 하나 생성한다.
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        System.out.println("테스트1");
        //왜 쿼리가 안나올까용
        try{
            System.out.println("테스트2");
            Member findMember = entityManager.find(Member.class, 2);
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.id = " + findMember.getName());
            tx.commit();
        }catch (Exception e) {
            tx.rollback();
        }finally {
            entityManager.close();
        }
        //여기서 닫아주네?
        entityManagerFactory.close();
    }
}
