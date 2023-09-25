package com.mysite.sbb.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService{
    // UserSecurityService :: 스프링 시큐리티가 제공하는 UserDetailService 구현해야함
    // UserDetailService :: loadByUsername 메서드를 구현하도록 강제하는 인터페이스
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // loadUserByUsername :: 사용자명으로 비밀번호 조회하여 리턴하는 메서드
        Optional<SiteUser> _siteUser = this.userRepository.findByusername(username);
        if(_siteUser.isEmpty()){
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
        SiteUser siteUser = _siteUser.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        if("admin".equals(username)) {
        // 사용자명이 admin이면 ADMIN 권한 부여, else는 유저 권한 부여
        // 사용자명, 비밀번호, 권한 입력해 User 객체 리턴
        // loadByUserName 메서드는 비밀번호가 화면으로부터 입력받은 비밀번호와 일치하는지 검사하는 로직 보유
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
        }
        return new User(siteUser.getUsername(), siteUser.getPassword(), authorities);
    }
}