package com.example.blog.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.dto.MemberDTO;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
    
    // http://localhost:8080/blog/hello
    @GetMapping(value = "/hello")
    public String getHello() {
        return "Hello";
    }

    // http://localhost:8080/blog/name
    @GetMapping(value = "/name")
    public String getName() {
        return "MyName";
    }

	// GET 형식의 요청에서 파라미터를 전달하기 위해 URL값을 담아 요정하는 방법
	// @GetMapping에서 사용된 {변수}의 이름과 메소드의 매개변수와 일치시켜야 한다.
    // http://localhost:8080/blog/variable1/{String 값}
    @RequestMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }

	// @GetMapping에서 사용된 {변수}의 이름과 메소드의 매개변수가 다를경우.
    // http://localhost:8080/blog/variable2/{String 값}
    @RequestMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable ("variable") String var) {
        return var;
    }

    // @RequestParam
	// GET 형식의 요청에서 쿼리 문자열을 전달하달 위해 사용되는 방법.
	// '?'를 기준으로 우측에 {키}={값}의 형태로 전달되며, 복수 형태로 전달할 경우 & 를 사용.
    // http://localhost:8080/blog/request1?name=about&email=thinktankabout@gmail.com&organization=thinktank
    @RequestMapping(value = "/request1")
    public String getRequestParam1(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }
    // 어떤 요청값이 들어올지 알 수 없는 경우.
    // http://localhost:8080/blog/request2?key1=value1&key2=value2
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        // param.forEach(key, value) -> sb.append(key).append(" : ").append(value).append("/n");
        return sb.toString();
    }

	// key와 value가 정해져있지만, 받아야할 파라미터가 많을 경우  DTO 객체를 사용한 방식
    // http://localhost:8080/blog/request3?name=about&email=thinktank.about@gmail.com&organization=thinktank
    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDTO memberDTO) {
        // return memberDTO.getName() + " " + memberDTO.getEmail() + " " + memberDTO.getOrganization()
        return memberDTO.toString();
    }

	// * @RequestMapping
	// 고전적인 방법으로 사용하지 않음.
	// value와 method로 정의하여 API 개발하는 방식
	// @RequestMapping(value = "/hello", method = RequestMethod.GET)
	// public String GetHello() {
	// 	return "Hello World";
	// }
}
