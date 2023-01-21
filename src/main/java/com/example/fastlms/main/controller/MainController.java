package com.example.fastlms.main.controller;

import com.example.fastlms.components.MailComponents;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Controller
public class MainController {
    private final MailComponents mailComponents;
    @RequestMapping("/admin/member/list")
    public String index(HttpServletRequest request) {

//        String userAgent = RequestUtils.getUserAgent(request);
//        String clientIp = RequestUtils.getClientIP(request);
//
//        log.info(userAgent);
//        log.info(clientIp);
        /*
        String email = "tjddbs1412@naver.com";
        String subject = "안녕하세요. 제로베이스입니다.";
        String text = "<p>안녕하세요. </P><P>반갑습니다.</p>";

        mailComponents.sendMail(email, subject, text);
        */
        return "/admin/member/list"; //resources에 있는 파일
    }

    // 스프링 -> MVC (view -> 템플릿엔진 화면에 내용을 출력(html))
    // .NET -> MVC (view -> 출력)
    // python django -> MTV(Template -> 화면출력)
    // 백엔드 과정 -> V(화면에 보여진 부분) -> 프론트 과정
    // V -> HTML ==> 웹페이지
    // V -> json ==> API

    //request -> WEB -> SERVER
    //respose -> SERVER -> WEB
    @RequestMapping("/error/denied")
    public String errorDenied() {

        return "error/denied"; //resources에 있는 파일
    }

}
