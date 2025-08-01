package com.dify4j.console;


import com.dify4j.api.Dify4jConfiguration;
import com.dify4j.api.Dify4jService;
import com.dify4j.api.Dify4jServiceImpl;
import com.dify4j.api.idm.TenantService;
import com.dify4j.api.idm.UserService;
import com.dify4j.api.knowledge.KnowledgeService;
import com.dify4j.api.security.SecurityEventPublisher;
import com.dify4j.console.sys.event.UserLoginLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 控制台配置
 *
 * @author Cgy
 * @since 1.0.0
 */
@Configuration
public class ConsoleConfig {


    @Bean
    public ResponseFactory responseFactory() {
        return new ResponseFactory();
    }


    @Bean
    public Dify4jService dify4jService(UserService userService, TenantService tenantService, KnowledgeService knowledgeService) {
        return new Dify4jServiceImpl(userService, tenantService, knowledgeService);
    }

    @Bean
    public UserLoginLogger userLoginLogger() {
        UserLoginLogger userLoginLogger = new UserLoginLogger();
        SecurityEventPublisher.addListener(userLoginLogger);
        return userLoginLogger;
    }
}
