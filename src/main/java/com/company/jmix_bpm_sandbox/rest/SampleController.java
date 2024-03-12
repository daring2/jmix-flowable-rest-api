package com.company.jmix_bpm_sandbox.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/authenticated/hello")
    public String authenticatedHello() {
        return "authenticated-hello";
    }

    @GetMapping("/anonymous/hello")
    public String anonymousHello() {
        return "anonymous-hello";
    }

}
