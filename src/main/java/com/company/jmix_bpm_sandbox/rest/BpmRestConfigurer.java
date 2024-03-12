package com.company.jmix_bpm_sandbox.rest;

import org.springframework.context.ApplicationContext;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

//@Configuration(proxyBeanMethods = false)
//@Qualifier("authorization-server-resource-server")
public class BpmRestConfigurer extends AbstractHttpConfigurer<BpmRestConfigurer, HttpSecurity> {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        var applicationContext = http.getSharedObject(ApplicationContext.class);
        var mappingIntrospector = applicationContext.getBean(HandlerMappingIntrospector.class);
        var matcher = new OrRequestMatcher(
                new MvcRequestMatcher.Builder(mappingIntrospector)
                        .pattern("/rest/**"),
                new MvcRequestMatcher.Builder(mappingIntrospector)
                        .servletPath("/rest/bpm/process")
                        .pattern("/**")
        );
        http.securityMatcher(matcher).authorizeHttpRequests(it ->
                it.requestMatchers(matcher).authenticated()
        );
    }

}
