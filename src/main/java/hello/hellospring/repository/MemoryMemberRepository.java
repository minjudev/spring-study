package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // 0, 1, 2 이렇게 키값을 생성해줌

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // null이 반환될 수 도 있으니 Optional로 감싸주기
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) // 람다 사용, 루프 돌며 파라미터로 들어온 name이 member.getName과 같은지 확인
                .findAny();                                      // 같은 경우에만 필터링됨, 필터링된 것을 찾으면 결과는 Optional로 반환됨
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // store에 있는 values는 멤버들임, 멤버들이 쫙 반환이 됨
    }
}
