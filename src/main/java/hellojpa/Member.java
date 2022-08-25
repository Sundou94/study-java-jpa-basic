package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

//근데 이상하다 나는 어디 테이블에 저장되라고 한적이 없는데?
//원래는 @Table(name= Member) 이렇게 테이블 이름을 표시를 해줘야하지만
//Entity와 이름이 같다면 안써도 무방하다.
@Entity
public class Member {

    @Id
    private long id;

    private String name;

    public Member() {
    }

    public Member(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
