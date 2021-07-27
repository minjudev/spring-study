package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); // null일 시 null 그대로 반환하기 보다 optional로 감싸서 반환하는 것 선호
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
