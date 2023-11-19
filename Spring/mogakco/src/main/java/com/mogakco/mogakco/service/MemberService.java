package com.mogakco.mogakco.service;

import com.mogakco.mogakco.domain.Member;
import com.mogakco.mogakco.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
// 서비스는 비즈니스 의존적으로 메소드를 선택한다.
public class MemberService {
    private final MemberRepository memberRepository;

    // 동일 이름에 대한 중복 이름 예외 처리
    public Long join(Member member){
        // ctrl + shift + alt + t : extract method 를 통한 refactor
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
            throw new IllegalArgumentException("이미 존재하는 회원입니다");
        });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
