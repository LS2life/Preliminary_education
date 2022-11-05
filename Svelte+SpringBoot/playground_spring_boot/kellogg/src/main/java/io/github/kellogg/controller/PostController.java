package io.github.kellogg.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.kellogg.dto.MemberDTO;

@RestController
@RequestMapping("/blog")
public class PostController {
    
    // http://localhost:8080/blog/default
    @PostMapping(value = "/default") 
    public String postMethod() {
        return "Hello World!";
    }

    // http://localhost:8080/blog/member
    // {
    //      "name" : "about",
    //      "email" : "thinktank.about@gmail.com",
    //      "organization" : "About my story"
    // }
    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();
        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }
    // http://localhost:8080/blog/member2
    @PostMapping(value = "/member2")
    public String postMemberDto(@RequestBody MemberDTO memberDTO) {
        return memberDTO.toString();
    }
}
