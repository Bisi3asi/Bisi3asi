package com.mogakco.mogakco.repository;

import com.mogakco.mogakco.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    @AfterEach // 모든 테스트 종료 시 작동
    public void afterEach(){
        memoryMemberRepository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");
        memoryMemberRepository.save(member);

        Member result = memoryMemberRepository.findById(member.getId()).get();
        System.out.println("result = " + (result == member));

        // Assertions
        Assertions.assertEquals(result, member);
        // assertj
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("java");
        memoryMemberRepository.save(member1);

        Member result = memoryMemberRepository.findByName("java").get();
        assertThat(result).isEqualTo(member1);
    }
}
