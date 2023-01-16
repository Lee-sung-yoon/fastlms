package com.example.fastlms.member.repository;

import com.example.fastlms.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {

    Optional<Member> findByEmailAuthKeyIs(String emailAuthKey);
    Optional<Member> findByUserIdAndUserName(String usrId, String userName);
    Optional<Member> findByResetPasswordKey(String resetPasswordKey);
}
