package com.example.fastlms.member.exception;

public class MemberStopUserAuthException extends RuntimeException {
    public MemberStopUserAuthException(String error) {
        super(error);
    }
}
