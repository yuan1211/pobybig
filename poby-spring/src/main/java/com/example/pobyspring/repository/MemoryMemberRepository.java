package com.example.pobyspring.repository;

import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>(); // 실무에서는 동시성 이슈 때문에 concurrentHashMap을 사용
    private static long sequence = 0L; // key값 생성을 위한 값 // 실무에서는 동시성 이슈 때문에 atomicLong을 사용

    @Override
    public Member save(Member member) {
        member.setId(++sequence); // 시퀀스를 하나씩 올리면서 매개변수로 받은 멤버의 id로 설정 (실제 id와는 무관한 서버에서 알기 위한 id)
        store.put(member.getId(), member); // 해당 id와 멤버를 해쉬맵에 넣기
        return member;
    }

    @Override
    public Optional<Member> findByID(Long id) {
        return Optional.ofNullable(store.get(id)); // id로 찾은 멤버 클래스 반환 (Optional 이기 때문에 null도 괜찮)
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); // store의 member들을 돌다가 매개변수로 받은 name과 이름이 일치하는 멤버 찾아 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // store의 value들 즉 멤버들 전부 리스트화해서 반환
    }
}
