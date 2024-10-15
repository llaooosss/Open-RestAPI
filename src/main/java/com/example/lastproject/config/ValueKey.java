package com.example.lastproject.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ValueKey {

    @Value("myapp.api.apiname")
    private String nameConf;

    @Value("myapp.api.tokenname")
    private String tokenConf;

}
