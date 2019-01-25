package com.example.project06.controller;


import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController   //Rest Api구현
public class SampleController {
    @GetMapping("/hello")  //hello라는 요청이 오면
    public Resource<Hello> hello(){
        Hello hello = new Hello();
        hello.setPrefix("Hey,");
        hello.setName("jukyung");

        Resource<Hello> helloResource = new Resource<>(hello);
        helloResource.add(linkTo(methodOn(SampleController.class).hello()).withSelfRel());
        //$._links.self 생성


        return helloResource;

        /*
        Hello 가 json으로 변환되어 응답으로 나가 겠지만
        아무런 링크정보를 넣지 않았으므로
         */

    }

}
