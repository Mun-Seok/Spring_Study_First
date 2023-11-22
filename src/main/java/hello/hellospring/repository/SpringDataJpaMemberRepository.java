package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{
    // spring data jpa가 자동으로 구현체를 만들고 등록함
    // JpaRepository가 기본 메서드 제공함

    // JPQL select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name); // 이름만으로도 조회 기능 제공
}
