package hellow.hellospring.service;

import hellow.hellospring.domain.Member;
import hellow.hellospring.repository.MemberRepositosy;
import hellow.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    public final MemberRepositosy memberRepositosy;

    @Autowired
    public MemberService(MemberRepositosy memberRepositosy) {
        this.memberRepositosy = memberRepositosy;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        validateDuplicateMember(member);  // 중복 회원 검증

        memberRepositosy.save(member);
        return member.getId();



    }

    private void validateDuplicateMember(Member member) {
        memberRepositosy.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepositosy.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepositosy.findById(memberId);
    }
}
