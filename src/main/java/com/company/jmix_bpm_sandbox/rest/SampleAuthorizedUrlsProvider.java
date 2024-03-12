package com.company.jmix_bpm_sandbox.rest;

import io.jmix.core.security.AuthorizedUrlsProvider;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class SampleAuthorizedUrlsProvider implements AuthorizedUrlsProvider {

    @Override
    public Collection<String> getAuthenticatedUrlPatterns() {
        return List.of("/authenticated/**", "/management/**", "/repository/**");
    }

    @Override
    public Collection<String> getAnonymousUrlPatterns() {
        return List.of("/anonymous/**");
    }

}
