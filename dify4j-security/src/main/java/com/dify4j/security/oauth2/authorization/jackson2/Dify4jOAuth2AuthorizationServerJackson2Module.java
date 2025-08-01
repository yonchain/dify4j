package com.dify4j.security.oauth2.authorization.jackson2;

import com.dify4j.security.oauth2.authorization.Dify4jOAuth2AuthorizationToken;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.security.jackson2.SecurityJackson2Modules;


public class Dify4jOAuth2AuthorizationServerJackson2Module extends SimpleModule {

    public Dify4jOAuth2AuthorizationServerJackson2Module() {
        super(Dify4jOAuth2AuthorizationServerJackson2Module.class.getName(), new Version(1, 0, 0, null, null, null));
    }

    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(Dify4jOAuth2AuthorizationToken.class, Dify4jOAuthAuthorizationTokenMixin.class);
    }
}