package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

//    private final MemberService memberService = new MemberService(); // 다른 컨트롤러에서도 사용할 수 있어 문제가 됨

//    @Autowired private final MemberService memberService; // 의존관계 주입 (Dependency Injection) - 필드주입 (사용 X)

    /*
    // 의존관계 주입 (Dependency Injection) - setter 주입
    @Autowired
    void setMemberService(MemberService memberService){
        this.memberService = memberService;
    }
    */

    // 스프링 컨테이너에 등록해 쓰기
    @Autowired // 의존관계 주입 (Dependency Injection) - 생성자 주입 (생성되는 시점에 한번 생성되고 끝나 좋음)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 회원가입 페이지로 이동
    @GetMapping("/members/new") // Get 조회할 때 주로 쓰임
    public String crateForm(){
        return "members/createMemberForm";
    }

    // 회원 등록해주기
    @PostMapping("members/new") // Post 등록할 때 주로 쓰임
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/"; // 홈화면으로 보냄
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
