package com.example.pobyspring;

import com.example.pobyspring.repository.MemberRepository;
import com.example.pobyspring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Member;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {
	MemberRepository repository = new MemoryMemberRepository();

	@Test
	public void save() {
		Member member = new Member() {
			@Override
			public Class<?> getDeclaringClass() {
				return null;
			}

			@Override
			public String getName() {
				return null;
			}

			@Override
			public int getModifiers() {
				return 0;
			}

			@Override
			public boolean isSynthetic() {
				return false;
			}
		};
		member.setName("spring");

		repository.save(member);

		Member result = repository.findById(member.getId()).get();
		assertThat(member).isEqualTo(result);

	}
}