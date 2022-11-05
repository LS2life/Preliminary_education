package io.github.kellogg.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.kellogg.dto.MemberDTO;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/blog")
public class PutController {
    
    // http://localhost:8080:/blog/default
    @PutMapping(value = "/default")
    public String putMethod(){ return "Hello World!"; }

    // http://localhost:8080:/blog/member
    @PutMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> putData) {
        StringBuilder sb = new StringBuilder();
        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        /*
        pram.forEach(key, value) -> sb.append(key).append(" : ").append(value).append("\n"));
         */

        return sb.toString();
    }

    // http://localhost:8080:/blog/member1
    @PutMapping(value = "/member1")
    public String postMemberDto1(@RequestBody MemberDTO memberDTO) { return memberDTO.toString();}

    // http://localhost:8080:/blog/member2
    @PutMapping(value = "/member2")
    public String postMemberDto2(@RequestBody MemberDTO memberDTO) { return memberDTO.toString();}

    // http://localhost:8080:/blog/member3
    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDTO> postMemberDto3(@RequestBody MemberDTO memberDTO){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDTO);
    }
}
