package hellow.hellospring.controller;

import hellow.hellospring.domain.Member;
import hellow.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemebrController {

        private final MemberService memberService;

//      @Autowired
//      public void setMemberService(MemberService memberService) {
//          this.memberService = memberService;                               ---> setter 주입
//    }


    //    @Autowired
    //    private final MemberService memberService;             --->  필드 주입



         @Autowired
         public MemebrController(MemberService memberService) {
              this.memberService = memberService;                //   ---> 생성자 주입 사용!
    }
    @GetMapping("/members/new")
    public String createForm() {
             return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);


        return "redirect:/";

    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
    @PostMapping("/members")
    public String back() {
             Member member = new Member();

             return "redirect:/";
    }

}
