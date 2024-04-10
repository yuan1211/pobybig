package com.example.pobyspring.repository;

import java.lang.reflect.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 저장소에 저장
    Optional<Member> findByID(Long id); // id로 찾기
    Optional<Member> findByName(String name); // 이름으로 찾기
    List<Member> findAll(); // 지금까지 저장소에 저장된 모든 회원 리스트를 반환
}



