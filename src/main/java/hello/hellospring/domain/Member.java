package hello.hellospring.domain;

import jakarta.persistence.*;

@Entity // jpa가 관리하는 Entity가 된다
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // identity 넣어줌, DB가 알아서 생성해줌
    private Long id;
//    @Column(name = "username") // username이라고 mapping
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
