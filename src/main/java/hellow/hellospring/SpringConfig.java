package hellow.hellospring;

import hellow.hellospring.repository.MemberRepositosy;
import hellow.hellospring.repository.MemoryMemberRepository;
import hellow.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class SpringConfig {
//
//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepositosy());
//    }
//
//    @Bean
//    public MemberRepositosy memberRepositosy() {
//        return new MemoryMemberRepository();
//    }
//
//}
