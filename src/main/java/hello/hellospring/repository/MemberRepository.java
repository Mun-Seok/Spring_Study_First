package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);


    Optional<Member> findById(Long id);
    // Optional - findById와 같은 메서드로 찾을 때 없으면 null 반환 대신 Optional로 감싸는 걸 선호(자바 8부터 사용 가능)

    Optional<Member> findByName(String name);

    List<Member> findAll();
}
