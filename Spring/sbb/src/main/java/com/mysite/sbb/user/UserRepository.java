package com.mysite.sbb.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<SiteUser, Long>{
// SiteUser의 PK 타입은 Long이므로 제너릭 Long으로 선언
    Optional<SiteUser> findByusername(String username);
}