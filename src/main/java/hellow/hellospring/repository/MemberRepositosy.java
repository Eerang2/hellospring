package hellow.hellospring.repository;

import hellow.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepositosy {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
