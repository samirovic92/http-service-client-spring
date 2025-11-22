package com.sei.serviceclient.config;

import com.sei.serviceclient.service.PostService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.support.RestClientHttpServiceGroupConfigurer;
import org.springframework.web.service.registry.ImportHttpServices;

@Configuration
@ImportHttpServices(group = "jsonplaceholder", types = {PostService.class})
public class HttpConfig {

    @Bean
    RestClientHttpServiceGroupConfigurer groupConfigurer() {
        return groups -> {
            groups.forEachClient((group, builder) ->
                    builder.baseUrl("https://jsonplaceholder.typicode.com")
                            .defaultHeader("Accept", "application/json")
                            .build()
            );
        };
    }
}
