package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


// 전체 클래스 테스트 해볼 수 있음
class MemmoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 테스트가 끝나면 메모리 지워줘야 함 전체 클래스 테스트 할 때 에러가 발생하지 않는다.
    @AfterEach // 테스트 메서드 실행 후 실행되는 메서드
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get(); // Optional이라 get으로 꺼냄
//        Assertions.assertEquals(member, result); // 같은지 확인, 다르면 오류가 남
        assertThat(member).isEqualTo(result); // 같은지 확인
    }

    @Test
    public void findByName() {
        // member1 생성
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        // member2 생성
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        // member1 생성
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        // member2 생성
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2); // 크기 비교
    }


}
