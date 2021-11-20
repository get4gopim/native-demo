package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    private RestTemplate restTemplate;

    public String getCustomer() {
        log.info("customer service add");
        return "Customer";
    }

    public String getBinPost(String msg) {
        log.info("getBinPost");

        HttpHeaders headers = new HttpHeaders();
        headers.set("Host", "www.example.com");
        headers.set("User-Agent", "whatever");

        HttpEntity<String> requestEntity = new HttpEntity<String>(msg);
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<String> responseEntity =
                restTemplate.postForEntity("http://httpbin.org/post", requestEntity, String.class);

        return responseEntity.getBody();
    }

}
