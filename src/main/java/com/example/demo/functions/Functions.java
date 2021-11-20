package com.example.demo.functions;

import com.example.demo.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;
import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
@Configuration
public class Functions {

    @Autowired
    private CustomerService customerService;

    @Bean
    Function<String, String> uppercase() {
        return msg -> {
            log.info("uppercase function - param: {}", msg);
            return msg.toUpperCase(Locale.ROOT);
        };
    }

    @Bean
    Supplier<String> getCustomer() {
        return () -> {
            log.info("customer");
          return customerService.getCustomer();
        };
    }

    @Bean
    Function<String, String> getBinPost() {
        return msg -> {
            log.info("getBinPost - param: {}", msg);
            return customerService.getBinPost(msg);
        };
    }

}
