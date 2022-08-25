package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * jdbc batch insert 와 동일한 JPA Flush 에 대한 테스트를 위한 Class
 */
public class JpaFlushTest {
    public static void main(String[] args) {
        // 1. Creat Entity Manage Factory
        // what is Persistence and PersistenceUnitName?
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");

        // 2. Creat EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // 3. Creat Transaction from EntityManager instance
        EntityTransaction tx = entityManager.getTransaction();

        // 4. Begin to Transaction!
        tx.begin();

        try {
            // 5. Find Member from Member entity
            long beginTime = System.currentTimeMillis();
            Member findMember = entityManager.find(Member.class, 1L);
            Member findMember2 = entityManager.find(Member.class, 2L);
            Member findMember3 = entityManager.find(Member.class, 3L);

            Member member = new Member(200L, "flushTest");

            // for ( int i = 4 ; i < 14 ; i ++ ){
            //     entityManager.persist(new Member(i, "test" + i));
            // }
            // em.flush 를 쓰게 된다면, tx.commit 이 되기 전에 쿼리를 보낼 수 있다.
            // flush : 쓰기지연 케쉬들, 변경 감지된 데이터들을 DB에 반영시킨다.
            // 1차 캐쉬가 지워지진 않는다.
            entityManager.flush();
            System.out.println("=============================");

            // 6. Commit Transaction
            // JPA 쓰기 지연 때문에 transaction commit 후에 쿼리가 날라간다.
            tx.commit();
            long endTime = System.currentTimeMillis();

            System.out.println(findMember.getName() + " / " + findMember.getId());
            // 실제로 묶어서 보내진 않는다.
            System.out.println((endTime - beginTime)/1000.00);

        }catch (Exception e) {
            System.out.println(e.getMessage());

            // 7. When an error occurs, rollback transaction
            tx.rollback();
        }
    }
}
